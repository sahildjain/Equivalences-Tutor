package equivalence;


public class EquivalenceLinkedList {
	
	private EquivalenceLinkNode head;
	private int size;

	public EquivalenceLinkedList() {
		this.setHead(null);
		this.setSize(0);
	}
	
	public boolean isEmpty() {
		return getHead() == null;
	}
	
	public void add(EquivalenceLinkNode node) {
		if(isEmpty()) {
			setHead(node);
			size = 1;
			return;
		}
		EquivalenceLinkNode curr = getHead();
		EquivalenceLinkNode next = curr.getNext();
		while(next != null) {
			curr = next;
			next = curr.getNext();
		}
		curr.setNext(node);
		node.setPrevious(curr);
		setSize(getSize() + 1);
	}
	
	public void removeLast() {
		if(isEmpty()) {
			return;
		}
		if(size == 1) {
			setSize(0);
			setHead(null);
			return;
		}
		if(size == 2) {
			getHead().setNext(null);
			setSize(1);
			return;
		}
		EquivalenceLinkNode prev = null;
		EquivalenceLinkNode curr = getHead();
		EquivalenceLinkNode next = curr.getNext();
		while(next != null) {
			prev = curr;
			curr = next;
			next = next.getNext();
		}
		prev.setNext(null);
		setSize(getSize() - 1);
	}
	
	public EquivalenceLinkNode getHead() {
		return head;
	}

	public void setHead(EquivalenceLinkNode head) {
		this.head = head;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	public EquivalenceLinkNode getLast() {
		EquivalenceLinkNode curr = getHead();
		EquivalenceLinkNode next = curr.getNext();
		while(next != null) {
			curr = next;
			next = next.getNext();
		}
		return curr;
	}

}
