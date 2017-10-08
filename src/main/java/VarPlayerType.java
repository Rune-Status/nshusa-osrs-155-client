public class VarPlayerType extends CacheableNode {

	static NodeCache varplayers;

	static IndexDataBase varplayer_ref;

	public int configType;

	static {
		varplayers = new NodeCache(64);
	}

	VarPlayerType() {
		this.configType = 0;
	}

	void decode(Buffer var1, int var2) {
		if (var2 == 5) {
			this.configType = var1.readUnsignedShort();
		}

	}

	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decode(var1, var2);
		}
	}
}
