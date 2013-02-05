package AST;

public class ASTAndNode extends ASTPropositionalBinaryNode {
	
	private ASTPropositionalNode unary;
	private ASTPropositionalNode propositional;
	
	public ASTAndNode(ASTPropositionalNode unary, ASTPropositionalNode propositional) {
		this.unary = unary;
		this.propositional = propositional;
	}
	
	public ASTPropositionalNode getLeft() {
		return this.unary;
	}
	
	public ASTPropositionalNode getRight() {
		return this.propositional;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitAndNode(this);
	}

	public void setLeft(ASTPropositionalNode left) {
		this.unary = left;
	}

	public void setRight(ASTPropositionalNode right) {
		this.propositional = right;
	}
	
}
