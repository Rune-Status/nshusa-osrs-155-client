public class FileSystem extends Node {

	public static int[] field3207;

	protected static String field3202;

	int field3206;

	public IndexFile index;

	public byte[] field3203;

	public IndexData data;

	static int method4214(IterableHashTable var0, int var1, int var2) {
		if (var0 == null) {
			return var2;
		} else {
			IntegerNode var3 = (IntegerNode) var0.get((long) var1);
			return var3 == null ? var2 : var3.value;
		}
	}
}
