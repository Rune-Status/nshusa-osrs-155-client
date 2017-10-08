public abstract class class117 extends Node {

	volatile boolean field1703;

	class120 field1705;

	class117 field1706;

	int field1704;

	protected class117() {
		this.field1703 = true;
	}

	protected abstract void vmethod4004(int[] var1, int var2, int var3);

	protected abstract void vmethod4023(int var1);

	final void method2374(int[] var1, int var2, int var3) {
		if (this.field1703) {
			this.vmethod4004(var1, var2, var3);
		} else {
			this.vmethod4023(var3);
		}

	}

	protected abstract class117 vmethod4002();

	protected abstract class117 vmethod4025();

	int vmethod2391() {
		return 255;
	}

	protected abstract int vmethod4007();
}
