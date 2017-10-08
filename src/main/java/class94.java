public class class94 {

	static byte[] field1476;

	static byte[] field1477;

	static Buffer[] field1478;

	static int field1485;

	static int[] field1480;

	static int field1474;

	static int[] field1482;

	static int[] field1483;

	static int[] field1475;

	static int[] field1481;

	static int field1486;

	static int[] field1487;

	static Buffer field1488;

	public static int field1491;

	static {
		field1476 = new byte[2048];
		field1477 = new byte[2048];
		field1478 = new Buffer[2048];
		field1485 = 0;
		field1480 = new int[2048];
		field1474 = 0;
		field1482 = new int[2048];
		field1483 = new int[2048];
		field1475 = new int[2048];
		field1481 = new int[2048];
		field1486 = 0;
		field1487 = new int[2048];
		field1488 = new Buffer(new byte[5000]);
	}

	public static void method1859(IndexDataBase var0) {
		VarPlayerType.varplayer_ref = var0;
		class181.field2452 = VarPlayerType.varplayer_ref.fileCount(16);
	}

	public static boolean method1858(int var0) {
		return (var0 >> 30 & 1) != 0;
	}
}
