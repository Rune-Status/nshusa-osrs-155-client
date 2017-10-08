public class class288 {

	public static int field3814;

	static IndexedSprite[] field3819;

	boolean field3817;

	int field3809;

	IndexDataBase field3815;

	String field3812;

	class288(IndexDataBase var1) {
		this.field3809 = 0;
		this.field3817 = false;
		this.field3815 = var1;
	}

	int method5304() {
		if (this.field3809 < 25) {
			if (!this.field3815.method4238(class40.field560.field559, this.field3812)) {
				return this.field3809;
			}

			this.field3809 = 25;
		}

		if (this.field3809 == 25) {
			if (!this.field3815.method4238(this.field3812, class40.field562.field559)) {
				return 25 + this.field3815.method4241(this.field3812) * 25 / 100;
			}

			this.field3809 = 50;
		}

		if (this.field3809 == 50) {
			if (this.field3815.method4276(class40.field568.field559, this.field3812)
					&& !this.field3815.method4238(class40.field568.field559, this.field3812)) {
				return 50;
			}

			this.field3809 = 75;
		}

		if (this.field3809 == 75) {
			if (!this.field3815.method4238(this.field3812, class40.field564.field559)) {
				return 75;
			}

			this.field3809 = 100;
			this.field3817 = true;
		}

		return this.field3809;
	}

	boolean method5305() {
		return this.field3817;
	}

	void method5303(String var1) {
		if (var1 != null && !var1.isEmpty()) {
			if (var1 != this.field3812) {
				this.field3812 = var1;
				this.field3809 = 0;
				this.field3817 = false;
				this.method5304();
			}
		}
	}

	int method5306() {
		return this.field3809;
	}
}
