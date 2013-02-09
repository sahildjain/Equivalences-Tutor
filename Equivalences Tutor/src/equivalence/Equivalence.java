package equivalence;

import AST.*;

public abstract class Equivalence {
	
	public ASTPropositionalNode findAndReplace(ASTPropositionalNode parent, ASTPropositionalNode originalNode, ASTPropositionalNode newNode) {
		if(parent instanceof ASTPropositionalUnaryNode) {
			ASTPropositionalUnaryNode unaryParent = (ASTPropositionalUnaryNode) parent;
			ASTPropositionalNode childNode = unaryParent.getLeaf();
			NodeEquivalence nodeEquivalence = new NodeEquivalence(childNode, originalNode);
			boolean equal = nodeEquivalence.isEquivalent();
			if(equal) {
				unaryParent.setLeaf(newNode);
				return unaryParent;
			}
			findAndReplace(childNode, originalNode, newNode);
		}
		if(parent instanceof ASTPropositionalBinaryNode) {
			ASTPropositionalBinaryNode binaryParent = (ASTPropositionalBinaryNode) parent;
			ASTPropositionalNode childLeftNode = binaryParent.getLeft();
			NodeEquivalence nodeEquivalence = new NodeEquivalence(childLeftNode, originalNode);
			boolean equal = nodeEquivalence.isEquivalent();
			if(equal) {
				
			}
			
		}
		return parent;
	}
}
