import java.util.Iterator;
import java.util.LinkedList;

public class WorldMapData {

	String field469;

	int field470;

	int fileId;

	boolean field481;

	String field468;

	int field471;

	Coordinates field477;

	LinkedList field472;

	int field476;

	int field474;

	int field473;

	int field475;

	public WorldMapData() {
		this.fileId = -1;
		this.field470 = -1;
		this.field471 = -1;
		this.field477 = null;
		this.field473 = Integer.MAX_VALUE;
		this.field474 = 0;
		this.field475 = Integer.MAX_VALUE;
		this.field476 = 0;
		this.field481 = false;
	}

	public void loadMapData(Buffer var1, int var2) {
		this.fileId = var2;
		this.field468 = var1.readString();
		this.field469 = var1.readString();
		this.field477 = new Coordinates(var1.readInt());
		this.field470 = var1.readInt();
		var1.readUnsignedByte();
		this.field481 = var1.readUnsignedByte() == 1;
		this.field471 = var1.readUnsignedByte();
		int var3 = var1.readUnsignedByte();
		this.field472 = new LinkedList();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.field472.add(this.method271(var1));
		}

		this.method305();
	}

	public String method279() {
		return this.field468;
	}

	public boolean method273(int var1, int var2) {
		int var3 = var1 / 64;
		int var4 = var2 / 64;
		if (var3 >= this.field473 && var3 <= this.field474) {
			if (var4 >= this.field475 && var4 <= this.field476) {
				Iterator var5 = this.field472.iterator();

				WorldMapSectionBase var6;
				do {
					if (!var5.hasNext()) {
						return false;
					}

					var6 = (WorldMapSectionBase) var5.next();
				} while (!var6.vmethod722(var1, var2));

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public int method313() {
		return this.fileId;
	}

	public int[] method285(int var1, int var2, int var3) {
		Iterator var4 = this.field472.iterator();

		WorldMapSectionBase var5;
		do {
			if (!var4.hasNext()) {
				return null;
			}

			var5 = (WorldMapSectionBase) var4.next();
		} while (!var5.vmethod725(var1, var2, var3));

		return var5.vmethod741(var1, var2, var3);
	}

	public int method316() {
		return this.field473;
	}

	public int method333() {
		return this.field475;
	}

	public boolean method272(int var1, int var2, int var3) {
		Iterator var4 = this.field472.iterator();

		WorldMapSectionBase var5;
		do {
			if (!var4.hasNext()) {
				return false;
			}

			var5 = (WorldMapSectionBase) var4.next();
		} while (!var5.vmethod725(var1, var2, var3));

		return true;
	}

	public Coordinates method275(int var1, int var2) {
		Iterator var3 = this.field472.iterator();

		WorldMapSectionBase var4;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			var4 = (WorldMapSectionBase) var3.next();
		} while (!var4.vmethod722(var1, var2));

		return var4.vmethod727(var1, var2);
	}

	public int method288() {
		return this.field477.plane;
	}

	public int method287() {
		return this.field477.worldX;
	}

	public int method289() {
		return this.field477.worldY;
	}

	public int method292() {
		return this.field471;
	}

	void method305() {
		Iterator var1 = this.field472.iterator();

		while (var1.hasNext()) {
			WorldMapSectionBase var2 = (WorldMapSectionBase) var1.next();
			var2.vmethod723(this);
		}

	}

	WorldMapSectionBase method271(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		class27 var3 = (class27) class48.forOrdinal(class27.method205(), var2);
		Object var4 = null;
		switch (var3.field404) {
		case 0:
			var4 = new WorldMapType2();
			break;
		case 1:
			var4 = new WorldMapType3();
			break;
		case 2:
			var4 = new WorldMapType1();
			break;
		case 3:
			var4 = new class48();
			break;
		default:
			throw new IllegalStateException("");
		}

		((WorldMapSectionBase) var4).vmethod728(var1);
		return (WorldMapSectionBase) var4;
	}

	public boolean method278() {
		return this.field481;
	}

	public int method290() {
		return this.field474;
	}

	public int method323() {
		return this.field476;
	}

	int method274() {
		return this.field470;
	}

	public String method280() {
		return this.field469;
	}

	public Coordinates method326() {
		return new Coordinates(this.field477);
	}

	static void setItemTableSlot(int var0, int var1, int var2, int var3) {
		ItemContainer var4 = (ItemContainer) ItemContainer.itemContainers.get((long) var0);
		if (var4 == null) {
			var4 = new ItemContainer();
			ItemContainer.itemContainers.put(var4, (long) var0);
		}

		if (var4.itemIds.length <= var1) {
			int[] var5 = new int[var1 + 1];
			int[] var6 = new int[var1 + 1];

			int var7;
			for (var7 = 0; var7 < var4.itemIds.length; ++var7) {
				var5[var7] = var4.itemIds[var7];
				var6[var7] = var4.stackSizes[var7];
			}

			for (var7 = var4.itemIds.length; var7 < var1; ++var7) {
				var5[var7] = -1;
				var6[var7] = 0;
			}

			var4.itemIds = var5;
			var4.stackSizes = var6;
		}

		var4.itemIds[var1] = var2;
		var4.stackSizes[var1] = var3;
	}
}
