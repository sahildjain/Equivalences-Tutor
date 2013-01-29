package AST;

public class ASTProgramNode extends ASTNode{

	private ASTDoubleConditionalNode doubleConditional;
	
	public ASTProgramNode(ASTDoubleConditionalNode doubleConditional) {
		this.doubleConditional = doubleConditional;
	}
	
	public ASTDoubleConditionalNode getDoubleConditional() {
		return this.doubleConditional;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitProgramNode(this);
	}

}
