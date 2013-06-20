package AST;

import gui.NewPersonalEquivalenceListener;

import java.awt.BorderLayout;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import buttonlisteners.OrButtonListener;

import net.miginfocom.swing.MigLayout;

public class ASTOrNode extends ASTPropositionalBinaryNode {
	
	private ASTNode conjunction;
	private ASTNode disjunction;
	private int key;

	public ASTOrNode(int key, ASTNode conjunction, ASTNode disjunction) {
		this.conjunction = conjunction;
		this.disjunction = disjunction;
		this.setKey(key);
	}
	
	public ASTNode getLeft() {
		return this.conjunction;
	}
	
	public ASTNode getRight() {
		return this.disjunction;
	}

	public void visit(ASTVisitor visitor) {
		visitor.visitOrNode(this);
	}

	public void setLeft(ASTNode left) {
		this.conjunction = left;
	}

	public void setRight(ASTNode right) {
		this.disjunction = right;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	public boolean equals(ASTPropositionalNode node) {
		if(!(node instanceof ASTOrNode)) {
			return false;
		}
		boolean left = getLeft().equals(((ASTOrNode) node).getLeft());
		boolean right = getRight().equals(((ASTOrNode) node).getRight());
		return left && right;
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("(");
		stringBuilder.append(getLeft().toString());
		stringBuilder.append(" \u2228 ");
		stringBuilder.append(getRight().toString());
		stringBuilder.append(")");
		return stringBuilder.toString();
	}
	
	public String toParserString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("(");
		stringBuilder.append(getLeft().toParserString());
		stringBuilder.append(" | ");
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
		if(left == -1 || right == -1) {
			return -1;
		}
		if(left == 1 || right == 1) {
			return 1;
		}
		return 0;
	}

	public JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side) {
		JPanel panel = new JPanel(new MigLayout());
		JPanel left = getLeft().createJPanel(l, side);
		JPanel right = getRight().createJPanel(l, side);
		JButton button = new JButton("\u2228");
		makeTransparent(button);
		JButton open = new JButton("(");
		JButton close = new JButton(")");
		makeTransparent(open);
		makeTransparent(close);
		JPanel openBracket = new JPanel();
		openBracket.add(open);
		JPanel closeBracket = new JPanel();
		closeBracket.add(close);
		OrButtonListener listener = new OrButtonListener(l, getKey(), side);
		button.addActionListener(listener);
		panel.add(openBracket, BorderLayout.WEST);
		panel.add(left, BorderLayout.WEST);
		panel.add(button, BorderLayout.WEST);
		panel.add(right, BorderLayout.WEST);
		panel.add(closeBracket, BorderLayout.EAST);
		return panel;
	}
	
	public ASTNode copy() {
		ASTOrNode newNode = new ASTOrNode(0, null, null);
		newNode.setLeft(getLeft().copy());
		newNode.setRight(getRight().copy());
		newNode.setKey(getKey());
		return newNode;
	}

}
