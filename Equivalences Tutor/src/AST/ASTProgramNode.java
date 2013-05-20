package AST;

public class ASTProgramNode extends ASTPropositionalUnaryNode {

	private ASTPropositionalNode doubleConditional;
	private int key;
	
	public ASTProgramNode(int key, ASTPropositionalNode doubleConditional) {
		this.doubleConditional = doubleConditional;
		this.setKey(key);
	}
	
	public ASTPropositionalNode getLeaf() {
		return this.doubleConditional;
	}
	
	public void setLeaf(ASTPropositionalNode leaf) {
		this.doubleConditional = leaf;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitProgramNode(this);
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean equals(ASTPropositionalNode node) {
		if(!(node instanceof ASTProgramNode)) {
			return false;
		}
		return getLeaf().equals(((ASTProgramNode) node).getLeaf());
	}

	public String toString() {
		System.out.println(getLeaf().toString());
		return getLeaf().toString();
	}
	
	

}
