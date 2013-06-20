package AST;

public abstract class ASTPropositionalBinaryNode extends ASTPropositionalNode {
	
	public abstract ASTNode getLeft();
	public abstract ASTNode getRight();
	public abstract void setLeft(ASTNode left);
	public abstract void setRight(ASTNode right);

}
