package equivalence;

import AST.*;

public class AndEquivalence extends Equivalence {
	
	private AST tree;
	private ASTAndNode andNode;
	
	public AndEquivalence(AST tree, ASTAndNode andNode) {
		this.setTree(tree);
		this.setAndNode(andNode);
	}
	
	// A & A = A
	public AST idempotency() {
		AST tree = getTree();
		ASTAndNode andNode = getAndNode();
		NodeEquivalence equivalence = new NodeEquivalence(andNode.getLeft(), andNode.getRight());
		if(equivalence.isEquivalent()) {
			ASTPropositionalNode node = findAndReplace(tree.getRoot(), andNode, andNode.getLeft());
			tree.setRoot((ASTProgramNode) node);
		}
		return tree;
	}
	
	// A & B = B & A
	public AST commutativity() {
		AST tree = getTree();
		ASTAndNode andNode = getAndNode();
		ASTPropositionalNode left = andNode.getLeft();
		ASTPropositionalNode right = andNode.getRight();
		ASTAndNode newNode = new ASTAndNode(andNode.getKey(), right, left);
		ASTPropositionalNode node = findAndReplace(tree.getRoot(), andNode, newNode);
		tree.setRoot((ASTProgramNode) node);
		return tree;
	}
	
	// (A & B) & C = A & (B & C)
	public AST associativityLeft() {
		AST tree = getTree();
		ASTAndNode andNode = getAndNode();
		int andKey = andNode.getKey();
		ASTPropositionalNode left = andNode.getLeft();
		ASTPropositionalNode right = andNode.getRight();
		if(left instanceof ASTAndNode) {
			int leftKey = left.getKey();
			ASTPropositionalNode newLeft = ((ASTAndNode) left).getLeft();
			ASTPropositionalNode newRight = new ASTAndNode(andKey, ((ASTAndNode) left).getRight(), right);
			ASTAndNode newAndNode = new ASTAndNode(leftKey, newLeft, newRight);
			ASTPropositionalNode node = findAndReplace(tree.getRoot(), andNode, newAndNode);
			tree.setRoot((ASTProgramNode) node);
		}
		return tree;
	}
	
	// A & (B & C) = (A & B) & C
	public AST associativityRight() {
		AST tree = getTree();
		ASTAndNode andNode = getAndNode();
		int andKey = andNode.getKey();
		ASTPropositionalNode left = andNode.getLeft();
		ASTPropositionalNode right = andNode.getRight();
		if(right instanceof ASTAndNode) {
			int rightKey = right.getKey();
			ASTPropositionalNode newRight = ((ASTAndNode) right).getRight();
			ASTPropositionalNode newLeft = new ASTAndNode(andKey, left, ((ASTAndNode) right).getLeft());
			ASTAndNode newAndNode = new ASTAndNode(rightKey, newLeft, newRight);
			ASTPropositionalNode node = findAndReplace(tree.getRoot(), andNode, newAndNode);
			tree.setRoot((ASTProgramNode) node);
		}
		return tree;
	}
	
	// A & B = !(!A | !B)
	public AST deMorgan() {
		AST tree = getTree();
		ASTAndNode andNode = getAndNode();
		ASTPropositionalNode left = andNode.getLeft();
		ASTPropositionalNode right = andNode.getRight();
		ASTNotNode notLeft = new ASTNotNode(tree.getKey(), left);
		tree.setKey(tree.getKey() + 1);
		ASTNotNode notRight = new ASTNotNode(tree.getKey(), right);
		tree.setKey(tree.getKey() + 1);
		ASTOrNode orNode = new ASTOrNode(andNode.getKey(), notLeft, notRight);
		ASTNotNode notNode = new ASTNotNode(tree.getKey(), orNode);
		tree.setKey(tree.getKey() + 1);
		ASTPropositionalNode node = findAndReplace(tree.getRoot(), andNode, notNode);
		tree.setRoot((ASTProgramNode) node);
		return tree;
	}
	
	public AST getTree() {
		return tree;
	}

	public void setTree(AST tree) {
		this.tree = tree;
	}

	public ASTAndNode getAndNode() {
		return andNode;
	}

	public void setAndNode(ASTAndNode andNode) {
		this.andNode = andNode;
	}
	
}