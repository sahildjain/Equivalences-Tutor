package equivalence;

import AST.*;

public class IffEquivalence  extends Equivalence {
	
	private AST tree;
	private ASTIffNode iffNode;
	
	public IffEquivalence(AST tree, ASTIffNode iffNode) {
		this.setTree(tree);
		this.setIffNode(iffNode);
	}
	
	// A <-> B = (A -> B) & (B -> A)
	public AST iffToAndEquivalence() {
		AST tree = getTree();
		ASTIffNode iffNode = getIffNode();
		ASTPropositionalNode left = iffNode.getLeft();
		ASTPropositionalNode right = iffNode.getRight();
		ASTIfThenNode ifThenNode1 = new ASTIfThenNode(left, right);
		ASTIfThenNode ifThenNode2 = new ASTIfThenNode(right, left);
		ASTAndNode andNode = new ASTAndNode(ifThenNode1, ifThenNode2);
		ASTPropositionalNode node = findAndReplace(tree.getRoot(), iffNode, andNode);
		tree.setRoot((ASTProgramNode) node);
		return tree;
	}
	
	// A <-> B = (A & B) | (!A & !B)
	public AST iffToOrNodeEquivalence() {
		AST tree = getTree();
		ASTIffNode iffNode = getIffNode();
		ASTPropositionalNode left = iffNode.getLeft();
		ASTPropositionalNode right = iffNode.getRight();
		ASTAndNode andNode1 = new ASTAndNode(left, right);
		ASTNotNode notLeft = new ASTNotNode(left);
		ASTNotNode notRight = new ASTNotNode(right);
		ASTAndNode andNode2 = new ASTAndNode(notLeft, notRight);
		ASTOrNode orNode = new ASTOrNode(andNode1, andNode2);
		ASTPropositionalNode node = findAndReplace(tree.getRoot(), iffNode, orNode);
		tree.setRoot((ASTProgramNode) node);
		return tree;
	}
	
	// A <-> B = !A <-> !B
	public AST negate() {
		AST tree = getTree();
		ASTIffNode iffNode = getIffNode();
		ASTPropositionalNode left = iffNode.getLeft();
		ASTPropositionalNode right = iffNode.getRight();
		ASTNotNode notLeft = new ASTNotNode(left);
		ASTNotNode notRight = new ASTNotNode(right);
		ASTIffNode newIffNode = new ASTIffNode(notLeft, notRight);
		ASTPropositionalNode node = findAndReplace(tree.getRoot(), iffNode, newIffNode);
		tree.setRoot((ASTProgramNode) node);
		return tree;
	}
	
	// A <-> !B = !(A <-> B) AND !A <-> B = !(A <-> B)
	public AST notIff() {
		AST tree = getTree();
		ASTIffNode iffNode = getIffNode();
		ASTPropositionalNode left = iffNode.getLeft();
		ASTPropositionalNode right = iffNode.getRight();
		ASTIffNode newNode = null;
		if(left instanceof ASTNotNode) {
			ASTPropositionalNode newLeft = ((ASTNotNode) left).getLeaf();
			newNode = new ASTIffNode(newLeft, right);
		}
		if(right instanceof ASTNotNode) {
			ASTPropositionalNode newRight = ((ASTNotNode) right).getLeaf();
			newNode = new ASTIffNode(left, newRight);
		}
		ASTPropositionalNode node = findAndReplace(tree.getRoot(), iffNode, newNode);
		tree.setRoot((ASTProgramNode) node);
		return tree;
	}

	public AST getTree() {
		return tree;
	}

	public void setTree(AST tree) {
		this.tree = tree;
	}

	public ASTIffNode getIffNode() {
		return iffNode;
	}

	public void setIffNode(ASTIffNode iffNode) {
		this.iffNode = iffNode;
	}

}
