package AST;

public abstract class ASTPropositionalUnaryNode extends ASTPropositionalNode {
	public abstract ASTPropositionalNode getLeaf();
	public abstract void setLeaf(ASTPropositionalNode leaf);
}
