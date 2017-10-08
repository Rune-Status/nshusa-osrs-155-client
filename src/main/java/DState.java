public final class DState {

	static String field2392;

	final int field2380;

	final int field2364;

	final int field2365;

	final int field2366;

	final int field2367;

	final int field2368;

	int next_in;

	int next_out;

	int[] field2384;

	int[] field2389;

	boolean[] inUse;

	boolean[] field2376;

	byte[] seqToUnseq;

	byte[] field2391;

	byte[] strm;

	int[] field2393;

	byte[] field2386;

	byte[] field2394;

	byte[] out;

	byte[][] field2395;

	int[][] field2396;

	int[][] field2379;

	int[][] field2398;

	int field2374;

	int[] field2371;

	int total_in_lo32;

	int total_in_hi32;

	int total_out_lo32;

	int total_out_hi32;

	int blockSize100k;

	int field2381;

	int nInUse;

	int out_len;

	byte out_ch;

	int tPos;

	int nblock_used;

	int k0;

	int field2400;

	DState() {
		this.field2380 = 4096;
		this.field2364 = 16;
		this.field2365 = 258;
		this.field2366 = 6;
		this.field2367 = 50;
		this.field2368 = 18002;
		this.next_in = 0;
		this.next_out = 0;
		this.field2384 = new int[256];
		this.field2389 = new int[257];
		this.inUse = new boolean[256];
		this.field2376 = new boolean[16];
		this.seqToUnseq = new byte[256];
		this.field2391 = new byte[4096];
		this.field2393 = new int[16];
		this.field2386 = new byte[18002];
		this.field2394 = new byte[18002];
		this.field2395 = new byte[6][258];
		this.field2396 = new int[6][258];
		this.field2379 = new int[6][258];
		this.field2398 = new int[6][258];
		this.field2371 = new int[6];
	}
}
