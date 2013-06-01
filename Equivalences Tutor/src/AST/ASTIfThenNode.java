package AST;

import gui.NewPersonalEquivalenceListener;

import java.awt.BorderLayout;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import buttonlisteners.IfButtonListener;

import net.miginfocom.swing.MigLayout;

public class ASTIfThenNode extends ASTPropositionalBinaryNode {
	
	private ASTPropositionalNode disjunction;
	private ASTPropositionalNode conditional;
	private int key;

	public ASTIfThenNode(int key, ASTPropositionalNode disjunction, ASTPropositionalNode conditional) {
		this.disjunction = disjunction;
		this.conditional = conditional;
		this.setKey(key);
	}
	
	public ASTPropositionalNode getLeft() {
		return this.disjunction;
	}
	
	public ASTPropositionalNode getRight() {
		return this.conditional;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitIfThenNode(this);
	}

	public void setLeft(ASTPropositionalNode left) {
		this.disjunction = left;
	}

	public void setRight(ASTPropositionalNode right) {
		this.conditional = right;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean equals(ASTPropositionalNode node) {
		if(!(node instanceof ASTIfThenNode)) {
			return false;
		}
		boolean left = getLeft().equals(((ASTIfThenNode) node).getLeft());
		boolean right = getRight().equals(((ASTIfThenNode) node).getRight());
		return left && right;
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("(");
		stringBuilder.append(getLeft().toString());
		stringBuilder.append(" \u2192 ");
		stringBuilder.append(getRight().toString());
		stringBuilder.append(")");
		return stringBuilder.toString();
	}
	
	public TreeMap<String, Integer> numIdentifiers(TreeMap<String, Integer> identifiers) {
		identifiers = getLeft().numIdentifiers(identifiers);
		identifiers = getRight().numIdentifiers(identifiers);
		return identifiers;
	}

	public int value(TreeMap<String, Integer> id) {
		int left = getLeft().value(id);
		int right = getRight().value(id);
		if(left == 1 && right == 0) {
			return 0;
		}
		return 1;
	}
	
	public JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side) {
		JPanel panel = new JPanel(new MigLayout());
		JPanel left = getLeft().createJPanel(l, side);
		JPanel right = getRight().createJPanel(l, side);
		JButton button = new JButton("\u2192");
		makeTransparent(button);
		JButton open = new JButton("(");
		JButton close = new JButton(")");
		makeTransparent(open);
		makeTransparent(close);
		JPanel openBracket = new JPanel();
		openBracket.add(open);
		JPanel closeBracket = new JPanel();
		closeBracket.add(close);
		IfButtonListener listener = new IfButtonListener(l, getKey(), side);
		button.addActionListener(listener);
		panel.add(openBracket, BorderLayout.WEST);
		panel.add(left, BorderLayout.WEST);
		panel.add(button, BorderLayout.WEST);
		panel.add(right, BorderLayout.WEST);
		panel.add(closeBracket, BorderLayout.EAST);
		return panel;
	}


}
