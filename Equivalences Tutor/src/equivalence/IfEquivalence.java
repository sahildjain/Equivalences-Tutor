package equivalence;

import AST.*;

public class IfEquivalence extends Equivalence {

	private AST tree;
	private ASTIfThenNode ifNode;
	
	public IfEquivalence(AST tree, ASTIfThenNode ifNode) {
		this.setTree(tree);
		this.setIfNode(ifNode);
	}
	
	public AST ifToOrEquivalence() {
		AST tree = getTree();
		ASTIfThenNode ifNode = getIfNode();
		ASTPropositionalNode left = ifNode.getLeft();
		ASTPropositionalNode right = ifNode.getRight();
		ASTNotNode notNode = new ASTNotNode(left);
		ASTOrNode orNode = new ASTOrNode(notNode, right);
		return findAndReplace(tree, ifNode, orNode);
	}
	
	public AST ifToAndEquivalence() {
		AST tree = getTree();
		ASTIfThenNode ifNode = getIfNode();
		ASTPropositionalNode left = ifNode.getLeft();
		ASTPropositionalNode right = ifNode.getRight();
		ASTNotNode notNode1 = new ASTNotNode(right);
		ASTAndNode andNode = new ASTAndNode(left, notNode1);
		ASTNotNode notNode2 = new ASTNotNode(andNode);
		return findAndReplace(tree, ifNode, notNode2);
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
