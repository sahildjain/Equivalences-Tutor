package AST;

public class ASTIffNode extends ASTPropositionalBinaryNode {
	
	private ASTPropositionalNode conditional;
	private ASTPropositionalNode doubleConditional;
	private int key;

	public ASTIffNode(int key, ASTPropositionalNode conditional, ASTPropositionalNode doubleConditional) {
		this.conditional = conditional;
		this.doubleConditional = doubleConditional;
		this.setKey(key);
	}
	
	public ASTPropositionalNode getLeft() {
		return this.conditional;
	}
	
	public ASTPropositionalNode getRight() {
		return this.doubleConditional;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitIffNode(this);
	}

	public void setLeft(ASTPropositionalNode left) {
		this.conditional = left;
	}

	public void setRight(ASTPropositionalNode right) {
		this.doubleConditional = right;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean equals(ASTPropositionalNode node) {
		if(!(node instanceof ASTIffNode)) {
			return false;
		}
		boolean left = getLeft().equals(((ASTIffNode) node).getLeft());
		boolean right = getRight().equals(((ASTIffNode) node).getRight());
		return left && right;
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("(");
		stringBuilder.append(getLeft().toString());
		stringBuilder.append(" \u2194 ");
		stringBuilder.append(getRight().toString());
		stringBuilder.append(")");
		return stringBuilder.toString();
	}

}
