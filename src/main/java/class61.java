public final class class61 {

	static int[][][] tileHeights;

	static RSSocket rssocket;

	static byte[][][] tileSettings;

	static int field773;

	static final int[] field783;

	static final int[] field771;

	static final int[] field782;

	static final int[] field770;

	static final int[] field774;

	static final int[] field775;

	static int field776;

	static int field777;

	static byte[][][] underlayIds;

	static byte[][][] overlayIds;

	static byte[][][] overlayRotations;

	static int[] field769;

	static {
		tileHeights = new int[4][105][105];
		tileSettings = new byte[4][104][104];
		field773 = 99;
		field783 = new int[] { 1, 2, 4, 8 };
		field771 = new int[] { 16, 32, 64, 128 };
		field782 = new int[] { 1, 0, -1, 0 };
		field770 = new int[] { 0, -1, 0, 1 };
		field774 = new int[] { 1, -1, -1, 1 };
		field775 = new int[] { -1, -1, 1, 1 };
		field776 = (int) (Math.random() * 17.0D) - 8;
		field777 = (int) (Math.random() * 33.0D) - 16;
	}

	public static boolean method1122(int var0) {
		return (var0 >> 21 & 1) != 0;
	}
}
