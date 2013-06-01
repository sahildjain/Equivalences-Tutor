package AST;

import gui.NewPersonalEquivalenceListener;

import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class ASTPropositionalNode extends ASTNode {
	
	public abstract boolean equals(ASTPropositionalNode node);
	public abstract String toString();
	public abstract TreeMap<String, Integer> numIdentifiers(TreeMap<String, Integer> identifiers);
	public abstract int value(TreeMap<String, Integer> id);
	public abstract JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side);
	
	public void makeTransparent(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}
	
}
