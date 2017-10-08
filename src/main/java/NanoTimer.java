public class NanoTimer extends Timer {

	long nanoTime;

	NanoTimer() {
		this.nanoTime = System.nanoTime();
	}

	public int vmethod3061(int var1, int var2) {
		long var3 = 1000000L * (long) var2;
		long var5 = this.nanoTime - System.nanoTime();
		if (var5 < var3) {
			var5 = var3;
		}

		class211.method4044(var5 / 1000000L);
		long var7 = System.nanoTime();

		int var9;
		for (var9 = 0; var9 < 10 && (var9 < 1 || this.nanoTime < var7); this.nanoTime += 1000000L * (long) var1) {
			++var9;
		}

		if (this.nanoTime < var7) {
			this.nanoTime = var7;
		}

		return var9;
	}

	public void vmethod3058() {
		this.nanoTime = System.nanoTime();
	}
}
