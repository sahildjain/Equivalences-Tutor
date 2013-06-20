package AST;

import java.awt.BorderLayout;

import gui.NewPersonalEquivalenceListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import buttonlisteners.ExistsButtonListener;

import net.miginfocom.swing.MigLayout;

public class ASTExistsNode extends ASTPredicateNode {
	
	private int key;
	private ASTIdentifierNode identifier;
	private ASTNode node;
	
	public ASTExistsNode(int key, ASTIdentifierNode identifier, ASTNode node) {
		this.setIdentifier(identifier);
		this.setNode(node);
		this.setKey(key);
	}

	public ASTPredicateNode copy() {
		ASTExistsNode newNode = new ASTExistsNode(0, null, null);
		newNode.setKey(getKey());
		newNode.setIdentifier(getIdentifier());
		newNode.setNode(getNode());
		return newNode;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\u2203");
		stringBuilder.append(getIdentifier().toString());
		stringBuilder.append("(" + getNode().toString() + ")");
		return stringBuilder.toString();
	}

	public String toParserString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("(E)");
		stringBuilder.append(getIdentifier().toString());
		stringBuilder.append("(" + getNode().toString() + ")");
		return stringBuilder.toString();
	}

	public JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side) {
		JPanel panel = new JPanel(new MigLayout());
		JButton existsButton = new JButton("\u2203");
		existsButton.addActionListener(new ExistsButtonListener(l, getKey(), side));
		JButton identifierButton = new JButton(getIdentifier().toString());
		makeTransparent(existsButton);
		makeTransparent(identifierButton);
		panel.add(existsButton, BorderLayout.WEST);
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

	public void visit(ASTVisitor visitor) {
		visitor.visitExistsNode(this);
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

}
