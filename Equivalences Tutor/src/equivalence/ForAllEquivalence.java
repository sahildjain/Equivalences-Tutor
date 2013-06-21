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

public class ForAllEquivalence extends Equivalence {
	
	public ForAllEquivalence(AST tree, int key) {
		super(tree, key);
	}
	
	public AST equivalence1() {
		try {
			AST tree = getTree();
			int key = getKey();
			ASTNode node = find(tree.getRoot(), key);
			if(node instanceof ASTForAllNode) {
				ASTForAllNode forAllNode = (ASTForAllNode) node;
				ASTNode temp = forAllNode.getNode();
				if(temp instanceof ASTForAllNode) {
					ASTForAllNode newNode1 = new ASTForAllNode(tree.getKey(), forAllNode.getIdentifier(), ((ASTForAllNode) temp).getNode());
					tree.setKey(tree.getKey() + 1);
					ASTForAllNode newNode = new ASTForAllNode(tree.getKey(), ((ASTForAllNode) temp).getIdentifier(), newNode1);
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
			if(node instanceof ASTForAllNode) {
				ASTForAllNode forAllNode = (ASTForAllNode) node;
				ASTNode temp = forAllNode.getNode();
				if(temp instanceof ASTAndNode) {
					 ASTAndNode andNode = (ASTAndNode) temp;
					 ASTForAllNode forLeft = new ASTForAllNode(tree.getKey(), forAllNode.getIdentifier(), andNode.getLeft());
					 tree.setKey(tree.getKey() + 1);
					 ASTForAllNode forRight = new ASTForAllNode(tree.getKey(), forAllNode.getIdentifier(), andNode.getRight());
					 tree.setKey(tree.getKey() + 1);
					 ASTAndNode newNode = new ASTAndNode(tree.getKey(), forLeft, forRight);
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
			if(node instanceof ASTForAllNode) {
				ASTForAllNode forAllNode = (ASTForAllNode) node;
				ASTNode temp = forAllNode.getNode();
				if(temp instanceof ASTNotNode) {
					 ASTNotNode notNode = (ASTNotNode) temp;
					 ASTNode n = notNode.getLeaf();
					 ASTExistsNode existsNode = new ASTExistsNode(tree.getKey(), forAllNode.getIdentifier(), n);
					 tree.setKey(tree.getKey() + 1);
					 ASTNotNode newNode = new ASTNotNode(tree.getKey(), existsNode);
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
			if(node instanceof ASTForAllNode) {
				ASTForAllNode forAllNode = (ASTForAllNode) node;
				boolean bound = isBound(forAllNode);
				if(bound) {
					ASTExistsNode existsNode = new ASTExistsNode(tree.getKey(), forAllNode.getIdentifier(), forAllNode.getNode());
					tree.setKey(tree.getKey() + 1);
					ASTNode p = replace(tree.getRoot().getLeaf(), existsNode, key);
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
			if(node instanceof ASTForAllNode) {
				ASTForAllNode forAllNode = (ASTForAllNode) node;
				if(forAllNode.getNode() instanceof ASTOrNode) {
					ASTOrNode orNode = (ASTOrNode) forAllNode.getNode();
					boolean contains = contains(orNode.getLeft(), forAllNode.getIdentifier().getLeaf());
					if(contains) {
						ASTOrNode newNode = new ASTOrNode(tree.getKey(), null, null);
						tree.setKey(tree.getKey() + 1);
						newNode.setLeft(orNode.getLeft());
						ASTForAllNode temp = new ASTForAllNode(tree.getKey(), forAllNode.getIdentifier(), orNode.getRight());
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
			if(node instanceof ASTForAllNode) {
				ASTForAllNode forAllNode = (ASTForAllNode) node;
				if(forAllNode.getNode() instanceof ASTIfThenNode) {
					ASTIfThenNode ifThenNode = (ASTIfThenNode) forAllNode.getNode();
					boolean contains = contains(ifThenNode.getLeft(), forAllNode.getIdentifier().getLeaf());
					if(contains) {
						ASTIfThenNode newNode = new ASTIfThenNode(tree.getKey(), null, null);
						tree.setKey(tree.getKey() + 1);
						newNode.setLeft(ifThenNode.getLeft());
						ASTForAllNode temp = new ASTForAllNode(tree.getKey(), forAllNode.getIdentifier(), ifThenNode.getRight());
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
			if(node instanceof ASTForAllNode) {
				ASTForAllNode forAllNode = (ASTForAllNode) node;
				if(forAllNode.getNode() instanceof ASTIfThenNode) {
					ASTIfThenNode ifThenNode = (ASTIfThenNode) forAllNode.getNode();
					boolean contains = contains(ifThenNode.getRight(), forAllNode.getIdentifier().getLeaf());
					if(contains) {
						ASTIfThenNode newNode = new ASTIfThenNode(tree.getKey(), null, null);
						tree.setKey(tree.getKey() + 1);
						newNode.setRight(ifThenNode.getRight());
						ASTExistsNode temp = new ASTExistsNode(tree.getKey(), forAllNode.getIdentifier(), ifThenNode.getLeft());
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
		
	private boolean isBound(ASTForAllNode node) {
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
