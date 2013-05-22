package equivalence;


public class EquivalenceLinkedList {
	
	private EquivalenceLinkNode head;
	private EquivalenceLinkNode last;
	private int size;

	public EquivalenceLinkedList() {
		this.setHead(null);
		this.setLast(null);
		this.setSize(0);
	}
	
	public boolean isEmpty() {
		return getHead() == null;
	}
	
	public void add(EquivalenceLinkNode node) {
		if(isEmpty()) {
			setHead(node);
			setLast(node);
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
		setLast(node);
	}
	
	/*TODO write delete function
	public void delete(EquivalenceLinkNode node) {
		EquivalenceLinkNode curr = getFirst();
		EquivalenceLinkNode temp = getFirst().getNext();
		if(size == 0) {
			return;
		}
		//TODO
	}*/
	
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
		return last;
	}

	public void setLast(EquivalenceLinkNode last) {
		this.last = last;
	}

}
