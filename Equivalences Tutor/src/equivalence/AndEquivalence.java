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
		ASTAndNode newNode = new ASTAndNode(right, left);
		ASTPropositionalNode node = findAndReplace(tree.getRoot(), andNode, newNode);
		tree.setRoot((ASTProgramNode) node);
		return tree;
	}
	
	// (A & B) & C = A & (B & C)
	public AST associativityLeft() {
		AST tree = getTree();
		ASTAndNode andNode = getAndNode();
		ASTPropositionalNode left = andNode.getLeft();
		ASTPropositionalNode right = andNode.getRight();
		if(left instanceof ASTAndNode) {
			ASTPropositionalNode newLeft = ((ASTAndNode) left).getLeft();
			ASTPropositionalNode newRight = new ASTAndNode(((ASTAndNode) left).getRight(), right);
			ASTAndNode newAndNode = new ASTAndNode(newLeft, newRight);
			ASTPropositionalNode node = findAndReplace(tree.getRoot(), andNode, newAndNode);
			tree.setRoot((ASTProgramNode) node);
		}
		return tree;
	}
	
	// A & (B & C) = (A & B) & C
	public AST associativityRight() {
		AST tree = getTree();
		ASTAndNode andNode = getAndNode();
		ASTPropositionalNode left = andNode.getLeft();
		ASTPropositionalNode right = andNode.getRight();
		if(right instanceof ASTAndNode) {
			ASTPropositionalNode newRight = ((ASTAndNode) right).getRight();
			ASTPropositionalNode newLeft = new ASTAndNode(left, ((ASTAndNode) right).getLeft());
			ASTAndNode newAndNode = new ASTAndNode(newLeft, newRight);
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
		ASTNotNode notLeft = new ASTNotNode(left);
		ASTNotNode notRight = new ASTNotNode(right);
		ASTOrNode orNode = new ASTOrNode(notLeft, notRight);
		ASTNotNode notNode = new ASTNotNode(orNode);
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