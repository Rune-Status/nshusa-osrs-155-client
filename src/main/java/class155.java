import java.io.File;

public class class155 {

	public static CacheFile field2258;

	public static File field2256;

	public static CacheFile field2261;

	public static CacheFile field2260;

	static File field2255;

	static {
		field2258 = null;
		field2261 = null;
		field2260 = null;
	}

	public static Spotanim getSpotAnimType(int var0) {
		Spotanim var1 = (Spotanim) Spotanim.spotanims.get((long) var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = Spotanim.field3321.getConfigData(13, var0);
			var1 = new Spotanim();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			Spotanim.spotanims.put(var1, (long) var0);
			return var1;
		}
	}

	public static class251 method3049(int var0) {
		class251 var1 = (class251) class251.field3386.get((long) var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class251.field3388.getConfigData(11, var0);
			var1 = new class251();
			if (var2 != null) {
				var1.method4527(new Buffer(var2));
			}

			var1.method4542();
			class251.field3386.put(var1, (long) var0);
			return var1;
		}
	}
}
