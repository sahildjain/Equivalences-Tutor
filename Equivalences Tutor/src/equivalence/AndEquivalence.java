package equivalence;

import AST.*;

public class AndEquivalence extends Equivalence {
	
	private AST tree;
	private ASTAndNode andNode;
	
	public AndEquivalence(AST tree, ASTAndNode andNode) {
		this.setTree(tree);
		this.setAndNode(andNode);
	}
	
	//A & A = A
	public AST idempotency() {
		AST tree = getTree();
		ASTAndNode andNode = getAndNode();
		NodeEquivalence equivalence = new NodeEquivalence(andNode.getLeft(), andNode.getRight());
		if(equivalence.isEquivalent()) {
			return findAndReplace(tree, andNode, andNode.getLeft());
		}
		return tree;
	}
	
	//A & B = B & A
	public AST commutativity() {
		AST tree = getTree();
		ASTAndNode andNode = getAndNode();
		ASTPropositionalNode left = andNode.getLeft();
		ASTPropositionalNode right = andNode.getRight();
		ASTAndNode newNode = new ASTAndNode(right, left);
		return findAndReplace(tree, andNode, newNode);
	}
	
	//(A & B) & C = A & (B & C)
	public AST associativityLeft() {
		AST tree = getTree();
		ASTAndNode andNode = getAndNode();
		ASTPropositionalNode left = andNode.getLeft();
		ASTPropositionalNode right = andNode.getRight();
		if(left instanceof ASTAndNode) {
			ASTPropositionalNode newLeft = ((ASTAndNode) left).getLeft();
			ASTPropositionalNode newRight = new ASTAndNode(((ASTAndNode) left).getRight(), right);
			ASTAndNode newAndNode = new ASTAndNode(newLeft, newRight);
			return findAndReplace(tree, andNode, newAndNode);
		}
		return tree;
	}
	
	//A & (B & C) = (A & B) & C
	public AST associativityRight() {
		AST tree = getTree();
		ASTAndNode andNode = getAndNode();
		ASTPropositionalNode left = andNode.getLeft();
		ASTPropositionalNode right = andNode.getRight();
		if(right instanceof ASTAndNode) {
			ASTPropositionalNode newRight = ((ASTAndNode) right).getRight();
			ASTPropositionalNode newLeft = new ASTAndNode(left, ((ASTAndNode) right).getLeft());
			ASTAndNode newAndNode = new ASTAndNode(newLeft, newRight);
			return findAndReplace(tree, andNode, newAndNode);
		}
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