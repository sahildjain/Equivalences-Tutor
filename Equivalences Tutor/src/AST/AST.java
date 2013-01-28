package AST;

public class AST {
	
	private ASTExpressionNode root;
	
	public AST(ASTExpressionNode root) {
		this.root = root;
	}
	
	public void visit(ASTVisitor visitor) {
		getRoot().visit(visitor);
	}
	
	public ASTExpressionNode getRoot() {
		return this.root;
	}

}
