public final class GameObject {

	static RenderOverview renderOverview;

	int relativeX;

	int offsetX;

	public int hash;

	int flags;

	int relativeY;

	int offsetY;

	int plane;

	int x;

	int y;

	int height;

	public Renderable renderable;

	int orientation;

	int cycle;

	int drawPriority;

	GameObject() {
		this.hash = 0;
		this.flags = 0;
	}

	static final void method2968(boolean var0) {
		for (int var1 = 0; var1 < Client.field960; ++var1) {
			NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
			int var3 = (Client.npcIndices[var1] << 14) + 536870912;
			if (var2 != null && var2.hasConfig() && var2.composition.isVisible == var0
					&& var2.composition.method4730()) {
				int var4 = var2.x >> 7;
				int var5 = var2.y >> 7;
				if (var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
					if (var2.field1211 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
						if (Client.field1015[var4][var5] == Client.field1016) {
							continue;
						}

						Client.field1015[var4][var5] = Client.field1016;
					}

					if (!var2.composition.field3586) {
						var3 -= Integer.MIN_VALUE;
					}

					class8.region.method2768(class5.plane, var2.x, var2.y,
							CacheFile.getTileHeight(var2.field1211 * 64 - 64 + var2.x,
									var2.field1211 * 64 - 64 + var2.y, class5.plane),
							60 + (var2.field1211 * 64 - 64), var2, var2.angle, var3, var2.field1210);
				}
			}
		}

	}
}
