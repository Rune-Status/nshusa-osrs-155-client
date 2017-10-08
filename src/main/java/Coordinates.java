public class Coordinates {

	public int plane;

	public int worldY;

	public int worldX;

	public Coordinates() {
		this.plane = -1;
	}

	public Coordinates(Coordinates var1) {
		this.plane = var1.plane;
		this.worldX = var1.worldX;
		this.worldY = var1.worldY;
	}

	public Coordinates(int var1, int var2, int var3) {
		this.plane = var1;
		this.worldX = var2;
		this.worldY = var3;
	}

	public Coordinates(int var1) {
		if (var1 == -1) {
			this.plane = -1;
		} else {
			this.plane = var1 >> 28 & 3;
			this.worldX = var1 >> 14 & 16383;
			this.worldY = var1 & 16383;
		}

	}

	public int method4058() {
		return this.plane << 28 | this.worldX << 14 | this.worldY;
	}

	public void method4050(int var1, int var2, int var3) {
		this.plane = var1;
		this.worldX = var2;
		this.worldY = var3;
	}

	boolean method4053(Coordinates var1) {
		return this.plane != var1.plane ? false : (this.worldX != var1.worldX ? false : this.worldY == var1.worldY);
	}

	public int hashCode() {
		return this.method4058();
	}

	public boolean equals(Object var1) {
		return this == var1 ? true : (!(var1 instanceof Coordinates) ? false : this.method4053((Coordinates) var1));
	}

	public String toString() {
		return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 63) + ","
				+ (this.worldY & 63);
	}
}
