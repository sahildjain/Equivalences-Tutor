package AST;

public class ASTAndNode extends ASTConjunctionNode {
	
	private ASTUnaryNode unary;
	private ASTConjunctionNode conjunction;
	
	public ASTAndNode(ASTUnaryNode unary, ASTConjunctionNode conjunction) {
		this.unary = unary;
		this.conjunction = conjunction;
	}
	
	public ASTUnaryNode getUnary() {
		return this.unary;
	}
	
	public ASTConjunctionNode getConjunction() {
		return this.conjunction;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitAndNode(this);
	}
	
}
