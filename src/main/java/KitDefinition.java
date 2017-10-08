public class KitDefinition extends CacheableNode {

	public static int field3350;

	public static NodeCache identKits;

	public static IndexDataBase field3349;

	public static IndexDataBase identKit_ref;

	int[] modelIds;

	int[] models;

	public int bodyPartId;

	public boolean nonSelectable;

	short[] recolorToFind;

	short[] retextureToFind;

	short[] recolorToReplace;

	short[] retextureToReplace;

	static {
		identKits = new NodeCache(64);
	}

	KitDefinition() {
		this.bodyPartId = -1;
		this.models = new int[] { -1, -1, -1, -1, -1 };
		this.nonSelectable = false;
	}

	void method4459(Buffer var1, int var2) {
		if (var2 == 1) {
			this.bodyPartId = var1.readUnsignedByte();
		} else {
			int var3;
			int var4;
			if (var2 == 2) {
				var3 = var1.readUnsignedByte();
				this.modelIds = new int[var3];

				for (var4 = 0; var4 < var3; ++var4) {
					this.modelIds[var4] = var1.readUnsignedShort();
				}
			} else if (var2 == 3) {
				this.nonSelectable = true;
			} else if (var2 == 40) {
				var3 = var1.readUnsignedByte();
				this.recolorToFind = new short[var3];
				this.recolorToReplace = new short[var3];

				for (var4 = 0; var4 < var3; ++var4) {
					this.recolorToFind[var4] = (short) var1.readUnsignedShort();
					this.recolorToReplace[var4] = (short) var1.readUnsignedShort();
				}
			} else if (var2 == 41) {
				var3 = var1.readUnsignedByte();
				this.retextureToFind = new short[var3];
				this.retextureToReplace = new short[var3];

				for (var4 = 0; var4 < var3; ++var4) {
					this.retextureToFind[var4] = (short) var1.readUnsignedShort();
					this.retextureToReplace[var4] = (short) var1.readUnsignedShort();
				}
			} else if (var2 >= 60 && var2 < 70) {
				this.models[var2 - 60] = var1.readUnsignedShort();
			}
		}

	}

	public boolean method4462() {
		boolean var1 = true;

		for (int var2 = 0; var2 < 5; ++var2) {
			if (this.models[var2] != -1 && !field3349.method4237(this.models[var2], 0)) {
				var1 = false;
			}
		}

		return var1;
	}

	public ModelData method4476() {
		ModelData[] var1 = new ModelData[5];
		int var2 = 0;

		for (int var3 = 0; var3 < 5; ++var3) {
			if (this.models[var3] != -1) {
				var1[var2++] = ModelData.method2498(field3349, this.models[var3], 0);
			}
		}

		ModelData var5 = new ModelData(var1, var2);
		int var4;
		if (this.recolorToFind != null) {
			for (var4 = 0; var4 < this.recolorToFind.length; ++var4) {
				var5.recolor(this.recolorToFind[var4], this.recolorToReplace[var4]);
			}
		}

		if (this.retextureToFind != null) {
			for (var4 = 0; var4 < this.retextureToFind.length; ++var4) {
				var5.method2513(this.retextureToFind[var4], this.retextureToReplace[var4]);
			}
		}

		return var5;
	}

	public boolean ready() {
		if (this.modelIds == null) {
			return true;
		} else {
			boolean var1 = true;

			for (int var2 = 0; var2 < this.modelIds.length; ++var2) {
				if (!field3349.method4237(this.modelIds[var2], 0)) {
					var1 = false;
				}
			}

			return var1;
		}
	}

	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method4459(var1, var2);
		}
	}

	public ModelData getModelData() {
		if (this.modelIds == null) {
			return null;
		} else {
			ModelData[] var1 = new ModelData[this.modelIds.length];

			for (int var2 = 0; var2 < this.modelIds.length; ++var2) {
				var1[var2] = ModelData.method2498(field3349, this.modelIds[var2], 0);
			}

			ModelData var4;
			if (var1.length == 1) {
				var4 = var1[0];
			} else {
				var4 = new ModelData(var1, var1.length);
			}

			int var3;
			if (this.recolorToFind != null) {
				for (var3 = 0; var3 < this.recolorToFind.length; ++var3) {
					var4.recolor(this.recolorToFind[var3], this.recolorToReplace[var3]);
				}
			}

			if (this.retextureToFind != null) {
				for (var3 = 0; var3 < this.retextureToFind.length; ++var3) {
					var4.method2513(this.retextureToFind[var3], this.retextureToReplace[var3]);
				}
			}

			return var4;
		}
	}

	public static boolean method4485(char var0) {
		if ((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
			if (var0 != 0) {
				char[] var1 = class266.field3665;

				for (int var2 = 0; var2 < var1.length; ++var2) {
					char var3 = var1[var2];
					if (var0 == var3) {
						return true;
					}
				}
			}

			return false;
		} else {
			return true;
		}
	}
}
