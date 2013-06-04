package AST;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class AST {
	
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
	
	public String toParserString() {
		return getRoot().toParserString();
	}
	
	public boolean equivalent(AST tree) {
		if(this.identifiers().keySet().equals(tree.identifiers().keySet())) {
			int[][] t1 = this.createTruthTable();
			int[][] t2 = tree.createTruthTable();
			boolean ret = Arrays.deepEquals(t1, t2);
			return ret;
		}
		else {
			
		}
		return false;
	}
	
	public int value(TreeMap<String, Integer> id) {
		return getRoot().value(id);
	}
	
	public int[][] createTruthTable() {
		TreeMap<String, Integer> identifiers = this.identifiers();
		int numIdentifiers = identifiers.size();
		int temp = (int) Math.pow(2, numIdentifiers);
		int[][] truthTable = new int[temp][numIdentifiers + 1];
		for(int i = 0; i < truthTable.length; i++) {
			String binary = Integer.toBinaryString(i);
			if(binary.length() < numIdentifiers) {
				int numZeroes = numIdentifiers - binary.length();
				String zeroes = "";
				while(zeroes.length() < numZeroes) {
					zeroes += "0";
				}
				binary = zeroes + binary;
			}
			for(int j = 0; j < truthTable[i].length - 1; j++) {
				char c = binary.charAt(j);
				int n = Integer.parseInt(Character.toString(c));
				truthTable[i][j] = n;
			}
		}
		for(int i = 0; i < truthTable.length; i++) {
			Set<String> keys = identifiers.keySet();
			TreeMap<String, Integer> id = new TreeMap<String, Integer>();
			Iterator<String> it = keys.iterator();
			int j = 0;
			while(it.hasNext()) {
				String key = (String) it.next();
				id.put(key, truthTable[i][j]);
				j++;
			}
			truthTable[i][j] = value(id);
		}
		/*for(int i = 0; i < truthTable.length; i++) {
			for(int j = 0; j < truthTable[i].length; j++) {
				System.out.print(truthTable[i][j] + " ");
			}
			System.out.println();
		}*/
		return truthTable;
	}
	
	public TreeMap<String, Integer> identifiers() {
		TreeMap<String, Integer> identifiers = new TreeMap<String, Integer>();
		identifiers = getRoot().numIdentifiers(identifiers);
		return identifiers;
	}
	
	public AST copy() {
		AST t = new AST(0, null);
		t.setKey(this.getKey());
		t.setRoot((ASTProgramNode) this.getRoot().copy());
		return t;
	}

}
