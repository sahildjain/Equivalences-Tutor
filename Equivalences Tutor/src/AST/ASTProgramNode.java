package AST;

public class ASTProgramNode extends ASTPropositionalUnaryNode {

	private ASTPropositionalNode doubleConditional;
	
	public ASTProgramNode(ASTPropositionalNode doubleConditional) {
		this.doubleConditional = doubleConditional;
	}
	
	public ASTPropositionalNode getLeaf() {
		return this.doubleConditional;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitProgramNode(this);
	}

}
