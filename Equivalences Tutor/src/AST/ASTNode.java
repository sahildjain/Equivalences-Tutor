package AST;

public abstract class ASTNode {
	
	public abstract void visit(ASTVisitor visitor);
	public abstract int getKey();
	public abstract void setKey(int key);

}
