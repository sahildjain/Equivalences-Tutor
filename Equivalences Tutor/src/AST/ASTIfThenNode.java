package AST;

public class ASTIfThenNode extends ASTConditionalNode {
	
	private ASTDisjunctionNode disjunction;
	private ASTConditionalNode conditional;

	public ASTIfThenNode(ASTDisjunctionNode disjunction, ASTConditionalNode conditional) {
		this.disjunction = disjunction;
		this.conditional = conditional;
	}
	
	public ASTDisjunctionNode getDisjunction() {
		return this.disjunction;
	}
	
	public ASTConditionalNode getConditional() {
		return this.conditional;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitIfThenNode(this);
	}

}
