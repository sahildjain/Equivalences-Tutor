package AST;

public class ASTProgramNode extends ASTPropositionalUnaryNode {

	private ASTPropositionalNode doubleConditional;
	
	public ASTProgramNode(ASTPropositionalNode doubleConditional) {
		this.doubleConditional = doubleConditional;
	}
	
	public ASTPropositionalNode getLeaf() {
		return this.doubleConditional;
	}
	
	public void setLeaf(ASTPropositionalNode leaf) {
		this.doubleConditional = leaf;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitProgramNode(this);
	}

}
