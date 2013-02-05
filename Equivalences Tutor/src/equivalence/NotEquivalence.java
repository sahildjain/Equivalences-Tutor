package equivalence;

import AST.*;

public class NotEquivalence extends Equivalence {

	private AST tree;
	private ASTNotNode notNode;
	
	public NotEquivalence(AST tree, ASTNotNode notNode) {
		this.setTree(tree);
		this.setNotNode(notNode);
	}
	
	public AST doubleNegation() {
		AST tree = getTree();
		ASTNotNode notNode = getNotNode();
		if(containsDoubleNegation()) {
			ASTNotNode secondNotNode = (ASTNotNode) notNode.getLeaf();
			ASTPropositionalNode node = secondNotNode.getLeaf();
			return findAndReplace(tree, notNode, node);
		}
		return tree;
	}

	private boolean containsDoubleNegation() {
		ASTPropositionalNode leaf = getNotNode().getLeaf();
		return leaf instanceof ASTNotNode;
	}

	public AST getTree() {
		return tree;
	}

	public void setTree(AST tree) {
		this.tree = tree;
	}

	public ASTNotNode getNotNode() {
		return notNode;
	}

	public void setNotNode(ASTNotNode notNode) {
		this.notNode = notNode;
	}
	
	

}