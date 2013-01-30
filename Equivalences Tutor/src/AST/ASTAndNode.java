package AST;

public class ASTAndNode extends ASTPropositionalBinaryNode {
	
	private ASTPropositionalNode unary;
	private ASTPropositionalNode propositional;
	
	public ASTAndNode(ASTPropositionalNode unary, ASTPropositionalNode propositional) {
		this.unary = unary;
		this.propositional = propositional;
	}
	
	public ASTPropositionalNode getUnary() {
		return this.unary;
	}
	
	public ASTPropositionalNode getPropositional() {
		return this.propositional;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitAndNode(this);
	}
	
}
