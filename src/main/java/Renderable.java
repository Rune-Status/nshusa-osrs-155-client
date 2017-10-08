public abstract class Renderable extends CacheableNode {

	static class114 field2113;

	static IndexData indexTrack2;

	public int modelHeight;

	protected Renderable() {
		this.modelHeight = 1000;
	}

	protected Model getModel() {
		return null;
	}

	void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
		Model var10 = this.getModel();
		if (var10 != null) {
			this.modelHeight = var10.modelHeight;
			var10.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
		}

	}
}
