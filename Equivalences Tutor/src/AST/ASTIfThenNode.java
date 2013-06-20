package AST;

import gui.NewPersonalEquivalenceListener;

import java.awt.BorderLayout;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import buttonlisteners.IfButtonListener;

import net.miginfocom.swing.MigLayout;

public class ASTIfThenNode extends ASTPropositionalBinaryNode {
	
	private ASTNode disjunction;
	private ASTNode conditional;
	private int key;

	public ASTIfThenNode(int key, ASTNode disjunction, ASTNode conditional) {
		this.disjunction = disjunction;
		this.conditional = conditional;
		this.setKey(key);
	}
	
	public ASTNode getLeft() {
		return this.disjunction;
	}
	
	public ASTNode getRight() {
		return this.conditional;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitIfThenNode(this);
	}

	public void setLeft(ASTNode left) {
		this.disjunction = left;
	}

	public void setRight(ASTNode right) {
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
	
	public String toParserString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("(");
		stringBuilder.append(getLeft().toParserString());
		stringBuilder.append(" -> ");
		stringBuilder.append(getRight().toParserString());
		stringBuilder.append(")");
		return stringBuilder.toString();
	}
	
	public TreeMap<String, Integer> numIdentifiers(TreeMap<String, Integer> identifiers) {
		if(getLeft() instanceof ASTPropositionalNode) {
			identifiers = ((ASTPropositionalNode) getLeft()).numIdentifiers(identifiers);
		}
		if(getRight() instanceof ASTPropositionalNode) {
			identifiers = ((ASTPropositionalNode) getRight()).numIdentifiers(identifiers);
		}
		return identifiers;
	}

	public int value(TreeMap<String, Integer> id) {
		int left = -1;
		int right = -1;
		if(getLeft() instanceof ASTPropositionalNode) {
			left = ((ASTPropositionalNode) getLeft()).value(id);
		}
		if(getRight() instanceof ASTPropositionalNode) {
			right = ((ASTPropositionalNode) getRight()).value(id);
		}
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

	public ASTPropositionalNode copy() {
		ASTIfThenNode newNode = new ASTIfThenNode(0, null, null);
		newNode.setLeft(getLeft().copy());
		newNode.setRight(getRight().copy());
		newNode.setKey(getKey());
		return newNode;
	}
	
}
