package AST;

public class ASTIffNode extends ASTPropositionalBinaryNode {
	
	private ASTPropositionalNode conditional;
	private ASTPropositionalNode doubleConditional;

	public ASTIffNode(ASTPropositionalNode conditional, ASTPropositionalNode doubleConditional) {
		this.conditional = conditional;
		this.doubleConditional = doubleConditional;
	}
	
	public ASTPropositionalNode getLeft() {
		return this.conditional;
	}
	
	public ASTPropositionalNode getRight() {
		return this.doubleConditional;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitIffNode(this);
	}

	public void setLeft(ASTPropositionalNode left) {
		this.conditional = left;
	}

	public void setRight(ASTPropositionalNode right) {
		this.doubleConditional = right;
	}

}
