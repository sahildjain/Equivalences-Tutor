package AST;

public class ASTIdentifierNode extends ASTPropositionalBinaryNode {
	
	private String id;
	
	public ASTIdentifierNode(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitIdentifierNode(this);
	}

}
