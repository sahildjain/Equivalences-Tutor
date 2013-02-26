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
			ASTPropositionalNode secondNode = secondNotNode.getLeaf();
			ASTPropositionalNode node = findAndReplace(tree.getRoot(), notNode, secondNode);
			tree.setRoot((ASTProgramNode) node);
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
			ASTNotNode notLeft = new ASTNotNode(tree.getKey(), left);
			tree.setKey(tree.getKey() + 1);
			ASTNotNode notRight = new ASTNotNode(tree.getKey(), right);
			tree.setKey(tree.getKey() + 1);
			ASTOrNode orNode = new ASTOrNode(andNode.getKey(), notLeft, notRight);
			ASTPropositionalNode node = findAndReplace(tree.getRoot(), notNode, orNode);
			tree.setRoot((ASTProgramNode) node);
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
			ASTNotNode notLeft = new ASTNotNode(notNode.getKey(), left);
			ASTNotNode notRight = new ASTNotNode(orNode.getKey(), right);
			ASTAndNode andNode = new ASTAndNode(tree.getKey(), notLeft, notRight);
			tree.setKey(tree.getKey() + 1);
			ASTPropositionalNode node = findAndReplace(tree.getRoot(), notNode, andNode);
			tree.setRoot((ASTProgramNode) node);
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