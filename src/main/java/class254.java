public class class254 extends CacheableNode {

	static NodeCache field3410;

	static NodeCache field3431;

	static NodeCache field3413;

	public static IndexDataBase field3420;

	public static IndexDataBase field3411;

	public static IndexDataBase field3412;

	String field3415;

	int field3434;

	int field3423;

	int field3424;

	int field3426;

	int field3425;

	int field3427;

	int field3418;

	public int field3435;

	public int field3430;

	public int field3422;

	public int[] field3433;

	public int field3436;

	public int field3429;

	public int field3428;

	public int field3432;

	static {
		field3410 = new NodeCache(64);
		field3413 = new NodeCache(64);
		field3431 = new NodeCache(20);
	}

	class254() {
		this.field3427 = -1;
		this.field3430 = 16777215;
		this.field3422 = 70;
		this.field3423 = -1;
		this.field3424 = -1;
		this.field3425 = -1;
		this.field3426 = -1;
		this.field3436 = 0;
		this.field3428 = 0;
		this.field3429 = -1;
		this.field3415 = "";
		this.field3435 = -1;
		this.field3432 = 0;
		this.field3434 = -1;
		this.field3418 = -1;
	}

	void method4577(Buffer var1, int var2) {
		if (var2 == 1) {
			this.field3427 = var1.method3252();
		} else if (var2 == 2) {
			this.field3430 = var1.read24BitInt();
		} else if (var2 == 3) {
			this.field3423 = var1.method3252();
		} else if (var2 == 4) {
			this.field3425 = var1.method3252();
		} else if (var2 == 5) {
			this.field3424 = var1.method3252();
		} else if (var2 == 6) {
			this.field3426 = var1.method3252();
		} else if (var2 == 7) {
			this.field3436 = var1.readShort();
		} else if (var2 == 8) {
			this.field3415 = var1.getJagString();
		} else if (var2 == 9) {
			this.field3422 = var1.readUnsignedShort();
		} else if (var2 == 10) {
			this.field3428 = var1.readShort();
		} else if (var2 == 11) {
			this.field3429 = 0;
		} else if (var2 == 12) {
			this.field3435 = var1.readUnsignedByte();
		} else if (var2 == 13) {
			this.field3432 = var1.readShort();
		} else if (var2 == 14) {
			this.field3429 = var1.readUnsignedShort();
		} else if (var2 == 17 || var2 == 18) {
			this.field3434 = var1.readUnsignedShort();
			if (this.field3434 == '\uffff') {
				this.field3434 = -1;
			}

			this.field3418 = var1.readUnsignedShort();
			if (this.field3418 == '\uffff') {
				this.field3418 = -1;
			}

			int var3 = -1;
			if (var2 == 18) {
				var3 = var1.readUnsignedShort();
				if (var3 == '\uffff') {
					var3 = -1;
				}
			}

			int var4 = var1.readUnsignedByte();
			this.field3433 = new int[var4 + 2];

			for (int var5 = 0; var5 <= var4; ++var5) {
				this.field3433[var5] = var1.readUnsignedShort();
				if (this.field3433[var5] == '\uffff') {
					this.field3433[var5] = -1;
				}
			}

			this.field3433[var4 + 1] = var3;
		}

	}

	void method4598(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method4577(var1, var2);
		}
	}

	public final class254 method4601() {
		int var1 = -1;
		if (this.field3434 != -1) {
			var1 = class88.method1777(this.field3434);
		} else if (this.field3418 != -1) {
			var1 = class211.widgetSettings[this.field3418];
		}

		int var2;
		if (var1 >= 0 && var1 < this.field3433.length - 1) {
			var2 = this.field3433[var1];
		} else {
			var2 = this.field3433[this.field3433.length - 1];
		}

		return var2 != -1 ? class93.method1843(var2) : null;
	}

	public SpritePixels method4580() {
		if (this.field3423 < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels) field3413.get((long) this.field3423);
			if (var1 != null) {
				return var1;
			} else {
				var1 = AbstractSoundSystem.method2136(field3411, this.field3423, 0);
				if (var1 != null) {
					field3413.put(var1, (long) this.field3423);
				}

				return var1;
			}
		}
	}

	public SpritePixels method4581() {
		if (this.field3424 < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels) field3413.get((long) this.field3424);
			if (var1 != null) {
				return var1;
			} else {
				var1 = AbstractSoundSystem.method2136(field3411, this.field3424, 0);
				if (var1 != null) {
					field3413.put(var1, (long) this.field3424);
				}

				return var1;
			}
		}
	}

	public SpritePixels method4604() {
		if (this.field3425 < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels) field3413.get((long) this.field3425);
			if (var1 != null) {
				return var1;
			} else {
				var1 = AbstractSoundSystem.method2136(field3411, this.field3425, 0);
				if (var1 != null) {
					field3413.put(var1, (long) this.field3425);
				}

				return var1;
			}
		}
	}

	public SpritePixels method4583() {
		if (this.field3426 < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels) field3413.get((long) this.field3426);
			if (var1 != null) {
				return var1;
			} else {
				var1 = AbstractSoundSystem.method2136(field3411, this.field3426, 0);
				if (var1 != null) {
					field3413.put(var1, (long) this.field3426);
				}

				return var1;
			}
		}
	}

	public Font method4584() {
		if (this.field3427 == -1) {
			return null;
		} else {
			Font var1 = (Font) field3431.get((long) this.field3427);
			if (var1 != null) {
				return var1;
			} else {
				IndexDataBase var3 = field3411;
				IndexDataBase var4 = field3412;
				int var5 = this.field3427;
				Font var2;
				if (!class249.method4517(var3, var5, 0)) {
					var2 = null;
				} else {
					byte[] var7 = var4.getConfigData(var5, 0);
					Font var6;
					if (var7 == null) {
						var6 = null;
					} else {
						Font var8 = new Font(var7, class287.field3807, World.offsetsY, class236.field3238,
								FileSystem.field3207, class181.field2456, class208.spritePixels);
						Actor.method1605();
						var6 = var8;
					}

					var2 = var6;
				}

				if (var2 != null) {
					field3431.put(var2, (long) this.field3427);
				}

				return var2;
			}
		}
	}

	public String method4605(int var1) {
		String var2 = this.field3415;

		while (true) {
			int var3 = var2.indexOf("%1");
			if (var3 < 0) {
				return var2;
			}

			String var4 = var2.substring(0, var3);
			String var5 = Integer.toString(var1);
			var2 = var4 + var5 + var2.substring(var3 + 2);
		}
	}

	static final void method4607(Actor var0) {
		var0.field1210 = false;
		Sequence var1;
		if (var0.poseAnimation != -1) {
			var1 = class204.getAnimation(var0.poseAnimation);
			if (var1 != null && var1.frameIDs != null) {
				++var0.field1238;
				if (var0.poseFrame < var1.frameIDs.length && var0.field1238 > var1.frameLenghts[var0.poseFrame]) {
					var0.field1238 = 1;
					++var0.poseFrame;
					class205.method3929(var1, var0.poseFrame, var0.x, var0.y);
				}

				if (var0.poseFrame >= var1.frameIDs.length) {
					var0.field1238 = 0;
					var0.poseFrame = 0;
					class205.method3929(var1, var0.poseFrame, var0.x, var0.y);
				}
			} else {
				var0.poseAnimation = -1;
			}
		}

		if (var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
			if (var0.field1249 < 0) {
				var0.field1249 = 0;
			}

			int var3 = class155.getSpotAnimType(var0.graphic).field3326;
			if (var3 != -1) {
				Sequence var2 = class204.getAnimation(var3);
				if (var2 != null && var2.frameIDs != null) {
					++var0.field1246;
					if (var0.field1249 < var2.frameIDs.length && var0.field1246 > var2.frameLenghts[var0.field1249]) {
						var0.field1246 = 1;
						++var0.field1249;
						class205.method3929(var2, var0.field1249, var0.x, var0.y);
					}

					if (var0.field1249 >= var2.frameIDs.length
							&& (var0.field1249 < 0 || var0.field1249 >= var2.frameIDs.length)) {
						var0.graphic = -1;
					}
				} else {
					var0.graphic = -1;
				}
			} else {
				var0.graphic = -1;
			}
		}

		if (var0.animation != -1 && var0.actionAnimationDisable <= 1) {
			var1 = class204.getAnimation(var0.animation);
			if (var1.precedenceAnimating == 1 && var0.field1241 > 0 && var0.field1255 <= Client.gameCycle
					&& var0.field1254 < Client.gameCycle) {
				var0.actionAnimationDisable = 1;
				return;
			}
		}

		if (var0.animation != -1 && var0.actionAnimationDisable == 0) {
			var1 = class204.getAnimation(var0.animation);
			if (var1 != null && var1.frameIDs != null) {
				++var0.field1207;
				if (var0.actionFrame < var1.frameIDs.length && var0.field1207 > var1.frameLenghts[var0.actionFrame]) {
					var0.field1207 = 1;
					++var0.actionFrame;
					class205.method3929(var1, var0.actionFrame, var0.x, var0.y);
				}

				if (var0.actionFrame >= var1.frameIDs.length) {
					var0.actionFrame -= var1.frameStep;
					++var0.field1243;
					if (var0.field1243 >= var1.maxLoops) {
						var0.animation = -1;
					} else if (var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
						class205.method3929(var1, var0.actionFrame, var0.x, var0.y);
					} else {
						var0.animation = -1;
					}
				}

				var0.field1210 = var1.stretches;
			} else {
				var0.animation = -1;
			}
		}

		if (var0.actionAnimationDisable > 0) {
			--var0.actionAnimationDisable;
		}

	}
}
