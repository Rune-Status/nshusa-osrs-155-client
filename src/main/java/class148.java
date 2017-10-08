import java.net.URL;

public class class148 {

	public static int field2203;

	static String sessionToken;

	volatile byte[] field2204;

	volatile boolean field2199;

	final URL field2201;

	class148(URL var1) {
		this.field2201 = var1;
	}

	public boolean method2990() {
		return this.field2199;
	}

	public byte[] method2984() {
		return this.field2204;
	}

	static final void method2982(int var0, int var1, int var2, int var3) {
		for (int var4 = 0; var4 < Client.field1116; ++var4) {
			if (Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0
					&& Client.widgetPositionX[var4] < var0 + var2
					&& Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1
					&& Client.widgetPositionY[var4] < var3 + var1) {
				Client.field1119[var4] = true;
			}
		}

	}

	static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7;
		if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
			class61.tileSettings[var1][var2][var3] = 0;

			while (true) {
				var7 = var0.readUnsignedByte();
				if (var7 == 0) {
					if (var1 == 0) {
						class61.tileHeights[0][var2][var3] = -Player.method1189(var2 + var4 + 932731,
								var3 + var5 + 556238) * 8;
					} else {
						class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - 240;
					}
					break;
				}

				if (var7 == 1) {
					int var8 = var0.readUnsignedByte();
					if (var8 == 1) {
						var8 = 0;
					}

					if (var1 == 0) {
						class61.tileHeights[0][var2][var3] = -var8 * 8;
					} else {
						class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - var8 * 8;
					}
					break;
				}

				if (var7 <= 49) {
					class61.overlayIds[var1][var2][var3] = var0.readByte();
					class277.overlayPaths[var1][var2][var3] = (byte) ((var7 - 2) / 4);
					class61.overlayRotations[var1][var2][var3] = (byte) (var7 - 2 + var6 & 3);
				} else if (var7 <= 81) {
					class61.tileSettings[var1][var2][var3] = (byte) (var7 - 49);
				} else {
					class61.underlayIds[var1][var2][var3] = (byte) (var7 - 81);
				}
			}
		} else {
			while (true) {
				var7 = var0.readUnsignedByte();
				if (var7 == 0) {
					break;
				}

				if (var7 == 1) {
					var0.readUnsignedByte();
					break;
				}

				if (var7 <= 49) {
					var0.readUnsignedByte();
				}
			}
		}

	}
}
