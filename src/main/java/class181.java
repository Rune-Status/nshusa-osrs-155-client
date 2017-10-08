public class class181 {

	public static int[] field2456;

	public static int field2452;

	static int field2454;

	static final void method3546() {
		if (class268.rssocket != null) {
			class268.rssocket.close();
			class268.rssocket = null;
		}

		WorldMapType1.method264();
		class8.region.reset();

		for (int var0 = 0; var0 < 4; ++var0) {
			Client.collisionMaps[var0].reset();
		}

		System.gc();
		class138.method2927(2);
		Client.field1086 = -1;
		Client.field1151 = false;

		for (class80 var1 = (class80) class80.field1324.getFront(); var1 != null; var1 = (class80) class80.field1324
				.getNext()) {
			if (var1.field1313 != null) {
				CombatInfoListHolder.field1364.method1949(var1.field1313);
				var1.field1313 = null;
			}

			if (var1.field1315 != null) {
				CombatInfoListHolder.field1364.method1949(var1.field1315);
				var1.field1315 = null;
			}
		}

		class80.field1324.clear();
		FrameMap.setGameState(10);
	}
}
