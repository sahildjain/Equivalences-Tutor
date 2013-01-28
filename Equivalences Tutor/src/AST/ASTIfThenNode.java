package AST;

public class ASTIfThenNode extends ASTConditionalNode {
	
	private ASTDisjunctionNode disjunction;
	private ASTIfThenNode ifthen;

	public ASTIfThenNode(ASTDisjunctionNode disjunction, ASTIfThenNode ifthen) {
		this.disjunction = disjunction;
		this.ifthen = ifthen;
	}
	
	public ASTDisjunctionNode getDisjunction() {
		return this.disjunction;
	}
	
	public ASTIfThenNode getIfThen() {
		return this.ifthen;
	}

}
