import java.util.Iterator;

public final class class80 extends Node {

	static Deque field1324;

	int field1318;

	ObjectComposition field1325;

	int field1317;

	int field1320;

	int field1321;

	int[] field1322;

	class115 field1313;

	int field1319;

	int field1311;

	int field1316;

	int field1326;

	int field1312;

	class115 field1315;

	int field1323;

	static {
		field1324 = new Deque();
	}

	void method1657() {
		int var1 = this.field1318;
		ObjectComposition var2 = this.field1325.getImpostor();
		if (var2 != null) {
			this.field1318 = var2.ambientSoundId;
			this.field1317 = var2.field3483 * 128;
			this.field1320 = var2.field3445;
			this.field1321 = var2.field3470;
			this.field1322 = var2.field3486;
		} else {
			this.field1318 = -1;
			this.field1317 = 0;
			this.field1320 = 0;
			this.field1321 = 0;
			this.field1322 = null;
		}

		if (var1 != this.field1318 && this.field1313 != null) {
			CombatInfoListHolder.field1364.method1949(this.field1313);
			this.field1313 = null;
		}

	}

	static String method1662() {
		String var0 = "";

		MessageNode var2;
		for (Iterator var1 = class96.field1508.iterator(); var1
				.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
			var2 = (MessageNode) var1.next();
		}

		return var0;
	}
}
