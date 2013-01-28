package AST;

public class ASTIffNode extends ASTDoubleConditionalNode {
	
	private ASTConditionalNode conditional;
	private ASTDoubleConditionalNode doubleConditional;

	public ASTIffNode(ASTConditionalNode conditional, ASTDoubleConditionalNode doubleConditional) {
		this.conditional = conditional;
		this.doubleConditional = doubleConditional;
	}
	
	public ASTConditionalNode getConditional() {
		return this.conditional;
	}
	
	public ASTDoubleConditionalNode getDoubleConditional() {
		return this.doubleConditional;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitIffNode(this);
	}

}
