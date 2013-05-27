package AST;

import gui.NewPersonalEquivalenceListener;

import java.util.TreeMap;
import javax.swing.JPanel;

public abstract class ASTPropositionalNode extends ASTNode {
	
	public abstract int getKey();
	public abstract void setKey(int key);
	public abstract boolean equals(ASTPropositionalNode node);
	public abstract String toString();
	public abstract TreeMap<String, Integer> numIdentifiers(TreeMap<String, Integer> identifiers);
	public abstract int value();
	public abstract JPanel createJPanel(NewPersonalEquivalenceListener l);
	
}
