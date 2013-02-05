package AST;

public abstract class ASTPropositionalBinaryNode extends ASTPropositionalNode {
	
	public abstract ASTPropositionalNode getLeft();
	public abstract ASTPropositionalNode getRight();
	public abstract void setLeft(ASTPropositionalNode left);
	public abstract void setRight(ASTPropositionalNode right);

}
