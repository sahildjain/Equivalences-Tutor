package equivalence;

import javax.swing.JOptionPane;

import AST.*;

public class FalsityEquivalence extends Equivalence {

	public FalsityEquivalence(AST tree, int key) {
		super(tree, key);
	}
	
	public AST andIntroduction1() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTFalsityNode) {
				String variable = JOptionPane.showInputDialog("What would you like to call the new variable?");
				ASTIdentifierNode id1 = new ASTIdentifierNode(tree.getKey(), variable, null, null);
				tree.setKey(tree.getKey() + 1);
				ASTIdentifierNode id2 = new ASTIdentifierNode(tree.getKey(), variable, null, null);
				tree.setKey(tree.getKey() + 1);
				ASTNotNode notNode = new ASTNotNode(tree.getKey(), id2);
				tree.setKey(tree.getKey() + 1);
				ASTAndNode andNode = new ASTAndNode(tree.getKey(), id1, notNode);
				tree.setKey(tree.getKey() + 1);
				ASTNode p = replace(tree.getRoot().getLeaf(), andNode, key);
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
	
	public AST andIntroduction2() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTFalsityNode) {
				String variable = JOptionPane.showInputDialog("What would you like to call the new variable?");
				ASTIdentifierNode id1 = new ASTIdentifierNode(tree.getKey(), variable, null, null);
				tree.setKey(tree.getKey() + 1);
				ASTAndNode orNode = new ASTAndNode(tree.getKey(), id1, node);
				tree.setKey(tree.getKey() + 1);
				ASTNode p = replace(tree.getRoot().getLeaf(), orNode, key);
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
