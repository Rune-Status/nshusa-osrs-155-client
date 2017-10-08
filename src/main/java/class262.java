import java.util.HashMap;

public class class262 {

	IndexDataBase field3637;

	IndexDataBase field3636;

	HashMap field3639;

	public class262(IndexDataBase var1, IndexDataBase var2) {
		this.field3637 = var1;
		this.field3636 = var2;
		this.field3639 = new HashMap();
	}

	public HashMap method4822(class261[] var1) {
		HashMap var2 = new HashMap();
		class261[] var3 = var1;

		for (int var4 = 0; var4 < var3.length; ++var4) {
			class261 var5 = var3[var4];
			if (this.field3639.containsKey(var5)) {
				var2.put(var5, this.field3639.get(var5));
			} else {
				Font var6 = class47.method720(this.field3637, this.field3636, var5.field3630, "");
				if (var6 != null) {
					this.field3639.put(var5, var6);
					var2.put(var5, var6);
				}
			}
		}

		return var2;
	}
}
