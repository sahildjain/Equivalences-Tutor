package equivalence;

import AST.AST;

public class EquivalenceLinkNode {
	
	private int lineNumber;
	private AST tree;
	private EquivalenceLinkNode previous;
	private EquivalenceLinkNode next;
	
	public EquivalenceLinkNode(int lineNumber, AST tree, EquivalenceLinkNode previous, EquivalenceLinkNode next) {
		this.setLineNumber(lineNumber);
		this.setTree(tree);
		this.setPrevious(previous);
		this.setNext(next);
	}
	
	public int getLineNumber() {
		return lineNumber;
	}
	
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public AST getTree() {
		return tree;
	}
	
	public void setTree(AST tree) {
		this.tree = tree;
	}
	
	public EquivalenceLinkNode getPrevious() {
		return previous;
	}
	
	public void setPrevious(EquivalenceLinkNode previous) {
		this.previous = previous;
	}
	
	public EquivalenceLinkNode getNext() {
		return next;
	}
	
	public void setNext(EquivalenceLinkNode next) {
		this.next = next;
	}
	
	public int equals(EquivalenceLinkNode node) {
		if(getLineNumber() < node.getLineNumber()) {
			return -1;
		}
		if(getLineNumber() > node.getLineNumber()) {
			return 1;
		}
		return 0;
	}

}
