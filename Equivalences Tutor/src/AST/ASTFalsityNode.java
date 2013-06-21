package AST;

import gui.NewPersonalEquivalenceListener;

import java.awt.BorderLayout;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import buttonlisteners.TruthButtonListener;

public class ASTFalsityNode extends ASTPropositionalNode {
	
	private int key;
	
	public ASTFalsityNode (int key) {
		this.setKey(key);
	}

	public boolean equals(ASTPropositionalNode node) {
		return node instanceof ASTFalsityNode;
	}

	public TreeMap<String, Integer> numIdentifiers(
			TreeMap<String, Integer> identifiers) {
		return null;
	}

	public int value(TreeMap<String, Integer> id) {
		return 0;
	}

	public JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side) {
		JPanel panel = new JPanel(new MigLayout());
		JButton button = new JButton("\u22A5");
		makeTransparent(button);
		TruthButtonListener listener = new TruthButtonListener(l, getKey(), side);
		button.addActionListener(listener);
		panel.add(button, BorderLayout.WEST);
		return panel;
	}

	@Override
	public ASTPropositionalNode copy() {
		ASTFalsityNode newNode = new ASTFalsityNode(0);
		newNode.setKey(getKey());
		return newNode;
	}

	@Override
	public void visit(ASTVisitor visitor) {
		
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
		return "\u22A5";
	}

	@Override
	public String toParserString() {
		return "(B)";
	}

}
