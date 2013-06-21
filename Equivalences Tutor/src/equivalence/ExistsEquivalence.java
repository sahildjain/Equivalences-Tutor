package equivalence;

import AST.AST;
import AST.ASTAndNode;
import AST.ASTExistsNode;
import AST.ASTForAllNode;
import AST.ASTIdentifierNode;
import AST.ASTIfThenNode;
import AST.ASTNode;
import AST.ASTNotNode;
import AST.ASTOrNode;
import AST.ASTProgramNode;
import AST.ASTPropositionalBinaryNode;
import AST.ASTPropositionalUnaryNode;

public class ExistsEquivalence extends Equivalence {
	
	public ExistsEquivalence(AST tree, int key) {
		super(tree, key);
	}
	
	public AST equivalence1() {
		try{
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTExistsNode) {
				ASTExistsNode existsNode = (ASTExistsNode) node;
				ASTNode temp = existsNode.getNode();
				if(temp instanceof ASTExistsNode) {
					ASTExistsNode newNode1 = new ASTExistsNode(tree.getKey(), existsNode.getIdentifier(), ((ASTExistsNode) temp).getNode());
					tree.setKey(tree.getKey() + 1);
					ASTExistsNode newNode = new ASTExistsNode(tree.getKey(), ((ASTExistsNode) temp).getIdentifier(), newNode1);
					tree.setKey(tree.getKey() + 1);
					ASTNode p = replace(tree.getRoot().getLeaf(), newNode, key);
					ASTProgramNode program = tree.getRoot();
					program.setLeaf(p);
					AST t = new AST(tree.getKey(), program);
					return t;
				}
			}
		}
		catch(Exception e) {
			return null;
		}
		return null;
	}
	
	public AST equivalence2() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTExistsNode) {
				ASTExistsNode existsNode = (ASTExistsNode) node;
				ASTNode temp = existsNode.getNode();
				if(temp instanceof ASTOrNode) {
					 ASTOrNode orNode = (ASTOrNode) temp;
					 ASTExistsNode existsLeft = new ASTExistsNode(tree.getKey(), existsNode.getIdentifier(), orNode.getLeft());
					 tree.setKey(tree.getKey() + 1);
					 ASTExistsNode existsRight = new ASTExistsNode(tree.getKey(), existsNode.getIdentifier(), orNode.getRight());
					 tree.setKey(tree.getKey() + 1);
					 ASTOrNode newNode = new ASTOrNode(tree.getKey(), existsLeft, existsRight);
					 tree.setKey(tree.getKey() + 1);
					 ASTNode p = replace(tree.getRoot().getLeaf(), newNode, key);
					 ASTProgramNode program = tree.getRoot();
					 program.setLeaf(p);
					 AST t = new AST(tree.getKey(), program);
					 return t;
				}
			}
		}
		catch(Exception e) {
			return null;
		}
		return null;
	}
	
	public AST equivalence3() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTExistsNode) {
				ASTExistsNode existsNode = (ASTExistsNode) node;
				ASTNode temp = existsNode.getNode();
				if(temp instanceof ASTNotNode) {
					 ASTNotNode notNode = (ASTNotNode) temp;
					 ASTNode n = notNode.getLeaf();
					 ASTForAllNode forAllNode = new ASTForAllNode(tree.getKey(), existsNode.getIdentifier(), n);
					 tree.setKey(tree.getKey() + 1);
					 ASTNotNode newNode = new ASTNotNode(tree.getKey(), forAllNode);
					 tree.setKey(tree.getKey() + 1);
					 ASTNode p = replace(tree.getRoot().getLeaf(), newNode, key);
					 ASTProgramNode program = tree.getRoot();
					 program.setLeaf(p);
					 AST t = new AST(tree.getKey(), program);
					 return t;
				}
			}
		}
		catch(Exception e) {
			return null;
		}
		return null;
	}
	
	public AST equivalence4() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTExistsNode) {
				ASTExistsNode existsNode = (ASTExistsNode) node;
				boolean bound = isBound(existsNode);
				if(bound) {
					ASTForAllNode forAllNode = new ASTForAllNode(tree.getKey(), existsNode.getIdentifier(), existsNode.getNode());
					tree.setKey(tree.getKey() + 1);
					ASTNode p = replace(tree.getRoot().getLeaf(), forAllNode, key);
					ASTProgramNode program = tree.getRoot();
					program.setLeaf(p);
					AST t = new AST(tree.getKey(), program);
					return t;
				}
			}
		}
		catch(Exception e) {
			return null;
		}
		return null;
	}
	
	public AST equivalence5() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTExistsNode) {
				ASTExistsNode existsNode = (ASTExistsNode) node;
				if(existsNode.getNode() instanceof ASTAndNode) {
					ASTAndNode andNode = (ASTAndNode) existsNode.getNode();
					boolean contains = contains(andNode.getLeft(), existsNode.getIdentifier().getLeaf());
					if(contains) {
						ASTAndNode newNode = new ASTAndNode(tree.getKey(), null, null);
						tree.setKey(tree.getKey() + 1);
						newNode.setLeft(andNode.getLeft());
						ASTExistsNode temp = new ASTExistsNode(tree.getKey(), existsNode.getIdentifier(), andNode.getRight());
						tree.setKey(tree.getKey() + 1);
						newNode.setRight(temp);
						ASTNode p = replace(tree.getRoot().getLeaf(), newNode, key);
						ASTProgramNode program = tree.getRoot();
						program.setLeaf(p);
						AST t = new AST(tree.getKey(), program);
						return t;
					}
				}
			}
		}
		catch(Exception e) {
			return null;
		}
		return null;
	}
	
	public AST equivalence6() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTExistsNode) {
				ASTExistsNode existsNode = (ASTExistsNode) node;
				if(existsNode.getNode() instanceof ASTIfThenNode) {
					ASTIfThenNode ifThenNode = (ASTIfThenNode) existsNode.getNode();
					boolean contains = contains(ifThenNode.getLeft(), existsNode.getIdentifier().getLeaf());
					if(contains) {
						ASTIfThenNode newNode = new ASTIfThenNode(tree.getKey(), null, null);
						tree.setKey(tree.getKey() + 1);
						newNode.setLeft(ifThenNode.getLeft());
						ASTExistsNode temp = new ASTExistsNode(tree.getKey(), existsNode.getIdentifier(), ifThenNode.getRight());
						tree.setKey(tree.getKey() + 1);
						newNode.setRight(temp);
						ASTNode p = replace(tree.getRoot().getLeaf(), newNode, key);
						ASTProgramNode program = tree.getRoot();
						program.setLeaf(p);
						AST t = new AST(tree.getKey(), program);
						return t;
					}
				}
			}
		}
		catch(Exception e) {
			return null;
		}
		return null;
	}
	
	public AST equivalence7() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTExistsNode) {
				ASTExistsNode existsNode = (ASTExistsNode) node;
				if(existsNode.getNode() instanceof ASTIfThenNode) {
					ASTIfThenNode ifThenNode = (ASTIfThenNode) existsNode.getNode();
					boolean contains = contains(ifThenNode.getRight(), existsNode.getIdentifier().getLeaf());
					if(contains) {
						ASTIfThenNode newNode = new ASTIfThenNode(tree.getKey(), null, null);
						tree.setKey(tree.getKey() + 1);
						newNode.setRight(ifThenNode.getRight());
						ASTForAllNode temp = new ASTForAllNode(tree.getKey(), existsNode.getIdentifier(), ifThenNode.getLeft());
						tree.setKey(tree.getKey() + 1);
						newNode.setRight(temp);
						ASTNode p = replace(tree.getRoot().getLeaf(), newNode, key);
						ASTProgramNode program = tree.getRoot();
						program.setLeaf(p);
						AST t = new AST(tree.getKey(), program);
						return t;
					}
				}
			}
		}
		catch(Exception e) {
			return null;
		}
		return null;
	}

	
	private boolean isBound(ASTExistsNode node) {
		String atom = node.getIdentifier().getLeaf();
		ASTNode n = node.getNode();
		return contains(n, atom);
	}
	
	private boolean contains(ASTNode node, String atom) {
		if(node instanceof ASTIdentifierNode) {
			boolean bool1 = atom.equals(((ASTIdentifierNode) node).getLeaf());
			boolean bool2 = atom.equals(((ASTIdentifierNode) node).getVariable1());
			boolean bool3 = atom.equals(((ASTIdentifierNode) node).getVariable2());
			return bool1 || bool2 || bool3;
		}
		if(node instanceof ASTPropositionalUnaryNode) {
			return contains(((ASTPropositionalUnaryNode) node).getLeaf(), atom);
		}
		if(node instanceof ASTPropositionalBinaryNode) {
			boolean left = contains(((ASTPropositionalBinaryNode) node).getLeft(), atom);
			boolean right = contains(((ASTPropositionalBinaryNode) node).getRight(), atom);
			return left || right;
		}
		if(node instanceof ASTForAllNode) {
			return contains(((ASTForAllNode) node).getNode(), atom);
		}
		if(node instanceof ASTExistsNode) {
			return contains(((ASTExistsNode) node).getNode(), atom);
		}
		return false;
	}
}
