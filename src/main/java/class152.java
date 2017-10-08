import java.applet.Applet;

public class class152 extends RuntimeException {

	public static int revision;

	public static Applet field2230;

	public static short[] colorsToFind;

	public static String field2224;

	String field2226;

	Throwable field2232;

	static int method3019(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = PacketBuffer.method3528(class81.intStack[--class81.intStackSize]);
		} else {
			var3 = var2 ? class81.field1341 : class81.field1340;
		}

		int var4;
		if (var0 == 1300) {
			var4 = class81.intStack[--class81.intStackSize] - 1;
			if (var4 >= 0 && var4 <= 9) {
				var3.method4118(var4, class81.scriptStringStack[--class81.scriptStringStackSize]);
				return 1;
			} else {
				--class81.scriptStringStackSize;
				return 1;
			}
		} else if (var0 == 1301) {
			class81.intStackSize -= 2;
			var4 = class81.intStack[class81.intStackSize];
			int var5 = class81.intStack[class81.intStackSize + 1];
			var3.dragParent = class5.method18(var4, var5);
			return 1;
		} else if (var0 == 1302) {
			var3.field2736 = class81.intStack[--class81.intStackSize] == 1;
			return 1;
		} else if (var0 == 1303) {
			var3.field2734 = class81.intStack[--class81.intStackSize];
			return 1;
		} else if (var0 == 1304) {
			var3.field2757 = class81.intStack[--class81.intStackSize];
			return 1;
		} else if (var0 == 1305) {
			var3.name = class81.scriptStringStack[--class81.scriptStringStackSize];
			return 1;
		} else if (var0 == 1306) {
			var3.selectedAction = class81.scriptStringStack[--class81.scriptStringStackSize];
			return 1;
		} else if (var0 == 1307) {
			var3.actions = null;
			return 1;
		} else {
			return 2;
		}
	}
}
