package equivalence;

import javax.swing.JOptionPane;

import AST.*;

public class TruthEquivalence extends Equivalence {

	public TruthEquivalence(AST tree, int key) {
		super(tree, key);
	}
	
	public AST implicationIntroduction() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTTruthNode) {
				String variable = JOptionPane.showInputDialog("What would you like to call the new variable?");
				ASTIdentifierNode id1 = new ASTIdentifierNode(tree.getKey(), variable, null, null);
				tree.setKey(tree.getKey() + 1);
				ASTIdentifierNode id2 = new ASTIdentifierNode(tree.getKey(), variable, null, null);
				tree.setKey(tree.getKey() + 1);
				ASTIfThenNode ifThenNode = new ASTIfThenNode(tree.getKey(), id1, id2);
				tree.setKey(tree.getKey() + 1);
				ASTNode p = replace(tree.getRoot().getLeaf(), ifThenNode, key);
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
	
	public AST implicationIntroduction2() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTTruthNode) {
				String variable = JOptionPane.showInputDialog("What would you like to call the new variable?");
				ASTIdentifierNode id1 = new ASTIdentifierNode(tree.getKey(), variable, null, null);
				tree.setKey(tree.getKey() + 1);
				ASTIfThenNode ifThenNode = new ASTIfThenNode(tree.getKey(), id1, node);
				tree.setKey(tree.getKey() + 1);
				ASTNode p = replace(tree.getRoot().getLeaf(), ifThenNode, key);
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
	
	public AST implicationIntroduction3() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTTruthNode) {
				String variable = JOptionPane.showInputDialog("What would you like to call the new variable?");
				ASTIdentifierNode id1 = new ASTIdentifierNode(tree.getKey(), variable, null, null);
				tree.setKey(tree.getKey() + 1);
				ASTFalsityNode falsityNode = new ASTFalsityNode(tree.getKey() + 1);
				tree.setKey(tree.getKey() + 1);
				ASTIfThenNode ifThenNode = new ASTIfThenNode(tree.getKey(), falsityNode, id1);
				tree.setKey(tree.getKey() + 1);
				ASTNode p = replace(tree.getRoot().getLeaf(), ifThenNode, key);
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
	
	public AST falsityIntroduction() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTTruthNode) {
				ASTFalsityNode falsityNode = new ASTFalsityNode(tree.getKey() + 1);
				tree.setKey(tree.getKey() + 1);
				ASTNotNode notNode = new ASTNotNode(tree.getKey(), falsityNode);
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

}
