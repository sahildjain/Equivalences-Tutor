package equivalence;

import AST.*;

public class OrEquivalence extends Equivalence {
	
	private AST tree;
	private int key;
	
	public OrEquivalence(AST tree, int key) {
		this.setTree(tree);
		this.setKey(key);
	}
	
	// A | B = B | A
	public AST commutativity() {
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
		return null;
	}
	
	// A | A = A
	public AST idempotence() {
		AST tree = getTree();
		int key = getKey();
		ASTNode node = find(tree.getRoot(), key);
		if(node instanceof ASTOrNode) {
			ASTOrNode orNode = (ASTOrNode) node;
			NodeEquivalence equivalence = new NodeEquivalence(orNode.getLeft(),orNode.getRight());
			if(equivalence.isEquivalent()) {
				ASTIdentifierNode identifer = new ASTIdentifierNode(tree.getKey() + 1, orNode.getLeft().toString());
				ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), identifer, key);
				ASTProgramNode program = tree.getRoot();
				program.setLeaf(p);
				AST t = new AST(tree.getKey() + 2, program);
				return t;
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