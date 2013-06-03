package AST;

import gui.NewPersonalEquivalenceListener;

import java.awt.BorderLayout;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import buttonlisteners.IffButtonListener;

import net.miginfocom.swing.MigLayout;

public class ASTIffNode extends ASTPropositionalBinaryNode {
	
	private ASTPropositionalNode conditional;
	private ASTPropositionalNode doubleConditional;
	private int key;

	public ASTIffNode(int key, ASTPropositionalNode conditional, ASTPropositionalNode doubleConditional) {
		this.conditional = conditional;
		this.doubleConditional = doubleConditional;
		this.setKey(key);
	}
	
	public ASTPropositionalNode getLeft() {
		return this.conditional;
	}
	
	public ASTPropositionalNode getRight() {
		return this.doubleConditional;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitIffNode(this);
	}

	public void setLeft(ASTPropositionalNode left) {
		this.conditional = left;
	}

	public void setRight(ASTPropositionalNode right) {
		this.doubleConditional = right;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean equals(ASTPropositionalNode node) {
		if(!(node instanceof ASTIffNode)) {
			return false;
		}
		boolean left = getLeft().equals(((ASTIffNode) node).getLeft());
		boolean right = getRight().equals(((ASTIffNode) node).getRight());
		return left && right;
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("(");
		stringBuilder.append(getLeft().toString());
		stringBuilder.append(" \u2194 ");
		stringBuilder.append(getRight().toString());
		stringBuilder.append(")");
		return stringBuilder.toString();
	}
	
	public String toParserString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("(");
		stringBuilder.append(getLeft().toParserString());
		stringBuilder.append(" <> ");
		stringBuilder.append(getRight().toParserString());
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
		if(left == right) {
			return 1;
		}
		return 0;
	}
	
	public JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side) {
		JPanel panel = new JPanel(new MigLayout());
		JPanel left = getLeft().createJPanel(l, side);
		JPanel right = getRight().createJPanel(l, side);
		JButton button = new JButton("\u2194");
		makeTransparent(button);
		JButton open = new JButton("(");
		JButton close = new JButton(")");
		makeTransparent(open);
		makeTransparent(close);
		JPanel openBracket = new JPanel();
		openBracket.add(open);
		JPanel closeBracket = new JPanel();
		closeBracket.add(close);
		IffButtonListener listener = new IffButtonListener(l, getKey(), side);
		button.addActionListener(listener);
		panel.add(openBracket, BorderLayout.WEST);
		panel.add(left, BorderLayout.WEST);
		panel.add(button, BorderLayout.WEST);
		panel.add(right, BorderLayout.WEST);
		panel.add(closeBracket, BorderLayout.EAST);
		return panel;
	}


}
