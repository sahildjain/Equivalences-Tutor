package AST;

public abstract class ASTPropositionalNode extends ASTNode {
	
	public abstract int getKey();
	public abstract void setKey(int key);
	public abstract boolean equals(ASTPropositionalNode node);
	public abstract String toString();
	
}
