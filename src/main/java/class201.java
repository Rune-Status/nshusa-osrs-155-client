import java.util.Iterator;

public class class201 implements Iterable {

	public CacheableNode field2504;

	public class201() {
		this.field2504 = new CacheableNode();
		this.field2504.previous = this.field2504;
		this.field2504.next = this.field2504;
	}

	public void method3773() {
		while (this.field2504.previous != this.field2504) {
			this.field2504.previous.unlinkDual();
		}

	}

	public void method3777(CacheableNode var1) {
		if (var1.next != null) {
			var1.unlinkDual();
		}

		var1.next = this.field2504.next;
		var1.previous = this.field2504;
		var1.next.previous = var1;
		var1.previous.next = var1;
	}

	public Iterator iterator() {
		return new class200(this);
	}
}
