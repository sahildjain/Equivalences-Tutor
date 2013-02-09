package equivalence;

import AST.*;

public class IfEquivalence extends Equivalence {

	private AST tree;
	private ASTIfThenNode ifNode;
	
	public IfEquivalence(AST tree, ASTIfThenNode ifNode) {
		this.setTree(tree);
		this.setIfNode(ifNode);
	}
	
	// A -> B = !A | B
	public AST ifToOrEquivalence() {
		AST tree = getTree();
		ASTIfThenNode ifNode = getIfNode();
		ASTPropositionalNode left = ifNode.getLeft();
		ASTPropositionalNode right = ifNode.getRight();
		ASTNotNode notNode = new ASTNotNode(left);
		ASTOrNode orNode = new ASTOrNode(notNode, right);
		ASTPropositionalNode node = findAndReplace(tree.getRoot(), ifNode, orNode);
		tree.setRoot((ASTProgramNode) node);
		return tree;
	}
	
	// A -> B = !(A & !B)
	public AST ifToAndEquivalence() {
		AST tree = getTree();
		ASTIfThenNode ifNode = getIfNode();
		ASTPropositionalNode left = ifNode.getLeft();
		ASTPropositionalNode right = ifNode.getRight();
		ASTNotNode notNode1 = new ASTNotNode(right);
		ASTAndNode andNode = new ASTAndNode(left, notNode1);
		ASTNotNode notNode2 = new ASTNotNode(andNode);
		//return findAndReplace(tree, ifNode, notNode2);
		ASTPropositionalNode node = findAndReplace(tree.getRoot(), ifNode, notNode2);
		tree.setRoot((ASTProgramNode) node);
		return tree;
	}
	
	public ASTIfThenNode getIfNode() {
		return ifNode;
	}
	
	public void setIfNode(ASTIfThenNode ifNode) {
		this.ifNode = ifNode;
	}
	
	public AST getTree() {
		return tree;
	}
	
	public void setTree(AST tree) {
		this.tree = tree;
	}
	
}
