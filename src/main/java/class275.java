public class class275 {

	long field3739;

	long field3733;

	public boolean field3735;

	long field3738;

	int field3740;

	int field3741;

	long field3734;

	long field3737;

	int field3736;

	int field3742;

	public class275() {
		this.field3733 = -1L;
		this.field3738 = -1L;
		this.field3735 = false;
		this.field3734 = 0L;
		this.field3739 = 0L;
		this.field3737 = 0L;
		this.field3736 = 0;
		this.field3740 = 0;
		this.field3741 = 0;
		this.field3742 = 0;
	}

	public void method4995() {
		if (-1L != this.field3738) {
			this.field3734 = class147.currentTimeMs() - this.field3738;
			this.field3738 = -1L;
		}

		++this.field3741;
		this.field3735 = true;
	}

	public void method4993() {
		if (-1L != this.field3733) {
			this.field3739 = class147.currentTimeMs() - this.field3733;
			this.field3733 = -1L;
		}

	}

	public void method4991(int var1) {
		this.field3738 = class147.currentTimeMs();
		this.field3736 = var1;
	}

	public void method4998(Buffer var1) {
		PacketBuffer.method3505(var1, this.field3739);
		PacketBuffer.method3505(var1, this.field3734);
		PacketBuffer.method3505(var1, this.field3737);
		var1.putShort(this.field3736);
		var1.putShort(this.field3740);
		var1.putShort(this.field3741);
		var1.putShort(this.field3742);
	}

	public void method4996() {
		this.field3735 = false;
		this.field3740 = 0;
	}

	public void method5001() {
		this.field3733 = class147.currentTimeMs();
	}

	public void method5014() {
		this.method4995();
	}
}
