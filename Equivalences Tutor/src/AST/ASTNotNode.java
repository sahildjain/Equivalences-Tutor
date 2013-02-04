package AST;

public class ASTNotNode extends ASTPropositionalUnaryNode {
	
	private ASTPropositionalNode unary;
	
	public ASTNotNode(ASTPropositionalNode unary) {
		this.unary = unary;
	}
	
	public ASTPropositionalNode getLeaf() {
		return this.unary;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitNotNode(this);
	}

}
