import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.runelite.rs.Opcodes;

public class RenderOverview {

	static final class261 field3826;

	static final class261 field3860;

	static final class261 field3828;

	IndexedSprite[] field3831;

	boolean field3853;

	HashSet field3848;

	int field3845;

	int field3833;

	int field3844;

	HashSet field3856;

	int field3849;

	boolean field3851;

	IndexDataBase field3825;

	HashMap field3827;

	HashSet field3852;

	HashSet field3865;

	class288 field3837;

	Iterator field3861;

	int field3840;

	float field3838;

	float field3839;

	WorldMapData field3834;

	WorldMapData field3823;

	int field3854;

	int field3841;

	int field3832;

	int field3857;

	HashMap field3830;

	int field3864;

	WorldMapData field3835;

	Font field3829;

	int field3855;

	class41 field3836;

	int field3843;

	Coordinates field3866;

	int field3846;

	HashSet field3858;

	int field3820;

	List field3863;

	final int[] field3862;

	HashSet field3850;

	int field3859;

	static {
		field3826 = class261.field3626;
		field3860 = class261.field3627;
		field3828 = class261.field3634;
	}

	public RenderOverview() {
		this.field3840 = -1;
		this.field3841 = -1;
		this.field3844 = -1;
		this.field3833 = -1;
		this.field3846 = -1;
		this.field3820 = -1;
		this.field3845 = 3;
		this.field3849 = 50;
		this.field3853 = false;
		this.field3865 = null;
		this.field3864 = -1;
		this.field3843 = -1;
		this.field3854 = -1;
		this.field3855 = -1;
		this.field3856 = new HashSet();
		this.field3848 = new HashSet();
		this.field3858 = new HashSet();
		this.field3852 = new HashSet();
		this.field3851 = false;
		this.field3859 = 0;
		this.field3862 = new int[] { 1008, 1009, 1010, 1011, 1012 };
		this.field3850 = new HashSet();
		this.field3866 = null;
	}

