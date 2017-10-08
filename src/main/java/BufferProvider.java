public abstract class BufferProvider {

	public static boolean field3778;

	public int[] pixels;

	public int width;

	public int height;

	public final void setRaster() {
		Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
	}

	public abstract void vmethod5136(int var1, int var2);

	public abstract void vmethod5133(int var1, int var2, int var3, int var4);
}
