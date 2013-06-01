package AST;

import gui.NewPersonalEquivalenceListener;

import java.awt.BorderLayout;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import buttonlisteners.NotButtonListener;

import net.miginfocom.swing.MigLayout;

public class ASTNotNode extends ASTPropositionalUnaryNode {
	
	private ASTPropositionalNode unary;
	private int key;
	
	public ASTNotNode(int key, ASTPropositionalNode unary) {
		this.unary = unary;
		this.setKey(key);
	}
	
	public ASTPropositionalNode getLeaf() {
		return this.unary;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitNotNode(this);
	}

	public void setLeaf(ASTPropositionalNode leaf) {
		this.unary = leaf;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	public boolean equals(ASTPropositionalNode node) {
		if(!(node instanceof ASTNotNode)) {
			return false;
		}
		return getLeaf().equals(((ASTNotNode) node).getLeaf());
	}
	
	public String toString() {
		return "\u00AC(" + getLeaf().toString() + ")";
	}
	
	public TreeMap<String, Integer> numIdentifiers(TreeMap<String, Integer> identifiers) {
		return getLeaf().numIdentifiers(identifiers);
	}

	public int value(TreeMap<String, Integer> id) {
		int leaf = getLeaf().value(id);
		if(leaf == 1) {
			return 0;
		}
		return 1;
	}

	public JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side) {
		JPanel panel = new JPanel(new MigLayout());
		JPanel child = getLeaf().createJPanel(l, side);
		JButton button = new JButton("\u00AC");
		makeTransparent(button);
		JButton open = new JButton("(");
		JButton close = new JButton(")");
		makeTransparent(open);
		makeTransparent(close);
		JPanel openBracket = new JPanel();
		openBracket.add(open);
		JPanel closeBracket = new JPanel();
		closeBracket.add(close);
		NotButtonListener listener = new NotButtonListener(l, getKey(), side);
		button.addActionListener(listener);
		panel.add(button, BorderLayout.WEST);
		panel.add(openBracket, BorderLayout.WEST);
		panel.add(child, BorderLayout.WEST);
		panel.add(closeBracket, BorderLayout.EAST);
		return panel;
	}

}
