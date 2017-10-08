public class Mapping {

	int field1707;

	int mux;

	int[] submapFloors;

	int[] field1710;

	Mapping() {
		class104.getInt(16);
		this.field1707 = class104.getBit() != 0 ? class104.getInt(4) + 1 : 1;
		if (class104.getBit() != 0) {
			class104.getInt(8);
		}

		class104.getInt(2);
		if (this.field1707 > 1) {
			this.mux = class104.getInt(4);
		}

		this.submapFloors = new int[this.field1707];
		this.field1710 = new int[this.field1707];

		for (int var1 = 0; var1 < this.field1707; ++var1) {
			class104.getInt(8);
			this.submapFloors[var1] = class104.getInt(8);
			this.field1710[var1] = class104.getInt(8);
		}

	}
}
