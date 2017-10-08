public final class class8 extends class9 {

	static Region region;

	static IndexData indexTextures;

	final int field255;

	final int field250;

	final int field251;

	final int field252;

	final int field253;

	class8(int var1, int var2, int var3, int var4, int var5) {
		this.field255 = var1;
		this.field250 = var2;
		this.field251 = var3;
		this.field252 = var4;
		this.field253 = var5;
	}

	public final void vmethod57() {
		Rasterizer2D.drawRectangle(this.field255 + Rasterizer2D.draw_region_x,
				this.field250 + Rasterizer2D.drawingAreaTop, this.field251 - this.field255,
				this.field252 - this.field250, this.field253);
	}

	public static int method46(int var0, int var1) {
		int var2;
		for (var2 = 1; var1 > 1; var1 >>= 1) {
			if ((var1 & 1) != 0) {
				var2 = var0 * var2;
			}

			var0 *= var0;
		}

		if (var1 == 1) {
			return var0 * var2;
		} else {
			return var2;
		}
	}
}
