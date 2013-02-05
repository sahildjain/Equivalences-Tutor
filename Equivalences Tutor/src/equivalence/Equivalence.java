package equivalence;

import AST.*;

public abstract class Equivalence {
	
	public AST findAndReplace(AST tree, ASTPropositionalNode originalNode, ASTPropositionalNode newNode) {
		ASTProgramNode programNode = tree.getRoot();
		ASTPropositionalNode leaf = programNode.getLeaf();
		
		return tree;
	}
	
}
