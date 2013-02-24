package AST;

public class ASTIfThenNode extends ASTPropositionalBinaryNode {
	
	private ASTPropositionalNode disjunction;
	private ASTPropositionalNode conditional;
	private int key;

	public ASTIfThenNode(int key, ASTPropositionalNode disjunction, ASTPropositionalNode conditional) {
		this.disjunction = disjunction;
		this.conditional = conditional;
		this.setKey(key);
	}
	
	public ASTPropositionalNode getLeft() {
		return this.disjunction;
	}
	
	public ASTPropositionalNode getRight() {
		return this.conditional;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitIfThenNode(this);
	}

	public void setLeft(ASTPropositionalNode left) {
		this.disjunction = left;
	}

	public void setRight(ASTPropositionalNode right) {
		this.conditional = right;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

}
