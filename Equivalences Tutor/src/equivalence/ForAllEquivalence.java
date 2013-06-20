package equivalence;

import AST.AST;
import AST.ASTAndNode;
import AST.ASTExistsNode;
import AST.ASTForAllNode;
import AST.ASTNode;
import AST.ASTNotNode;
import AST.ASTProgramNode;

public class ForAllEquivalence extends Equivalence {
	
	public ForAllEquivalence(AST tree, int key) {
		super(tree, key);
	}
	
	public AST equivalence1() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTForAllNode) {
				ASTForAllNode forAllNode = (ASTForAllNode) node;
				ASTNode temp = forAllNode.getNode();
				if(temp instanceof ASTForAllNode) {
					ASTForAllNode newNode1 = new ASTForAllNode(tree.getKey(), forAllNode.getIdentifier(), ((ASTForAllNode) temp).getNode());
					tree.setKey(tree.getKey() + 1);
					ASTForAllNode newNode = new ASTForAllNode(tree.getKey(), ((ASTForAllNode) temp).getIdentifier(), newNode1);
					tree.setKey(tree.getKey() + 1);
					ASTNode p = replace(tree.getRoot().getLeaf(), newNode, key);
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
	
	public AST equivalence2() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTForAllNode) {
				ASTForAllNode forAllNode = (ASTForAllNode) node;
				ASTNode temp = forAllNode.getNode();
				if(temp instanceof ASTAndNode) {
					 ASTAndNode andNode = (ASTAndNode) temp;
					 ASTForAllNode forLeft = new ASTForAllNode(tree.getKey(), forAllNode.getIdentifier(), andNode.getLeft());
					 tree.setKey(tree.getKey() + 1);
					 ASTForAllNode forRight = new ASTForAllNode(tree.getKey(), forAllNode.getIdentifier(), andNode.getRight());
					 tree.setKey(tree.getKey() + 1);
					 ASTAndNode newNode = new ASTAndNode(tree.getKey(), forLeft, forRight);
					 tree.setKey(tree.getKey() + 1);
					 ASTNode p = replace(tree.getRoot().getLeaf(), newNode, key);
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
	
	public AST equivalence3() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTForAllNode) {
				ASTForAllNode forAllNode = (ASTForAllNode) node;
				ASTNode temp = forAllNode.getNode();
				if(temp instanceof ASTNotNode) {
					 ASTNotNode notNode = (ASTNotNode) temp;
					 ASTNode n = notNode.getLeaf();
					 ASTExistsNode existsNode = new ASTExistsNode(tree.getKey(), forAllNode.getIdentifier(), n);
					 tree.setKey(tree.getKey() + 1);
					 ASTNotNode newNode = new ASTNotNode(tree.getKey(), existsNode);
					 tree.setKey(tree.getKey() + 1);
					 ASTNode p = replace(tree.getRoot().getLeaf(), newNode, key);
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
	

}
