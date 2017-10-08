public final class PacketBuffer extends Buffer {

	static final int[] field2435;

	int bitPosition;

	ISAACCipher cipher;

	static {
		field2435 = new int[] { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff',
				131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727,
				268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1 };
	}

	public PacketBuffer(int var1) {
		super(var1);
	}

	public int readOpcode() {
		return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
	}

	public void putOpcode(int var1) {
		super.payload[++super.offset - 1] = (byte) (var1 + this.cipher.nextInt());
	}

	public void bitAccess() {
		this.bitPosition = super.offset * 8;
	}

	public void byteAccess() {
		super.offset = (this.bitPosition + 7) / 8;
	}

	public int getBits(int var1) {
		int var2 = this.bitPosition >> 3;
		int var3 = 8 - (this.bitPosition & 7);
		int var4 = 0;

		for (this.bitPosition += var1; var1 > var3; var3 = 8) {
			var4 += (super.payload[var2++] & field2435[var3]) << var1 - var3;
			var1 -= var3;
		}

		if (var3 == var1) {
			var4 += super.payload[var2] & field2435[var3];
		} else {
			var4 += super.payload[var2] >> var3 - var1 & field2435[var1];
		}

		return var4;
	}

	public int bitsAvail(int var1) {
		return var1 * 8 - this.bitPosition;
	}

	public void seed(int[] var1) {
		this.cipher = new ISAACCipher(var1);
	}

	static void method3505(Buffer var0, long var1) {
		var1 /= 10L;
		if (var1 < 0L) {
			var1 = 0L;
		} else if (var1 > 65535L) {
			var1 = 65535L;
		}

		var0.putShort((int) var1);
	}

	public static Widget method3528(int var0) {
		int var1 = var0 >> 16;
		int var2 = var0 & '\uffff';
		if (class177.widgets[var1] == null || class177.widgets[var1][var2] == null) {
			boolean var3 = class93.loadWidget(var1);
			if (!var3) {
				return null;
			}
		}

		return class177.widgets[var1][var2];
	}
}
