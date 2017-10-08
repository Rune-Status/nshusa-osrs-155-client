public class class105 extends class120 {

	public byte[] field1596;

	public int field1597;

	public boolean field1599;

	public int field1598;

	int field1595;

	class105(int var1, byte[] var2, int var3, int var4) {
		this.field1597 = var1;
		this.field1596 = var2;
		this.field1598 = var3;
		this.field1595 = var4;
	}

	class105(int var1, byte[] var2, int var3, int var4, boolean var5) {
		this.field1597 = var1;
		this.field1596 = var2;
		this.field1598 = var3;
		this.field1595 = var4;
		this.field1599 = var5;
	}

	public class105 method2053(class114 var1) {
		this.field1596 = var1.method2185(this.field1596);
		this.field1597 = var1.method2186(this.field1597);
		if (this.field1598 == this.field1595) {
			this.field1598 = this.field1595 = var1.method2194(this.field1598);
		} else {
			this.field1598 = var1.method2194(this.field1598);
			this.field1595 = var1.method2194(this.field1595);
			if (this.field1598 == this.field1595) {
				--this.field1598;
			}
		}

		return this;
	}
}
