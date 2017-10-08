import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public final class class49 implements class156, MouseWheelListener {

	int field642;

	class49() {
		this.field642 = 0;
	}

	void method751(Component var1) {
		var1.addMouseWheelListener(this);
	}

	void method764(Component var1) {
		var1.removeMouseWheelListener(this);
	}

	public synchronized int vmethod3053() {
		int var1 = this.field642;
		this.field642 = 0;
		return var1;
	}

	public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
		this.field642 += var1.getWheelRotation();
	}
}
