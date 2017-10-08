public final class Node2LinkedList {

	CacheableNode sentinel;

	public Node2LinkedList() {
		this.sentinel = new CacheableNode();
		this.sentinel.previous = this.sentinel;
		this.sentinel.next = this.sentinel;
	}

	void clear() {
		while (true) {
			CacheableNode var1 = this.sentinel.previous;
			if (var1 == this.sentinel) {
				return;
			}

			var1.unlinkDual();
		}
	}

	CacheableNode pop() {
		CacheableNode var1 = this.sentinel.previous;
		if (var1 == this.sentinel) {
			return null;
		} else {
			var1.unlinkDual();
			return var1;
		}
	}

	public void push(CacheableNode var1) {
		if (var1.next != null) {
			var1.unlinkDual();
		}

		var1.next = this.sentinel.next;
		var1.previous = this.sentinel;
		var1.next.previous = var1;
		var1.previous.next = var1;
	}

	public void setHead(CacheableNode var1) {
		if (var1.next != null) {
			var1.unlinkDual();
		}

		var1.next = this.sentinel;
		var1.previous = this.sentinel.previous;
		var1.next.previous = var1;
		var1.previous.next = var1;
	}

	public CacheableNode peek() {
		CacheableNode var1 = this.sentinel.previous;
		return var1 == this.sentinel ? null : var1;
	}
}
