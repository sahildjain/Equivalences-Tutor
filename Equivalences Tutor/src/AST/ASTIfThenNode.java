package AST;

public class ASTIfThenNode extends ASTPropositionalBinaryNode {
	
	private ASTPropositionalNode disjunction;
	private ASTPropositionalNode conditional;

	public ASTIfThenNode(ASTPropositionalNode disjunction, ASTPropositionalNode conditional) {
		this.disjunction = disjunction;
		this.conditional = conditional;
	}
	
	public ASTPropositionalNode getDisjunction() {
		return this.disjunction;
	}
	
	public ASTPropositionalNode getConditional() {
		return this.conditional;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitIfThenNode(this);
	}

}
