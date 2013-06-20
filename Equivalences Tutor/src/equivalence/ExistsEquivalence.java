package equivalence;

import AST.AST;
import AST.ASTExistsNode;
import AST.ASTForAllNode;
import AST.ASTNode;
import AST.ASTNotNode;
import AST.ASTOrNode;
import AST.ASTProgramNode;

public class ExistsEquivalence extends Equivalence {
	
	public ExistsEquivalence(AST tree, int key) {
		super(tree, key);
	}
	
	public AST equivalence1() {
		try{
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTExistsNode) {
				ASTExistsNode existsNode = (ASTExistsNode) node;
				ASTNode temp = existsNode.getNode();
				if(temp instanceof ASTExistsNode) {
					ASTExistsNode newNode1 = new ASTExistsNode(tree.getKey(), existsNode.getIdentifier(), ((ASTExistsNode) temp).getNode());
					tree.setKey(tree.getKey() + 1);
					ASTExistsNode newNode = new ASTExistsNode(tree.getKey(), ((ASTExistsNode) temp).getIdentifier(), newNode1);
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
			if(node instanceof ASTExistsNode) {
				ASTExistsNode existsNode = (ASTExistsNode) node;
				ASTNode temp = existsNode.getNode();
				if(temp instanceof ASTOrNode) {
					 ASTOrNode orNode = (ASTOrNode) temp;
					 ASTExistsNode existsLeft = new ASTExistsNode(tree.getKey(), existsNode.getIdentifier(), orNode.getLeft());
					 tree.setKey(tree.getKey() + 1);
					 ASTExistsNode existsRight = new ASTExistsNode(tree.getKey(), existsNode.getIdentifier(), orNode.getRight());
					 tree.setKey(tree.getKey() + 1);
					 ASTOrNode newNode = new ASTOrNode(tree.getKey(), existsLeft, existsRight);
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
			if(node instanceof ASTExistsNode) {
				ASTExistsNode existsNode = (ASTExistsNode) node;
				ASTNode temp = existsNode.getNode();
				if(temp instanceof ASTNotNode) {
					 ASTNotNode notNode = (ASTNotNode) temp;
					 ASTNode n = notNode.getLeaf();
					 ASTForAllNode forAllNode = new ASTForAllNode(tree.getKey(), existsNode.getIdentifier(), n);
					 tree.setKey(tree.getKey() + 1);
					 ASTNotNode newNode = new ASTNotNode(tree.getKey(), forAllNode);
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
