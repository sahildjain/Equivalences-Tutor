package AST;

import gui.NewPersonalEquivalenceListener;

import java.awt.BorderLayout;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import buttonlisteners.TruthButtonListener;

public class ASTTruthNode extends ASTPropositionalNode {
	
	private int key;
	
	public ASTTruthNode(int key) {
		this.setKey(key);
	}

	public boolean equals(ASTPropositionalNode node) {
		return node instanceof ASTTruthNode;
	}

	public TreeMap<String, Integer> numIdentifiers(
			TreeMap<String, Integer> identifiers) {
		// TODO Auto-generated method stub
		return null;
	}

	public int value(TreeMap<String, Integer> id) {
		return 1;
	}

	public JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side) {
		JPanel panel = new JPanel(new MigLayout());
		JButton button = new JButton("\u22A4");
		makeTransparent(button);
		TruthButtonListener listener = new TruthButtonListener(l, getKey(), side);
		button.addActionListener(listener);
		panel.add(button, BorderLayout.WEST);
		return panel;
	}

	public ASTPropositionalNode copy() {
		ASTTruthNode newNode = new ASTTruthNode(0);
		newNode.setKey(getKey());
		return newNode;
	}

	@Override
	public int getKey() {
		return this.key;
	}

	@Override
	public void setKey(int key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "\u22A4";
	}

	@Override
	public String toParserString() {
		return "(T)";
	}

	@Override
	public void visit(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

}
