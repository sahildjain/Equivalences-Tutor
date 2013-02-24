package AST;

public class ASTIdentifierNode extends ASTPropositionalNode {
	
	private String id;
	private int key;
	
	public ASTIdentifierNode(int key, String id) {
		this.id = id;
		this.setKey(key);
	}
	
	public String getLeaf() {
		return this.id;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitIdentifierNode(this);
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

}
