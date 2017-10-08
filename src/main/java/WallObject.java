public final class WallObject {

	static int baseX;

	public int hash;

	int config;

	int x;

	int y;

	public Renderable renderable1;

	int floor;

	public Renderable renderable2;

	int orientationA;

	int orientationB;

	WallObject() {
		this.hash = 0;
		this.config = 0;
	}

	static final void method2937(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
		String[] var5 = var1.inventoryActions;
		byte var6 = -1;
		String var7 = null;
		if (var5 != null && var5[var3] != null) {
			if (var3 == 0) {
				var6 = 33;
			} else if (var3 == 1) {
				var6 = 34;
			} else if (var3 == 2) {
				var6 = 35;
			} else if (var3 == 3) {
				var6 = 36;
			} else {
				var6 = 37;
			}

			var7 = var5[var3];
		} else if (var3 == 4) {
			var6 = 37;
			var7 = "Drop";
		}

		if (var6 != -1 && var7 != null) {
			String var9 = class60.getColTags(16748608) + var1.name;
			int var11 = var1.id;
			int var13 = var0.id;
			if (!Client.isMenuOpen && Client.menuOptionCount < 500) {
				Client.menuOptions[Client.menuOptionCount] = var7;
				Client.menuTargets[Client.menuOptionCount] = var9;
				Client.menuTypes[Client.menuOptionCount] = var6;
				Client.menuIdentifiers[Client.menuOptionCount] = var11;
				Client.menuActionParams0[Client.menuOptionCount] = var2;
				Client.menuActionParams1[Client.menuOptionCount] = var13;
				Client.field1021[Client.menuOptionCount] = var4;
				++Client.menuOptionCount;
			}
		}

	}
}
