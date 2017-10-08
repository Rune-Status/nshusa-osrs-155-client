import java.util.zip.CRC32;

public class class238 {

	public static int field3257;

	public static int field3252;

	public static HashTable field3259;

	public static int field3271;

	public static HashTable field3251;

	public static Node2LinkedList field3258;

	public static FileRequest currentRequest;

	public static int field3255;

	public static HashTable field3256;

	public static long field3268;

	public static int field3253;

	public static HashTable field3261;

	public static int field3254;

	static IndexData[] field3260;

	public static int field3262;

	public static RSSocket field3265;

	public static Buffer field3270;

	public static int field3266;

	static CRC32 field3267;

	public static byte field3269;

	static boolean field3263;

	static {
		field3252 = 0;
		field3251 = new HashTable(4096);
		field3255 = 0;
		field3256 = new HashTable(32);
		field3253 = 0;
		field3258 = new Node2LinkedList();
		field3259 = new HashTable(4096);
		field3254 = 0;
		field3261 = new HashTable(4096);
		field3262 = 0;
		field3270 = new Buffer(8);
		field3266 = 0;
		field3267 = new CRC32();
		field3260 = new IndexData[256];
		field3269 = 0;
		field3257 = 0;
		field3271 = 0;
	}

	public static boolean method4362(int var0) {
		return var0 >= class221.field2826.field2838 && var0 <= class221.field2836.field2838;
	}
}
