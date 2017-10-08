import java.applet.Applet;

public class class56 {

	static Applet field694;

	static String field695;

	static int field697;

	static {
		field694 = null;
		field695 = null;
	}

	public static int method850(byte[] var0, int var1) {
		return class14.method89(var0, 0, var1);
	}

	static final boolean method848(char var0) {
		return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
	}

	static final void method849(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
		int var7;
		int var8;
		for (int var6 = 0; var6 < 4; ++var6) {
			for (var7 = 0; var7 < 64; ++var7) {
				for (var8 = 0; var8 < 64; ++var8) {
					if (var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
						var5[var6].flags[var7 + var1][var8 + var2] &= -16777217;
					}
				}
			}
		}

		Buffer var10 = new Buffer(var0);

		for (var7 = 0; var7 < 4; ++var7) {
			for (var8 = 0; var8 < 64; ++var8) {
				for (int var9 = 0; var9 < 64; ++var9) {
					class148.loadTerrain(var10, var7, var8 + var1, var9 + var2, var3, var4, 0);
				}
			}
		}

	}

	static void method837(int var0, boolean var1, int var2, boolean var3) {
		if (class138.worldList != null) {
			RSCanvas.method810(0, class138.worldList.length - 1, var0, var1, var2, var3);
		}

	}
}
