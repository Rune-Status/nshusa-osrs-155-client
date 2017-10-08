public class Sequence extends CacheableNode {

	public static NodeCache skeletons;

	public static NodeCache sequences;

	public static IndexDataBase skel_ref;

	public static IndexDataBase skin_ref;

	public static IndexDataBase seq_ref;

	public int precedenceAnimating;

	public int[] frameIDs;

	int[] interleaveLeave;

	public int priority;

	public int frameStep;

	public int[] frameLenghts;

	public boolean stretches;

	public int leftHandItem;

	public int forcedPriority;

	public int rightHandItem;

	int[] field3609;

	public int maxLoops;

	public int replyMode;

	public int[] field3613;

	static {
		sequences = new NodeCache(64);
		skeletons = new NodeCache(100);
	}

	Sequence() {
		this.frameStep = -1;
		this.stretches = false;
		this.forcedPriority = 5;
		this.leftHandItem = -1;
		this.rightHandItem = -1;
		this.maxLoops = 99;
		this.precedenceAnimating = -1;
		this.priority = -1;
		this.replyMode = 2;
	}

	void method4781(Buffer var1, int var2) {
		int var3;
		int var4;
		if (var2 == 1) {
			var3 = var1.readUnsignedShort();
			this.frameLenghts = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.frameLenghts[var4] = var1.readUnsignedShort();
			}

			this.frameIDs = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.frameIDs[var4] = var1.readUnsignedShort();
			}

			for (var4 = 0; var4 < var3; ++var4) {
				this.frameIDs[var4] += var1.readUnsignedShort() << 16;
			}
		} else if (var2 == 2) {
			this.frameStep = var1.readUnsignedShort();
		} else if (var2 == 3) {
			var3 = var1.readUnsignedByte();
			this.interleaveLeave = new int[var3 + 1];

			for (var4 = 0; var4 < var3; ++var4) {
				this.interleaveLeave[var4] = var1.readUnsignedByte();
			}

			this.interleaveLeave[var3] = 9999999;
		} else if (var2 == 4) {
			this.stretches = true;
		} else if (var2 == 5) {
			this.forcedPriority = var1.readUnsignedByte();
		} else if (var2 == 6) {
			this.leftHandItem = var1.readUnsignedShort();
		} else if (var2 == 7) {
			this.rightHandItem = var1.readUnsignedShort();
		} else if (var2 == 8) {
			this.maxLoops = var1.readUnsignedByte();
		} else if (var2 == 9) {
			this.precedenceAnimating = var1.readUnsignedByte();
		} else if (var2 == 10) {
			this.priority = var1.readUnsignedByte();
		} else if (var2 == 11) {
			this.replyMode = var1.readUnsignedByte();
		} else if (var2 == 12) {
			var3 = var1.readUnsignedByte();
			this.field3609 = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3609[var4] = var1.readUnsignedShort();
			}

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3609[var4] += var1.readUnsignedShort() << 16;
			}
		} else if (var2 == 13) {
			var3 = var1.readUnsignedByte();
			this.field3613 = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3613[var4] = var1.read24BitInt();
			}
		}

	}

	public Model method4799(Model var1, int var2) {
		var2 = this.frameIDs[var2];
		Frames var3 = GraphicsObject.getFrames(var2 >> 16);
		var2 &= '\uffff';
		if (var3 == null) {
			return var1.method2641(true);
		} else {
			Model var4 = var1.method2641(!var3.method2941(var2));
			var4.method2639(var3, var2);
			return var4;
		}
	}

	public Model method4779(Model var1, int var2, Sequence var3, int var4) {
		var2 = this.frameIDs[var2];
		Frames var5 = GraphicsObject.getFrames(var2 >> 16);
		var2 &= '\uffff';
		if (var5 == null) {
			return var3.method4799(var1, var4);
		} else {
			var4 = var3.frameIDs[var4];
			Frames var6 = GraphicsObject.getFrames(var4 >> 16);
			var4 &= '\uffff';
			Model var7;
			if (var6 == null) {
				var7 = var1.method2641(!var5.method2941(var2));
				var7.method2639(var5, var2);
				return var7;
			} else {
				var7 = var1.method2641(!var5.method2941(var2) & !var6.method2941(var4));
				var7.method2647(var5, var2, var6, var4, this.interleaveLeave);
				return var7;
			}
		}
	}

	Model method4811(Model var1, int var2, int var3) {
		var2 = this.frameIDs[var2];
		Frames var4 = GraphicsObject.getFrames(var2 >> 16);
		var2 &= '\uffff';
		if (var4 == null) {
			return var1.method2641(true);
		} else {
			Model var5 = var1.method2641(!var4.method2941(var2));
			var3 &= 3;
			if (var3 == 1) {
				var5.method2603();
			} else if (var3 == 2) {
				var5.method2602();
			} else if (var3 == 3) {
				var5.method2656();
			}

			var5.method2639(var4, var2);
			if (var3 == 1) {
				var5.method2656();
			} else if (var3 == 2) {
				var5.method2602();
			} else if (var3 == 3) {
				var5.method2603();
			}

			return var5;
		}
	}

	Model method4785(Model var1, int var2) {
		var2 = this.frameIDs[var2];
		Frames var3 = GraphicsObject.getFrames(var2 >> 16);
		var2 &= '\uffff';
		if (var3 == null) {
			return var1.method2591(true);
		} else {
			Model var4 = var1.method2591(!var3.method2941(var2));
			var4.method2639(var3, var2);
			return var4;
		}
	}

	public Model method4802(Model var1, int var2) {
		int var3 = this.frameIDs[var2];
		Frames var4 = GraphicsObject.getFrames(var3 >> 16);
		var3 &= '\uffff';
		if (var4 == null) {
			return var1.method2641(true);
		} else {
			Frames var5 = null;
			int var6 = 0;
			if (this.field3609 != null && var2 < this.field3609.length) {
				var6 = this.field3609[var2];
				var5 = GraphicsObject.getFrames(var6 >> 16);
				var6 &= '\uffff';
			}

			Model var7;
			if (var5 != null && var6 != '\uffff') {
				var7 = var1.method2641(!var4.method2941(var3) & !var5.method2941(var6));
				var7.method2639(var4, var3);
				var7.method2639(var5, var6);
				return var7;
			} else {
				var7 = var1.method2641(!var4.method2941(var3));
				var7.method2639(var4, var3);
				return var7;
			}
		}
	}

	void post() {
		if (this.precedenceAnimating == -1) {
			if (this.interleaveLeave != null) {
				this.precedenceAnimating = 2;
			} else {
				this.precedenceAnimating = 0;
			}
		}

		if (this.priority == -1) {
			if (this.interleaveLeave != null) {
				this.priority = 2;
			} else {
				this.priority = 0;
			}
		}

	}

	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method4781(var1, var2);
		}
	}

	public static int method4782(CharSequence var0, int var1) {
		return class41.parseInt(var0, var1, true);
	}

	public static boolean method4813(char var0) {
		return var0 >= 32 && var0 <= 126 ? true
				: (var0 >= 160 && var0 <= 255 ? true
						: var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
	}
}
