package equivalence;

import AST.*;

public class AndEquivalence extends Equivalence {
	
	private AST tree;
	private int key;
	
	public AndEquivalence(AST tree, int key) {
		this.setTree(tree);
	}
	
	// A & A = A
	public AST idempotence() {
		AST tree = getTree();
		int key = getKey();
		ASTNode node = find(tree.getRoot(), key);
		if(node instanceof ASTAndNode) {
			NodeEquivalence equivalence = new NodeEquivalence(((ASTAndNode) node).getLeft(),((ASTAndNode) node).getRight());
			if(equivalence.isEquivalent()) {
				ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), (ASTAndNode) node, key);
				ASTProgramNode program = tree.getRoot();
				program.setLeaf(p);
				AST t = new AST(tree.getKey(), program);
				return t;
			}
		}
		return null;
	}
	
	// A & B = B & A
	public AST commutativity() {
		/*
		AST tree = getTree();
		ASTAndNode andNode = getAndNode();
		ASTPropositionalNode left = andNode.getLeft();
		ASTPropositionalNode right = andNode.getRight();
		ASTAndNode newNode = new ASTAndNode(andNode.getKey(), right, left);
		ASTPropositionalNode node = findAndReplace(tree.getRoot(), andNode, newNode);
		tree.setRoot((ASTProgramNode) node);
		return tree;*/
	}
	
	// (A & B) & C = A & (B & C)
	public AST associativityLeft() {
		/*
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
		return tree;*/
	}
	
	// A & (B & C) = (A & B) & C
	public AST associativityRight() {
		/*
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
		*/
	}
	
	// A & B = !(!A | !B)
	public AST deMorgan() {
		/*
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
		*/
	}
	
	public AST getTree() {
		return tree;
	}

	public void setTree(AST tree) {
		this.tree = tree;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
}