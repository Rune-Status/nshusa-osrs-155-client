public class class205 extends Node {

	class202 field2560;

	int field2567;

	class207 field2558;

	class105 field2559;

	class115 field2570;

	int field2566;

	int field2563;

	int field2565;

	int field2571;

	int field2575;

	int field2557;

	int field2561;

	int field2576;

	int field2577;

	int field2574;

	int field2573;

	int field2568;

	int field2564;

	int field2569;

	int field2562;

	int field2572;

	void method3927() {
		this.field2558 = null;
		this.field2559 = null;
		this.field2560 = null;
		this.field2570 = null;
	}

	static final void method3930(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7,
			int var8) {
		PendingSpawn var9 = null;

		for (PendingSpawn var10 = (PendingSpawn) Client.pendingSpawns
				.getFront(); var10 != null; var10 = (PendingSpawn) Client.pendingSpawns.getNext()) {
			if (var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
				var9 = var10;
				break;
			}
		}

		if (var9 == null) {
			var9 = new PendingSpawn();
			var9.level = var0;
			var9.type = var3;
			var9.x = var1;
			var9.y = var2;
			class132.method2677(var9);
			Client.pendingSpawns.addFront(var9);
		}

		var9.id = var4;
		var9.field1203 = var5;
		var9.orientation = var6;
		var9.delay = var7;
		var9.hitpoints = var8;
	}

	static void method3929(Sequence var0, int var1, int var2, int var3) {
		if (Client.field1154 < 50 && Client.field1114 != 0) {
			if (var0.field3613 != null && var1 < var0.field3613.length) {
				int var4 = var0.field3613[var1];
				if (var4 != 0) {
					int var5 = var4 >> 8;
					int var6 = var4 >> 4 & 7;
					int var7 = var4 & 15;
					Client.field1155[Client.field1154] = var5;
					Client.field1156[Client.field1154] = var6;
					Client.field1157[Client.field1154] = 0;
					Client.audioEffects[Client.field1154] = null;
					int var8 = (var2 - 64) / 128;
					int var9 = (var3 - 64) / 128;
					Client.field1158[Client.field1154] = var7 + (var9 << 8) + (var8 << 16);
					++Client.field1154;
				}
			}
		}
	}
}
