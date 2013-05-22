package AST;

import java.util.TreeMap;

public class ASTAndNode extends ASTPropositionalBinaryNode {
	
	private ASTPropositionalNode unary;
	private ASTPropositionalNode propositional;
	private int key;
	
	public ASTAndNode(int key, ASTPropositionalNode unary, ASTPropositionalNode propositional) {
		this.unary = unary;
		this.propositional = propositional;
		this.setKey(key);
	}
	
	public ASTPropositionalNode getLeft() {
		return this.unary;
	}
	
	public ASTPropositionalNode getRight() {
		return this.propositional;
	}
	
	public void visit(ASTVisitor visitor) {
		visitor.visitAndNode(this);
	}

	public void setLeft(ASTPropositionalNode left) {
		this.unary = left;
	}

	public void setRight(ASTPropositionalNode right) {
		this.propositional = right;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean equals(ASTPropositionalNode node) {
		if(!(node instanceof ASTAndNode)) {
			return false;
		}
		boolean left = getLeft().equals(((ASTAndNode) node).getLeft());
		boolean right = getRight().equals(((ASTAndNode) node).getRight());
		return left && right;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("(");
		stringBuilder.append(getLeft().toString());
		stringBuilder.append(" \u2227 ");
		stringBuilder.append(getRight().toString());
		stringBuilder.append(")");
		return stringBuilder.toString();
	}

	public TreeMap<String, Integer> numIdentifiers(TreeMap<String, Integer> identifiers) {
		identifiers = getLeft().numIdentifiers(identifiers);
		identifiers = getRight().numIdentifiers(identifiers);
		return identifiers;
	}

	public int value() {
		int left = getLeft().value();
		int right = getRight().value();
		if (right == 1 && left == 1) {
			return 1;
		}
		return 0;
	}
	
	
}
