public class class21 {

	static int clanChatCount;

	public static Timer method151() {
		try {
			return new NanoTimer();
		} catch (Throwable var1) {
			return new MilliTimer();
		}
	}

	public static void method149() {
		Area.skeletonsIndex.reset();
	}

	protected static final void method150() {
		class114.timer.vmethod3058();

		int var0;
		for (var0 = 0; var0 < 32; ++var0) {
			GameEngine.field711[var0] = 0L;
		}

		for (var0 = 0; var0 < 32; ++var0) {
			GameEngine.field731[var0] = 0L;
		}

		class56.field697 = 0;
	}
}
