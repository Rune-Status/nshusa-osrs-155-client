public class class251 extends CacheableNode {

	static NodeCache field3386;

	static int field3391;

	static IndexDataBase field3388;

	char field3387;

	boolean field3390;

	public int field3392;

	public String field3389;

	static {
		field3386 = new NodeCache(64);
	}

	class251() {
		this.field3390 = true;
	}

	void method4539(Buffer var1, int var2) {
		if (var2 == 1) {
			byte var4 = var1.readByte();
			int var5 = var4 & 255;
			if (var5 == 0) {
				throw new IllegalArgumentException("");
			}

			if (var5 >= 128 && var5 < 160) {
				char var6 = class266.field3665[var5 - 128];
				if (var6 == 0) {
					var6 = 63;
				}

				var5 = var6;
			}

			char var3 = (char) var5;
			this.field3387 = var3;
		} else if (var2 == 2) {
			this.field3392 = var1.readInt();
		} else if (var2 == 4) {
			this.field3390 = false;
		} else if (var2 == 5) {
			this.field3389 = var1.readString();
		}

	}

	public boolean method4528() {
		return this.field3387 == 115;
	}

	void method4542() {
	}

	void method4527(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method4539(var1, var2);
		}
	}

	static final void method4526(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null) {
				if (var3.type == 0) {
					if (var3.children != null) {
						method4526(var3.children, var1);
					}

					WidgetNode var4 = (WidgetNode) Client.componentTable.get((long) var3.id);
					if (var4 != null) {
						int var5 = var4.id;
						if (class93.loadWidget(var5)) {
							method4526(class177.widgets[var5], var1);
						}
					}
				}

				ScriptEvent var6;
				if (var1 == 0 && var3.field2765 != null) {
					var6 = new ScriptEvent();
					var6.widget = var3;
					var6.field846 = var3.field2765;
					CollisionData.method3128(var6);
				}

				if (var1 == 1 && var3.field2766 != null) {
					if (var3.index >= 0) {
						Widget var7 = PacketBuffer.method3528(var3.id);
						if (var7 == null || var7.children == null || var3.index >= var7.children.length
								|| var3 != var7.children[var3.index]) {
							continue;
						}
					}

					var6 = new ScriptEvent();
					var6.widget = var3;
					var6.field846 = var3.field2766;
					CollisionData.method3128(var6);
				}
			}
		}

	}
}
