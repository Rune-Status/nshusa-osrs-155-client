public class class14 {

	String field292;

	String field291;

	public final long field289;

	public final int field297;

	public final GrandExchangeOffer field295;

	class14(Buffer var1, byte var2, int var3) {
		this.field291 = var1.readString();
		this.field292 = var1.readString();
		this.field297 = var1.readUnsignedShort();
		this.field289 = var1.readLong();
		int var4 = var1.readInt();
		int var5 = var1.readInt();
		this.field295 = new GrandExchangeOffer();
		this.field295.method117(2);
		this.field295.method103(var2);
		this.field295.price = var4;
		this.field295.totalQuantity = var5;
		this.field295.quantitySold = 0;
		this.field295.spent = 0;
		this.field295.itemId = var3;
	}

	public String method80() {
		return this.field291;
	}

	public String method84() {
		return this.field292;
	}

	static int method89(byte[] var0, int var1, int var2) {
		int var3 = -1;

		for (int var4 = var1; var4 < var2; ++var4) {
			var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
		}

		var3 = ~var3;
		return var3;
	}

	static final void drawStatusBox(String var0, boolean var1) {
		byte var2 = 4;
		int var3 = var2 + 6;
		int var4 = var2 + 6;
		int var5 = class20.font_p12full.method4878(var0, 250);
		int var6 = class20.font_p12full.method4838(var0, 250) * 13;
		Rasterizer2D.method5129(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 0);
		Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2, 16777215);
		class20.font_p12full.method4844(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
		MilliTimer.method3014(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6);
		if (var1) {
			class12.field275.vmethod5136(0, 0);
		} else {
			class148.method2982(var3, var4, var5, var6);
		}

	}

	static final int method85() {
		return class132.field1985;
	}

	static void method86() {
		for (int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
			int var2 = Client.menuTypes[var0];
			boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
			if (var1) {
				if (var0 < Client.menuOptionCount - 1) {
					for (int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
						Client.menuOptions[var3] = Client.menuOptions[var3 + 1];
						Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
						Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
						Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
						Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
						Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
						Client.field1021[var3] = Client.field1021[var3 + 1];
					}
				}

				--Client.menuOptionCount;
			}
		}

	}
}
