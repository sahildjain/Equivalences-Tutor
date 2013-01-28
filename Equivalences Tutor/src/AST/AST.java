package AST;

public class AST {
	
	private ASTProgramNode root;
	
	public AST(ASTProgramNode root) {
		this.root = root;
	}
	
	public void visit(ASTVisitor visitor) {
		getRoot().visit(visitor);
	}
	
	public ASTProgramNode getRoot() {
		return this.root;
	}

}
