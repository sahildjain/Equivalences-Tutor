package equivalence;

import AST.AST;
import AST.ASTAndNode;
import AST.ASTFalsityNode;
import AST.ASTNode;
import AST.ASTNotNode;
import AST.ASTOrNode;
import AST.ASTProgramNode;
import AST.ASTPropositionalNode;

public class IdentifierEquivalence extends Equivalence {
	
	public IdentifierEquivalence(AST tree, int key) {
		super(tree, key);	
	}
	
	// A = !!A
	public AST doubleNegation() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			ASTNotNode notNode = new ASTNotNode(tree.getKey(), (ASTPropositionalNode) node);
			tree.setKey(tree.getKey() + 1);
			ASTNotNode notNotNode = new ASTNotNode(tree.getKey(), notNode);
			tree.setKey(tree.getKey() + 1);
			ASTNode p = replace(tree.getRoot().getLeaf(), notNotNode, key);
			ASTProgramNode program = tree.getRoot();
			program.setLeaf(p);
			AST t = new AST(tree.getKey(), program);
			return t;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	// A = A & A
	public AST andIdempotence() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			ASTNode propNode1 = ((ASTPropositionalNode) node).copy();
			propNode1.setKey(tree.getKey());
			tree.setKey(tree.getKey() + 1);
			ASTNode propNode2 = ((ASTPropositionalNode) node).copy();
			propNode2.setKey(tree.getKey());
			tree.setKey(tree.getKey() + 1);
			ASTAndNode andNode = new ASTAndNode(tree.getKey(), propNode1, propNode2);
			tree.setKey(tree.getKey() + 1);
			ASTNode p = replace(tree.getRoot().getLeaf(), andNode, key);
			ASTProgramNode program = tree.getRoot();
			program.setLeaf(p);
			AST t = new AST(tree.getKey(), program);
			return t;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	// A = A & A
	public AST orIdempotence() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			ASTNode propNode1 = ((ASTPropositionalNode) node).copy();
			propNode1.setKey(tree.getKey());
			tree.setKey(tree.getKey() + 1);
			ASTNode propNode2 = ((ASTPropositionalNode) node).copy();
			propNode2.setKey(tree.getKey());
			tree.setKey(tree.getKey() + 1);
			ASTOrNode orNode = new ASTOrNode(tree.getKey(), propNode1, propNode2);
			tree.setKey(tree.getKey() + 1);
			ASTNode p = replace(tree.getRoot().getLeaf(), orNode, key);
			ASTProgramNode program = tree.getRoot();
			program.setLeaf(p);
			AST t = new AST(tree.getKey(), program);
			return t;
		}
		catch(Exception e) {
			return null;
		}
	}

	public AST falsityIntroduction() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			ASTOrNode orNode = new ASTOrNode(tree.getKey(), node, null);
			tree.setKey(tree.getKey() + 1);
			ASTFalsityNode falsity = new ASTFalsityNode(tree.getKey());
			tree.setKey(tree.getKey() + 1);
			orNode.setRight(falsity);
			ASTNode p = replace(tree.getRoot().getLeaf(), orNode, key);
			ASTProgramNode program = tree.getRoot();
			program.setLeaf(p);
			AST t = new AST(tree.getKey(), program);
			return t;
		}
		catch(Exception e) {
			return null;
		}
	}

}
