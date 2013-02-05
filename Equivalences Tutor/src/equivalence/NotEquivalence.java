package equivalence;

import AST.*;

public class NotEquivalence extends Equivalence {

	private AST tree;
	private ASTNotNode notNode;
	
	public NotEquivalence(AST tree, ASTNotNode notNode) {
		this.setTree(tree);
		this.setNotNode(notNode);
	}
	
	// !!A = A
	public AST doubleNegation() {
		AST tree = getTree();
		ASTNotNode notNode = getNotNode();
		if(containsDoubleNegation()) {
			ASTNotNode secondNotNode = (ASTNotNode) notNode.getLeaf();
			ASTPropositionalNode node = secondNotNode.getLeaf();
			return findAndReplace(tree, notNode, node);
		}
		return tree;
	}
	
	// !(A & B) = !A | !B
	public AST deMorganAnd() {
		AST tree = getTree();
		ASTNotNode notNode = getNotNode();
		ASTPropositionalNode leaf = notNode.getLeaf();
		if(leaf instanceof ASTAndNode) {
			ASTAndNode andNode = (ASTAndNode) leaf;
			ASTPropositionalNode left = andNode.getLeft();
			ASTPropositionalNode right = andNode.getRight();
			ASTNotNode notLeft = new ASTNotNode(left);
			ASTNotNode notRight = new ASTNotNode(right);
			ASTOrNode orNode = new ASTOrNode(notLeft, notRight);
			return findAndReplace(tree, notNode, orNode);
		}
		return tree;
	}
	
	// !(A | B) = !A & !B
	public AST deMorganOr() {
		AST tree = getTree();
		ASTNotNode notNode = getNotNode();
		ASTPropositionalNode leaf = notNode.getLeaf();
		if(leaf instanceof ASTOrNode) {
			ASTOrNode orNode = (ASTOrNode) leaf;
			ASTPropositionalNode left = orNode.getLeft();
			ASTPropositionalNode right = orNode.getRight();
			ASTNotNode notLeft = new ASTNotNode(left);
			ASTNotNode notRight = new ASTNotNode(right);
			ASTAndNode andNode = new ASTAndNode(notLeft, notRight);
			return findAndReplace(tree, notNode, andNode);
		}
		return tree;
	}

	private boolean containsDoubleNegation() {
		ASTPropositionalNode leaf = getNotNode().getLeaf();
		return leaf instanceof ASTNotNode;
	}

	public AST getTree() {
		return tree;
	}

	public void setTree(AST tree) {
		this.tree = tree;
	}

	public ASTNotNode getNotNode() {
		return notNode;
	}

	public void setNotNode(ASTNotNode notNode) {
		this.notNode = notNode;
	}
	
	

}