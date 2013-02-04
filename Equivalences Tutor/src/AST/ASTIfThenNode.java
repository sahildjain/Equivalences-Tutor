package AST;

public class ASTIfThenNode extends ASTPropositionalBinaryNode {
	
	private ASTPropositionalNode disjunction;
	private ASTPropositionalNode conditional;

	public ASTIfThenNode(ASTPropositionalNode disjunction, ASTPropositionalNode conditional) {
		this.disjunction = disjunction;
		this.conditional = conditional;
	}
	
	public ASTPropositionalNode getLeft() {
		return this.disjunction;
	}
	
	public ASTPropositionalNode getRight() {
		return this.conditional;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitIfThenNode(this);
	}

}
