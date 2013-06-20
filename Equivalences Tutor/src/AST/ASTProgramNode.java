package AST;

import gui.NewPersonalEquivalenceListener;

import java.util.TreeMap;

import javax.swing.JPanel;

public class ASTProgramNode extends ASTPropositionalUnaryNode {

	private ASTNode doubleConditional;
	private int key;
	
	public ASTProgramNode(int key, ASTNode doubleConditional) {
		this.doubleConditional = doubleConditional;
		this.setKey(key);
	}
	
	public ASTNode getLeaf() {
		return this.doubleConditional;
	}
	
	public void setLeaf(ASTNode leaf) {
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
		if(getLeaf() instanceof ASTPropositionalNode) {
			identifiers = ((ASTPropositionalNode) getLeaf()).numIdentifiers(identifiers);
		}
		return identifiers;
	}

	public int value(TreeMap<String, Integer> id) {
		if(getLeaf() instanceof ASTPropositionalNode) {
			return ((ASTPropositionalNode) getLeaf()).value(id);
		}
		return -1;
	}

	public JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side) {
		return getLeaf().createJPanel(l, side);
	}
	
	public ASTPropositionalNode copy() {
		ASTProgramNode newNode = new ASTProgramNode(0, null);
		newNode.setLeaf(getLeaf().copy());
		newNode.setKey(getKey());
		return newNode;
	}

	
}
