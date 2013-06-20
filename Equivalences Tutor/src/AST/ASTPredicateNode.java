package AST;

import gui.NewPersonalEquivalenceListener;

import javax.swing.JPanel;

public abstract class ASTPredicateNode extends ASTNode {
	
	public abstract ASTPredicateNode copy();
	public abstract String toString();
	public abstract String toParserString();
	public abstract JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side);
	
}
