package AST;

import gui.NewPersonalEquivalenceListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class ASTNode {
	
	public abstract void visit(ASTVisitor visitor);
	public abstract int getKey();
	public abstract void setKey(int key);
	public abstract String toString();
	public abstract String toParserString();
	public abstract JPanel createJPanel(NewPersonalEquivalenceListener l, boolean side);
	public abstract ASTNode copy();
	
	public void makeTransparent(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}

}
