import javax.imageio.ImageIO;

public class class54 {

	static int menuX;

	static RSSocket field688;

	static IndexData field686;

	static SpritePixels[] field687;

	static {
		ImageIO.setUseCache(false);
	}

	static final boolean method813() {
		return class132.field1982;
	}

	static final void method812(int var0, int var1, int var2, int var3) {
		for (int var4 = var1; var4 <= var3 + var1; ++var4) {
			for (int var5 = var0; var5 <= var0 + var2; ++var5) {
				if (var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
					class174.field2411[0][var5][var4] = 127;
					if (var0 == var5 && var5 > 0) {
						class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 - 1][var4];
					}

					if (var5 == var0 + var2 && var5 < 103) {
						class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 + 1][var4];
					}

					if (var4 == var1 && var4 > 0) {
						class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 - 1];
					}

					if (var3 + var1 == var4 && var4 < 103) {
						class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 + 1];
					}
				}
			}
		}

	}
}
