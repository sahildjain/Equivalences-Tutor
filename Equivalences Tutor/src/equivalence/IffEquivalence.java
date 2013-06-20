package equivalence;

import AST.*;

public class IffEquivalence  extends Equivalence {
	
	public IffEquivalence(AST tree, int key) {
		super(tree, key);
	}
	
	// A <-> B = (A -> B) & (B -> A)
	public AST iffToAndEquivalence() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node  = find(tree.getRoot(), key);
			if(node instanceof ASTIffNode) {
				ASTIffNode iffNode = (ASTIffNode) node;
				ASTNode left = iffNode.getLeft();
				ASTNode right = iffNode.getRight();
				ASTIfThenNode ifThenNode1 = new ASTIfThenNode(tree.getKey(), left, right);
				tree.setKey(tree.getKey() + 1);
				ASTIfThenNode ifThenNode2 = new ASTIfThenNode(tree.getKey(), right, left);
				tree.setKey(tree.getKey() + 1);
				ASTAndNode andNode = new ASTAndNode(iffNode.getKey(), ifThenNode1, ifThenNode2);
				ASTNode p = replace(tree.getRoot().getLeaf(), andNode, key);
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
	
	// A <-> B = (A & B) | (!A & !B)
	public AST iffToOrEquivalence() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node  = find(tree.getRoot(), key);
			if(node instanceof ASTIffNode) {
				ASTIffNode iffNode = (ASTIffNode) node;
				ASTNode left = iffNode.getLeft();
				ASTNode right = iffNode.getRight();
				ASTAndNode andNode1 = new ASTAndNode(tree.getKey(), left, right);
				tree.setKey(tree.getKey() + 1);
				ASTNotNode notLeft = new ASTNotNode(tree.getKey(), left);
				tree.setKey(tree.getKey() + 1);
				ASTNotNode notRight = new ASTNotNode(tree.getKey(), right);
				tree.setKey(tree.getKey() + 1);
				ASTAndNode andNode2 = new ASTAndNode(tree.getKey(), notLeft, notRight);
				tree.setKey(tree.getKey() + 1);
				ASTOrNode orNode = new ASTOrNode(iffNode.getKey(), andNode1, andNode2);
				ASTNode p = replace(tree.getRoot().getLeaf(), orNode, key);
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
	
	// A <-> B = !A <-> !B
	public AST negate() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node  = find(tree.getRoot(), key);
			if(node instanceof ASTIffNode) {
				ASTIffNode iffNode = (ASTIffNode) node;
				ASTNode left = iffNode.getLeft();
				ASTNode right = iffNode.getRight();
				ASTNotNode notLeft = new ASTNotNode(tree.getKey(), left);
				tree.setKey(tree.getKey() + 1);
				ASTNotNode notRight = new ASTNotNode(tree.getKey(), right);
				tree.setKey(tree.getKey() + 1);
				ASTIffNode newIffNode = new ASTIffNode(iffNode.getKey(), notLeft, notRight);
				ASTNode p = replace(tree.getRoot().getLeaf(), newIffNode, key);
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
	
	//TODO A <-> !B = !A <-> B
	public AST iffNot1() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node  = find(tree.getRoot(), key);
			if(node instanceof ASTIffNode) {
				ASTIffNode iffNode = (ASTIffNode) node;
				ASTNode left = iffNode.getLeft();
				ASTNode right = iffNode.getRight();
				if(right instanceof ASTNotNode) {
					ASTNotNode notLeft = new ASTNotNode(tree.getKey(), left);
					tree.setKey(tree.getKey() + 1);
					ASTNode propNode = ((ASTNotNode) right).getLeaf();
					ASTIffNode newIffNode = new ASTIffNode(tree.getKey(), notLeft, propNode);
					ASTNode p = replace(tree.getRoot().getLeaf(), newIffNode, key);
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
	
	
	
	// TODO !A <-> B = A <-> !B
	public AST iffNot2() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node  = find(tree.getRoot(), key);
			if(node instanceof ASTIffNode) {
				ASTIffNode iffNode = (ASTIffNode) node;
				ASTNode left = iffNode.getLeft();
				ASTNode right = iffNode.getRight();
				if(left instanceof ASTNotNode) {
					ASTNotNode notRight = new ASTNotNode(tree.getKey(), right);
					tree.setKey(tree.getKey() + 1);
					ASTNode propNode = ((ASTNotNode) left).getLeaf();
					ASTIffNode newIffNode = new ASTIffNode(tree.getKey(), propNode, notRight);
					ASTNode p = replace(tree.getRoot().getLeaf(), newIffNode, key);
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
	
	// A <-> !B = !(A <-> B) AND !A <-> B = !(A <-> B)
	/* TODO fix this method, seems wrong.
	public AST notIff() {
		AST tree = getTree();
		ASTIffNode iffNode = getIffNode();
		ASTPropositionalNode left = iffNode.getLeft();
		ASTPropositionalNode right = iffNode.getRight();
		ASTIffNode newNode = null;
		if(left instanceof ASTNotNode) {
			ASTPropositionalNode newLeft = ((ASTNotNode) left).getLeaf();
			newNode = new ASTIffNode(newLeft, right);
		}
		if(right instanceof ASTNotNode) {
			ASTPropositionalNode newRight = ((ASTNotNode) right).getLeaf();
			newNode = new ASTIffNode(left, newRight);
		}
		ASTPropositionalNode node = findAndReplace(tree.getRoot(), iffNode, newNode);
		tree.setRoot((ASTProgramNode) node);
		return tree;
	}
	*/

}
