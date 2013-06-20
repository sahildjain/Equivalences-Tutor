package AST;

public interface ASTVisitor {

	public void visitAndNode(ASTAndNode node);
	public void visitOrNode(ASTOrNode node);
	public void visitNotNode(ASTNotNode node);
	public void visitIdentifierNode(ASTIdentifierNode node);
	public void visitIfThenNode(ASTIfThenNode node);
	public void visitIffNode(ASTIffNode node);
	public void visitProgramNode(ASTProgramNode node);
	public void visitForAllNode(ASTForAllNode node);
	public void visitExistsNode(ASTExistsNode node);
	
}
