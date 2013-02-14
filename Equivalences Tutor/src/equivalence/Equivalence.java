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
			boolean equalLeft = nodeEquivalence.isEquivalent();
			ASTPropositionalNode childRightNode = binaryParent.getRight();
			nodeEquivalence = new NodeEquivalence(childRightNode, originalNode);
			boolean equalRight = nodeEquivalence.isEquivalent();
			if(equalLeft && equalRight) {
				
			}
			if(equalLeft) {
				binaryParent.setLeft(newNode);
				return binaryParent;
			}
			if(equalRight) {
				binaryParent.setRight(newNode);
				return binaryParent;
			}
		}
		if(parent instanceof ASTIdentifierNode) {
			
		}
		return parent;
	}
}
