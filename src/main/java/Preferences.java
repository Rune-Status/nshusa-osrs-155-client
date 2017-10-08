import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Preferences {

	static int field1309;

	int screenType;

	String field1306;

	boolean hideRoofs;

	boolean field1304;

	LinkedHashMap preferences;

	boolean muted;

	static {
		field1309 = 6;
	}

	Preferences() {
		this.screenType = 1;
		this.field1306 = null;
		this.field1304 = false;
		this.preferences = new LinkedHashMap();
		this.method1648(true);
	}

	Preferences(Buffer var1) {
		this.screenType = 1;
		this.field1306 = null;
		this.field1304 = false;
		this.preferences = new LinkedHashMap();
		if (var1 != null && var1.payload != null) {
			int var2 = var1.readUnsignedByte();
			if (var2 >= 0 && var2 <= field1309) {
				if (var1.readUnsignedByte() == 1) {
					this.hideRoofs = true;
				}

				if (var2 > 1) {
					this.muted = var1.readUnsignedByte() == 1;
				}

				if (var2 > 3) {
					this.screenType = var1.readUnsignedByte();
				}

				if (var2 > 2) {
					int var3 = var1.readUnsignedByte();

					for (int var4 = 0; var4 < var3; ++var4) {
						int var5 = var1.readInt();
						int var6 = var1.readInt();
						this.preferences.put(Integer.valueOf(var5), Integer.valueOf(var6));
					}
				}

				if (var2 > 4) {
					this.field1306 = var1.getNullString();
				}

				if (var2 > 5) {
					this.field1304 = var1.method3243();
				}
			} else {
				this.method1648(true);
			}
		} else {
			this.method1648(true);
		}

	}

	void method1648(boolean var1) {
	}

	Buffer serialize() {
		Buffer var1 = new Buffer(100);
		var1.putByte(field1309);
		var1.putByte(this.hideRoofs ? 1 : 0);
		var1.putByte(this.muted ? 1 : 0);
		var1.putByte(this.screenType);
		var1.putByte(this.preferences.size());
		Iterator var2 = this.preferences.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			var1.putInt(((Integer) var3.getKey()).intValue());
			var1.putInt(((Integer) var3.getValue()).intValue());
		}

		var1.putString(this.field1306 != null ? this.field1306 : "");
		var1.method3363(this.field1304);
		return var1;
	}

	static final int method1647(int var0, int var1, int var2) {
		int var3 = 256 - var2;
		return ((var1 & '\uff00') * var2 + (var0 & '\uff00') * var3 & 16711680)
				+ (var3 * (var0 & 16711935) + (var1 & 16711935) * var2 & -16711936) >> 8;
	}

	static final int method1645(int var0, int var1) {
		int var2 = var0 + var1 * 57;
		var2 ^= var2 << 13;
		int var3 = 1376312589 + (var2 * var2 * 15731 + 789221) * var2 & Integer.MAX_VALUE;
		return var3 >> 19 & 255;
	}
}
