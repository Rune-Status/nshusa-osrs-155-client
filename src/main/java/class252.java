public class class252 extends CacheableNode {

	static NodeCache field3395;

	static IndexDataBase field3397;

	IterableHashTable field3394;

	static {
		field3395 = new NodeCache(64);
	}

	void method4567(Buffer var1, int var2) {
		if (var2 == 249) {
			this.field3394 = class41.method590(var1, this.field3394);
		}

	}

	public int method4550(int var1, int var2) {
		return FileSystem.method4214(this.field3394, var1, var2);
	}

	public String method4551(int var1, String var2) {
		return class85.method1769(this.field3394, var1, var2);
	}

	void method4547() {
	}

	void method4555(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method4567(var1, var2);
		}
	}
}
