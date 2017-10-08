public class class33 {

	public static boolean highMemory;

	static IndexedSprite[] field488;

	static short[] field491;

	String field486;

	class24 field485;

	int field487;

	int field484;

	class33(String var1, int var2, int var3, class24 var4) {
		this.field486 = var1;
		this.field487 = var2;
		this.field484 = var3;
		this.field485 = var4;
	}

	public static void method337() {
		Overlay.overlays.reset();
	}

	static final void method336(int var0, int var1, int var2, int var3) {
		if (Client.cursorState == 1) {
			class20.field335[Client.field1171 / 100].method5172(Client.field1019 - 8, Client.field1020 - 8);
		}

		if (Client.cursorState == 2) {
			class20.field335[Client.field1171 / 100 + 4].method5172(Client.field1019 - 8, Client.field1020 - 8);
		}

		class41.method593();
	}

	public static boolean method338(int var0) {
		return (var0 >> 31 & 1) != 0;
	}
}
