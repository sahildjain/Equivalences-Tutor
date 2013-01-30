package AST;

public class ASTIffNode extends ASTPropositionalBinaryNode {
	
	private ASTPropositionalNode conditional;
	private ASTPropositionalNode doubleConditional;

	public ASTIffNode(ASTPropositionalNode conditional, ASTPropositionalNode doubleConditional) {
		this.conditional = conditional;
		this.doubleConditional = doubleConditional;
	}
	
	public ASTPropositionalNode getConditional() {
		return this.conditional;
	}
	
	public ASTPropositionalNode getDoubleConditional() {
		return this.doubleConditional;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitIffNode(this);
	}

}
