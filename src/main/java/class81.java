import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class class81 {

	static int[] field1332;

	static int[][] SHAPE_VERTICES;

	static int[] intStack;

	static String[] scriptStringStack;

	static int scriptStackCount;

	static ScriptState[] scriptStack;

	static Calendar field1329;

	static final String[] field1343;

	static int field1344;

	static int intStackSize;

	static int scriptStringStackSize;

	static int[] scriptLocalInts;

	static Widget field1340;

	static Widget field1341;

	static {
		field1332 = new int[5];
		SHAPE_VERTICES = new int[5][5000];
		intStack = new int[1000];
		scriptStringStack = new String[1000];
		scriptStackCount = 0;
		scriptStack = new ScriptState[50];
		field1329 = Calendar.getInstance();
		field1343 = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		field1344 = 0;
	}

	static void method1724(Component var0) {
		var0.removeKeyListener(KeyFocusListener.keyboard);
		var0.removeFocusListener(KeyFocusListener.keyboard);
		KeyFocusListener.field654 = -1;
	}

	public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
		File var3 = new File(class155.field2256, "preferences" + var0 + ".dat");
		if (var3.exists()) {
			try {
				FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
				return var10;
			} catch (IOException var9) {
				;
			}
		}

		String var4 = "";
		if (Ignore.field858 == 33) {
			var4 = "_rc";
		} else if (Ignore.field858 == 34) {
			var4 = "_wip";
		}

		File var5 = new File(class89.userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
		FileOnDisk var6;
		if (!var2 && var5.exists()) {
			try {
				var6 = new FileOnDisk(var5, "rw", 10000L);
				return var6;
			} catch (IOException var8) {
				;
			}
		}

		try {
			var6 = new FileOnDisk(var3, "rw", 10000L);
			return var6;
		} catch (IOException var7) {
			throw new RuntimeException();
		}
	}

	static final void method1726(int var0, int var1) {
		if (Client.menuOptionCount >= 2 || Client.itemSelectionState != 0 || Client.spellSelected) {
			int var2 = Client.menuOptionCount - 1;
			String var4;
			if (Client.itemSelectionState == 1 && Client.menuOptionCount < 2) {
				var4 = "Use" + " " + Client.field1067 + " " + "->";
			} else if (Client.spellSelected && Client.menuOptionCount < 2) {
				var4 = Client.field1071 + " " + Client.field948 + " " + "->";
			} else {
				var4 = class87.method1776(var2);
			}

			if (Client.menuOptionCount > 2) {
				var4 = var4 + class60.getColTags(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2)
						+ " more options";
			}

			Friend.field827.drawRandomizedMouseoverText(var4, var0 + 4, var1 + 15, 16777215, 0,
					Client.gameCycle / 1000);
		}
	}
}
