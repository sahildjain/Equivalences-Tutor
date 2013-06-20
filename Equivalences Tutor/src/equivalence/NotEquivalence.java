package equivalence;

import AST.*;

public class NotEquivalence extends Equivalence {
	
	public NotEquivalence(AST tree, int key) {
		super(tree, key);
	}
	
	// !!A = A
	public AST doubleNegation() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTNotNode) {
				ASTNotNode notNode = (ASTNotNode) node;
				if(containsDoubleNegation(notNode)) {
					ASTNotNode secondNotNode = (ASTNotNode) notNode.getLeaf();
					ASTNode secondNode = secondNotNode.getLeaf();
					ASTNode p = replace(tree.getRoot().getLeaf(), secondNode, key);
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
	
	// !(A & B) = !A | !B
	public AST deMorganAnd() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTNotNode) {
				ASTNotNode notNode = (ASTNotNode) node;
				ASTNode leaf = notNode.getLeaf();
				if(leaf instanceof ASTAndNode) {
					ASTAndNode andNode = (ASTAndNode) leaf;
					ASTNode left = andNode.getLeft();
					ASTNode right = andNode.getRight();
					ASTNotNode notLeft = new ASTNotNode(tree.getKey(), left);
					tree.setKey(tree.getKey() + 1);
					ASTNotNode notRight = new ASTNotNode(tree.getKey(), right);
					tree.setKey(tree.getKey() + 1);
					ASTOrNode orNode = new ASTOrNode(andNode.getKey(), notLeft, notRight);
					ASTNode p = replace(tree.getRoot().getLeaf(), orNode, key);
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
	
	// !(A | B) = !A & !B
	public AST deMorganOr() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTNotNode) {
				ASTNotNode notNode = (ASTNotNode) node;
				ASTNode leaf = notNode.getLeaf();
				if(leaf instanceof ASTOrNode) {
					ASTOrNode orNode = (ASTOrNode) leaf;
					ASTNode left = orNode.getLeft();
					ASTNode right = orNode.getRight();
					ASTNotNode notLeft = new ASTNotNode(notNode.getKey(), left);
					ASTNotNode notRight = new ASTNotNode(orNode.getKey(), right);
					ASTAndNode andNode = new ASTAndNode(tree.getKey(), notLeft, notRight);
					tree.setKey(tree.getKey() + 1);
					ASTNode p = replace(tree.getRoot().getLeaf(), andNode, key);
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
	
	// !(A <-> B) = A <-> !B
	public AST notIff() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTNotNode) {
				ASTNotNode notNode = (ASTNotNode) node;
				ASTNode leaf = notNode.getLeaf();
				if(leaf instanceof ASTIffNode) {
					ASTNode left = ((ASTIffNode) leaf).getLeft();
					ASTNode right = ((ASTIffNode) leaf).getRight();
					ASTNotNode notRight = new ASTNotNode(tree.getKey(), right);
					tree.setKey(tree.getKey() + 1);
					ASTIffNode iffNode = new ASTIffNode(tree.getKey(), left, notRight);
					tree.setKey(tree.getKey() + 1);
					ASTNode p = replace(tree.getRoot().getLeaf(), iffNode, key);
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
		
	// !(A -> B) = A & !B
	public AST notIfThen() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTNotNode) {
				ASTNotNode notNode = (ASTNotNode) node;
				ASTNode leaf = notNode.getLeaf();
				if(leaf instanceof ASTIfThenNode) {
					ASTNode left = ((ASTIfThenNode) leaf).getLeft();
					ASTNode right = ((ASTIfThenNode) leaf).getRight();
					ASTNotNode notRight = new ASTNotNode(tree.getKey(), right);
					tree.setKey(tree.getKey() + 1);
					ASTAndNode andNode = new ASTAndNode(tree.getKey(), left, notRight);
					tree.setKey(tree.getKey() + 1);
					ASTNode p = replace(tree.getRoot().getLeaf(), andNode, key);
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

	private boolean containsDoubleNegation(ASTNotNode notNode) {
		ASTNode leaf = notNode.getLeaf();
		return leaf instanceof ASTNotNode;
	}

}