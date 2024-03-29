package equivalence;

import AST.*;

public class NodeEquivalence {
	
	private ASTNode node1;
	private ASTNode node2;

	public NodeEquivalence(ASTNode node1, ASTNode node2) {
		this.setNode1(node1);
		this.setNode2(node2);
	}

	public boolean isEquivalent() {
		ASTNode node1 = getNode1();
		ASTNode node2 = getNode2();
		
		if(node1 instanceof ASTNotNode && node2 instanceof ASTNotNode) {
			ASTNotNode notNode1 = (ASTNotNode) node1;
			ASTNotNode notNode2 = (ASTNotNode) node2;
			NodeEquivalence equivalence = new NodeEquivalence(notNode1.getLeaf(), notNode2.getLeaf());
			return equivalence.isEquivalent();
		}
		if(node1 instanceof ASTIdentifierNode && node2 instanceof ASTIdentifierNode) {
			String id1 = ((ASTIdentifierNode) node1).getLeaf();
			String id2 = ((ASTIdentifierNode) node2).getLeaf();
			return id1.equals(id2);
		}
		if(node1 instanceof ASTProgramNode && node2 instanceof ASTProgramNode) {
			ASTProgramNode program1 = (ASTProgramNode) node1;
			ASTProgramNode program2 = (ASTProgramNode) node2;
			NodeEquivalence equivalence = new NodeEquivalence(program1.getLeaf(), program2.getLeaf());
			return equivalence.isEquivalent();
		}
		if(node1.getClass().equals(node2.getClass())) {
			ASTPropositionalBinaryNode binaryNode1 = (ASTPropositionalBinaryNode) node1;
			ASTPropositionalBinaryNode binaryNode2 = (ASTPropositionalBinaryNode) node2;
			NodeEquivalence leftEquivalence = new NodeEquivalence(binaryNode1.getLeft(), binaryNode2.getLeft());
			NodeEquivalence rightEquivalence = new NodeEquivalence(binaryNode1.getRight(), binaryNode2.getRight());
			boolean left = leftEquivalence.isEquivalent();
			boolean right = rightEquivalence.isEquivalent();
			return left && right;
		}
		return false;
	}
	
	public ASTNode getNode1() {
		return node1;
	}

	public void setNode1(ASTNode node1) {
		this.node1 = node1;
	}

	public ASTNode getNode2() {
		return node2;
	}

	public void setNode2(ASTNode node2) {
		this.node2 = node2;
	}
	
}
