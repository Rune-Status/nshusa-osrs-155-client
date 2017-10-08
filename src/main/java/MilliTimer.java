import net.runelite.rs.Opcodes;

public class MilliTimer extends Timer {

	int field2221;

	long[] field2218;

	int sleepTime;

	int field2220;

	long milliTime;

	int field2216;

	MilliTimer() {
		this.field2218 = new long[10];
		this.field2221 = 256;
		this.sleepTime = 1;
		this.field2220 = 0;
		this.milliTime = class147.currentTimeMs();

		for (int var1 = 0; var1 < 10; ++var1) {
			this.field2218[var1] = this.milliTime;
		}

	}

	public int vmethod3061(int var1, int var2) {
		int var3 = this.field2221;
		int var4 = this.sleepTime;
		this.field2221 = 300;
		this.sleepTime = 1;
		this.milliTime = class147.currentTimeMs();
		if (this.field2218[this.field2216] == 0L) {
			this.field2221 = var3;
			this.sleepTime = var4;
		} else if (this.milliTime > this.field2218[this.field2216]) {
			this.field2221 = (int) ((long) (var1 * 2560) / (this.milliTime - this.field2218[this.field2216]));
		}

		if (this.field2221 < 25) {
			this.field2221 = 25;
		}

		if (this.field2221 > 256) {
			this.field2221 = 256;
			this.sleepTime = (int) ((long) var1 - (this.milliTime - this.field2218[this.field2216]) / 10L);
		}

		if (this.sleepTime > var1) {
			this.sleepTime = var1;
		}

		this.field2218[this.field2216] = this.milliTime;
		this.field2216 = (this.field2216 + 1) % 10;
		int var5;
		if (this.sleepTime > 1) {
			for (var5 = 0; var5 < 10; ++var5) {
				if (0L != this.field2218[var5]) {
					this.field2218[var5] += (long) this.sleepTime;
				}
			}
		}

		if (this.sleepTime < var2) {
			this.sleepTime = var2;
		}

		class211.method4044((long) this.sleepTime);

		for (var5 = 0; this.field2220 < 256; this.field2220 += this.field2221) {
			++var5;
		}

		this.field2220 &= 255;
		return var5;
	}

	public void vmethod3058() {
		for (int var1 = 0; var1 < 10; ++var1) {
			this.field2218[var1] = 0L;
		}

	}

	static final void method3014(int var0, int var1, int var2, int var3) {
		for (int var4 = 0; var4 < Client.field1116; ++var4) {
			if (Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0
					&& Client.widgetPositionX[var4] < var0 + var2
					&& Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1
					&& Client.widgetPositionY[var4] < var3 + var1) {
				Client.field1118[var4] = true;
			}
		}

	}

	static final void method3013(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
		int var6 = var3 * var3 + var2 * var2;
		if (var6 > 4225 && var6 < 90000) {
			int var7 = Client.mapAngle & 2047;
			int var8 = Graphics3D.SINE[var7];
			int var9 = Graphics3D.COSINE[var7];
			int var10 = var9 * var2 + var3 * var8 >> 16;
			int var11 = var3 * var9 - var8 * var2 >> 16;
			double var12 = Math.atan2((double) var10, (double) var11);
			int var14 = var5.field2615 / 2 - 25;
			int var15 = (int) (Math.sin(var12) * (double) var14);
			int var16 = (int) (Math.cos(var12) * (double) var14);
			byte var17 = 20;
			class15.mapedge.method5187(var0 + var5.field2615 / 2 - var17 / 2 + var15,
					var5.field2611 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
		} else {
			class43.drawDot(var0, var1, var2, var3, var4, var5);
		}

	}

	static final void method3012(String var0) {
		if (WorldMapType1.clanMembers != null) {
			Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_216);
			Client.secretPacketBuffer1.putByte(class162.getLength(var0));
			Client.secretPacketBuffer1.putString(var0);
		}
	}

	static int method3004(World var0, World var1, int var2, boolean var3) {
		if (var2 == 1) {
			int var4 = var0.playerCount;
			int var5 = var1.playerCount;
			if (!var3) {
				if (var4 == -1) {
					var4 = 2001;
				}

				if (var5 == -1) {
					var5 = 2001;
				}
			}

			return var4 - var5;
		} else {
			return var2 == 2 ? var0.location - var1.location
					: (var2 == 3
							? (var0.activity.equals("-") ? (var1.activity.equals("-") ? 0 : (var3 ? -1 : 1))
									: (var1.activity.equals("-") ? (var3 ? 1 : -1)
											: var0.activity.compareTo(var1.activity)))
							: (var2 == 4
									? (var0.method1631() ? (var1.method1631() ? 0 : 1) : (var1.method1631() ? -1 : 0))
									: (var2 == 5
											? (var0.method1614() ? (var1.method1614() ? 0 : 1)
													: (var1.method1614() ? -1 : 0))
											: (var2 == 6
													? (var0.method1615() ? (var1.method1615() ? 0 : 1)
															: (var1.method1615() ? -1 : 0))
													: (var2 == 7
															? (var0.method1638() ? (var1.method1638() ? 0 : 1)
																	: (var1.method1638() ? -1 : 0))
															: var0.id - var1.id)))));
		}
	}
}
