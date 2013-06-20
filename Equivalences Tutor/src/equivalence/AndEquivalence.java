package equivalence;

import AST.*;

public class AndEquivalence extends Equivalence {
	
	public AndEquivalence(AST tree, int key) {
		super(tree, key);
	}
	
	// A & A = A
	public AST idempotence() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTAndNode) {
				ASTAndNode andNode = (ASTAndNode) node;
				NodeEquivalence equivalence = new NodeEquivalence(andNode.getLeft(),((ASTAndNode) node).getRight());
				if(equivalence.isEquivalent()) {
					ASTNode propNode = andNode.getLeft();
					propNode.setKey(tree.getKey());
					tree.setKey(tree.getKey() + 1);
					ASTNode p = replace(tree.getRoot().getLeaf(), propNode, key);
					ASTProgramNode program = tree.getRoot();
					program.setLeaf(p);
					AST t = new AST(tree.getKey(), program);
					return t;
				}
			}
		}
		catch(Exception e) {
			return null;
		}
		return null;
	}
	
	// A & B = B & A
	public AST commutativity() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node  = find(tree.getRoot(), key);
			if(node instanceof ASTAndNode) {
				ASTAndNode andNode = (ASTAndNode) node;
				ASTAndNode newNode = new ASTAndNode(andNode.getKey(), andNode.getRight(), andNode.getLeft());
				ASTNode p = replace(tree.getRoot().getLeaf(), newNode, key);
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
	
	// (A & B) & C = A & (B & C)
	public AST associativityLeft() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node  = find(tree.getRoot(), key);
			if(node instanceof ASTAndNode) {
				ASTAndNode andNode = (ASTAndNode) node;
				ASTNode left = andNode.getLeft();
				ASTNode right = andNode.getRight();
				ASTNode newLeft = ((ASTAndNode) left).getLeft();
				ASTNode newRight = new ASTAndNode(key, ((ASTAndNode) left).getRight(), right);
				ASTAndNode newAndNode = new ASTAndNode(left.getKey(), newLeft, newRight);
				ASTNode p = replace(tree.getRoot().getLeaf(), newAndNode, key);
				/*if(p == null) {
					return null;
				}*/
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
			if(node instanceof ASTAndNode) {
				ASTAndNode andNode = (ASTAndNode) node;
				ASTNode left = andNode.getLeft();
				ASTNode right = andNode.getRight();
				ASTNode newRight = ((ASTAndNode) right).getRight();
				ASTPropositionalNode newLeft = new ASTAndNode(key, left, ((ASTAndNode) right).getLeft());
				ASTAndNode newAndNode = new ASTAndNode(right.getKey(), newLeft, newRight);
				ASTNode p = replace(tree.getRoot().getLeaf(), newAndNode, key);
				/*if(p == null) {
					return null;
				}*/
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
	
	// A & B = !(!A | !B)
	public AST deMorgan() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node  = find(tree.getRoot(), key);
			if(node instanceof ASTAndNode) {
				ASTAndNode andNode = (ASTAndNode) node;
				ASTNode left = andNode.getLeft();
				ASTNode right = andNode.getRight();
				ASTNotNode notLeft = new ASTNotNode(tree.getKey(), left);
				tree.setKey(tree.getKey() + 1);
				ASTNotNode notRight = new ASTNotNode(tree.getKey(), right);
				tree.setKey(tree.getKey() + 1);
				ASTOrNode orNode = new ASTOrNode(tree.getKey(), notLeft, notRight);
				tree.setKey(tree.getKey() + 1);
				ASTNotNode notNode = new ASTNotNode(tree.getKey(), orNode);
				tree.setKey(tree.getKey() + 1);
				ASTNode p = replace(tree.getRoot().getLeaf(), notNode, key);
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
	
	public AST iff() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node  = find(tree.getRoot(), key);
			if(node instanceof ASTAndNode) {
				ASTAndNode andNode = (ASTAndNode) node;
				ASTNode left = andNode.getLeft();
				ASTNode right = andNode.getRight();
				if(left instanceof ASTIfThenNode && right instanceof ASTIfThenNode) {
					ASTIfThenNode leftIf = (ASTIfThenNode) left;
					ASTIfThenNode rightIf = (ASTIfThenNode) right;
					NodeEquivalence eq1 = new NodeEquivalence(leftIf.getLeft(), rightIf.getRight());
					NodeEquivalence eq2 = new NodeEquivalence(leftIf.getRight(), rightIf.getLeft());
					if(eq1.isEquivalent() && eq2.isEquivalent()) {
						ASTIffNode iffNode = new ASTIffNode(tree.getKey(), leftIf.getLeft(), rightIf.getLeft());
						tree.setKey(tree.getKey() + 1);
						ASTNode p = replace(tree.getRoot().getLeaf(), iffNode, key);
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
			ASTNode node  = find(tree.getRoot(), key);
			if(node instanceof ASTAndNode) {
				ASTAndNode andNode = (ASTAndNode) node;
				ASTNode left = andNode.getLeft();
				ASTNode right = andNode.getRight();
				if(right instanceof ASTOrNode) {
					NodeEquivalence eq = new NodeEquivalence(((ASTOrNode) right).getLeft(), ((ASTOrNode) right).getRight());
					if(!eq.isEquivalent()) {
						ASTAndNode newLeft = new ASTAndNode(tree.getKey(), left, ((ASTOrNode) right).getLeft());
						tree.setKey(tree.getKey() + 1);
						ASTAndNode newRight = new ASTAndNode(tree.getKey(), left, ((ASTOrNode) right).getRight());
						tree.setKey(tree.getKey() + 1);
						ASTOrNode orNode = new ASTOrNode(tree.getKey(), newLeft, newRight);
						tree.setKey(tree.getKey() + 1);
						ASTNode p = replace(tree.getRoot().getLeaf(), orNode, key);
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
	
	public AST distback() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTAndNode) {
				ASTAndNode andNode = (ASTAndNode) node;
				ASTNode left = andNode.getLeft();
				ASTNode right = andNode.getRight();
				if(left instanceof ASTOrNode && right instanceof ASTOrNode) {
					NodeEquivalence eq = new NodeEquivalence(((ASTOrNode) left).getLeft(), ((ASTOrNode) right).getLeft());
					if(eq.isEquivalent()) {
						ASTAndNode and = new ASTAndNode(tree.getKey(), ((ASTOrNode) left).getRight(), ((ASTOrNode) right).getRight());
						tree.setKey(tree.getKey() + 1);
						ASTOrNode orNode = new ASTOrNode(tree.getKey(), ((ASTOrNode) left).getLeft(), and);
						tree.setKey(tree.getKey() + 1);
						ASTNode p = replace(tree.getRoot().getLeaf(), orNode, key);
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
			if(node instanceof ASTAndNode) {
				ASTAndNode andNode = (ASTAndNode) node;
				ASTNode left = andNode.getLeft();
				ASTNode right = andNode.getRight();
				if(right instanceof ASTOrNode) {
					ASTOrNode orNode = (ASTOrNode) right;
					NodeEquivalence eq = new NodeEquivalence(orNode.getLeft(), left);
					if(eq.isEquivalent()) {
						ASTNode p = replace(tree.getRoot().getLeaf(), left, key);
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
	
}