package AST;

public class ASTIdentifierNode extends ASTNode {
	
	private String id;
	
	public ASTIdentifierNode(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}

}
