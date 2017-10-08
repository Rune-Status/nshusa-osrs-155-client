public final class class10 extends class9 {

	static int menuY;

	static int[] field262;

	final int field267;

	final int field259;

	final int field260;

	final int field263;

	final int field261;

	final int field264;

	final int field266;

	class10(Model var1, int var2, int var3, int var4, int var5) {
		this.field267 = var2 + var1.field1944 - var1.field1947;
		this.field260 = var3 + var1.field1963 - var1.field1948;
		this.field261 = var4 + var1.field1946 - var1.field1924;
		this.field259 = var2 + var1.field1947 + var1.field1944;
		this.field263 = var3 + var1.field1948 + var1.field1963;
		this.field264 = var4 + var1.field1924 + var1.field1946;
		this.field266 = var5;
	}

	public final void vmethod57() {
		for (int var4 = 0; var4 < 8; ++var4) {
			int var1 = (var4 & 1) == 0 ? this.field267 : this.field259;
			int var2 = (var4 & 2) == 0 ? this.field260 : this.field263;
			int var3 = (var4 & 4) == 0 ? this.field261 : this.field264;
			if ((var4 & 1) == 0) {
				class207.method3998(var1, var2, var3, this.field259, var2, var3, this.field266);
			}

			if ((var4 & 2) == 0) {
				class207.method3998(var1, var2, var3, var1, this.field263, var3, this.field266);
			}

			if ((var4 & 4) == 0) {
				class207.method3998(var1, var2, var3, var1, var2, this.field264, this.field266);
			}
		}

	}

	public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
		boolean var12 = false;
		if (!Client.isMenuOpen && Client.menuOptionCount < 500) {
			Client.menuOptions[Client.menuOptionCount] = var0;
			Client.menuTargets[Client.menuOptionCount] = var1;
			Client.menuTypes[Client.menuOptionCount] = var2;
			Client.menuIdentifiers[Client.menuOptionCount] = var3;
			Client.menuActionParams0[Client.menuOptionCount] = var4;
			Client.menuActionParams1[Client.menuOptionCount] = var5;
			Client.field1021[Client.menuOptionCount] = var12;
			++Client.menuOptionCount;
		}

	}

	static void method58() {
		FileOnDisk var0 = null;

		try {
			var0 = class81.getPreferencesFile("", Client.field923.field3198, true);
			Buffer var1 = class23.preferences.serialize();
			var0.write(var1.payload, 0, var1.offset);
		} catch (Exception var3) {
			;
		}

		try {
			if (var0 != null) {
				var0.method2445(true);
			}
		} catch (Exception var2) {
			;
		}

	}
}
