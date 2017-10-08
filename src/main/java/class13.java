import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class class13 {

	public static Comparator field281;

	public static Comparator field280;

	public static Comparator field283;

	public static Comparator field282;

	public final List field284;

	static {
		field281 = new class19();
		new class12();
		field280 = new class17();
		field283 = new class18();
		field282 = new class15();
	}

	public class13(Buffer var1, boolean var2) {
		int var3 = var1.readUnsignedShort();
		boolean var4 = var1.readUnsignedByte() == 1;
		byte var5;
		if (var4) {
			var5 = 1;
		} else {
			var5 = 0;
		}

		int var6 = var1.readUnsignedShort();
		this.field284 = new ArrayList(var6);

		for (int var7 = 0; var7 < var6; ++var7) {
			this.field284.add(new class14(var1, var5, var3));
		}

	}

	public void method74(Comparator var1, boolean var2) {
		if (var2) {
			Collections.sort(this.field284, var1);
		} else {
			Collections.sort(this.field284, Collections.reverseOrder(var1));
		}

	}

	static final void method78(class117 var0) {
		var0.field1703 = false;
		if (var0.field1705 != null) {
			var0.field1705.field1737 = 0;
		}

		for (class117 var1 = var0.vmethod4025(); var1 != null; var1 = var0.vmethod4002()) {
			method78(var1);
		}

	}
}
