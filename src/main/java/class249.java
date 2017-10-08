import java.awt.Component;

public class class249 {

	public static boolean method4517(IndexDataBase var0, int var1, int var2) {
		byte[] var3 = var0.getConfigData(var1, var2);
		if (var3 == null) {
			return false;
		} else {
			Timer.decodeSprite(var3);
			return true;
		}
	}

	static void method4518(Component var0) {
		var0.setFocusTraversalKeysEnabled(false);
		var0.addKeyListener(KeyFocusListener.keyboard);
		var0.addFocusListener(KeyFocusListener.keyboard);
	}
}
