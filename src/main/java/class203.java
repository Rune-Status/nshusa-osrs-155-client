public class class203 {

	public static int field2521;

	public static class204 field2523;

	public static class110 field2524;

	public static IndexDataBase field2522;

	public static int field2520;

	public static IndexDataBase field2517;

	public static IndexDataBase field2519;

	public static IndexDataBase field2518;

	static {
		field2521 = 0;
	}

	static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
		IndexFile var4 = null;
		if (class155.field2261 != null) {
			var4 = new IndexFile(var0, class155.field2261, class96.field1514[var0], 1000000);
		}

		return new IndexData(var4, class204.field2552, var0, var1, var2, var3);
	}

	public static String method3795(CharSequence var0) {
		String var1 = CombatInfo1.method1610(class36.method491(var0));
		if (var1 == null) {
			var1 = "";
		}

		return var1;
	}
}
