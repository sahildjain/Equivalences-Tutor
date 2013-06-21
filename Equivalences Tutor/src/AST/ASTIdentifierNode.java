package AST;

import gui.NewPersonalEquivalenceListener;

import java.awt.BorderLayout;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import buttonlisteners.IdentifierButtonListener;

import net.miginfocom.swing.MigLayout;

public class ASTIdentifierNode extends ASTPropositionalNode {
	
	private String id;
	private int key;
	private int value;
	private String variable1;
	private String variable2;
	
	public ASTIdentifierNode(int key, String id, String variable1, String variable2) {
		this.id = id;
		this.setKey(key);
		this.setVariable1(variable1);
		this.setVariable2(variable2);
	}
	
	public String getLeaf() {
		return this.id;
	}
	
	public void setLeaf(String id) {
		this.id = id;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitIdentifierNode(this);
	}

	public int getKey() {
		return this.key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean equals(ASTPropositionalNode node) {
		if(!(node instanceof ASTIdentifierNode)) {
			return false;
		}
		return getLeaf().equals(((ASTIdentifierNode) node).getLeaf());
	}

	public String toString() {
		if(getVariable1() == null && getVariable2() == null) {
			return getLeaf();
		}
		if(getVariable2() == null) {
			return getLeaf() + "(" + getVariable1() + ")";
		}
		return getLeaf() + "(" + getVariable1() + ", " + getVariable2() + ")";
	}
	
	public String toParserString() {
		return getLeaf();
	}

	public TreeMap<String, Integer> numIdentifiers(TreeMap<String, Integer> identifiers) {
		int value = 1;
		if(identifiers.containsKey(getLeaf())) {
			value = identifiers.get(getLeaf()) + 1;
		}
		identifiers.put(getLeaf(), value);
		return identifiers;
	}

	public int value(TreeMap<String, Integer> id) {
		setValue(id.get(getLeaf()));
		return this.getValue();
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side) {
		JButton open = new JButton("(");
		JButton close = new JButton(")");
		makeTransparent(open);
		makeTransparent(close);
		if(getVariable1() == null && getVariable2() == null) {
			JPanel panel = new JPanel(new MigLayout());
			JButton button = new JButton(getLeaf());
			makeTransparent(button);
			IdentifierButtonListener listener = new IdentifierButtonListener(l, getKey(), side);
			button.addActionListener(listener);
			panel.add(button);
			return panel;
		}
		if(getVariable2() == null) {
			JPanel panel = new JPanel(new MigLayout());
			JButton button = new JButton(getLeaf());
			makeTransparent(button);
			JButton id = new JButton(getVariable1());
			makeTransparent(id);
			IdentifierButtonListener listener = new IdentifierButtonListener(l, getKey(), side);
			button.addActionListener(listener);
			panel.add(button, BorderLayout.WEST);
			panel.add(open, BorderLayout.WEST);
			panel.add(id, BorderLayout.WEST);
			panel.add(close, BorderLayout.WEST);
			return panel;
		}
		JPanel panel = new JPanel(new MigLayout());
		JButton button = new JButton(getLeaf());
		makeTransparent(button);
		JButton id1 = new JButton(getVariable1() + ",");
		makeTransparent(id1);
		JButton id2 = new JButton(getVariable2());
		makeTransparent(id2);
		IdentifierButtonListener listener = new IdentifierButtonListener(l, getKey(), side);
		button.addActionListener(listener);
		panel.add(button, BorderLayout.WEST);
		panel.add(open, BorderLayout.WEST);
		panel.add(id1, BorderLayout.WEST);
		panel.add(id2, BorderLayout.WEST);
		panel.add(close, BorderLayout.WEST);
		return panel;
	}
	
	public ASTPropositionalNode copy() {
		ASTIdentifierNode newNode = new ASTIdentifierNode(0, null, null, null);
		newNode.setLeaf(getLeaf());
		newNode.setKey(getKey());
		return newNode;
	}

	public String getVariable1() {
		return variable1;
	}

	public void setVariable1(String variable1) {
		this.variable1 = variable1;
	}

	public String getVariable2() {
		return variable2;
	}

	public void setVariable2(String variable2) {
		this.variable2 = variable2;
	}

}
