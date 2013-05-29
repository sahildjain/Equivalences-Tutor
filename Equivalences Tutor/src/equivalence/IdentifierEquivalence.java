package equivalence;

import AST.AST;
import AST.ASTAndNode;
import AST.ASTNode;
import AST.ASTNotNode;
import AST.ASTOrNode;
import AST.ASTProgramNode;
import AST.ASTPropositionalNode;

public class IdentifierEquivalence extends Equivalence {
	
	private AST tree;
	private int key;
	
	public IdentifierEquivalence(AST tree, int key) {
		this.setTree(tree);
		this.setKey(key);		
	}
	
	// A = !!A
	public AST doubleNegation() {
		AST tree = getTree();
		int key = getKey();
		ASTNode node = find(tree.getRoot(), key);
		ASTNotNode notNode = new ASTNotNode(tree.getKey() + 1, (ASTPropositionalNode) node);
		ASTNotNode notNotNode = new ASTNotNode(tree.getKey() + 2, notNode);
		tree.setKey(tree.getKey() + 3);
		ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), notNotNode, key);
		ASTProgramNode program = tree.getRoot();
		program.setLeaf(p);
		AST t = new AST(tree.getKey(), program);
		return t;
	}
	
	// A = A & A
	public AST andIdempotence() {
		AST tree = getTree();
		int key = getKey();
		ASTNode node = find(tree.getRoot(), key);
		ASTAndNode andNode = new ASTAndNode(tree.getKey() + 1, (ASTPropositionalNode) node, (ASTPropositionalNode) node);
		tree.setKey(tree.getKey() + 3);
		ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), andNode, key);
		ASTProgramNode program = tree.getRoot();
		program.setLeaf(p);
		AST t = new AST(tree.getKey(), program);
		return t;
	}
	
	// A = A & A
	public AST orIdempotence() {
		AST tree = getTree();
		int key = getKey();
		ASTNode node = find(tree.getRoot(), key);
		ASTOrNode orNode = new ASTOrNode(tree.getKey() + 1, (ASTPropositionalNode) node, (ASTPropositionalNode) node);
		tree.setKey(tree.getKey() + 3);
		ASTPropositionalNode p = replace(tree.getRoot().getLeaf(), orNode, key);
		ASTProgramNode program = tree.getRoot();
		program.setLeaf(p);
		AST t = new AST(tree.getKey(), program);
		return t;
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