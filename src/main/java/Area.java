public class Area extends CacheableNode {

	static NodeCache skeletonsIndex;

	static IndexDataBase field3291;

	static int field3297;

	public int spriteId;

	int[] field3300;

	public final int field3292;

	public String name;

	public class257 field3289;

	int field3301;

	public int field3296;

	int field3290;

	public int field3298;

	public class239 field3305;

	public String[] field3294;

	int field3303;

	public int field3309;

	int field3302;

	public String field3299;

	int field3304;

	int[] field3307;

	byte[] field3308;

	static {
		skeletonsIndex = new NodeCache(256);
	}

	Area(int var1) {
		this.spriteId = -1;
		this.field3301 = -1;
		this.field3298 = 0;
		this.field3294 = new String[5];
		this.field3290 = Integer.MAX_VALUE;
		this.field3302 = Integer.MAX_VALUE;
		this.field3303 = Integer.MIN_VALUE;
		this.field3304 = Integer.MIN_VALUE;
		this.field3289 = class257.field3544;
		this.field3305 = class239.field3277;
		this.field3309 = -1;
		this.field3292 = var1;
	}

	public SpritePixels method4395(boolean var1) {
		int var2 = this.spriteId;
		return this.method4396(var2);
	}

	SpritePixels method4396(int var1) {
		if (var1 < 0) {
			return null;
		} else {
			SpritePixels var2 = (SpritePixels) skeletonsIndex.get((long) var1);
			if (var2 != null) {
				return var2;
			} else {
				var2 = AbstractSoundSystem.method2136(field3291, var1, 0);
				if (var2 != null) {
					skeletonsIndex.put(var2, (long) var1);
				}

				return var2;
			}
		}
	}

	void method4393(Buffer var1, int var2) {
		if (var2 == 1) {
			this.spriteId = var1.method3252();
		} else if (var2 == 2) {
			this.field3301 = var1.method3252();
		} else if (var2 == 3) {
			this.name = var1.readString();
		} else if (var2 == 4) {
			this.field3296 = var1.read24BitInt();
		} else if (var2 == 5) {
			var1.read24BitInt();
		} else if (var2 == 6) {
			this.field3298 = var1.readUnsignedByte();
		} else {
			int var3;
			if (var2 == 7) {
				var3 = var1.readUnsignedByte();
				if ((var3 & 1) == 0) {
					;
				}

				if ((var3 & 2) == 2) {
					;
				}
			} else if (var2 == 8) {
				var1.readUnsignedByte();
			} else if (var2 >= 10 && var2 <= 14) {
				this.field3294[var2 - 10] = var1.readString();
			} else if (var2 == 15) {
				var3 = var1.readUnsignedByte();
				this.field3300 = new int[var3 * 2];

				int var4;
				for (var4 = 0; var4 < var3 * 2; ++var4) {
					this.field3300[var4] = var1.readShort();
				}

				var1.readInt();
				var4 = var1.readUnsignedByte();
				this.field3307 = new int[var4];

				int var5;
				for (var5 = 0; var5 < this.field3307.length; ++var5) {
					this.field3307[var5] = var1.readInt();
				}

				this.field3308 = new byte[var3];

				for (var5 = 0; var5 < var3; ++var5) {
					this.field3308[var5] = var1.readByte();
				}
			} else if (var2 != 16) {
				if (var2 == 17) {
					this.field3299 = var1.readString();
				} else if (var2 == 18) {
					var1.method3252();
				} else if (var2 == 19) {
					this.field3309 = var1.readUnsignedShort();
				} else if (var2 == 21) {
					var1.readInt();
				} else if (var2 == 22) {
					var1.readInt();
				} else if (var2 == 23) {
					var1.readUnsignedByte();
					var1.readUnsignedByte();
					var1.readUnsignedByte();
				} else if (var2 == 24) {
					var1.readShort();
					var1.readShort();
				} else if (var2 == 25) {
					var1.method3252();
				} else if (var2 == 28) {
					var1.readUnsignedByte();
				} else if (var2 == 29) {
					class257[] var6 = new class257[] { class257.field3549, class257.field3544, class257.field3546 };
					this.field3289 = (class257) class48.forOrdinal(var6, var1.readUnsignedByte());
				} else if (var2 == 30) {
					this.field3305 = (class239) class48.forOrdinal(class182.method3547(), var1.readUnsignedByte());
				}
			}
		}

	}

	public int method4397() {
		return this.field3292;
	}

	void method4392(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method4393(var1, var2);
		}
	}

	void method4401() {
		if (this.field3300 != null) {
			for (int var1 = 0; var1 < this.field3300.length; var1 += 2) {
				if (this.field3300[var1] < this.field3290) {
					this.field3290 = this.field3300[var1];
				} else if (this.field3300[var1] > this.field3303) {
					this.field3303 = this.field3300[var1];
				}

				if (this.field3300[var1 + 1] < this.field3302) {
					this.field3302 = this.field3300[var1 + 1];
				} else if (this.field3300[var1 + 1] > this.field3304) {
					this.field3304 = this.field3300[var1 + 1];
				}
			}
		}

	}
}
