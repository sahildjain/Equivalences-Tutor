package equivalence;

import AST.*;

public class AndEquivalence extends Equivalence {
	
	private AST tree;
	private int key;
	
	public AndEquivalence(AST tree, int key) {
		this.setTree(tree);
		this.setKey(key);
	}
	
	// A & A = A
	public AST idempotence() {
		AST tree = getTree();
		int key = getKey();
		ASTNode node = find(tree.getRoot(), key);
		if(node instanceof ASTAndNode) {
			ASTAndNode andNode = (ASTAndNode) node;
			NodeEquivalence equivalence = new NodeEquivalence(andNode.getLeft(),((ASTAndNode) node).getRight());
			if(equivalence.isEquivalent()) {
				ASTIdentifierNode identifer = new ASTIdentifierNode(tree.getKey(), andNode.getLeft().toString());
				tree.setKey(tree.getKey() + 1);
				ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), identifer, key);
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
		AST tree = getTree();
		int key = getKey();
		ASTNode node  = find(tree.getRoot(), key);
		if(node instanceof ASTAndNode) {
			ASTAndNode andNode = (ASTAndNode) node;
			ASTAndNode newNode = new ASTAndNode(tree.getKey(), andNode.getRight(), andNode.getLeft());
			tree.setKey(tree.getKey() + 1);
			ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), newNode, key);
			ASTProgramNode program = tree.getRoot();
			program.setLeaf(p);
			AST t = new AST(tree.getKey(), program);
			return t;
		}
		return null;
	}
	
	// (A & B) & C = A & (B & C)
	public AST associativityLeft() {
		AST tree = getTree();
		int key = getKey();
		ASTNode node  = find(tree.getRoot(), key);
		if(node instanceof ASTAndNode) {
			ASTAndNode andNode = (ASTAndNode) node;
			ASTPropositionalNode left = andNode.getLeft();
			ASTPropositionalNode right = andNode.getRight();
			ASTPropositionalNode newLeft = ((ASTAndNode) left).getLeft();
			ASTPropositionalNode newRight = new ASTAndNode(key, ((ASTAndNode) left).getRight(), right);
			ASTAndNode newAndNode = new ASTAndNode(left.getKey(), newLeft, newRight);
			ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), newAndNode, key);
			ASTProgramNode program = tree.getRoot();
			program.setLeaf(p);
			AST t = new AST(tree.getKey(), program);
			return t;
		}
		return null;
	}
	
	// A & (B & C) = (A & B) & C
	public AST associativityRight() {
		AST tree = getTree();
		int key = getKey();
		ASTNode node  = find(tree.getRoot(), key);
		if(node instanceof ASTAndNode) {
			ASTAndNode andNode = (ASTAndNode) node;
			ASTPropositionalNode left = andNode.getLeft();
			ASTPropositionalNode right = andNode.getRight();
			ASTPropositionalNode newRight = ((ASTAndNode) right).getRight();
			ASTPropositionalNode newLeft = new ASTAndNode(key, left, ((ASTAndNode) right).getLeft());
			ASTAndNode newAndNode = new ASTAndNode(right.getKey(), newLeft, newRight);
			ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), newAndNode, key);
			ASTProgramNode program = tree.getRoot();
			program.setLeaf(p);
			AST t = new AST(tree.getKey(), program);
			return t;
		}
		return null;
	}
	
	// A & B = !(!A | !B)
	public AST deMorgan() {
		AST tree = getTree();
		int key = getKey();
		ASTNode node  = find(tree.getRoot(), key);
		if(node instanceof ASTAndNode) {
			ASTAndNode andNode = (ASTAndNode) node;
			ASTPropositionalNode left = andNode.getLeft();
			ASTPropositionalNode right = andNode.getRight();
			ASTNotNode notLeft = new ASTNotNode(tree.getKey(), left);
			tree.setKey(tree.getKey() + 1);
			ASTNotNode notRight = new ASTNotNode(tree.getKey(), right);
			tree.setKey(tree.getKey() + 1);
			ASTOrNode orNode = new ASTOrNode(andNode.getKey(), notLeft, notRight);
			ASTNotNode notNode = new ASTNotNode(tree.getKey(), orNode);
			tree.setKey(tree.getKey() + 1);
			ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), notNode, key);
			ASTProgramNode program = tree.getRoot();
			program.setLeaf(p);
			AST t = new AST(tree.getKey(), program);
			return t;
		}
		return null;
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