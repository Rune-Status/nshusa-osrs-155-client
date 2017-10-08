import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;

public abstract class class28 {

	static int menuHeight;

	static SpritePixels[] pkIcons;

	static int field427;

	int field416;

	int field417;

	short[][][] field420;

	int field419;

	short[][][] field421;

	class31[][][][] field424;

	int field425;

	byte[][][] field422;

	int field418;

	int field426;

	byte[][][] field423;

	class28() {
		new LinkedList();
	}

	int method212(int var1, int var2) {
		return var1 >= 0 && var2 >= 0 ? (var1 < 64 && var2 < 64 ? this.field420[0][var1][var2] - 1 : -1) : -1;
	}

	void method213(int var1, int var2, Buffer var3, int var4) {
		boolean var5 = (var4 & 2) != 0;
		if (var5) {
			this.field421[0][var1][var2] = (short) var3.readUnsignedByte();
		}

		this.field420[0][var1][var2] = (short) var3.readUnsignedByte();
	}

	void method223(int var1, int var2, Buffer var3, int var4) {
		int var5 = ((var4 & 24) >> 3) + 1;
		boolean var6 = (var4 & 2) != 0;
		boolean var7 = (var4 & 4) != 0;
		this.field420[0][var1][var2] = (short) var3.readUnsignedByte();
		int var8;
		int var9;
		int var11;
		if (var6) {
			var8 = var3.readUnsignedByte();

			for (var9 = 0; var9 < var8; ++var9) {
				int var10 = var3.readUnsignedByte();
				if (var10 != 0) {
					this.field421[var9][var1][var2] = (short) var10;
					var11 = var3.readUnsignedByte();
					this.field422[var9][var1][var2] = (byte) (var11 >> 2);
					this.field423[var9][var1][var2] = (byte) (var11 & 3);
				}
			}
		}

		if (var7) {
			for (var8 = 0; var8 < var5; ++var8) {
				var9 = var3.readUnsignedByte();
				if (var9 != 0) {
					class31[] var14 = this.field424[var8][var1][var2] = new class31[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						int var12 = var3.method3252();
						int var13 = var3.readUnsignedByte();
						var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
					}
				}
			}
		}

	}

	int method215() {
		return this.field416;
	}

	int method216() {
		return this.field417;
	}

	void method228(int var1, int var2, Buffer var3) {
		int var4 = var3.readUnsignedByte();
		if (var4 != 0) {
			if ((var4 & 1) != 0) {
				this.method213(var1, var2, var3, var4);
			} else {
				this.method223(var1, var2, var3, var4);
			}

		}
	}

	static final void method234() {
		if (class40.soundSystem1 != null) {
			class40.soundSystem1.method2084();
		}

		if (class1.soundSystem0 != null) {
			class1.soundSystem0.method2084();
		}

	}

	static long method233() {
		try {
			URL var0 = new URL(class44.method637("services", false) + "m=accountappeal/login.ws");
			URLConnection var1 = var0.openConnection();
			var1.setRequestProperty("connection", "close");
			var1.setDoInput(true);
			var1.setDoOutput(true);
			var1.setConnectTimeout(5000);
			OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
			var2.write("data1=req");
			var2.flush();
			InputStream var3 = var1.getInputStream();
			Buffer var4 = new Buffer(new byte[1000]);

			do {
				int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
				if (var5 == -1) {
					var4.offset = 0;
					long var7 = var4.readLong();
					return var7;
				}

				var4.offset += var5;
			} while (var4.offset < 1000);

			return 0L;
		} catch (Exception var9) {
			return 0L;
		}
	}

	static void method219(int var0, Coordinates var1, boolean var2) {
		WorldMapData var3 = Friend.method1134().method5419(var0);
		int var4 = AbstractByteBuffer.localPlayer.field894;
		int var5 = (AbstractByteBuffer.localPlayer.x >> 7) + WallObject.baseX;
		int var6 = (AbstractByteBuffer.localPlayer.y >> 7) + Varcs.baseY;
		Coordinates var7 = new Coordinates(var4, var5, var6);
		Friend.method1134().method5434(var3, var7, var1, var2);
	}
}
