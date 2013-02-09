package AST;

public class ASTIdentifierNode extends ASTPropositionalNode {
	
	private String id;
	
	public ASTIdentifierNode(String id) {
		this.id = id;
	}
	
	public String getLeaf() {
		return this.id;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitIdentifierNode(this);
	}

}
