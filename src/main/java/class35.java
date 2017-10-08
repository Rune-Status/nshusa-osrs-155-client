public class class35 {

	static final class35 field515;

	public static Track1 field516;

	static final class35 field512;

	static SpritePixels[] hitmarks;

	static int[] blendedSaturation;

	static int field514;

	final int field513;

	static {
		field515 = new class35(0);
		field512 = new class35(1);
	}

	class35(int var1) {
		this.field513 = var1;
	}

	public static int djb2Hash(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + PlayerComposition.method4079(var0.charAt(var3));
		}

		return var2;
	}

	public static boolean method484(IndexDataBase var0, int var1) {
		byte[] var2 = var0.method4224(var1);
		if (var2 == null) {
			return false;
		} else {
			Timer.decodeSprite(var2);
			return true;
		}
	}

	static int method485(int var0, Script var1, boolean var2) {
		Widget var3 = PacketBuffer.method3528(class81.intStack[--class81.intStackSize]);
		if (var0 == 2500) {
			class81.intStack[++class81.intStackSize - 1] = var3.relativeX;
			return 1;
		} else if (var0 == 2501) {
			class81.intStack[++class81.intStackSize - 1] = var3.relativeY;
			return 1;
		} else if (var0 == 2502) {
			class81.intStack[++class81.intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == 2503) {
			class81.intStack[++class81.intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == 2504) {
			class81.intStack[++class81.intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == 2505) {
			class81.intStack[++class81.intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}
}
