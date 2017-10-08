import java.util.zip.Inflater;

public class GZipDecompressor {

	static Varcs chatMessages;

	Inflater inflator;

	GZipDecompressor(int var1, int var2, int var3) {
	}

	public GZipDecompressor() {
		this(-1, 1000000, 1000000);
	}

	public void decompress(Buffer var1, byte[] var2) {
		if (var1.payload[var1.offset] == 31 && -117 == var1.payload[var1.offset + 1]) {
			if (this.inflator == null) {
				this.inflator = new Inflater(true);
			}

			try {
				this.inflator.setInput(var1.payload, var1.offset + 10, var1.payload.length - (var1.offset + 8 + 10));
				this.inflator.inflate(var2);
			} catch (Exception var4) {
				this.inflator.reset();
				throw new RuntimeException("");
			}

			this.inflator.reset();
		} else {
			throw new RuntimeException("");
		}
	}
}
