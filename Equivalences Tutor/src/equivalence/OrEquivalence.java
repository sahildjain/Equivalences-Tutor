package equivalence;

import AST.*;

public class OrEquivalence extends Equivalence {
	
	private AST tree;
	private ASTOrNode orNode;
	
	public OrEquivalence(AST tree, ASTOrNode orNode) {
		this.setTree(tree);
		this.setOrNode(orNode);
	}
	
	// A | B = B | A
	public AST commutativity() {
		AST tree = getTree();
		ASTOrNode orNode = getOrNode();
		ASTPropositionalNode left = orNode.getLeft();
		ASTPropositionalNode right = orNode.getRight();
		ASTOrNode newNode = new ASTOrNode(right, left);
		return findAndReplace(tree, orNode, newNode);
	}
	
	// A & A = A
	public AST idempotence() {
		AST tree = getTree();
		ASTOrNode orNode = getOrNode();
		NodeEquivalence equivalence = new NodeEquivalence(orNode.getLeft(), orNode.getRight());
		if(equivalence.isEquivalent()) {
			return findAndReplace(tree, orNode, orNode.getLeft());
		}
		return tree;
	}
	
	public AST getTree() {
		return tree;
	}
	
	public void setTree(AST tree) {
		this.tree = tree;
	}
	
	public ASTOrNode getOrNode() {
		return orNode;
	}
	
	public void setOrNode(ASTOrNode orNode) {
		this.orNode = orNode;
	}
	
}