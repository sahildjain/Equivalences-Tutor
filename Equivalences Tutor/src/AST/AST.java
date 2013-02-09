package AST;

public class AST {
	
	private ASTProgramNode root;
	
	public AST(ASTProgramNode root) {
		this.setRoot(root);
	}
	
	public void visit(ASTVisitor visitor) {
		getRoot().visit(visitor);
	}
	
	public ASTProgramNode getRoot() {
		return this.root;
	}
	
	public void setRoot(ASTProgramNode node) {
		this.root = node;
	}

}
