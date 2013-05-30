package AST;

import java.util.TreeMap;

public class AST implements Cloneable {
	
	private ASTProgramNode root;
	private int key;
	
	public AST(int key, ASTProgramNode root) {
		this.setRoot(root);
		this.setKey(key);
	}
	
	public boolean equals(AST tree) {
		return getRoot().equals(tree.getRoot());
	}
	
	public void visit(ASTVisitor visitor) {
		getRoot().visit(visitor);
	}
	
	public ASTProgramNode getRoot() {
		return this.root;
	}
	
	public void setRoot(ASTProgramNode node) {
		this.root = node;
	}

	public int getKey() {
		return this.key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	public String toString() {
		return getRoot().toString();
	}
	
	// TODO
	public boolean equivalent(AST tree) {
		numIdentifiers();
		return false;
	}
	
	/*public int[][] truthTable() {
		int numIdentifiers = numIdentifiers();
		int temp = (int) Math.pow(2, numIdentifiers);
		int[][] truthTable = new int[temp][numIdentifiers];
		for(int i = 0; i < temp; ++i) {
			String binary = Integer.toBinaryString(i);
			
		}
		return null;
	}*/
	
	private int numIdentifiers() {
		TreeMap<String, Integer> identifiers = new TreeMap<String, Integer>();
		identifiers = getRoot().numIdentifiers(identifiers);
		return identifiers.size();
	}
	
	@Override
	public Object clone() {
		try {
			return super.clone();
		}
		catch(CloneNotSupportedException e) {
			System.out.println("Clone not allowed");
			return this;
		}
	}

}
