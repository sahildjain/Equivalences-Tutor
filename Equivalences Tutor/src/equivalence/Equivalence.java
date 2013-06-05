package equivalence;

import AST.*;

public abstract class Equivalence {
	
	private AST tree;
	private int key;
	
	public Equivalence(AST tree, int key) {
		this.setTree(tree);
		this.setKey(key);
	}
	
	public static ASTNode find(ASTNode node, int key) {
		if(node.getKey() == key) {
			return node;
		}
		if(node instanceof ASTPropositionalBinaryNode) {
			ASTPropositionalBinaryNode binary = (ASTPropositionalBinaryNode) node;
			ASTNode left = find(binary.getLeft(), key);
			ASTNode right = find(binary.getRight(), key);
			if(left != null) {
				return left;
			}
			if(right != null) {
				return right;
			}
		}
		if(node instanceof ASTPropositionalUnaryNode) {
			ASTPropositionalUnaryNode unary = (ASTPropositionalUnaryNode) node;
			ASTNode ret = find(unary.getLeaf(), key);
			if(ret != null) {
				return ret;
			}
		}
		return null;
	}
	
	public static ASTPropositionalNode replace(ASTPropositionalNode prop, ASTNode node, int key) {
		if(prop.getKey() == key) {
			return (ASTPropositionalNode) node;
		}
		if(prop instanceof ASTPropositionalBinaryNode) {
			ASTPropositionalBinaryNode binary = (ASTPropositionalBinaryNode) prop;
			if(find(binary.getLeft(), key) != null) {
				binary.setLeft(replace(((ASTPropositionalBinaryNode) prop).getLeft(), node, key));
			}
			if(find(((ASTPropositionalBinaryNode) prop).getRight(), key) != null) {
				binary.setRight(replace(((ASTPropositionalBinaryNode) prop).getRight(), node, key));
			}
			return binary;
		}
		if(prop instanceof ASTPropositionalUnaryNode) {
			ASTPropositionalUnaryNode unary = (ASTPropositionalUnaryNode) prop;
			unary.setLeaf(replace(unary.getLeaf(), node, key));
			return unary;
		}
		return null;
	}

	public AST getTree() {
		return tree;
	}

	public void setTree(AST tree) {
		this.tree = tree;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

}
