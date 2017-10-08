public class FaceNormal {

	static IndexData configsIndex;

	static SpritePixels[] mapfunctions;

	int y;

	int x;

	int z;

	static void method2938(Widget[] var0, int var1, int var2, int var3, boolean var4) {
		for (int var5 = 0; var5 < var0.length; ++var5) {
			Widget var6 = var0[var5];
			if (var6 != null && var6.parentId == var1) {
				TextureProvider.method2478(var6, var2, var3, var4);
				WorldMapType2.method499(var6, var2, var3);
				if (var6.scrollX > var6.scrollWidth - var6.width) {
					var6.scrollX = var6.scrollWidth - var6.width;
				}

				if (var6.scrollX < 0) {
					var6.scrollX = 0;
				}

				if (var6.scrollY > var6.scrollHeight - var6.height) {
					var6.scrollY = var6.scrollHeight - var6.height;
				}

				if (var6.scrollY < 0) {
					var6.scrollY = 0;
				}

				if (var6.type == 0) {
					BaseVarType.method17(var0, var6, var4);
				}
			}
		}

	}

	static void method2939(int var0, IndexFile var1, IndexData var2) {
		FileSystem var3 = new FileSystem();
		var3.field3206 = 1;
		var3.hash = (long) var0;
		var3.index = var1;
		var3.data = var2;
		Deque var4 = class236.field3237;
		synchronized (class236.field3237) {
			class236.field3237.addFront(var3);
		}

		Object var9 = class236.field3236;
		synchronized (class236.field3236) {
			if (class236.field3234 == 0) {
				class236.field3235 = new Thread(new class236());
				class236.field3235.setDaemon(true);
				class236.field3235.start();
				class236.field3235.setPriority(5);
			}

			class236.field3234 = 600;
		}
	}
}
