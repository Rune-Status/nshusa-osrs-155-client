public enum class27 implements RSEnum {

	field407(2, (byte) 0),

	field409(0, (byte) 1),

	field400(1, (byte) 2),

	field402(3, (byte) 3);

	static Widget field403;

	final int field404;

	final byte field405;

	class27(int var3, byte var4) {
		this.field404 = var3;
		this.field405 = var4;
	}

	public int rsOrdinal() {
		return this.field405;
	}

	static class27[] method205() {
		return new class27[] { field407, field400, field409, field402 };
	}

	public static void method204() {
		if (MouseInput.mouse != null) {
			MouseInput var0 = MouseInput.mouse;
			synchronized (MouseInput.mouse) {
				MouseInput.mouse = null;
			}
		}

	}
}
