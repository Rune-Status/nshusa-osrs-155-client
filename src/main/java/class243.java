public class class243 extends CacheableNode {

	public static NodeCache field3310;

	public static IndexDataBase field3311;

	public boolean field3312;

	static {
		field3310 = new NodeCache(64);
	}

	public class243() {
		this.field3312 = false;
	}

	void method4425(Buffer var1, int var2) {
		if (var2 == 2) {
			this.field3312 = true;
		}

	}

	public void method4419(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method4425(var1, var2);
		}
	}

	public static void method4420() {
		class254.field3410.reset();
		class254.field3413.reset();
		class254.field3431.reset();
	}
}
