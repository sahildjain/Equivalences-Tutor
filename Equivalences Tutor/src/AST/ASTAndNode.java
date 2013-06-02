package AST;

import gui.NewPersonalEquivalenceListener;

import java.awt.BorderLayout;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import buttonlisteners.AndButtonListener;

import net.miginfocom.swing.MigLayout;

public class ASTAndNode extends ASTPropositionalBinaryNode {
	
	private ASTPropositionalNode unary;
	private ASTPropositionalNode propositional;
	private int key;
	
	public ASTAndNode(int key, ASTPropositionalNode unary, ASTPropositionalNode propositional) {
		this.unary = unary;
		this.propositional = propositional;
		this.setKey(key);
	}
	
	public ASTPropositionalNode getLeft() {
		return this.unary;
	}
	
	public ASTPropositionalNode getRight() {
		return this.propositional;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitAndNode(this);
	}

	public void setLeft(ASTPropositionalNode left) {
		this.unary = left;
	}

	public void setRight(ASTPropositionalNode right) {
		this.propositional = right;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean equals(ASTPropositionalNode node) {
		if(!(node instanceof ASTAndNode)) {
			return false;
		}
		boolean left = getLeft().equals(((ASTAndNode) node).getLeft());
		boolean right = getRight().equals(((ASTAndNode) node).getRight());
		return left && right;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("(");
		stringBuilder.append(getLeft().toString());
		stringBuilder.append(" \u2227 ");
		stringBuilder.append(getRight().toString());
		stringBuilder.append(")");
		return stringBuilder.toString();
	}
	
	public String toParserString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("(");
		stringBuilder.append(getLeft().toString());
		stringBuilder.append(" & ");
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
		if (right == 1 && left == 1) {
			return 1;
		}
		return 0;
	}

	public JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side) {
		JPanel panel = new JPanel(new MigLayout());
		JPanel left = getLeft().createJPanel(l, side);
		JPanel right = getRight().createJPanel(l, side);
		JButton button = new JButton("\u2227");
		makeTransparent(button);
		JButton open = new JButton("(");
		JButton close = new JButton(")");
		makeTransparent(open);
		makeTransparent(close);
		JPanel openBracket = new JPanel();
		openBracket.add(open);
		JPanel closeBracket = new JPanel();
		closeBracket.add(close);
		AndButtonListener listener = new AndButtonListener(l, getKey(), side);
		button.addActionListener(listener);
		panel.add(openBracket, BorderLayout.WEST);
		panel.add(left, BorderLayout.WEST);
		panel.add(button, BorderLayout.WEST);
		panel.add(right, BorderLayout.WEST);
		panel.add(closeBracket, BorderLayout.EAST);
		return panel;
	}
	
}
