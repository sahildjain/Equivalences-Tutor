package AST;

public class ASTOrNode extends ASTPropositionalBinaryNode {
	
	private ASTPropositionalNode conjunction;
	private ASTPropositionalNode disjunction;
	private int key;

	public ASTOrNode(int key, ASTPropositionalNode conjunction, ASTPropositionalNode disjunction) {
		this.conjunction = conjunction;
		this.disjunction = disjunction;
		this.setKey(key);
	}
	
	public ASTPropositionalNode getLeft() {
		return this.conjunction;
	}
	
	public ASTPropositionalNode getRight() {
		return this.disjunction;
	}

	public void visit(ASTVisitor visitor) {
		visitor.visitOrNode(this);
	}

	public void setLeft(ASTPropositionalNode left) {
		this.conjunction = left;
	}

	public void setRight(ASTPropositionalNode right) {
		this.disjunction = right;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

}
