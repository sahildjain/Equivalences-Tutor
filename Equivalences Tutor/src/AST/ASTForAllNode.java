package AST;

import java.awt.BorderLayout;

import gui.NewPersonalEquivalenceListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import buttonlisteners.ForAllButtonListener;

import net.miginfocom.swing.MigLayout;

public class ASTForAllNode extends ASTPredicateNode {
	
	private int key;
	private ASTIdentifierNode identifier;
	private ASTNode node;
	
	public ASTForAllNode(int key, ASTIdentifierNode identifier, ASTNode node) {
		this.setIdentifier(identifier);
		this.setNode(node);
		this.setKey(key);
	}

	public void visit(ASTVisitor visitor) {
		visitor.visitForAllNode(this);
	}

	public int getKey() {
		return this.key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public ASTIdentifierNode getIdentifier() {
		return identifier;
	}

	public void setIdentifier(ASTIdentifierNode identifier) {
		this.identifier = identifier;
	}

	public ASTNode getNode() {
		return node;
	}

	public void setNode(ASTNode node) {
		this.node = node;
	}

	public ASTPredicateNode copy() {
		ASTForAllNode newNode = new ASTForAllNode(0, null, null);
		newNode.setKey(getKey());
		newNode.setIdentifier(getIdentifier());
		newNode.setNode(getNode());
		return newNode;
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\u2200");
		stringBuilder.append(getIdentifier().toString());
		stringBuilder.append("(" + getNode().toString() + ")");
		return stringBuilder.toString();
	}

	public String toParserString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("(A)");
		stringBuilder.append(getIdentifier().toString());
		stringBuilder.append("(" + getNode().toString() + ")");
		return stringBuilder.toString();
	}

	public JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side) {
		JPanel panel = new JPanel(new MigLayout());
		JButton forAllButton = new JButton("\u2200");
		forAllButton.addActionListener(new ForAllButtonListener(l, getKey(), side));
		JButton identifierButton = new JButton(getIdentifier().toString());
		makeTransparent(forAllButton);
		makeTransparent(identifierButton);
		panel.add(forAllButton, BorderLayout.WEST);
		panel.add(identifierButton, BorderLayout.WEST);
		JButton open = new JButton("(");
		JButton close = new JButton(")");
		makeTransparent(open);
		makeTransparent(close);
		panel.add(open, BorderLayout.WEST);
		panel.add(getNode().createJPanel(l, side), BorderLayout.WEST);
		panel.add(close, BorderLayout.WEST);
		return panel;
	}

}