	void method5321(int var1, int var2, boolean var3) {
		boolean var4 = Client.rights >= 2;
		if (var4) {
			if (this.field3834 != null) {
				int var5 = (int) ((float) this.field3832
						+ ((float) (var1 - this.field3846) - (float) this.method5349() * this.field3839 / 2.0F)
								/ this.field3839);
				int var6 = (int) ((float) this.field3857
						- ((float) (var2 - this.field3820) - (float) this.method5439() * this.field3839 / 2.0F)
								/ this.field3839);
				this.field3866 = this.field3834.method275(var5 + this.field3834.method316() * 64,
						var6 + this.field3834.method333() * 64);
				if (this.field3866 != null && var3 && KeyFocusListener.field655[82] && KeyFocusListener.field655[81]
						&& var3) {
					int var7 = this.field3866.worldX;
					int var8 = this.field3866.worldY;
					int var9 = this.field3866.plane;
					Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_201);
					if (Client.RUNELITE_PACKET) {
						Client.secretPacketBuffer1.runeliteWriteInt(var8);
						Client.secretPacketBuffer1.runeliteWriteInt(var7);
						Client.secretPacketBuffer1.runeliteWriteInt(var9);
					} else {
						Client.secretPacketBuffer1.method3365(var8);
						Client.secretPacketBuffer1.method3270(var7);
						Client.secretPacketBuffer1.method3263(var9);
					}
				}
			} else {
				this.field3866 = null;
			}
		}

	}

	boolean method5324() {
		return this.field3840 != -1 && this.field3841 != -1;
	}

	public WorldMapData method5325(int var1, int var2, int var3) {
		Iterator var4 = this.field3827.values().iterator();

		WorldMapData var5;
		do {
			if (!var4.hasNext()) {
				return null;
			}

			var5 = (WorldMapData) var4.next();
		} while (!var5.method272(var1, var2, var3));

		return var5;
	}

	float method5418(int var1) {
		return var1 == 25 ? 1.0F
				: (var1 == 37 ? 1.5F : (var1 == 50 ? 2.0F : (var1 == 75 ? 3.0F : (var1 == 100 ? 4.0F : 8.0F))));
	}

	public WorldMapData method5419(int var1) {
		Iterator var2 = this.field3827.values().iterator();

		WorldMapData var3;
		do {
			if (!var2.hasNext()) {
				return null;
			}

			var3 = (WorldMapData) var2.next();
		} while (var3.method313() != var1);

		return var3;
	}

	void method5458(WorldMapData var1) {
		this.field3834 = var1;
		this.field3836 = new class41(this.field3831, this.field3830);
		this.field3837.method5303(this.field3834.method279());
	}

	public int method5442() {
		return this.field3834 == null ? -1 : this.field3832 + this.field3834.method316() * 64;
	}

	void method5330(WorldMapData var1) {
		if (this.field3834 == null || var1 != this.field3834) {
			this.method5458(var1);
			this.method5327(-1, -1, -1);
		}
	}

	void method5322() {
		if (this.field3839 < this.field3838) {
			this.field3839 = Math.min(this.field3838, this.field3839 + this.field3839 / 30.0F);
		}

		if (this.field3839 > this.field3838) {
			this.field3839 = Math.max(this.field3838, this.field3839 - this.field3839 / 30.0F);
		}

	}

	void method5365() {
		this.field3852.clear();
		this.field3852.addAll(this.field3856);
		this.field3852.addAll(this.field3858);
	}

	void method5327(int var1, int var2, int var3) {
		if (this.field3834 != null) {
			int[] var4 = this.field3834.method285(var1, var2, var3);
			if (var4 == null) {
				var4 = this.field3834.method285(this.field3834.method288(), this.field3834.method287(),
						this.field3834.method289());
			}

			this.field3832 = var4[0] - this.field3834.method316() * 64;
			this.field3857 = var4[1] - this.field3834.method333() * 64;
			this.field3840 = -1;
			this.field3841 = -1;
			this.field3839 = this.method5418(this.field3834.method292());
			this.field3838 = this.field3839;
			this.field3863 = null;
			this.field3861 = null;
			this.field3836.method547();
		}
	}

	public int method5347() {
		return this.field3834 == null ? -1 : this.field3857 + this.field3834.method333() * 64;
	}

	void method5350() {
		if (this.method5324()) {
			int var1 = this.field3840 - this.field3832;
			int var2 = this.field3841 - this.field3857;
			if (var1 != 0) {
				var1 /= Math.min(8, Math.abs(var1));
			}

			if (var2 != 0) {
				var2 /= Math.min(8, Math.abs(var2));
			}

			this.field3832 += var1;
			this.field3857 += var2;
			if (this.field3840 == this.field3832 && this.field3857 == this.field3841) {
				this.field3840 = -1;
				this.field3841 = -1;
			}

		}
	}

	public void method5342(int var1, int var2) {
		if (this.field3834 != null && this.field3834.method273(var1, var2)) {
			this.field3840 = var1 - this.field3834.method316() * 64;
			this.field3841 = var2 - this.field3834.method333() * 64;
		}
	}

	public void method5381(int var1, int var2) {
		if (this.field3834 != null) {
			this.field3832 = var1 - this.field3834.method316() * 64;
			this.field3857 = var2 - this.field3834.method333() * 64;
			this.field3840 = -1;
			this.field3841 = -1;
		}
	}

	public int method5349() {
		return this.field3844;
	}

	public int method5439() {
		return this.field3833;
	}

	public class39 method5370() {
		return this.field3861 == null ? null : (!this.field3861.hasNext() ? null : (class39) this.field3861.next());
	}

	void method5336(int var1, int var2, int var3, int var4, int var5) {
		byte var6 = 20;
		int var7 = var3 / 2 + var1;
		int var8 = var4 / 2 + var2 - 18 - var6;
		Rasterizer2D.method5129(var1, var2, var3, var4, -16777216);
		Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
		Rasterizer2D.method5129(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
		this.field3829.method4843("Loading...", var7, var6 + var8, -1, -1);
	}

	public void extractWorldmap(int var1, int var2, int var3, int var4, int var5) {
		int[] var6 = new int[4];
		Rasterizer2D.copyDrawRegion(var6);
		Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
		Rasterizer2D.method5129(var1, var2, var3, var4, -16777216);
		int var7 = this.field3837.method5306();
		if (var7 < 100) {
			this.method5336(var1, var2, var3, var4, var7);
		} else {
			if (!this.field3836.method585()) {
				this.field3836.method541(this.field3825, this.field3834.method279(), Client.isMembers);
				if (!this.field3836.method585()) {
					return;
				}
			}

			if (this.field3865 != null) {
				++this.field3843;
				if (this.field3843 % this.field3849 == 0) {
					this.field3843 = 0;
					++this.field3864;
				}

				if (this.field3864 >= this.field3845 && !this.field3853) {
					this.field3865 = null;
				}
			}

			int var8 = (int) Math.ceil((double) ((float) var3 / this.field3839));
			int var9 = (int) Math.ceil((double) ((float) var4 / this.field3839));
			this.field3836.method543(this.field3832 - var8 / 2, this.field3857 - var9 / 2, var8 / 2 + this.field3832,
					var9 / 2 + this.field3857, var1, var2, var3 + var1, var2 + var4);
			boolean var10;
			if (!this.field3851) {
				var10 = false;
				if (var5 - this.field3859 > 100) {
					this.field3859 = var5;
					var10 = true;
				}

				this.field3836.method540(this.field3832 - var8 / 2, this.field3857 - var9 / 2,
						var8 / 2 + this.field3832, var9 / 2 + this.field3857, var1, var2, var3 + var1, var2 + var4,
						this.field3852, this.field3865, this.field3843, this.field3849, var10);
			}

			var10 = Client.rights >= 2;
			if (var10 && this.field3866 != null) {
				this.field3829.method4840("Coord: " + this.field3866, Rasterizer2D.draw_region_x + 10,
						Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
			}

			this.field3844 = var8;
			this.field3833 = var9;
			this.field3846 = var1;
			this.field3820 = var2;
			Rasterizer2D.setDrawRegion(var6);
		}
	}

	public int method5318() {
		return this.field3825.method4238(this.field3823.method279(), class40.field562.field559) ? 100
				: this.field3825.method4241(this.field3823.method279());
	}

	public void extractData(int var1, int var2, int var3, int var4) {
		if (this.field3837.method5305()) {
			if (!this.field3836.method585()) {
				this.field3836.method541(this.field3825, this.field3834.method279(), Client.isMembers);
				if (!this.field3836.method585()) {
					return;
				}
			}

			this.field3836.method580(var1, var2, var3, var4, this.field3865, this.field3843, this.field3849);
		}
	}

	public void method5317(IndexDataBase var1, Font var2, HashMap var3, IndexedSprite[] var4) {
		this.field3831 = var4;
		this.field3825 = var1;
		this.field3829 = var2;
		this.field3830 = new HashMap();
		this.field3830.put(class24.field364, var3.get(field3826));
		this.field3830.put(class24.field362, var3.get(field3860));
		this.field3830.put(class24.field366, var3.get(field3828));
		this.field3837 = new class288(var1);
		int var5 = this.field3825.getFile(class40.field561.field559);
		int[] var6 = this.field3825.getChilds(var5);
		this.field3827 = new HashMap(var6.length);

		for (int var7 = 0; var7 < var6.length; ++var7) {
			Buffer var8 = new Buffer(this.field3825.getConfigData(var5, var6[var7]));
			WorldMapData var9 = new WorldMapData();
			var9.loadMapData(var8, var6[var7]);
			this.field3827.put(var9.method279(), var9);
			if (var9.method278()) {
				this.field3823 = var9;
			}
		}

		this.method5330(this.field3823);
		this.field3835 = null;
	}

	public void method5326(int var1, int var2, int var3, boolean var4) {
		WorldMapData var5 = this.method5325(var1, var2, var3);
		if (var5 == null) {
			if (!var4) {
				return;
			}

			var5 = this.field3823;
		}

		boolean var6 = false;
		if (var5 != this.field3835 || var4) {
			this.field3835 = var5;
			this.method5330(var5);
			var6 = true;
		}

		if (var6 || var4) {
			this.method5327(var1, var2, var3);
		}

	}

	public void method5373() {
		this.field3837.method5304();
	}

	public void method5422(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
		if (this.field3837.method5305()) {
			this.method5322();
			this.method5350();
			if (var3) {
				int var8 = (int) Math.ceil((double) ((float) var6 / this.field3839));
				int var9 = (int) Math.ceil((double) ((float) var7 / this.field3839));
				List var10 = this.field3836.method546(this.field3832 - var8 / 2 - 1, this.field3857 - var9 / 2 - 1,
						var8 / 2 + this.field3832 + 1, var9 / 2 + this.field3857 + 1, var4, var5, var6, var7, var1,
						var2);
				HashSet var11 = new HashSet();

				Iterator var12;
				class39 var13;
				ScriptEvent var14;
				class47 var15;
				for (var12 = var10.iterator(); var12.hasNext(); CollisionData.method3128(var14)) {
					var13 = (class39) var12.next();
					var11.add(var13);
					var14 = new ScriptEvent();
					var15 = new class47(var13.field552, var13.field548, var13.field547);
					var14.method1145(new Object[] { var15, Integer.valueOf(var1), Integer.valueOf(var2) });
					if (this.field3850.contains(var13)) {
						var14.method1143(class219.field2803);
					} else {
						var14.method1143(class219.field2804);
					}
				}

				var12 = this.field3850.iterator();

				while (var12.hasNext()) {
					var13 = (class39) var12.next();
					if (!var11.contains(var13)) {
						var14 = new ScriptEvent();
						var15 = new class47(var13.field552, var13.field548, var13.field547);
						var14.method1145(new Object[] { var15, Integer.valueOf(var1), Integer.valueOf(var2) });
						var14.method1143(class219.field2802);
						CollisionData.method3128(var14);
					}
				}

				this.field3850 = var11;
			}
		}
	}

	public void method5366(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (this.field3837.method5305()) {
			int var7 = (int) Math.ceil((double) ((float) var3 / this.field3839));
			int var8 = (int) Math.ceil((double) ((float) var4 / this.field3839));
			List var9 = this.field3836.method546(this.field3832 - var7 / 2 - 1, this.field3857 - var8 / 2 - 1,
					var7 / 2 + this.field3832 + 1, var8 / 2 + this.field3857 + 1, var1, var2, var3, var4, var5, var6);
			if (!var9.isEmpty()) {
				Iterator var10 = var9.iterator();

				boolean var13;
				do {
					if (!var10.hasNext()) {
						return;
					}

					class39 var11 = (class39) var10.next();
					Area var12 = class3.field24[var11.field552];
					var13 = false;

					for (int var14 = this.field3862.length - 1; var14 >= 0; --var14) {
						if (var12.field3294[var14] != null) {
							class10.addMenuEntry(var12.field3294[var14], var12.field3299, this.field3862[var14],
									var11.field552, var11.field548.method4058(), var11.field547.method4058());
							var13 = true;
						}
					}
				} while (!var13);

			}
		}
	}

	public void method5412(int var1) {
		WorldMapData var2 = this.method5419(var1);
		if (var2 != null) {
			this.method5330(var2);
		}

	}

	public int method5338() {
		return 1.0D == (double) this.field3838 ? 25
				: ((double) this.field3838 == 1.5D ? 37
						: (2.0D == (double) this.field3838 ? 50
								: (3.0D == (double) this.field3838 ? 75
										: (4.0D == (double) this.field3838 ? 100 : 200))));
	}

	public void method5369(int var1, int var2, boolean var3, boolean var4) {
		this.method5321(var1, var2, var4);
		if (this.field3854 == -1) {
			this.field3854 = var1;
		}

		if (this.field3855 == -1) {
			this.field3855 = var2;
		}

		int var5 = var1 - this.field3854;
		int var6 = var2 - this.field3855;
		this.field3854 = var1;
		this.field3855 = var2;
		if (var3 && !this.method5324()) {
			this.field3832 -= (int) ((float) var5 / this.field3838);
			this.field3857 += (int) ((float) var6 / this.field3838);
		}

	}

	public void method5335(int var1) {
		this.field3838 = this.method5418(var1);
	}

	public boolean method5476() {
		return this.field3837.method5305();
	}

	public Coordinates method5348() {
		return this.field3834 == null ? null : this.field3834.method275(this.method5442(), this.method5347());
	}

	public void method5474(int var1, int var2, int var3) {
		if (this.field3834 != null) {
			int[] var4 = this.field3834.method285(var1, var2, var3);
			if (var4 != null) {
				this.method5342(var4[0], var4[1]);
			}

		}
	}

	public void method5345(int var1, int var2, int var3) {
		if (this.field3834 != null) {
			int[] var4 = this.field3834.method285(var1, var2, var3);
			if (var4 != null) {
				this.method5381(var4[0], var4[1]);
			}

		}
	}

	public int method5328() {
		return this.field3834 == null ? -1 : this.field3834.method313();
	}

	public void method5352() {
		this.field3845 = 3;
	}

	public WorldMapData method5329() {
		return this.field3834;
	}

	public void method5354() {
		this.field3849 = 50;
	}

	public void method5445(int var1) {
		if (var1 >= 1) {
			this.field3845 = var1;
		}

	}

	public void method5358() {
		this.field3865 = null;
	}

	public void method5492(int var1) {
		if (var1 >= 1) {
			this.field3849 = var1;
		}

	}

	public void method5356(int var1) {
		this.field3865 = new HashSet();
		this.field3865.add(Integer.valueOf(var1));
		this.field3864 = 0;
		this.field3843 = 0;
	}

	public void method5355(boolean var1) {
		this.field3853 = var1;
	}

	public void method5357(int var1) {
		this.field3865 = new HashSet();
		this.field3864 = 0;
		this.field3843 = 0;

		for (int var2 = 0; var2 < class3.field24.length; ++var2) {
			if (class3.field24[var2] != null && class3.field24[var2].field3309 == var1) {
				this.field3865.add(Integer.valueOf(class3.field24[var2].field3292));
			}
		}

	}

	public class39 method5320() {
		if (!this.field3837.method5305()) {
			return null;
		} else if (!this.field3836.method585()) {
			return null;
		} else {
			HashMap var1 = this.field3836.method549();
			this.field3863 = new LinkedList();
			Iterator var2 = var1.values().iterator();

			while (var2.hasNext()) {
				List var3 = (List) var2.next();
				this.field3863.addAll(var3);
			}

			this.field3861 = this.field3863.iterator();
			return this.method5370();
		}
	}

	public void method5388(boolean var1) {
		this.field3851 = !var1;
	}

	public boolean method5362() {
		return !this.field3851;
	}

	public void method5383(int var1, boolean var2) {
		if (!var2) {
			this.field3856.add(Integer.valueOf(var1));
		} else {
			this.field3856.remove(Integer.valueOf(var1));
		}

		this.method5365();
	}

	public void method5361(int var1, boolean var2) {
		if (!var2) {
			this.field3848.add(Integer.valueOf(var1));
		} else {
			this.field3848.remove(Integer.valueOf(var1));
		}

		for (int var3 = 0; var3 < class3.field24.length; ++var3) {
			if (class3.field24[var3] != null && class3.field24[var3].field3309 == var1) {
				int var4 = class3.field24[var3].field3292;
				if (!var2) {
					this.field3858.add(Integer.valueOf(var4));
				} else {
					this.field3858.remove(Integer.valueOf(var4));
				}
			}
		}

		this.method5365();
	}

	public boolean method5363(int var1) {
		return !this.field3856.contains(Integer.valueOf(var1));
	}

	public void method5434(WorldMapData var1, Coordinates var2, Coordinates var3, boolean var4) {
		if (var1 != null) {
			if (this.field3834 == null || var1 != this.field3834) {
				this.method5458(var1);
			}

			if (!var4 && this.field3834.method272(var2.plane, var2.worldX, var2.worldY)) {
				this.method5327(var2.plane, var2.worldX, var2.worldY);
			} else {
				this.method5327(var3.plane, var3.worldX, var3.worldY);
			}

		}
	}

	public boolean method5364(int var1) {
		return !this.field3848.contains(Integer.valueOf(var1));
	}

	public Coordinates method5367(int var1, Coordinates var2) {
		if (!this.field3837.method5305()) {
			return null;
		} else if (!this.field3836.method585()) {
			return null;
		} else if (!this.field3834.method273(var2.worldX, var2.worldY)) {
			return null;
		} else {
			HashMap var3 = this.field3836.method549();
			List var4 = (List) var3.get(Integer.valueOf(var1));
			if (var4 != null && !var4.isEmpty()) {
				class39 var5 = null;
				int var6 = -1;
				Iterator var7 = var4.iterator();

				while (true) {
					class39 var8;
					int var11;
					do {
						if (!var7.hasNext()) {
							return var5.field547;
						}

						var8 = (class39) var7.next();
						int var9 = var8.field547.worldX - var2.worldX;
						int var10 = var8.field547.worldY - var2.worldY;
						var11 = var10 * var10 + var9 * var9;
						if (var11 == 0) {
							return var8.field547;
						}
					} while (var11 >= var6 && var5 != null);

					var5 = var8;
					var6 = var11;
				}
			} else {
				return null;
			}
		}
	}

	public void method5323(int var1, int var2, Coordinates var3, Coordinates var4) {
		ScriptEvent var5 = new ScriptEvent();
		class47 var6 = new class47(var2, var3, var4);
		var5.method1145(new Object[] { var6 });
		switch (var1) {
		case 1008:
			var5.method1143(class219.field2806);
			break;
		case 1009:
			var5.method1143(class219.field2797);
			break;
		case 1010:
			var5.method1143(class219.field2798);
			break;
		case 1011:
			var5.method1143(class219.field2799);
			break;
		case 1012:
			var5.method1143(class219.field2800);
		}

		CollisionData.method3128(var5);
	}
}
