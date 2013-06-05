package equivalence;

import AST.*;

public class OrEquivalence extends Equivalence {
	
	public OrEquivalence(AST tree, int key) {
		super(tree, key);
	}
	
	// A | B = B | A
	public AST commutativity() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTOrNode) {
				ASTOrNode orNode = (ASTOrNode) node;
				ASTPropositionalNode left = orNode.getLeft();
				ASTPropositionalNode right = orNode.getRight();
				ASTOrNode newNode = new ASTOrNode(orNode.getKey(), right, left);
				ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), newNode, key);
				ASTProgramNode program = tree.getRoot();
				program.setLeaf(p);
				AST t = new AST(tree.getKey() + 2, program);
				return t;
			}
		}
		catch(Exception e) {
			return null;
		}
		return null;
	}
	
	// A | A = A
	public AST idempotence() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTOrNode) {
				ASTOrNode orNode = (ASTOrNode) node;
				NodeEquivalence equivalence = new NodeEquivalence(orNode.getLeft(),orNode.getRight());
				if(equivalence.isEquivalent()) {
					ASTPropositionalNode propNode = orNode.getLeft();
					propNode.setKey(tree.getKey());
					tree.setKey(tree.getKey() + 1);
					ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), propNode, key);
					ASTProgramNode program = tree.getRoot();
					program.setLeaf(p);
					AST t = new AST(tree.getKey() + 2, program);
					return t;
				}
			}
		}
		catch(Exception e) {
			return null;
		}
		return null;
	}
	
	public AST dist() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node  = find(tree.getRoot(), key);
			if(node instanceof ASTOrNode) {
				ASTOrNode orNode = (ASTOrNode) node;
				ASTPropositionalNode left = orNode.getLeft();
				ASTPropositionalNode right = orNode.getRight();
				if(right instanceof ASTAndNode) {
					NodeEquivalence eq = new NodeEquivalence(((ASTAndNode) right).getLeft(), ((ASTAndNode) right).getRight());
					if(!eq.isEquivalent()) {
						ASTOrNode newLeft = new ASTOrNode(tree.getKey(), left, ((ASTAndNode) right).getLeft());
						tree.setKey(tree.getKey() + 1);
						ASTOrNode newRight = new ASTOrNode(tree.getKey(), left, ((ASTAndNode) right).getRight());
						tree.setKey(tree.getKey() + 1);
						ASTAndNode andNode = new ASTAndNode(tree.getKey(), newLeft, newRight);
						tree.setKey(tree.getKey() + 1);
						ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), andNode, key);
						ASTProgramNode program = tree.getRoot();
						program.setLeaf(p);
						AST t = new AST(tree.getKey(), program);
						return t;
					}
				}
			}
		}
		catch(Exception e) {
			return null;
		}
		return null;
	}
	
	public AST distdiff() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTOrNode) {
				ASTOrNode orNode = (ASTOrNode) node;
				ASTPropositionalNode left = orNode.getLeft();
				ASTPropositionalNode right = orNode.getRight();
				if(left instanceof ASTAndNode && right instanceof ASTAndNode) {
					NodeEquivalence eq = new NodeEquivalence(((ASTAndNode) left).getLeft(), ((ASTAndNode) right).getLeft());
					if(eq.isEquivalent()) {
						ASTOrNode or = new ASTOrNode(tree.getKey(), ((ASTAndNode) left).getRight(), ((ASTAndNode) right).getRight());
						tree.setKey(tree.getKey() + 1);
						ASTAndNode andNode = new ASTAndNode(tree.getKey(), ((ASTAndNode) left).getLeft(), or);
						tree.setKey(tree.getKey() + 1);
						ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), andNode, key);
						ASTProgramNode program = tree.getRoot();
						program.setLeaf(p);
						AST t = new AST(tree.getKey() + 2, program);
						return t;
					}
				}
			}
		}
		catch(Exception e) {
			return null;
		}
		return null;
	}
	
	public AST distsame() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTOrNode) {
				ASTOrNode orNode = (ASTOrNode) node;
				ASTPropositionalNode left = orNode.getLeft();
				ASTPropositionalNode right = orNode.getRight();
				if(right instanceof ASTAndNode) {
					ASTAndNode andNode = (ASTAndNode) right;
					NodeEquivalence eq = new NodeEquivalence(andNode.getLeft(), left);
					if(eq.isEquivalent()) {
						ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), left, key);
						ASTProgramNode program = tree.getRoot();
						program.setLeaf(p);
						AST t = new AST(tree.getKey() + 2, program);
						return t;
					}
				}
			}
		}
		catch(Exception e) {
			return null;
		}
		return null;
	}
	
	// (A & B) & C = A & (B & C)
	public AST associativityLeft() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node  = find(tree.getRoot(), key);
			if(node instanceof ASTOrNode) {
				ASTOrNode orNode = (ASTOrNode) node;
				ASTPropositionalNode left = orNode.getLeft();
				ASTPropositionalNode right = orNode.getRight();
				ASTPropositionalNode newLeft = ((ASTOrNode) left).getLeft();
				ASTPropositionalNode newRight = new ASTOrNode(tree.getKey(), ((ASTOrNode) left).getRight(), right);
				tree.setKey(tree.getKey() + 1);
				ASTOrNode newOrNode = new ASTOrNode(tree.getKey(), newLeft, newRight);
				tree.setKey(tree.getKey() + 1);
				ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), newOrNode, key);
				if(p == null) {
					return null;
				}
				ASTProgramNode program = tree.getRoot();
				program.setLeaf(p);
				AST t = new AST(tree.getKey(), program);
				return t;
			}
		}
		catch(Exception e) {
			return null;
		}
		return null;
	}
		
	// A & (B & C) = (A & B) & C
	public AST associativityRight() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node  = find(tree.getRoot(), key);
			if(node instanceof ASTOrNode) {
				ASTOrNode orNode = (ASTOrNode) node;
				ASTPropositionalNode left = orNode.getLeft();
				ASTPropositionalNode right = orNode.getRight();
				ASTPropositionalNode newRight = ((ASTOrNode) right).getRight();
				ASTPropositionalNode newLeft = new ASTOrNode(key, left, ((ASTOrNode) right).getLeft());
				ASTOrNode newOrNode = new ASTOrNode(right.getKey(), newLeft, newRight);
				ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), newOrNode, key);
				if(p == null) {
					return null;
				}
				ASTProgramNode program = tree.getRoot();
				program.setLeaf(p);
				AST t = new AST(tree.getKey(), program);
				return t;
			}
		}
		catch(Exception e) {
			return null;
		}
		return null;
	}
	
}