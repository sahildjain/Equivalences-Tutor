package equivalence;

import AST.*;

public abstract class Equivalence {
	
	public AST findAndReplace(AST tree, ASTPropositionalNode originalNode, ASTPropositionalNode newNode) {
		ASTPropositionalNode leaf = tree.getRoot().getLeaf();
		if(new NodeEquivalence(originalNode, leaf).isEquivalent()) {
			tree.getRoot().setLeaf(newNode);
		}
		return tree;
	}
		
}
