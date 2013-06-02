package AST;

import gui.NewPersonalEquivalenceListener;

import java.util.TreeMap;

import javax.swing.JPanel;

public class ASTProgramNode extends ASTPropositionalUnaryNode {

	private ASTPropositionalNode doubleConditional;
	private int key;
	
	public ASTProgramNode(int key, ASTPropositionalNode doubleConditional) {
		this.doubleConditional = doubleConditional;
		this.setKey(key);
	}
	
	public ASTPropositionalNode getLeaf() {
		return this.doubleConditional;
	}
	
	public void setLeaf(ASTPropositionalNode leaf) {
		this.doubleConditional = leaf;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitProgramNode(this);
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean equals(ASTPropositionalNode node) {
		if(!(node instanceof ASTProgramNode)) {
			return false;
		}
		return getLeaf().equals(((ASTProgramNode) node).getLeaf());
	}

	public String toString() {
		return getLeaf().toString();
	}
	
	public String toParserString() {
		return getLeaf().toParserString();
	}
	
	public TreeMap<String, Integer> numIdentifiers(TreeMap<String, Integer> identifiers) {
		identifiers = getLeaf().numIdentifiers(identifiers);
		return identifiers;
	}

	public int value(TreeMap<String, Integer> id) {
		return getLeaf().value(id);
	}

	public JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side) {
		return getLeaf().createJPanel(l, side);
	}

	
}
