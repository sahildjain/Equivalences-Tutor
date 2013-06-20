package AST;

import gui.NewPersonalEquivalenceListener;

import java.util.TreeMap;

import javax.swing.JPanel;

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

	@Override
	public JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side) {
		return null;
	}

	@Override
	public ASTPropositionalNode copy() {
		return null;
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
		return null;
	}

}
