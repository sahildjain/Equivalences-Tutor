package AST;

public class ASTOrNode extends ASTDisjunctionNode {
	
	private ASTConjunctionNode conjunction;
	private ASTDisjunctionNode disjunction;

	public ASTOrNode(ASTConjunctionNode conjunction, ASTDisjunctionNode disjunction) {
		this.conjunction = conjunction;
		this.disjunction = disjunction;
	}
	
	public ASTConjunctionNode getConjunction() {
		return this.conjunction;
	}
	
	public ASTDisjunctionNode getDisjunction() {
		return this.disjunction;
	}

	public void visit(ASTVisitor visitor) {
		visitor.visitOrNode(this);
	}

}
