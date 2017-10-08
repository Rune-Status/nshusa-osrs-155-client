public abstract class Actor extends Renderable {

	static int field1270;

	int[] pathX;

	int queueSize;

	int animation;

	int[] hitsplatCycles;

	boolean field1210;

	int field1235;

	CombatInfoList combatInfoList;

	int field1241;

	int[] pathY;

	byte field1226;

	int actionAnimationDisable;

	int field1251;

	int poseAnimation;

	int field1211;

	int[] hitsplatTypes;

	int idlePoseAnimation;

	int actionFrame;

	int field1266;

	int poseFrame;

	int field1213;

	int field1215;

	byte[] field1264;

	int field1260;

	int x;

	int[] field1245;

	int field1217;

	int field1218;

	int[] field1230;

	int field1219;

	int field1257;

	int y;

	int[] field1231;

	String overhead;

	int graphic;

	boolean inSequence;

	int field1249;

	int field1223;

	int field1224;

	int field1225;

	int field1214;

	int interacting;

	boolean field1234;

	int orientation;

	int field1238;

	int field1207;

	int field1243;

	int field1246;

	int field1256;

	int field1252;

	int field1265;

	int graphicsDelay;

	int angle;

	int field1255;

	int field1254;

	int field1236;

	int field1229;

	int field1250;

	int field1216;

	int field1261;

	boolean field1221;

	Actor() {
		this.field1210 = false;
		this.field1211 = 1;
		this.idlePoseAnimation = -1;
		this.field1266 = -1;
		this.field1213 = -1;
		this.field1215 = -1;
		this.field1260 = -1;
		this.field1217 = -1;
		this.field1218 = -1;
		this.field1219 = -1;
		this.overhead = null;
		this.inSequence = false;
		this.field1223 = 100;
		this.field1224 = 0;
		this.field1225 = 0;
		this.field1226 = 0;
		this.field1245 = new int[4];
		this.hitsplatTypes = new int[4];
		this.hitsplatCycles = new int[4];
		this.field1230 = new int[4];
		this.field1231 = new int[4];
		this.combatInfoList = new CombatInfoList();
		this.interacting = -1;
		this.field1234 = false;
		this.field1235 = -1;
		this.poseAnimation = -1;
		this.poseFrame = 0;
		this.field1238 = 0;
		this.animation = -1;
		this.actionFrame = 0;
		this.field1207 = 0;
		this.actionAnimationDisable = 0;
		this.field1243 = 0;
		this.graphic = -1;
		this.field1249 = 0;
		this.field1246 = 0;
		this.field1256 = 0;
		this.field1257 = 200;
		this.field1252 = 0;
		this.field1265 = 32;
		this.queueSize = 0;
		this.pathX = new int[10];
		this.pathY = new int[10];
		this.field1264 = new byte[10];
		this.field1251 = 0;
		this.field1241 = 0;
	}

	boolean hasConfig() {
		return false;
	}

	final void method1590(int var1, int var2, int var3, int var4, int var5, int var6) {
		boolean var7 = true;
		boolean var8 = true;

		int var9;
		for (var9 = 0; var9 < 4; ++var9) {
			if (this.hitsplatCycles[var9] > var5) {
				var7 = false;
			} else {
				var8 = false;
			}
		}

		var9 = -1;
		int var10 = -1;
		int var11 = 0;
		if (var1 >= 0) {
			class254 var12 = class93.method1843(var1);
			var10 = var12.field3435;
			var11 = var12.field3422;
		}

		int var14;
		if (var8) {
			if (var10 == -1) {
				return;
			}

			var9 = 0;
			var14 = 0;
			if (var10 == 0) {
				var14 = this.hitsplatCycles[0];
			} else if (var10 == 1) {
				var14 = this.hitsplatTypes[0];
			}

			for (int var13 = 1; var13 < 4; ++var13) {
				if (var10 == 0) {
					if (this.hitsplatCycles[var13] < var14) {
						var9 = var13;
						var14 = this.hitsplatCycles[var13];
					}
				} else if (var10 == 1 && this.hitsplatTypes[var13] < var14) {
					var9 = var13;
					var14 = this.hitsplatTypes[var13];
				}
			}

			if (var10 == 1 && var14 >= var2) {
				return;
			}
		} else {
			if (var7) {
				this.field1226 = 0;
			}

			for (var14 = 0; var14 < 4; ++var14) {
				byte var15 = this.field1226;
				this.field1226 = (byte) ((this.field1226 + 1) % 4);
				if (this.hitsplatCycles[var15] <= var5) {
					var9 = var15;
					break;
				}
			}
		}

		if (var9 >= 0) {
			this.field1245[var9] = var1;
			this.hitsplatTypes[var9] = var2;
			this.field1230[var9] = var3;
			this.field1231[var9] = var4;
			this.hitsplatCycles[var9] = var5 + var11 + var6;
		}
	}

	final void method1591(int var1) {
		CombatInfo2 var2 = class12.method72(var1);

		for (CombatInfoListHolder var3 = (CombatInfoListHolder) this.combatInfoList
				.method3664(); var3 != null; var3 = (CombatInfoListHolder) this.combatInfoList.method3665()) {
			if (var2 == var3.combatInfo2) {
				var3.unlink();
				return;
			}
		}

	}

	final void method1588() {
		this.queueSize = 0;
		this.field1241 = 0;
	}

	final void method1600(int var1, int var2, int var3, int var4, int var5, int var6) {
		CombatInfo2 var7 = class12.method72(var1);
		CombatInfoListHolder var8 = null;
		CombatInfoListHolder var9 = null;
		int var10 = var7.field3369;
		int var11 = 0;

		CombatInfoListHolder var12;
		for (var12 = (CombatInfoListHolder) this.combatInfoList
				.method3664(); var12 != null; var12 = (CombatInfoListHolder) this.combatInfoList.method3665()) {
			++var11;
			if (var12.combatInfo2.field3364 == var7.field3364) {
				var12.method1737(var2 + var4, var5, var6, var3);
				return;
			}

			if (var12.combatInfo2.field3360 <= var7.field3360) {
				var8 = var12;
			}

			if (var12.combatInfo2.field3369 > var10) {
				var9 = var12;
				var10 = var12.combatInfo2.field3369;
			}
		}

		if (var9 != null || var11 < 4) {
			var12 = new CombatInfoListHolder(var7);
			if (var8 == null) {
				this.combatInfoList.method3661(var12);
			} else {
				CombatInfoList.method3662(var12, var8);
			}

			var12.method1737(var2 + var4, var5, var6, var3);
			if (var11 >= 4) {
				var9.unlink();
			}

		}
	}

	public static void method1605() {
		class287.field3807 = null;
		World.offsetsY = null;
		class236.field3238 = null;
		FileSystem.field3207 = null;
		class181.field2456 = null;
		class208.spritePixels = null;
	}
}
