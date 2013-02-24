package AST;

public class AST {
	
	private ASTProgramNode root;
	private int key;
	
	public AST(int key, ASTProgramNode root) {
		this.setRoot(root);
		this.setKey(key);
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

	public int getCounter() {
		return this.key;
	}

	public void setKey(int key) {
		this.key = key;
	}

}
