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

	public boolean equals(ASTPropositionalNode node) {
		if(!(node instanceof ASTIdentifierNode)) {
			return false;
		}
		return getLeaf().equals(((ASTIdentifierNode) node).getLeaf());
	}

	public String toString() {
		return getLeaf();
	}

}
