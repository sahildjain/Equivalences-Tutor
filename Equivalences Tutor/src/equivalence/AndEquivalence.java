package equivalence;

import AST.*;

public class AndEquivalence extends Equivalence {
	
	private AST tree;
	private ASTAndNode andNode;
	
	public AndEquivalence(AST tree, ASTAndNode andNode) {
		this.setTree(tree);
		this.setAndNode(andNode);
	}
	
	public AST idempotency() {
		AST tree = getTree();
		
		return tree;
	}

	public AST getTree() {
		return tree;
	}

	public void setTree(AST tree) {
		this.tree = tree;
	}

	public ASTAndNode getAndNode() {
		return andNode;
	}

	public void setAndNode(ASTAndNode andNode) {
		this.andNode = andNode;
	}
	
}