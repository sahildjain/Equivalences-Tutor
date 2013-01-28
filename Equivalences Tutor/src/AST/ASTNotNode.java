package AST;

public class ASTNotNode extends ASTUnaryNode {
	
	private ASTUnaryNode unary;
	
	public ASTNotNode(ASTUnaryNode unary) {
		this.unary = unary;
	}
	
	public ASTUnaryNode getUnary() {
		return this.unary;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitNotNode(this);
	}

}
