package equivalence;

import AST.*;

public class IfEquivalence extends Equivalence {
	
	public IfEquivalence(AST tree, int key) {
		super(tree, key);
	}
	
	// A -> B = !A | B
	public AST ifToOrEquivalence() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTIfThenNode) {
				ASTIfThenNode ifNode = (ASTIfThenNode) node;
				ASTPropositionalNode left = ifNode.getLeft();
				ASTPropositionalNode right = ifNode.getRight();
				ASTNotNode notNode = new ASTNotNode(tree.getKey(), left);
				tree.setKey(tree.getKey() + 1);
				ASTOrNode orNode = new ASTOrNode(ifNode.getKey(), notNode, right);
				ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), orNode, key);
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
	
	// A -> B = !(A & !B)
	public AST ifToAndEquivalence() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTIfThenNode) {
				ASTIfThenNode ifNode = (ASTIfThenNode) node;
				ASTPropositionalNode left = ifNode.getLeft();
				ASTPropositionalNode right = ifNode.getRight();
				ASTNotNode notNode1 = new ASTNotNode(tree.getKey(), right);
				tree.setKey(tree.getKey() + 1);
				ASTAndNode andNode = new ASTAndNode(ifNode.getKey(), left, notNode1);
				ASTNotNode notNode2 = new ASTNotNode(tree.getKey(), andNode);
				tree.setKey(tree.getKey() + 1);
				ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), notNode2, key);
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
	
}
