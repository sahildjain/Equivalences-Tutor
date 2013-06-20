package AST;

import gui.NewPersonalEquivalenceListener;

import java.util.TreeMap;

import javax.swing.JPanel;

public class ASTTruthNode extends ASTPropositionalNode {
	
	private int key;
	
	public ASTTruthNode(int key) {
		this.setKey(key);
	}

	@Override
	public boolean equals(ASTPropositionalNode node) {
		return node instanceof ASTTruthNode;
	}

	@Override
	public TreeMap<String, Integer> numIdentifiers(
			TreeMap<String, Integer> identifiers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int value(TreeMap<String, Integer> id) {
		return 1;
	}

	@Override
	public JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ASTPropositionalNode copy() {
		ASTTruthNode newNode = new ASTTruthNode(0);
		newNode.setKey(getKey());
		return newNode;
	}

	@Override
	public void visit(ASTVisitor visitor) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

}
