package AST;

public abstract class ASTPropositionalUnaryNode extends ASTPropositionalNode {
	
	public abstract ASTNode getLeaf();
	public abstract void setLeaf(ASTNode leaf);
}
