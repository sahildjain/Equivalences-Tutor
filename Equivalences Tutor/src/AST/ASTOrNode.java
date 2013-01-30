package AST;

public class ASTOrNode extends ASTPropositionalBinaryNode {
	
	private ASTPropositionalNode conjunction;
	private ASTPropositionalNode disjunction;

	public ASTOrNode(ASTPropositionalNode conjunction, ASTPropositionalNode disjunction) {
		this.conjunction = conjunction;
		this.disjunction = disjunction;
	}
	
	public ASTPropositionalNode getConjunction() {
		return this.conjunction;
	}
	
	public ASTPropositionalNode getDisjunction() {
		return this.disjunction;
	}

	public void visit(ASTVisitor visitor) {
		visitor.visitOrNode(this);
	}

}
