import java.awt.Image;

public class class48 implements WorldMapSectionBase {

	static Image field637;

	protected static int canvasHeight;

	static int field638;

	static Widget field635;

	int field629;

	int field627;

	int field633;

	int field626;

	int field641;

	int field631;

	int field636;

	int field625;

	int field628;

	int field630;

	public boolean vmethod722(int var1, int var2) {
		return var1 >= (this.field627 << 6) + (this.field633 << 3)
				&& var1 <= (this.field627 << 6) + (this.field633 << 3) + 7
				&& var2 >= (this.field636 << 6) + (this.field625 << 3)
				&& var2 <= (this.field636 << 6) + (this.field625 << 3) + 7;
	}

	public boolean vmethod725(int var1, int var2, int var3) {
		return var1 >= this.field629 && var1 < this.field626 + this.field629
				? var2 >= (this.field641 << 6) + (this.field631 << 3)
						&& var2 <= (this.field641 << 6) + (this.field631 << 3) + 7
						&& var3 >= (this.field628 << 6) + (this.field630 << 3)
						&& var3 <= (this.field628 << 6) + (this.field630 << 3) + 7
				: false;
	}

	public void vmethod723(WorldMapData var1) {
		if (var1.field473 > this.field627) {
			var1.field473 = this.field627;
		}

		if (var1.field474 < this.field627) {
			var1.field474 = this.field627;
		}

		if (var1.field475 > this.field636) {
			var1.field475 = this.field636;
		}

		if (var1.field476 < this.field636) {
			var1.field476 = this.field636;
		}

	}

	public Coordinates vmethod727(int var1, int var2) {
		if (!this.vmethod722(var1, var2)) {
			return null;
		} else {
			int var3 = this.field641 * 64 - this.field627 * 64 + var1 + (this.field631 * 8 - this.field633 * 8);
			int var4 = this.field628 * 64 - this.field636 * 64 + var2 + (this.field630 * 8 - this.field625 * 8);
			return new Coordinates(this.field629, var3, var4);
		}
	}

	public int[] vmethod741(int var1, int var2, int var3) {
		if (!this.vmethod725(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[] {
					var2 + (this.field627 * 64 - this.field641 * 64) + (this.field633 * 8 - this.field631 * 8),
					this.field625 * 8 - this.field630 * 8 + var3 + (this.field636 * 64 - this.field628 * 64) };
			return var4;
		}
	}

	public void vmethod728(Buffer var1) {
		this.field629 = var1.readUnsignedByte();
		this.field626 = var1.readUnsignedByte();
		this.field641 = var1.readUnsignedShort();
		this.field631 = var1.readUnsignedByte();
		this.field628 = var1.readUnsignedShort();
		this.field630 = var1.readUnsignedByte();
		this.field627 = var1.readUnsignedShort();
		this.field633 = var1.readUnsignedByte();
		this.field636 = var1.readUnsignedShort();
		this.field625 = var1.readUnsignedByte();
		this.method733();
	}

	void method733() {
	}

	public static RSEnum forOrdinal(RSEnum[] var0, int var1) {
		RSEnum[] var2 = var0;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			RSEnum var4 = var2[var3];
			if (var1 == var4.rsOrdinal()) {
				return var4;
			}
		}

		return null;
	}

	static int method735(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = PacketBuffer.method3528(class81.intStack[--class81.intStackSize]);
		} else {
			var3 = var2 ? class81.field1341 : class81.field1340;
		}

		if (var0 == 1927) {
			if (class81.field1344 >= 10) {
				throw new RuntimeException();
			} else if (var3.field2767 == null) {
				return 0;
			} else {
				ScriptEvent var4 = new ScriptEvent();
				var4.widget = var3;
				var4.field846 = var3.field2767;
				var4.field854 = class81.field1344 + 1;
				Client.field1112.addFront(var4);
				return 1;
			}
		} else {
			return 2;
		}
	}
}
