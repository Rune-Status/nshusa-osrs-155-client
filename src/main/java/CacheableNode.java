public class CacheableNode extends Node {

	public CacheableNode next;

	public CacheableNode previous;

	public void unlinkDual() {
		if (this.next != null) {
			this.next.previous = this.previous;
			this.previous.next = this.next;
			this.previous = null;
			this.next = null;
		}
	}
}
