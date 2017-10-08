import java.util.Iterator;

public class class188 implements Iterator {

	CombatInfoList field2470;

	Node field2469;

	Node field2471;

	class188(CombatInfoList var1) {
		this.field2471 = null;
		this.field2470 = var1;
		this.field2469 = this.field2470.node.next;
		this.field2471 = null;
	}

	public boolean hasNext() {
		return this.field2470.node != this.field2469;
	}

	public void remove() {
		if (this.field2471 == null) {
			throw new IllegalStateException();
		} else {
			this.field2471.unlink();
			this.field2471 = null;
		}
	}

	public Object next() {
		Node var1 = this.field2469;
		if (var1 == this.field2470.node) {
			var1 = null;
			this.field2469 = null;
		} else {
			this.field2469 = var1.next;
		}

		this.field2471 = var1;
		return var1;
	}
}
