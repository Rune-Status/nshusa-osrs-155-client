public class ItemComposition extends CacheableNode {

	public static NodeCache items;

	public static NodeCache itemModelCache;

	public static NodeCache itemSpriteCache;

	public static Font field3488;

	int maleHeadModel;

	int maleModel;

	int inventoryModel;

	int[] countObj;

	int team;

	IterableHashTable field3494;

	int maleHeadModel2;

	int maleModel1;

	int maleModel2;

	public String[] inventoryActions;

	public String name;

	int femaleHeadModel;

	public int zoom2d;

	public int id;

	int femaleHeadModel2;

	int femaleModel;

	int[] countCo;

	int femaleModel1;

	int femaleModel2;

	public int xan2d;

	int resizeX;

	public int yan2d;

	public int isStackable;

	public int offsetX2d;

	int resizeY;

	public int offsetY2d;

	public int zan2d;

	public boolean isMembers;

	public int price;

	int resizeZ;

	short[] colourToReplace;

	int maleOffset;

	public int notedTemplate;

	public String[] groundActions;

	int femaleOffset;

	public boolean field3538;

	short[] textureToReplace;

	public int note;

	public int ambient;

	short[] colourToReplaceWith;

	int notedId;

	short[] textToReplaceWith;

	public int contrast;

	public int field3526;

	public int field3542;

	int unnotedId;

	public int field3541;

	static {
		items = new NodeCache(64);
		itemModelCache = new NodeCache(50);
		itemSpriteCache = new NodeCache(200);
	}

	ItemComposition() {
		this.name = "null";
		this.zoom2d = 2000;
		this.xan2d = 0;
		this.yan2d = 0;
		this.zan2d = 0;
		this.offsetX2d = 0;
		this.offsetY2d = 0;
		this.isStackable = 0;
		this.price = 1;
		this.isMembers = false;
		this.groundActions = new String[] { null, null, "Take", null, null };
		this.inventoryActions = new String[] { null, null, null, null, "Drop" };
		this.team = -2;
		this.maleModel = -1;
		this.maleModel1 = -1;
		this.maleOffset = 0;
		this.femaleModel = -1;
		this.femaleModel1 = -1;
		this.femaleOffset = 0;
		this.maleModel2 = -1;
		this.femaleModel2 = -1;
		this.maleHeadModel = -1;
		this.maleHeadModel2 = -1;
		this.femaleHeadModel = -1;
		this.femaleHeadModel2 = -1;
		this.note = -1;
		this.notedTemplate = -1;
		this.resizeX = 128;
		this.resizeY = 128;
		this.resizeZ = 128;
		this.ambient = 0;
		this.contrast = 0;
		this.field3526 = 0;
		this.field3538 = false;
		this.unnotedId = -1;
		this.notedId = -1;
		this.field3541 = -1;
		this.field3542 = -1;
	}

	void populateFromBuffer(Buffer var1, int var2) {
		if (var2 == 1) {
			this.inventoryModel = var1.readUnsignedShort();
		} else if (var2 == 2) {
			this.name = var1.readString();
		} else if (var2 == 4) {
			this.zoom2d = var1.readUnsignedShort();
		} else if (var2 == 5) {
			this.xan2d = var1.readUnsignedShort();
		} else if (var2 == 6) {
			this.yan2d = var1.readUnsignedShort();
		} else if (var2 == 7) {
			this.offsetX2d = var1.readUnsignedShort();
			if (this.offsetX2d > 32767) {
				this.offsetX2d -= 65536;
			}
		} else if (var2 == 8) {
			this.offsetY2d = var1.readUnsignedShort();
			if (this.offsetY2d > 32767) {
				this.offsetY2d -= 65536;
			}
		} else if (var2 == 11) {
			this.isStackable = 1;
		} else if (var2 == 12) {
			this.price = var1.readInt();
		} else if (var2 == 16) {
			this.isMembers = true;
		} else if (var2 == 23) {
			this.maleModel = var1.readUnsignedShort();
			this.maleOffset = var1.readUnsignedByte();
		} else if (var2 == 24) {
			this.maleModel1 = var1.readUnsignedShort();
		} else if (var2 == 25) {
			this.femaleModel = var1.readUnsignedShort();
			this.femaleOffset = var1.readUnsignedByte();
		} else if (var2 == 26) {
			this.femaleModel1 = var1.readUnsignedShort();
		} else if (var2 >= 30 && var2 < 35) {
			this.groundActions[var2 - 30] = var1.readString();
			if (this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
				this.groundActions[var2 - 30] = null;
			}
		} else if (var2 >= 35 && var2 < 40) {
			this.inventoryActions[var2 - 35] = var1.readString();
		} else {
			int var3;
			int var4;
			if (var2 == 40) {
				var3 = var1.readUnsignedByte();
				this.colourToReplace = new short[var3];
				this.colourToReplaceWith = new short[var3];

				for (var4 = 0; var4 < var3; ++var4) {
					this.colourToReplace[var4] = (short) var1.readUnsignedShort();
					this.colourToReplaceWith[var4] = (short) var1.readUnsignedShort();
				}
			} else if (var2 == 41) {
				var3 = var1.readUnsignedByte();
				this.textureToReplace = new short[var3];
				this.textToReplaceWith = new short[var3];

				for (var4 = 0; var4 < var3; ++var4) {
					this.textureToReplace[var4] = (short) var1.readUnsignedShort();
					this.textToReplaceWith[var4] = (short) var1.readUnsignedShort();
				}
			} else if (var2 == 42) {
				this.team = var1.readByte();
			} else if (var2 == 65) {
				this.field3538 = true;
			} else if (var2 == 78) {
				this.maleModel2 = var1.readUnsignedShort();
			} else if (var2 == 79) {
				this.femaleModel2 = var1.readUnsignedShort();
			} else if (var2 == 90) {
				this.maleHeadModel = var1.readUnsignedShort();
			} else if (var2 == 91) {
				this.femaleHeadModel = var1.readUnsignedShort();
			} else if (var2 == 92) {
				this.maleHeadModel2 = var1.readUnsignedShort();
			} else if (var2 == 93) {
				this.femaleHeadModel2 = var1.readUnsignedShort();
			} else if (var2 == 95) {
				this.zan2d = var1.readUnsignedShort();
			} else if (var2 == 97) {
				this.note = var1.readUnsignedShort();
			} else if (var2 == 98) {
				this.notedTemplate = var1.readUnsignedShort();
			} else if (var2 >= 100 && var2 < 110) {
				if (this.countObj == null) {
					this.countObj = new int[10];
					this.countCo = new int[10];
				}

				this.countObj[var2 - 100] = var1.readUnsignedShort();
				this.countCo[var2 - 100] = var1.readUnsignedShort();
			} else if (var2 == 110) {
				this.resizeX = var1.readUnsignedShort();
			} else if (var2 == 111) {
				this.resizeY = var1.readUnsignedShort();
			} else if (var2 == 112) {
				this.resizeZ = var1.readUnsignedShort();
			} else if (var2 == 113) {
				this.ambient = var1.readByte();
			} else if (var2 == 114) {
				this.contrast = var1.readByte() * 5;
			} else if (var2 == 115) {
				this.field3526 = var1.readUnsignedByte();
			} else if (var2 == 139) {
				this.unnotedId = var1.readUnsignedShort();
			} else if (var2 == 140) {
				this.notedId = var1.readUnsignedShort();
			} else if (var2 == 148) {
				this.field3541 = var1.readUnsignedShort();
			} else if (var2 == 149) {
				this.field3542 = var1.readUnsignedShort();
			} else if (var2 == 249) {
				this.field3494 = class41.method590(var1, this.field3494);
			}
		}

	}

	public final Model getModel(int var1) {
		if (this.countObj != null && var1 > 1) {
			int var2 = -1;

			for (int var3 = 0; var3 < 10; ++var3) {
				if (var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
					var2 = this.countObj[var3];
				}
			}

			if (var2 != -1) {
				return class46.getItemDefinition(var2).getModel(1);
			}
		}

		Model var5 = (Model) itemModelCache.get((long) this.id);
		if (var5 != null) {
			return var5;
		} else {
			ModelData var6 = ModelData.method2498(class89.field1406, this.inventoryModel, 0);
			if (var6 == null) {
				return null;
			} else {
				if (this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
					var6.method2515(this.resizeX, this.resizeY, this.resizeZ);
				}

				int var4;
				if (this.colourToReplace != null) {
					for (var4 = 0; var4 < this.colourToReplace.length; ++var4) {
						var6.recolor(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
					}
				}

				if (this.textureToReplace != null) {
					for (var4 = 0; var4 < this.textureToReplace.length; ++var4) {
						var6.method2513(this.textureToReplace[var4], this.textToReplaceWith[var4]);
					}
				}

				var5 = var6.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
				var5.field1938 = true;
				itemModelCache.put(var5, (long) this.id);
				return var5;
			}
		}
	}

	public final ModelData method4712(int var1) {
		int var3;
		if (this.countObj != null && var1 > 1) {
			int var2 = -1;

			for (var3 = 0; var3 < 10; ++var3) {
				if (var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
					var2 = this.countObj[var3];
				}
			}

			if (var2 != -1) {
				return class46.getItemDefinition(var2).method4712(1);
			}
		}

		ModelData var4 = ModelData.method2498(class89.field1406, this.inventoryModel, 0);
		if (var4 == null) {
			return null;
		} else {
			if (this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
				var4.method2515(this.resizeX, this.resizeY, this.resizeZ);
			}

			if (this.colourToReplace != null) {
				for (var3 = 0; var3 < this.colourToReplace.length; ++var3) {
					var4.recolor(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
				}
			}

			if (this.textureToReplace != null) {
				for (var3 = 0; var3 < this.textureToReplace.length; ++var3) {
					var4.method2513(this.textureToReplace[var3], this.textToReplaceWith[var3]);
				}
			}

			return var4;
		}
	}

	void post() {
	}

	public final boolean method4687(boolean var1) {
		int var2 = this.maleHeadModel;
		int var3 = this.maleHeadModel2;
		if (var1) {
			var2 = this.femaleHeadModel;
			var3 = this.femaleHeadModel2;
		}

		if (var2 == -1) {
			return true;
		} else {
			boolean var4 = true;
			if (!class89.field1406.method4237(var2, 0)) {
				var4 = false;
			}

			if (var3 != -1 && !class89.field1406.method4237(var3, 0)) {
				var4 = false;
			}

			return var4;
		}
	}

	void loadBuffer(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.populateFromBuffer(var1, var2);
		}
	}

	public final ModelData method4671(boolean var1) {
		int var2 = this.maleHeadModel;
		int var3 = this.maleHeadModel2;
		if (var1) {
			var2 = this.femaleHeadModel;
			var3 = this.femaleHeadModel2;
		}

		if (var2 == -1) {
			return null;
		} else {
			ModelData var4 = ModelData.method2498(class89.field1406, var2, 0);
			if (var3 != -1) {
				ModelData var5 = ModelData.method2498(class89.field1406, var3, 0);
				ModelData[] var6 = new ModelData[] { var4, var5 };
				var4 = new ModelData(var6, 2);
			}

			int var7;
			if (this.colourToReplace != null) {
				for (var7 = 0; var7 < this.colourToReplace.length; ++var7) {
					var4.recolor(this.colourToReplace[var7], this.colourToReplaceWith[var7]);
				}
			}

			if (this.textureToReplace != null) {
				for (var7 = 0; var7 < this.textureToReplace.length; ++var7) {
					var4.method2513(this.textureToReplace[var7], this.textToReplaceWith[var7]);
				}
			}

			return var4;
		}
	}

	public final boolean readyWorn(boolean var1) {
		int var2 = this.maleModel;
		int var3 = this.maleModel1;
		int var4 = this.maleModel2;
		if (var1) {
			var2 = this.femaleModel;
			var3 = this.femaleModel1;
			var4 = this.femaleModel2;
		}

		if (var2 == -1) {
			return true;
		} else {
			boolean var5 = true;
			if (!class89.field1406.method4237(var2, 0)) {
				var5 = false;
			}

			if (var3 != -1 && !class89.field1406.method4237(var3, 0)) {
				var5 = false;
			}

			if (var4 != -1 && !class89.field1406.method4237(var4, 0)) {
				var5 = false;
			}

			return var5;
		}
	}

	public final ModelData getWornModelData(boolean var1) {
		int var2 = this.maleModel;
		int var3 = this.maleModel1;
		int var4 = this.maleModel2;
		if (var1) {
			var2 = this.femaleModel;
			var3 = this.femaleModel1;
			var4 = this.femaleModel2;
		}

		if (var2 == -1) {
			return null;
		} else {
			ModelData var5 = ModelData.method2498(class89.field1406, var2, 0);
			if (var3 != -1) {
				ModelData var6 = ModelData.method2498(class89.field1406, var3, 0);
				if (var4 != -1) {
					ModelData var7 = ModelData.method2498(class89.field1406, var4, 0);
					ModelData[] var8 = new ModelData[] { var5, var6, var7 };
					var5 = new ModelData(var8, 3);
				} else {
					ModelData[] var10 = new ModelData[] { var5, var6 };
					var5 = new ModelData(var10, 2);
				}
			}

			if (!var1 && this.maleOffset != 0) {
				var5.method2511(0, this.maleOffset, 0);
			}

			if (var1 && this.femaleOffset != 0) {
				var5.method2511(0, this.femaleOffset, 0);
			}

			int var9;
			if (this.colourToReplace != null) {
				for (var9 = 0; var9 < this.colourToReplace.length; ++var9) {
					var5.recolor(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
				}
			}

			if (this.textureToReplace != null) {
				for (var9 = 0; var9 < this.textureToReplace.length; ++var9) {
					var5.method2513(this.textureToReplace[var9], this.textToReplaceWith[var9]);
				}
			}

			return var5;
		}
	}

	void method4676(ItemComposition var1, ItemComposition var2) {
		this.inventoryModel = var1.inventoryModel;
		this.zoom2d = var1.zoom2d;
		this.xan2d = var1.xan2d;
		this.yan2d = var1.yan2d;
		this.zan2d = var1.zan2d;
		this.offsetX2d = var1.offsetX2d;
		this.offsetY2d = var1.offsetY2d;
		this.colourToReplace = var1.colourToReplace;
		this.colourToReplaceWith = var1.colourToReplaceWith;
		this.textureToReplace = var1.textureToReplace;
		this.textToReplaceWith = var1.textToReplaceWith;
		this.name = var2.name;
		this.isMembers = var2.isMembers;
		this.price = var2.price;
		this.isStackable = 1;
	}

	void method4664(ItemComposition var1, ItemComposition var2) {
		this.inventoryModel = var1.inventoryModel;
		this.zoom2d = var1.zoom2d;
		this.xan2d = var1.xan2d;
		this.yan2d = var1.yan2d;
		this.zan2d = var1.zan2d;
		this.offsetX2d = var1.offsetX2d;
		this.offsetY2d = var1.offsetY2d;
		this.colourToReplace = var2.colourToReplace;
		this.colourToReplaceWith = var2.colourToReplaceWith;
		this.textureToReplace = var2.textureToReplace;
		this.textToReplaceWith = var2.textToReplaceWith;
		this.name = var2.name;
		this.isMembers = var2.isMembers;
		this.isStackable = var2.isStackable;
		this.maleModel = var2.maleModel;
		this.maleModel1 = var2.maleModel1;
		this.maleModel2 = var2.maleModel2;
		this.femaleModel = var2.femaleModel;
		this.femaleModel1 = var2.femaleModel1;
		this.femaleModel2 = var2.femaleModel2;
		this.maleHeadModel = var2.maleHeadModel;
		this.maleHeadModel2 = var2.maleHeadModel2;
		this.femaleHeadModel = var2.femaleHeadModel;
		this.femaleHeadModel2 = var2.femaleHeadModel2;
		this.field3526 = var2.field3526;
		this.groundActions = var2.groundActions;
		this.inventoryActions = new String[5];
		if (var2.inventoryActions != null) {
			for (int var3 = 0; var3 < 4; ++var3) {
				this.inventoryActions[var3] = var2.inventoryActions[var3];
			}
		}

		this.inventoryActions[4] = "Discard";
		this.price = 0;
	}

	void method4661(ItemComposition var1, ItemComposition var2) {
		this.inventoryModel = var1.inventoryModel;
		this.zoom2d = var1.zoom2d;
		this.xan2d = var1.xan2d;
		this.yan2d = var1.yan2d;
		this.zan2d = var1.zan2d;
		this.offsetX2d = var1.offsetX2d;
		this.offsetY2d = var1.offsetY2d;
		this.colourToReplace = var1.colourToReplace;
		this.colourToReplaceWith = var1.colourToReplaceWith;
		this.textureToReplace = var1.textureToReplace;
		this.textToReplaceWith = var1.textToReplaceWith;
		this.isStackable = var1.isStackable;
		this.name = var2.name;
		this.price = 0;
		this.isMembers = false;
		this.field3538 = false;
	}

	public ItemComposition method4714(int var1) {
		if (this.countObj != null && var1 > 1) {
			int var2 = -1;

			for (int var3 = 0; var3 < 10; ++var3) {
				if (var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
					var2 = this.countObj[var3];
				}
			}

			if (var2 != -1) {
				return class46.getItemDefinition(var2);
			}
		}

		return this;
	}

	public int method4675() {
		return this.team != -1 && this.inventoryActions != null
				? (this.team >= 0 ? (this.inventoryActions[this.team] != null ? this.team : -1)
						: ("Drop".equalsIgnoreCase(this.inventoryActions[4]) ? 4 : -1))
				: -1;
	}

	public int method4667(int var1, int var2) {
		return FileSystem.method4214(this.field3494, var1, var2);
	}

	public String method4674(int var1, String var2) {
		return class85.method1769(this.field3494, var1, var2);
	}
}
