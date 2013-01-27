package AST;

public interface ASTVisitor {

	public void visitAndNode(ASTAndNode node);
	public void visitOrNode(ASTOrNode node);
	public void visitNotNode(ASTNotNode node);
}
