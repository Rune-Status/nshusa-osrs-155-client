public class Varbit extends CacheableNode {

	public static NodeCache varbits;

	public static IndexDataBase varbit_ref;

	static int[] field3383;

	public int configId;

	public int leastSignificantBit;

	public int mostSignificantBit;

	static {
		varbits = new NodeCache(64);
	}

	void method4521(Buffer var1, int var2) {
		if (var2 == 1) {
			this.configId = var1.readUnsignedShort();
			this.leastSignificantBit = var1.readUnsignedByte();
			this.mostSignificantBit = var1.readUnsignedByte();
		}

	}

	public void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method4521(var1, var2);
		}
	}
}
