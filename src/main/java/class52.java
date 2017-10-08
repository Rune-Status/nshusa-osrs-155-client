import java.applet.Applet;

import netscape.javascript.JSObject;

public class class52 {

	public static Object method796(Applet var0, String var1, Object[] var2) throws Throwable {
		return JSObject.getWindow(var0).call(var1, var2);
	}

	public static Object method795(Applet var0, String var1) throws Throwable {
		return JSObject.getWindow(var0).call(var1, (Object[]) null);
	}

	public static void method793(Applet var0, String var1) throws Throwable {
		JSObject.getWindow(var0).eval(var1);
	}
}
