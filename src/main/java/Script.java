public class Script extends CacheableNode {

	static NodeCache field1518;

	int[] instructions;

	int[] intOperands;

	int localIntCount;

	int localStringCount;

	String[] stringOperands;

	int intStackCount;

	IterableHashTable[] switches;

	int stringStackCount;

	static {
		field1518 = new NodeCache(128);
	}

	IterableHashTable[] method1919(int var1) {
		return new IterableHashTable[var1];
	}

	static boolean method1926(Widget var0) {
		if (Client.field961) {
			if (class244.getWidgetConfig(var0) != 0) {
				return false;
			}

			if (var0.type == 0) {
				return false;
			}
		}

		return var0.isHidden;
	}
}
