public class WorldMapType3 implements WorldMapSectionBase {

	static int field397;

	static class156 field396;

	static MachineInfo field378;

	int field390;

	int field384;

	int field388;

	int field379;

	int field395;

	int field393;

	int field399;

	int field383;

	int field389;

	int field386;

	int field391;

	int field380;

	int field381;

	int field387;

	public boolean vmethod722(int var1, int var2) {
		return var1 >= (this.field384 << 6) + (this.field388 << 3)
				&& var1 <= (this.field384 << 6) + (this.field395 << 3) + 7
				&& var2 >= (this.field383 << 6) + (this.field389 << 3)
				&& var2 <= (this.field383 << 6) + (this.field391 << 3) + 7;
	}

	public boolean vmethod725(int var1, int var2, int var3) {
		return var1 >= this.field390 && var1 < this.field390 + this.field379
				? var2 >= (this.field393 << 6) + (this.field399 << 3)
						&& var2 <= (this.field393 << 6) + (this.field386 << 3) + 7
						&& var3 >= (this.field381 << 6) + (this.field380 << 3)
						&& var3 <= (this.field381 << 6) + (this.field387 << 3) + 7
				: false;
	}

	public void vmethod723(WorldMapData var1) {
		if (var1.field473 > this.field384) {
			var1.field473 = this.field384;
		}

		if (var1.field474 < this.field384) {
			var1.field474 = this.field384;
		}

		if (var1.field475 > this.field383) {
			var1.field475 = this.field383;
		}

		if (var1.field476 < this.field383) {
			var1.field476 = this.field383;
		}

	}

	public Coordinates vmethod727(int var1, int var2) {
		if (!this.vmethod722(var1, var2)) {
			return null;
		} else {
			int var3 = this.field393 * 64 - this.field384 * 64 + var1 + (this.field399 * 8 - this.field388 * 8);
			int var4 = this.field380 * 8 - this.field389 * 8 + var2 + (this.field381 * 64 - this.field383 * 64);
			return new Coordinates(this.field390, var3, var4);
		}
	}

	public int[] vmethod741(int var1, int var2, int var3) {
		if (!this.vmethod725(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[] {
					this.field388 * 8 - this.field399 * 8 + this.field384 * 64 - this.field393 * 64 + var2,
					this.field389 * 8 - this.field380 * 8 + var3 + (this.field383 * 64 - this.field381 * 64) };
			return var4;
		}
	}

	public void vmethod728(Buffer var1) {
		this.field390 = var1.readUnsignedByte();
		this.field379 = var1.readUnsignedByte();
		this.field393 = var1.readUnsignedShort();
		this.field399 = var1.readUnsignedByte();
		this.field386 = var1.readUnsignedByte();
		this.field381 = var1.readUnsignedShort();
		this.field380 = var1.readUnsignedByte();
		this.field387 = var1.readUnsignedByte();
		this.field384 = var1.readUnsignedShort();
		this.field388 = var1.readUnsignedByte();
		this.field395 = var1.readUnsignedByte();
		this.field383 = var1.readUnsignedShort();
		this.field389 = var1.readUnsignedByte();
		this.field391 = var1.readUnsignedByte();
		this.method180();
	}

	void method180() {
	}

	static void method203(int var0) {
		if (var0 != -1) {
			if (class93.loadWidget(var0)) {
				Widget[] var1 = class177.widgets[var0];

				for (int var2 = 0; var2 < var1.length; ++var2) {
					Widget var3 = var1[var2];
					if (var3.field2739 != null) {
						ScriptEvent var4 = new ScriptEvent();
						var4.widget = var3;
						var4.field846 = var3.field2739;
						Player.method1188(var4, 2000000);
					}
				}

			}
		}
	}

	static void method193() {
		for (class80 var0 = (class80) class80.field1324.getFront(); var0 != null; var0 = (class80) class80.field1324
				.getNext()) {
			if (var0.field1325 != null) {
				var0.method1657();
			}
		}

	}
}
