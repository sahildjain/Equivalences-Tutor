package AST;

import gui.NewPersonalEquivalenceListener;

import javax.swing.JPanel;

public class ASTRelationNode extends ASTPredicateNode {
	
	private int key;
	private ASTIdentifierNode identifier;
	private String relation;
	
	public ASTRelationNode(int key, ASTIdentifierNode identifier, String relation) {
		this.setIdentifier(identifier);
		this.setRelation(relation);
		this.setKey(key);
	}

	public ASTPredicateNode copy() {
		return null;
	}

	public String toString() {
		return null;
	}

	public String toParserString() {
		return null;
	}

	public JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side) {
		return null;
	}

	public void visit(ASTVisitor visitor) {
		
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

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
}
