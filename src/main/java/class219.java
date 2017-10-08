public class class219 implements class218 {

	public static final class219 field2806;

	public static final class219 field2801;

	public static final class219 field2797;

	public static final class219 field2798;

	public static final class219 field2799;

	public static final class219 field2800;

	public static final class219 field2804;

	public static final class219 field2802;

	public static final class219 field2803;

	static final class219 field2805;

	public final int field2796;

	static {
		field2806 = new class219("", 10);
		field2797 = new class219("", 11);
		field2798 = new class219("", 12);
		field2799 = new class219("", 13);
		field2800 = new class219("", 14);
		field2804 = new class219("", 15, new ScriptVarType[] { ScriptVarType.field231, ScriptVarType.field231 },
				(ScriptVarType[]) null);
		field2802 = new class219("", 16, new ScriptVarType[] { ScriptVarType.field231, ScriptVarType.field231 },
				(ScriptVarType[]) null);
		field2803 = new class219("", 17, new ScriptVarType[] { ScriptVarType.field231, ScriptVarType.field231 },
				(ScriptVarType[]) null);
		field2805 = new class219("", 73, true, true);
		field2801 = new class219("", 76, true, false);
	}

	class219(String var1, int var2) {
		this(var1, var2, false, (ScriptVarType[]) null, false, (ScriptVarType[]) null);
	}

	class219(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
		this.field2796 = var2;
	}

	class219(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
		this(var1, var2, var3 != null, var3, null != var4, var4);
	}

	class219(String var1, int var2, boolean var3, boolean var4) {
		this(var1, var2, var3, (ScriptVarType[]) null, var4, (ScriptVarType[]) null);
	}

	public int rsOrdinal() {
		return this.field2796;
	}

	static Script method4177(byte[] var0) {
		Script var1 = new Script();
		Buffer var2 = new Buffer(var0);
		var2.offset = var2.payload.length - 2;
		int var3 = var2.readUnsignedShort();
		int var4 = var2.payload.length - 2 - var3 - 12;
		var2.offset = var4;
		int var5 = var2.readInt();
		var1.localIntCount = var2.readUnsignedShort();
		var1.localStringCount = var2.readUnsignedShort();
		var1.intStackCount = var2.readUnsignedShort();
		var1.stringStackCount = var2.readUnsignedShort();
		int var6 = var2.readUnsignedByte();
		int var7;
		int var8;
		if (var6 > 0) {
			var1.switches = var1.method1919(var6);

			for (var7 = 0; var7 < var6; ++var7) {
				var8 = var2.readUnsignedShort();
				IterableHashTable var9 = new IterableHashTable(class88.method1780(var8));
				var1.switches[var7] = var9;

				while (var8-- > 0) {
					int var10 = var2.readInt();
					int var11 = var2.readInt();
					var9.put(new IntegerNode(var11), (long) var10);
				}
			}
		}

		var2.offset = 0;
		var2.getNullString();
		var1.instructions = new int[var5];
		var1.intOperands = new int[var5];
		var1.stringOperands = new String[var5];

		for (var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
			var8 = var2.readUnsignedShort();
			if (var8 == 3) {
				var1.stringOperands[var7] = var2.readString();
			} else if (var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
				var1.intOperands[var7] = var2.readInt();
			} else {
				var1.intOperands[var7] = var2.readUnsignedByte();
			}
		}

		return var1;
	}
}
