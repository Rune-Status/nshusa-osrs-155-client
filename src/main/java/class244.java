public class class244 extends CacheableNode {

	public static NodeCache field3316;

	public static IndexDataBase field3319;

	public boolean field3317;

	static {
		field3316 = new NodeCache(64);
	}

	public class244() {
		this.field3317 = false;
	}

	void method4431(Buffer var1, int var2) {
		if (var2 == 2) {
			this.field3317 = true;
		}

	}

	public void method4427(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method4431(var1, var2);
		}
	}

	static int getWidgetConfig(Widget var0) {
		IntegerNode var1 = (IntegerNode) Client.widgetFlags.get((long) var0.index + ((long) var0.id << 32));
		return var1 != null ? var1.value : var0.config;
	}

	public static void method4432(Huffman var0) {
		class265.field3664 = var0;
	}
}
