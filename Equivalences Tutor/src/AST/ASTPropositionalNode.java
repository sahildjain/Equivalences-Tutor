package AST;

import java.util.TreeMap;

public abstract class ASTPropositionalNode extends ASTNode {
	
	public abstract boolean equals(ASTPropositionalNode node);
	public abstract TreeMap<String, Integer> numIdentifiers(TreeMap<String, Integer> identifiers);
	public abstract int value(TreeMap<String, Integer> id);
	
}
