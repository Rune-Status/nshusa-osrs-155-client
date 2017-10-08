public class Node {

	Node previous;

	public Node next;

	public long hash;

	public void unlink() {
		if (this.previous != null) {
			this.previous.next = this.next;
			this.next.previous = this.previous;
			this.next = null;
			this.previous = null;
		}
	}

	public boolean linked() {
		return this.previous != null;
	}
}
