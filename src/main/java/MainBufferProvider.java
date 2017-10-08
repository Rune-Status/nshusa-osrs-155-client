import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public final class MainBufferProvider extends BufferProvider {

	Image image;

	Component field701;

	MainBufferProvider(int var1, int var2, Component var3) {
		super.width = var1;
		super.height = var2;
		super.pixels = new int[var2 * var1 + 1];
		DataBufferInt var4 = new DataBufferInt(super.pixels, super.pixels.length);
		DirectColorModel var5 = new DirectColorModel(32, 16711680, '\uff00', 255);
		WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.width, super.height),
				var4, (Point) null);
		this.image = new BufferedImage(var5, var6, false, new Hashtable());
		this.method853(var3);
		this.setRaster();
	}

	final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
		try {
			Shape var6 = var1.getClip();
			var1.clipRect(var2, var3, var4, var5);
			var1.drawImage(this.image, 0, 0, this.field701);
			var1.setClip(var6);
		} catch (Exception var7) {
			this.field701.repaint();
		}

	}

	final void draw(Graphics var1, int var2, int var3) {
		try {
			var1.drawImage(this.image, var2, var3, this.field701);
		} catch (Exception var5) {
			this.field701.repaint();
		}

	}

	final void method853(Component var1) {
		this.field701 = var1;
	}

	public final void vmethod5136(int var1, int var2) {
		this.draw(this.field701.getGraphics(), var1, var2);
	}

	public final void vmethod5133(int var1, int var2, int var3, int var4) {
		this.drawSub(this.field701.getGraphics(), var1, var2, var3, var4);
	}
}
