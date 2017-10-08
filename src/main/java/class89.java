public enum class89 implements RSEnum {

	field1404(0),

	field1401(1),

	field1402(2),

	field1403(3);

	final int field1400;

	public static IndexDataBase field1406;

	public static String userHome;

	class89(int var3) {
		this.field1400 = var3;
	}

	public int rsOrdinal() {
		return this.field1400;
	}

	public static void method1784() {
		VarPlayerType.varplayers.reset();
	}

	static void method1783() {
		if (Client.spellSelected) {
			Widget var0 = class5.method18(class25.field372, Client.field1069);
			if (var0 != null && var0.field2750 != null) {
				ScriptEvent var1 = new ScriptEvent();
				var1.widget = var0;
				var1.field846 = var0.field2750;
				CollisionData.method3128(var1);
			}

			Client.spellSelected = false;
			class25.method172(var0);
		}
	}
}
