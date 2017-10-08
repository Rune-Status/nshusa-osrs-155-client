public class InvType extends CacheableNode {

	static NodeCache inventoryCache;

	static IndexDataBase field3283;

	public int size;

	static {
		inventoryCache = new NodeCache(64);
	}

	InvType() {
		this.size = 0;
	}

	void method4369(Buffer var1, int var2) {
		if (var2 == 2) {
			this.size = var1.readUnsignedShort();
		}

	}

	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method4369(var1, var2);
		}
	}
}
