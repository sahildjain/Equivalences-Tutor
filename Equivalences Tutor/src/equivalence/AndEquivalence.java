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
		AST tree = getTree().copy();
		int key = getKey();
		ASTNode node = find(tree.getRoot(), key);
		if(node instanceof ASTAndNode) {
			ASTAndNode andNode = (ASTAndNode) node;
			NodeEquivalence equivalence = new NodeEquivalence(andNode.getLeft(),((ASTAndNode) node).getRight());
			if(equivalence.isEquivalent()) {
				ASTPropositionalNode propNode = andNode.getLeft();
				propNode.setKey(tree.getKey());
				tree.setKey(tree.getKey() + 1);
				ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), propNode, key);
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
			ASTAndNode newNode = new ASTAndNode(andNode.getKey(), andNode.getRight(), andNode.getLeft());
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
		try {
			if(node instanceof ASTAndNode) {
				ASTAndNode andNode = (ASTAndNode) node;
				ASTPropositionalNode left = andNode.getLeft();
				ASTPropositionalNode right = andNode.getRight();
				ASTPropositionalNode newLeft = ((ASTAndNode) left).getLeft();
				ASTPropositionalNode newRight = new ASTAndNode(key, ((ASTAndNode) left).getRight(), right);
				ASTAndNode newAndNode = new ASTAndNode(left.getKey(), newLeft, newRight);
				ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), newAndNode, key);
				if(p == null) {
					return null;
				}
				ASTProgramNode program = tree.getRoot();
				program.setLeaf(p);
				AST t = new AST(tree.getKey(), program);
				return t;
			}
		}
		catch(ClassCastException e) {
			return null;
		}
		return null;
	}
	
	// A & (B & C) = (A & B) & C
	public AST associativityRight() {
		AST tree = getTree();
		int key = getKey();
		ASTNode node  = find(tree.getRoot(), key);
		try {
			if(node instanceof ASTAndNode) {
				ASTAndNode andNode = (ASTAndNode) node;
				ASTPropositionalNode left = andNode.getLeft();
				ASTPropositionalNode right = andNode.getRight();
				ASTPropositionalNode newRight = ((ASTAndNode) right).getRight();
				ASTPropositionalNode newLeft = new ASTAndNode(key, left, ((ASTAndNode) right).getLeft());
				ASTAndNode newAndNode = new ASTAndNode(right.getKey(), newLeft, newRight);
				ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), newAndNode, key);
				if(p == null) {
					return null;
				}
				ASTProgramNode program = tree.getRoot();
				program.setLeaf(p);
				AST t = new AST(tree.getKey(), program);
				return t;
			}
		}
		catch(ClassCastException e) {
			return null;
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
	
	public AST iff() {
		AST tree = getTree();
		int key = getKey();
		ASTNode node  = find(tree.getRoot(), key);
		if(node instanceof ASTAndNode) {
			ASTAndNode andNode = (ASTAndNode) node;
			ASTPropositionalNode left = andNode.getLeft();
			ASTPropositionalNode right = andNode.getRight();
			if(left instanceof ASTIfThenNode && right instanceof ASTIfThenNode) {
				ASTIfThenNode leftIf = (ASTIfThenNode) left;
				ASTIfThenNode rightIf = (ASTIfThenNode) right;
				NodeEquivalence eq1 = new NodeEquivalence(leftIf.getLeft(), rightIf.getRight());
				NodeEquivalence eq2 = new NodeEquivalence(leftIf.getRight(), rightIf.getLeft());
				if(eq1.isEquivalent() && eq2.isEquivalent()) {
					ASTIffNode iffNode = new ASTIffNode(tree.getKey(), leftIf.getLeft(), rightIf.getLeft());
					tree.setKey(tree.getKey() + 1);
					ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), iffNode, key);
					ASTProgramNode program = tree.getRoot();
					program.setLeaf(p);
					AST t = new AST(tree.getKey(), program);
					return t;
				}
			}
		}
		return null;
	}
	
	public AST distdiff() {
		AST tree = getTree();
		int key = getKey();
		ASTNode node  = find(tree.getRoot(), key);
		if(node instanceof ASTAndNode) {
			ASTAndNode andNode = (ASTAndNode) node;
			ASTPropositionalNode left = andNode.getLeft();
			ASTPropositionalNode right = andNode.getRight();
			if(right instanceof ASTOrNode) {
				NodeEquivalence eq = new NodeEquivalence(((ASTOrNode) right).getLeft(), ((ASTOrNode) right).getRight());
				if(!eq.isEquivalent()) {
					ASTAndNode newLeft = new ASTAndNode(tree.getKey(), left, ((ASTOrNode) right).getLeft());
					tree.setKey(tree.getKey() + 1);
					ASTAndNode newRight = new ASTAndNode(tree.getKey(), left, ((ASTOrNode) right).getRight());
					tree.setKey(tree.getKey() + 1);
					ASTOrNode orNode = new ASTOrNode(tree.getKey(), newLeft, newRight);
					tree.setKey(tree.getKey() + 1);
					ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), orNode, key);
					ASTProgramNode program = tree.getRoot();
					program.setLeaf(p);
					AST t = new AST(tree.getKey(), program);
					return t;
				}
			}
		}
		return null;
	}
	
	public AST distback() {
		AST tree = getTree();
		int key = getKey();
		ASTNode node = find(tree.getRoot(), key);
		if(node instanceof ASTAndNode) {
			ASTAndNode andNode = (ASTAndNode) node;
			ASTPropositionalNode left = andNode.getLeft();
			ASTPropositionalNode right = andNode.getRight();
			if(left instanceof ASTOrNode && right instanceof ASTOrNode) {
				NodeEquivalence eq = new NodeEquivalence(((ASTOrNode) left).getLeft(), ((ASTOrNode) right).getLeft());
				if(eq.isEquivalent()) {
					ASTAndNode and = new ASTAndNode(tree.getKey(), ((ASTOrNode) left).getRight(), ((ASTOrNode) right).getRight());
					tree.setKey(tree.getKey() + 1);
					ASTOrNode orNode = new ASTOrNode(tree.getKey(), ((ASTOrNode) left).getLeft(), and);
					tree.setKey(tree.getKey() + 1);
					ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), orNode, key);
					ASTProgramNode program = tree.getRoot();
					program.setLeaf(p);
					AST t = new AST(tree.getKey() + 2, program);
					return t;
				}
			}
		}
		return null;
	}
	
	public AST distsame() {
		AST tree = getTree();
		int key = getKey();
		ASTNode node = find(tree.getRoot(), key);
		if(node instanceof ASTAndNode) {
			ASTAndNode andNode = (ASTAndNode) node;
			ASTPropositionalNode left = andNode.getLeft();
			ASTPropositionalNode right = andNode.getRight();
			if(right instanceof ASTOrNode) {
				ASTOrNode orNode = (ASTOrNode) right;
				NodeEquivalence eq = new NodeEquivalence(orNode.getLeft(), left);
				if(eq.isEquivalent()) {
					ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), left, key);
					ASTProgramNode program = tree.getRoot();
					program.setLeaf(p);
					AST t = new AST(tree.getKey() + 2, program);
					return t;
				}
			}
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