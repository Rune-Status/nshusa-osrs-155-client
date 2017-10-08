import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class Buffer extends Node {

	static int[] crc32Table;

	static long[] crc64Table;

	public byte[] payload;

	public int offset;

	static {
		crc32Table = new int[256];

		int var2;
		for (int var1 = 0; var1 < 256; ++var1) {
			int var0 = var1;

			for (var2 = 0; var2 < 8; ++var2) {
				if ((var0 & 1) == 1) {
					var0 = var0 >>> 1 ^ -306674912;
				} else {
					var0 >>>= 1;
				}
			}

			crc32Table[var1] = var0;
		}

		crc64Table = new long[256];

		for (var2 = 0; var2 < 256; ++var2) {
			long var4 = (long) var2;

			for (int var3 = 0; var3 < 8; ++var3) {
				if ((var4 & 1L) == 1L) {
					var4 = var4 >>> 1 ^ -3932672073523589310L;
				} else {
					var4 >>>= 1;
				}
			}

			crc64Table[var2] = var4;
		}

	}

	public Buffer(int var1) {
		this.payload = class174.method3463(var1);
		this.offset = 0;
	}

	public Buffer(byte[] var1) {
		this.payload = var1;
		this.offset = 0;
	}

	public int readInt() {
		this.offset += 4;
		return ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255)
				+ ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 24);
	}

	public void putByte(int var1) {
		this.payload[++this.offset - 1] = (byte) var1;
	}

	public int readUnsignedByte() {
		return this.payload[++this.offset - 1] & 255;
	}

	public int method3252() {
		if (this.payload[this.offset] < 0) {
			return this.readInt() & Integer.MAX_VALUE;
		} else {
			int var1 = this.readUnsignedShort();
			return var1 == 32767 ? -1 : var1;
		}
	}

	public int read24BitInt() {
		this.offset += 3;
		return ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255)
				+ ((this.payload[this.offset - 2] & 255) << 8);
	}

	public int readVarInt() {
		byte var1 = this.payload[++this.offset - 1];

		int var2;
		for (var2 = 0; var1 < 0; var1 = this.payload[++this.offset - 1]) {
			var2 = (var2 | var1 & 127) << 7;
		}

		return var2 | var1;
	}

	public byte readByte() {
		return this.payload[++this.offset - 1];
	}

	public String readString() {
		int var1 = this.offset;

		while (this.payload[++this.offset - 1] != 0) {
			;
		}

		int var2 = this.offset - var1 - 1;
		return var2 == 0 ? "" : class12.getString(this.payload, var1, var2);
	}

	public int readUnsignedShort() {
		this.offset += 2;
		return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
	}

	public void readBytes(byte[] var1, int var2, int var3) {
		for (int var4 = var2; var4 < var3 + var2; ++var4) {
			var1[var4] = this.payload[++this.offset - 1];
		}

	}

	public void putInt(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 >> 24);
		this.payload[++this.offset - 1] = (byte) (var1 >> 16);
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
		this.payload[++this.offset - 1] = (byte) var1;
	}

	public void putShort(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
		this.payload[++this.offset - 1] = (byte) var1;
	}

	public int readShort() {
		this.offset += 2;
		int var1 = (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
		if (var1 > 32767) {
			var1 -= 65536;
		}

		return var1;
	}

	public String getJagString() {
		byte var1 = this.payload[++this.offset - 1];
		if (var1 != 0) {
			throw new IllegalStateException("");
		} else {
			int var2 = this.offset;

			while (this.payload[++this.offset - 1] != 0) {
				;
			}

			int var3 = this.offset - var2 - 1;
			return var3 == 0 ? "" : class12.getString(this.payload, var2, var3);
		}
	}

	public void putVarInt(int var1) {
		if ((var1 & -128) != 0) {
			if ((var1 & -16384) != 0) {
				if ((var1 & -2097152) != 0) {
					if ((var1 & -268435456) != 0) {
						this.putByte(var1 >>> 28 | 128);
					}

					this.putByte(var1 >>> 21 | 128);
				}

				this.putByte(var1 >>> 14 | 128);
			}

			this.putByte(var1 >>> 7 | 128);
		}

		this.putByte(var1 & 127);
	}

	public void putBytes(byte[] var1, int var2, int var3) {
		for (int var4 = var2; var4 < var3 + var2; ++var4) {
			this.payload[++this.offset - 1] = var1[var4];
		}

	}

	public long readLong() {
		long var1 = (long) this.readInt() & 4294967295L;
		long var3 = (long) this.readInt() & 4294967295L;
		return (var1 << 32) + var3;
	}

	public int getLargeSmart() {
		return this.payload[this.offset] < 0 ? this.readInt() & Integer.MAX_VALUE : this.readUnsignedShort();
	}

	public void decryptXtea(int[] var1, int var2, int var3) {
		int var4 = this.offset;
		this.offset = var2;
		int var5 = (var3 - var2) / 8;

		for (int var6 = 0; var6 < var5; ++var6) {
			int var7 = this.readInt();
			int var8 = this.readInt();
			int var9 = -957401312;
			int var10 = -1640531527;

			for (int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) {
				var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9;
				var9 -= var10;
			}

			this.offset -= 8;
			this.putInt(var7);
			this.putInt(var8);
		}

		this.offset = var4;
	}

	public void putString(String var1) {
		int var2 = var1.indexOf(0);
		if (var2 >= 0) {
			throw new IllegalArgumentException("");
		} else {
			this.offset += Signlink.method3020(var1, 0, var1.length(), this.payload, this.offset);
			this.payload[++this.offset - 1] = 0;
		}
	}

	public void method3363(boolean var1) {
		this.putByte(var1 ? 1 : 0);
	}

	public void put24bitInt(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 >> 16);
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
		this.payload[++this.offset - 1] = (byte) var1;
	}

	public String getNullString() {
		if (this.payload[this.offset] == 0) {
			++this.offset;
			return null;
		} else {
			return this.readString();
		}
	}

	public boolean method3243() {
		return (this.readUnsignedByte() & 1) == 1;
	}

	public int readShortSmart() {
		int var1 = this.payload[this.offset] & 255;
		return var1 < 128 ? this.readUnsignedByte() - 64 : this.readUnsignedShort() - '쀀';
	}

	public void putJagString(String var1) {
		int var2 = var1.indexOf(0);
		if (var2 >= 0) {
			throw new IllegalArgumentException("");
		} else {
			this.payload[++this.offset - 1] = 0;
			this.offset += Signlink.method3020(var1, 0, var1.length(), this.payload, this.offset);
			this.payload[++this.offset - 1] = 0;
		}
	}

	public void method3270(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
		this.payload[++this.offset - 1] = (byte) (var1 + 128);
	}

	public void method3279(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
		this.payload[++this.offset - 1] = (byte) var1;
		this.payload[++this.offset - 1] = (byte) (var1 >> 24);
		this.payload[++this.offset - 1] = (byte) (var1 >> 16);
	}

	public void method3365(int var1) {
		this.payload[++this.offset - 1] = (byte) var1;
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
	}

	public void putLength(int var1) {
		this.payload[this.offset - var1 - 1] = (byte) var1;
	}

	public int getUSmart() {
		int var1 = this.payload[this.offset] & 255;
		return var1 < 128 ? this.readUnsignedByte() : this.readUnsignedShort() - '耀';
	}

	public int putCrc(int var1) {
		byte[] var3 = this.payload;
		int var4 = this.offset;
		int var5 = -1;

		for (int var6 = var1; var6 < var4; ++var6) {
			var5 = var5 >>> 8 ^ crc32Table[(var5 ^ var3[var6]) & 255];
		}

		var5 = ~var5;
		this.putInt(var5);
		return var5;
	}

	public void method3263(int var1) {
		this.payload[++this.offset - 1] = (byte) (128 - var1);
	}

	public void putLEInt(int var1) {
		this.payload[++this.offset - 1] = (byte) (0 - var1);
	}

	public int method3418() {
		return 128 - this.payload[++this.offset - 1] & 255;
	}

	public void putLong(long var1) {
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 56));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 48));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 40));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 32));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 24));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 16));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 8));
		this.payload[++this.offset - 1] = (byte) ((int) var1);
	}

	public int method3265() {
		return 0 - this.payload[++this.offset - 1] & 255;
	}

	public int readUnsignedShortOb1() {
		return this.payload[++this.offset - 1] - 128 & 255;
	}

	public int method3272() {
		this.offset += 2;
		return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
	}

	public int readIntME() {
		this.offset += 4;
		return ((this.payload[this.offset - 2] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 8)
				+ (this.payload[this.offset - 3] & 255) + ((this.payload[this.offset - 1] & 255) << 16);
	}

	public int method3283() {
		this.offset += 4;
		return ((this.payload[this.offset - 1] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 16)
				+ (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 3] & 255) << 24);
	}

	public int method3275() {
		this.offset += 2;
		int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
		if (var1 > 32767) {
			var1 -= 65536;
		}

		return var1;
	}

	public int readUShortLEA() {
		this.offset += 2;
		return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
	}

	public int method3299() {
		this.offset += 2;
		return (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
	}

	public void putShortLE(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 + 128);
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
	}

	public byte method3268() {
		return (byte) (128 - this.payload[++this.offset - 1]);
	}

	public int method3277() {
		this.offset += 3;
		return (this.payload[this.offset - 3] & 255) + ((this.payload[this.offset - 2] & 255) << 8)
				+ ((this.payload[this.offset - 1] & 255) << 16);
	}

	public void encryptRsa(BigInteger exponent, BigInteger modulus) {
		int var3 = this.offset;
		this.offset = 0;
		byte[] var4 = new byte[var3];
		this.readBytes(var4, 0, var3);
		BigInteger var5 = new BigInteger(var4);
		BigInteger var6 = var5.modPow(exponent, modulus);
		byte[] var7 = var6.toByteArray();
		this.offset = 0;
		this.putShort(var7.length);
		this.putBytes(var7, 0, var7.length);
	}

	public int method3326() {
		this.offset += 4;
		return (this.payload[this.offset - 4] & 255) + ((this.payload[this.offset - 3] & 255) << 8)
				+ ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 1] & 255) << 24);
	}

	public String getCESU8() {
		byte var1 = this.payload[++this.offset - 1];
		if (var1 != 0) {
			throw new IllegalStateException("");
		} else {
			int var2 = this.readVarInt();
			if (var2 + this.offset > this.payload.length) {
				throw new IllegalStateException("");
			} else {
				String var3 = RSSocket.method3088(this.payload, this.offset, var2);
				this.offset += var2;
				return var3;
			}
		}
	}

	public void putCESU8(CharSequence var1) {
		int var2 = Projectile.method1828(var1);
		this.payload[++this.offset - 1] = 0;
		this.putVarInt(var2);
		this.offset += class177.method3481(this.payload, this.offset, var1);
	}

	public void putShortLength(int var1) {
		this.payload[this.offset - var1 - 2] = (byte) (var1 >> 8);
		this.payload[this.offset - var1 - 1] = (byte) var1;
	}

	public void method3307(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
		this.payload[++this.offset - 1] = (byte) (var1 >> 16);
		this.payload[++this.offset - 1] = (byte) var1;
	}

	public boolean checkCrc() {
		this.offset -= 4;
		int var1 = class14.method89(this.payload, 0, this.offset);
		int var2 = this.readInt();
		return var1 == var2;
	}

	public void putLengthInt(int var1) {
		this.payload[this.offset - var1 - 4] = (byte) (var1 >> 24);
		this.payload[this.offset - var1 - 3] = (byte) (var1 >> 16);
		this.payload[this.offset - var1 - 2] = (byte) (var1 >> 8);
		this.payload[this.offset - var1 - 1] = (byte) var1;
	}

	public void method3224(long var1) {
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 40));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 32));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 24));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 16));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 8));
		this.payload[++this.offset - 1] = (byte) ((int) var1);
	}

	public byte method3267() {
		return (byte) (0 - this.payload[++this.offset - 1]);
	}

	public void encryptXtea2(int[] var1) {
		int var2 = this.offset / 8;
		this.offset = 0;

		for (int var3 = 0; var3 < var2; ++var3) {
			int var4 = this.readInt();
			int var5 = this.readInt();
			int var6 = 0;
			int var7 = -1640531527;

			for (int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6) {
				var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3];
				var6 += var7;
			}

			this.offset -= 8;
			this.putInt(var4);
			this.putInt(var5);
		}

	}

	public void method3291(byte[] var1, int var2, int var3) {
		for (int var4 = var2; var4 < var3 + var2; ++var4) {
			var1[var4] = (byte) (this.payload[++this.offset - 1] - 128);
		}

	}

	public byte method3302() {
		return (byte) (this.payload[++this.offset - 1] - 128);
	}

	public void decryptXtea(int[] var1) {
		int var2 = this.offset / 8;
		this.offset = 0;

		for (int var3 = 0; var3 < var2; ++var3) {
			int var4 = this.readInt();
			int var5 = this.readInt();
			int var6 = -957401312;
			int var7 = -1640531527;

			for (int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3]) {
				var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6;
				var6 -= var7;
			}

			this.offset -= 8;
			this.putInt(var4);
			this.putInt(var5);
		}

	}

	public void encryptXtea(int[] var1, int var2, int var3) {
		int var4 = this.offset;
		this.offset = var2;
		int var5 = (var3 - var2) / 8;

		for (int var6 = 0; var6 < var5; ++var6) {
			int var7 = this.readInt();
			int var8 = this.readInt();
			int var9 = 0;
			int var10 = -1640531527;

			for (int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9) {
				var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3];
				var9 += var10;
			}

			this.offset -= 8;
			this.putInt(var7);
			this.putInt(var8);
		}

		this.offset = var4;
	}

	public void method3280(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 >> 16);
		this.payload[++this.offset - 1] = (byte) (var1 >> 24);
		this.payload[++this.offset - 1] = (byte) var1;
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
	}

	public void method3282(int var1) {
		this.payload[++this.offset - 1] = (byte) var1;
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
		this.payload[++this.offset - 1] = (byte) (var1 >> 16);
		this.payload[++this.offset - 1] = (byte) (var1 >> 24);
	}

	public void method3226(byte[] var1, int var2, int var3) {
		for (int var4 = var3 + var2 - 1; var4 >= var2; --var4) {
			var1[var4] = this.payload[++this.offset - 1];
		}

	}

	public void method3261(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 + 128);
	}

	public void putShortSmart(int var1) {
		if (var1 >= 0 && var1 < 128) {
			this.putByte(var1);
		} else if (var1 >= 0 && var1 < '耀') {
			this.putShort(var1 + '耀');
		} else {
			throw new IllegalArgumentException();
		}
	}

	public static VarPlayerType method3461(int var0) {
		VarPlayerType var1 = (VarPlayerType) VarPlayerType.varplayers.get((long) var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = VarPlayerType.varplayer_ref.getConfigData(16, var0);
			var1 = new VarPlayerType();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			VarPlayerType.varplayers.put(var1, (long) var0);
			return var1;
		}
	}

	byte runeliteReadByte() {
		++this.offset;
		return this.payload[this.offset - 1];
	}

	short runeliteReadShort() {
		this.offset += 2;
		return (short) ((this.payload[this.offset - 2] & 255) << 8 | this.payload[this.offset - 1] & 255);
	}

	int runeliteReadInt() {
		this.offset += 4;
		return (this.payload[this.offset - 4] & 255) << 24 | (this.payload[this.offset - 3] & 255) << 16
				| (this.payload[this.offset - 2] & 255) << 8 | this.payload[this.offset - 1] & 255;
	}

	long runeliteReadLong() {
		this.offset += 8;
		return ((long) this.payload[this.offset - 8] & 255L) << 56 | ((long) this.payload[this.offset - 7] & 255L) << 48
				| ((long) this.payload[this.offset - 6] & 255L) << 40
				| ((long) this.payload[this.offset - 5] & 255L) << 32
				| ((long) this.payload[this.offset - 4] & 255L) << 24
				| ((long) this.payload[this.offset - 3] & 255L) << 16
				| ((long) this.payload[this.offset - 2] & 255L) << 8 | (long) this.payload[this.offset - 1] & 255L;
	}

	String runeliteReadString() {
		short var1 = this.runeliteReadShort();
		if (var1 < 0) {
			throw new RuntimeException("length < 0");
		} else {
			this.offset += var1;

			try {
				return new String(this.payload, this.offset - var1, var1, "UTF-8");
			} catch (UnsupportedEncodingException var3) {
				throw new RuntimeException(var3);
			}
		}
	}

	void runeliteWriteByte(byte var1) {
		this.payload[this.offset++] = var1;
	}

	void runeliteWriteShort(short var1) {
		this.payload[this.offset++] = (byte) (var1 >> 8);
		this.payload[this.offset++] = (byte) var1;
	}

	void runeliteWriteInt(int var1) {
		this.payload[this.offset++] = (byte) (var1 >> 24);
		this.payload[this.offset++] = (byte) (var1 >> 16);
		this.payload[this.offset++] = (byte) (var1 >> 8);
		this.payload[this.offset++] = (byte) var1;
	}

	void runeliteWriteLong(long var1) {
		this.payload[this.offset++] = (byte) ((int) (var1 >> 56));
		this.payload[this.offset++] = (byte) ((int) (var1 >> 48));
		this.payload[this.offset++] = (byte) ((int) (var1 >> 40));
		this.payload[this.offset++] = (byte) ((int) (var1 >> 32));
		this.payload[this.offset++] = (byte) ((int) (var1 >> 24));
		this.payload[this.offset++] = (byte) ((int) (var1 >> 16));
		this.payload[this.offset++] = (byte) ((int) (var1 >> 8));
		this.payload[this.offset++] = (byte) ((int) var1);
	}

	void runeliteWriteString(String var1) {
		byte[] var2;
		try {
			var2 = var1.getBytes("UTF-8");
		} catch (UnsupportedEncodingException var7) {
			throw new RuntimeException(var7);
		}

		this.runeliteWriteShort((short) var2.length);
		byte[] var3 = var2;
		int var4 = var2.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			byte var6 = var3[var5];
			this.payload[this.offset++] = var6;
		}

	}
}
