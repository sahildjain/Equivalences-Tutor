package AST;

import java.util.TreeMap;

public class ASTNotNode extends ASTPropositionalUnaryNode {
	
	private ASTPropositionalNode unary;
	private int key;
	
	public ASTNotNode(int key, ASTPropositionalNode unary) {
		this.unary = unary;
		this.setKey(key);
	}
	
	public ASTPropositionalNode getLeaf() {
		return this.unary;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitNotNode(this);
	}

	public void setLeaf(ASTPropositionalNode leaf) {
		this.unary = leaf;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	public boolean equals(ASTPropositionalNode node) {
		if(!(node instanceof ASTNotNode)) {
			return false;
		}
		return getLeaf().equals(((ASTNotNode) node).getLeaf());
	}
	
	public String toString() {
		return "\u00AC(" + getLeaf().toString() + ")";
	}
	
	public TreeMap<String, Integer> numIdentifiers(TreeMap<String, Integer> identifiers) {
		return getLeaf().numIdentifiers(identifiers);
	}

	public int value() {
		int leaf = getLeaf().value();
		if(leaf == 1) {
			return 0;
		}
		return 1;
	}

}
