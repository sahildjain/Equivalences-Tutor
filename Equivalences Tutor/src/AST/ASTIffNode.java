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

	public TreeMap<String, Integer> numIdentifiers(TreeMap<String, Integer> identifiers) {
		identifiers = getLeft().numIdentifiers(identifiers);
		identifiers = getRight().numIdentifiers(identifiers);
		return identifiers;
	}

	public int value() {
		int left = getLeft().value();
		int right = getRight().value();
		if(left == right) {
			return 1;
		}
		return 0;
	}
	
	public JPanel createJPanel(NewPersonalEquivalenceListener l) {
		JPanel panel = new JPanel(new MigLayout());
		JPanel left = getLeft().createJPanel(l);
		JPanel right = getRight().createJPanel(l);
		JButton button = new JButton("\u2194");
		IffButtonListener listener = new IffButtonListener(getKey());
		button.addActionListener(listener);
		panel.add(left, BorderLayout.WEST);
		panel.add(button, BorderLayout.CENTER);
		panel.add(right, BorderLayout.EAST);
		return panel;
	}


}
