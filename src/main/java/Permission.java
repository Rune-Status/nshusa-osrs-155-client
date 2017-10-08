public enum Permission implements RSEnum {

	field3180(0, -1, true, false, true),

	field3175(1, 0, true, true, true),

	field3178(2, 1, true, true, false),

	field3174(3, 2, false, false, true),

	field3176(4, 3, false, false, true),

	field3179(5, 10, false, false, true);

	final int field3177;

	public final int field3181;

	public final boolean field3182;

	public final boolean field3183;

	Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
		this.field3177 = var3;
		this.field3181 = var4;
		this.field3182 = var6;
		this.field3183 = var7;
	}

	public int rsOrdinal() {
		return this.field3177;
	}
}
