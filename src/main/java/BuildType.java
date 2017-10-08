public class BuildType {

	static final BuildType RC;

	static final BuildType WIP;

	static final BuildType LIVE;

	static final BuildType BUILD_LIVE;

	static int field3190;

	static int[] field3191;

	public final String identifier;

	public final int ordinal;

	static {
		RC = new BuildType("LIVE", 0);
		WIP = new BuildType("BUILDLIVE", 3);
		LIVE = new BuildType("RC", 1);
		BUILD_LIVE = new BuildType("WIP", 2);
	}

	BuildType(String var1, int var2) {
		this.identifier = var1;
		this.ordinal = var2;
	}

	static String method4209(byte[] var0, int var1, int var2) {
		StringBuilder var3 = new StringBuilder();

		for (int var4 = var1; var4 < var2 + var1; var4 += 3) {
			int var5 = var0[var4] & 255;
			var3.append(class269.field3681[var5 >>> 2]);
			if (var4 < var2 - 1) {
				int var6 = var0[var4 + 1] & 255;
				var3.append(class269.field3681[(var5 & 3) << 4 | var6 >>> 4]);
				if (var4 < var2 - 2) {
					int var7 = var0[var4 + 2] & 255;
					var3.append(class269.field3681[(var6 & 15) << 2 | var7 >>> 6])
							.append(class269.field3681[var7 & 63]);
				} else {
					var3.append(class269.field3681[(var6 & 15) << 2]).append("=");
				}
			} else {
				var3.append(class269.field3681[(var5 & 3) << 4]).append("==");
			}
		}

		return var3.toString();
	}

	public static class252 method4211(int var0) {
		class252 var1 = (class252) class252.field3395.get((long) var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class252.field3397.getConfigData(34, var0);
			var1 = new class252();
			if (var2 != null) {
				var1.method4555(new Buffer(var2));
			}

			var1.method4547();
			class252.field3395.put(var1, (long) var0);
			return var1;
		}
	}
}
