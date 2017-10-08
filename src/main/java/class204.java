import java.util.LinkedHashMap;

public class class204 extends class117 {

	static IndexFile field2552;

	int[] field2543;

	int field2549;

	int field2527;

	int[] field2535;

	HashTable field2553;

	int[] field2551;

	int[] field2530;

	int[] field2542;

	class205[][] field2545;

	int[] field2539;

	class206 field2547;

	class208 field2528;

	int field2550;

	int[] field2526;

	int[] field2544;

	int[] field2534;

	long field2554;

	int[] field2540;

	int[] field2531;

	int field2537;

	boolean field2548;

	class205[][] field2546;

	int[] field2529;

	int[] field2541;

	long field2532;

	int[] field2536;

	int[] field2538;

	public class204() {
		this.field2527 = 256;
		this.field2537 = 1000000;
		this.field2526 = new int[16];
		this.field2530 = new int[16];
		this.field2531 = new int[16];
		this.field2542 = new int[16];
		this.field2551 = new int[16];
		this.field2534 = new int[16];
		this.field2535 = new int[16];
		this.field2536 = new int[16];
		this.field2529 = new int[16];
		this.field2539 = new int[16];
		this.field2538 = new int[16];
		this.field2541 = new int[16];
		this.field2540 = new int[16];
		this.field2543 = new int[16];
		this.field2544 = new int[16];
		this.field2545 = new class205[16][128];
		this.field2546 = new class205[16][128];
		this.field2547 = new class206();
		this.field2528 = new class208(this);
		this.field2553 = new HashTable(128);
		this.method3817();
	}

	void method3806(int var1, int var2) {
		this.field2542[var1] = var2;
		this.field2534[var1] = var2 & -128;
		this.method3798(var1, var2);
	}

	void method3810(int var1, int var2, int var3) {
		class205 var4 = this.field2545[var1][var2];
		if (var4 != null) {
			this.field2545[var1][var2] = null;
			if ((this.field2539[var1] & 2) != 0) {
				for (class205 var5 = (class205) this.field2528.field2601
						.getFront(); var5 != null; var5 = (class205) this.field2528.field2601.getNext()) {
					if (var4.field2563 == var5.field2563 && var5.field2571 < 0 && var4 != var5) {
						var4.field2571 = 0;
						break;
					}
				}
			} else {
				var4.field2571 = 0;
			}

		}
	}

	void method3814(int var1) {
		for (class205 var2 = (class205) this.field2528.field2601
				.getFront(); var2 != null; var2 = (class205) this.field2528.field2601.getNext()) {
			if (var1 < 0 || var2.field2563 == var1) {
				if (var2.field2570 != null) {
					var2.field2570.method2198(class31.sampleRate / 100);
					if (var2.field2570.method2340()) {
						this.field2528.field2606.method1979(var2.field2570);
					}

					var2.method3927();
				}

				if (var2.field2571 < 0) {
					this.field2545[var2.field2563][var2.field2574] = null;
				}

				var2.unlink();
			}
		}

	}

	public synchronized void method3803() {
		this.field2547.method3934();
		this.method3817();
	}

	void method3884(int var1) {
		if (var1 >= 0) {
			this.field2526[var1] = 12800;
			this.field2530[var1] = 8192;
			this.field2531[var1] = 16383;
			this.field2535[var1] = 8192;
			this.field2536[var1] = 0;
			this.field2529[var1] = 8192;
			this.method3818(var1);
			this.method3907(var1);
			this.field2539[var1] = 0;
			this.field2538[var1] = 32767;
			this.field2541[var1] = 256;
			this.field2540[var1] = 0;
			this.method3869(var1, 8192);
		} else {
			for (var1 = 0; var1 < 16; ++var1) {
				this.method3884(var1);
			}

		}
	}

	void method3808(int var1, int var2, int var3) {
		this.method3810(var1, var2, 64);
		if ((this.field2539[var1] & 2) != 0) {
			for (class205 var4 = (class205) this.field2528.field2601
					.getTail(); var4 != null; var4 = (class205) this.field2528.field2601.getPrevious()) {
				if (var4.field2563 == var1 && var4.field2571 < 0) {
					this.field2545[var1][var4.field2574] = null;
					this.field2545[var1][var2] = var4;
					int var5 = (var4.field2567 * var4.field2566 >> 12) + var4.field2565;
					var4.field2565 += var2 - var4.field2574 << 8;
					var4.field2566 = var5 - var4.field2565;
					var4.field2567 = 4096;
					var4.field2574 = var2;
					return;
				}
			}
		}

		class207 var9 = (class207) this.field2553.get((long) this.field2551[var1]);
		if (var9 != null) {
			class105 var8 = var9.field2593[var2];
			if (var8 != null) {
				class205 var6 = new class205();
				var6.field2563 = var1;
				var6.field2558 = var9;
				var6.field2559 = var8;
				var6.field2560 = var9.field2597[var2];
				var6.field2561 = var9.field2592[var2];
				var6.field2574 = var2;
				var6.field2576 = 1024 + var3 * var3 * var9.field2595[var2] * var9.field2598 >> 11;
				var6.field2557 = var9.field2596[var2] & 255;
				var6.field2565 = (var2 << 8) - (var9.field2594[var2] & 32767);
				var6.field2568 = 0;
				var6.field2569 = 0;
				var6.field2562 = 0;
				var6.field2571 = -1;
				var6.field2572 = 0;
				if (this.field2540[var1] == 0) {
					var6.field2570 = class115.method2352(var8, this.method3854(var6), this.method3823(var6),
							this.method3828(var6));
				} else {
					var6.field2570 = class115.method2352(var8, this.method3854(var6), 0, this.method3828(var6));
					this.method3809(var6, var9.field2594[var2] < 0);
				}

				if (var9.field2594[var2] < 0) {
					var6.field2570.method2346(-1);
				}

				if (var6.field2561 >= 0) {
					class205 var7 = this.field2546[var1][var6.field2561];
					if (var7 != null && var7.field2571 < 0) {
						this.field2545[var1][var7.field2574] = null;
						var7.field2571 = 0;
					}

					this.field2546[var1][var6.field2561] = var6;
				}

				this.field2528.field2601.addFront(var6);
				this.field2545[var1][var2] = var6;
			}
		}
	}

	void method3811(int var1, int var2, int var3) {
	}

	void method3817() {
		this.method3814(-1);
		this.method3884(-1);

		int var1;
		for (var1 = 0; var1 < 16; ++var1) {
			this.field2551[var1] = this.field2542[var1];
		}

		for (var1 = 0; var1 < 16; ++var1) {
			this.field2534[var1] = this.field2542[var1] & -128;
		}

	}

	void method3798(int var1, int var2) {
		if (var2 != this.field2551[var1]) {
			this.field2551[var1] = var2;

			for (int var3 = 0; var3 < 128; ++var3) {
				this.field2546[var1][var3] = null;
			}
		}

	}

	protected synchronized void vmethod4004(int[] var1, int var2, int var3) {
		if (this.field2547.method3949()) {
			int var4 = this.field2547.field2579 * this.field2537 / class31.sampleRate;

			do {
				long var5 = (long) var4 * (long) var3 + this.field2532;
				if (this.field2554 - var5 >= 0L) {
					this.field2532 = var5;
					break;
				}

				int var7 = (int) (((long) var4 + (this.field2554 - this.field2532) - 1L) / (long) var4);
				this.field2532 += (long) var4 * (long) var7;
				this.field2528.vmethod4004(var1, var2, var7);
				var2 += var7;
				var3 -= var7;
				this.method3830();
			} while (this.field2547.method3949());
		}

		this.field2528.vmethod4004(var1, var2, var3);
	}

	protected synchronized void vmethod4023(int var1) {
		if (this.field2547.method3949()) {
			int var2 = this.field2547.field2579 * this.field2537 / class31.sampleRate;

			do {
				long var3 = this.field2532 + (long) var2 * (long) var1;
				if (this.field2554 - var3 >= 0L) {
					this.field2532 = var3;
					break;
				}

				int var5 = (int) ((this.field2554 - this.field2532 + (long) var2 - 1L) / (long) var2);
				this.field2532 += (long) var2 * (long) var5;
				this.field2528.vmethod4023(var5);
				var1 -= var5;
				this.method3830();
			} while (this.field2547.method3949());
		}

		this.field2528.vmethod4023(var1);
	}

	void method3812(int var1, int var2) {
	}

	void method3813(int var1, int var2) {
		this.field2535[var1] = var2;
	}

	protected synchronized class117 vmethod4002() {
		return null;
	}

	int method3854(class205 var1) {
		int var2 = (var1.field2567 * var1.field2566 >> 12) + var1.field2565;
		var2 += (this.field2535[var1.field2563] - 8192) * this.field2541[var1.field2563] >> 12;
		class202 var3 = var1.field2560;
		int var4;
		if (var3.field2512 > 0 && (var3.field2511 > 0 || this.field2536[var1.field2563] > 0)) {
			var4 = var3.field2511 << 2;
			int var5 = var3.field2513 << 1;
			if (var1.field2573 < var5) {
				var4 = var4 * var1.field2573 / var5;
			}

			var4 += this.field2536[var1.field2563] >> 7;
			double var6 = Math.sin((double) (var1.field2564 & 511) * 0.01227184630308513D);
			var2 += (int) (var6 * (double) var4);
		}

		var4 = (int) ((double) (var1.field2559.field1597 * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double) var2)
				/ (double) class31.sampleRate + 0.5D);
		return var4 < 1 ? 1 : var4;
	}

	synchronized boolean method3846(Track1 var1, IndexDataBase var2, class110 var3, int var4) {
		var1.method4030();
		boolean var5 = true;
		int[] var6 = null;
		if (var4 > 0) {
			var6 = new int[] { var4 };
		}

		for (class199 var7 = (class199) var1.field2608.method3646(); var7 != null; var7 = (class199) var1.field2608
				.method3647()) {
			int var8 = (int) var7.hash;
			class207 var9 = (class207) this.field2553.get((long) var8);
			if (var9 == null) {
				var9 = class60.method1068(var2, var8);
				if (var9 == null) {
					var5 = false;
					continue;
				}

				this.field2553.put(var9, (long) var8);
			}

			if (!var9.method3988(var3, var7.field2500, var6)) {
				var5 = false;
			}
		}

		if (var5) {
			var1.method4031();
		}

		return var5;
	}

	boolean method3831(class205 var1) {
		if (var1.field2570 == null) {
			if (var1.field2571 >= 0) {
				var1.unlink();
				if (var1.field2561 > 0 && var1 == this.field2546[var1.field2563][var1.field2561]) {
					this.field2546[var1.field2563][var1.field2561] = null;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	void method3818(int var1) {
		if ((this.field2539[var1] & 2) != 0) {
			for (class205 var2 = (class205) this.field2528.field2601
					.getFront(); var2 != null; var2 = (class205) this.field2528.field2601.getNext()) {
				if (var2.field2563 == var1 && this.field2545[var1][var2.field2574] == null && var2.field2571 < 0) {
					var2.field2571 = 0;
				}
			}
		}

	}

	public int method3865() {
		return this.field2527;
	}

	void method3907(int var1) {
		if ((this.field2539[var1] & 4) != 0) {
			for (class205 var2 = (class205) this.field2528.field2601
					.getFront(); var2 != null; var2 = (class205) this.field2528.field2601.getNext()) {
				if (var2.field2563 == var1) {
					var2.field2577 = 0;
				}
			}
		}

	}

	void method3820(int var1) {
		int var2 = var1 & 240;
		int var3;
		int var4;
		int var5;
		if (var2 == 128) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3810(var3, var4, var5);
		} else if (var2 == 144) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var5 > 0) {
				this.method3808(var3, var4, var5);
			} else {
				this.method3810(var3, var4, 64);
			}

		} else if (var2 == 160) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3811(var3, var4, var5);
		} else if (var2 == 176) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var4 == 0) {
				this.field2534[var3] = (var5 << 14) + (this.field2534[var3] & -2080769);
			}

			if (var4 == 32) {
				this.field2534[var3] = (var5 << 7) + (this.field2534[var3] & -16257);
			}

			if (var4 == 1) {
				this.field2536[var3] = (var5 << 7) + (this.field2536[var3] & -16257);
			}

			if (var4 == 33) {
				this.field2536[var3] = var5 + (this.field2536[var3] & -128);
			}

			if (var4 == 5) {
				this.field2529[var3] = (var5 << 7) + (this.field2529[var3] & -16257);
			}

			if (var4 == 37) {
				this.field2529[var3] = var5 + (this.field2529[var3] & -128);
			}

			if (var4 == 7) {
				this.field2526[var3] = (var5 << 7) + (this.field2526[var3] & -16257);
			}

			if (var4 == 39) {
				this.field2526[var3] = var5 + (this.field2526[var3] & -128);
			}

			if (var4 == 10) {
				this.field2530[var3] = (var5 << 7) + (this.field2530[var3] & -16257);
			}

			if (var4 == 42) {
				this.field2530[var3] = var5 + (this.field2530[var3] & -128);
			}

			if (var4 == 11) {
				this.field2531[var3] = (var5 << 7) + (this.field2531[var3] & -16257);
			}

			if (var4 == 43) {
				this.field2531[var3] = var5 + (this.field2531[var3] & -128);
			}

			if (var4 == 64) {
				if (var5 >= 64) {
					this.field2539[var3] |= 1;
				} else {
					this.field2539[var3] &= -2;
				}
			}

			if (var4 == 65) {
				if (var5 >= 64) {
					this.field2539[var3] |= 2;
				} else {
					this.method3818(var3);
					this.field2539[var3] &= -3;
				}
			}

			if (var4 == 99) {
				this.field2538[var3] = (var5 << 7) + (this.field2538[var3] & 127);
			}

			if (var4 == 98) {
				this.field2538[var3] = (this.field2538[var3] & 16256) + var5;
			}

			if (var4 == 101) {
				this.field2538[var3] = (var5 << 7) + (this.field2538[var3] & 127) + 16384;
			}

			if (var4 == 100) {
				this.field2538[var3] = (this.field2538[var3] & 16256) + var5 + 16384;
			}

			if (var4 == 120) {
				this.method3814(var3);
			}

			if (var4 == 121) {
				this.method3884(var3);
			}

			if (var4 == 123) {
				this.method3841(var3);
			}

			int var6;
			if (var4 == 6) {
				var6 = this.field2538[var3];
				if (var6 == 16384) {
					this.field2541[var3] = (var5 << 7) + (this.field2541[var3] & -16257);
				}
			}

			if (var4 == 38) {
				var6 = this.field2538[var3];
				if (var6 == 16384) {
					this.field2541[var3] = var5 + (this.field2541[var3] & -128);
				}
			}

			if (var4 == 16) {
				this.field2540[var3] = (var5 << 7) + (this.field2540[var3] & -16257);
			}

			if (var4 == 48) {
				this.field2540[var3] = var5 + (this.field2540[var3] & -128);
			}

			if (var4 == 81) {
				if (var5 >= 64) {
					this.field2539[var3] |= 4;
				} else {
					this.method3907(var3);
					this.field2539[var3] &= -5;
				}
			}

			if (var4 == 17) {
				this.method3869(var3, (var5 << 7) + (this.field2543[var3] & -16257));
			}

			if (var4 == 49) {
				this.method3869(var3, var5 + (this.field2543[var3] & -128));
			}

		} else if (var2 == 192) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3798(var3, var4 + this.field2534[var3]);
		} else if (var2 == 208) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3812(var3, var4);
		} else if (var2 == 224) {
			var3 = var1 & 15;
			var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
			this.method3813(var3, var4);
		} else {
			var2 = var1 & 255;
			if (var2 == 255) {
				this.method3817();
			}
		}
	}

	public synchronized boolean method3870() {
		return this.field2547.method3949();
	}

	synchronized void method3800() {
		for (class207 var1 = (class207) this.field2553.method3646(); var1 != null; var1 = (class207) this.field2553
				.method3647()) {
			var1.method3997();
		}

	}

	public synchronized void method3824() {
		for (class207 var1 = (class207) this.field2553.method3646(); var1 != null; var1 = (class207) this.field2553
				.method3647()) {
			var1.unlink();
		}

	}

	boolean method3832(class205 var1, int[] var2, int var3, int var4) {
		var1.field2575 = class31.sampleRate / 100;
		if (var1.field2571 < 0 || var1.field2570 != null && !var1.field2570.method2219()) {
			int var5 = var1.field2567;
			if (var5 > 0) {
				var5 -= (int) (16.0D * Math.pow(2.0D, (double) this.field2529[var1.field2563] * 4.921259842519685E-4D)
						+ 0.5D);
				if (var5 < 0) {
					var5 = 0;
				}

				var1.field2567 = var5;
			}

			var1.field2570.method2216(this.method3854(var1));
			class202 var6 = var1.field2560;
			boolean var7 = false;
			++var1.field2573;
			var1.field2564 += var6.field2512;
			double var8 = 5.086263020833333E-6D
					* (double) ((var1.field2567 * var1.field2566 >> 12) + (var1.field2574 - 60 << 8));
			if (var6.field2509 > 0) {
				if (var6.field2510 > 0) {
					var1.field2568 += (int) (128.0D * Math.pow(2.0D, var8 * (double) var6.field2510) + 0.5D);
				} else {
					var1.field2568 += 128;
				}
			}

			if (var6.field2516 != null) {
				if (var6.field2514 > 0) {
					var1.field2569 += (int) (128.0D * Math.pow(2.0D, (double) var6.field2514 * var8) + 0.5D);
				} else {
					var1.field2569 += 128;
				}

				while (var1.field2562 < var6.field2516.length - 2
						&& var1.field2569 > (var6.field2516[var1.field2562 + 2] & 255) << 8) {
					var1.field2562 += 2;
				}

				if (var6.field2516.length - 2 == var1.field2562 && 0 == var6.field2516[var1.field2562 + 1]) {
					var7 = true;
				}
			}

			if (var1.field2571 >= 0 && var6.field2515 != null && (this.field2539[var1.field2563] & 1) == 0
					&& (var1.field2561 < 0 || var1 != this.field2546[var1.field2563][var1.field2561])) {
				if (var6.field2505 > 0) {
					var1.field2571 += (int) (128.0D * Math.pow(2.0D, var8 * (double) var6.field2505) + 0.5D);
				} else {
					var1.field2571 += 128;
				}

				while (var1.field2572 < var6.field2515.length - 2
						&& var1.field2571 > (var6.field2515[var1.field2572 + 2] & 255) << 8) {
					var1.field2572 += 2;
				}

				if (var6.field2515.length - 2 == var1.field2572) {
					var7 = true;
				}
			}

			if (var7) {
				var1.field2570.method2198(var1.field2575);
				if (var2 != null) {
					var1.field2570.vmethod4004(var2, var3, var4);
				} else {
					var1.field2570.vmethod4023(var4);
				}

				if (var1.field2570.method2340()) {
					this.field2528.field2606.method1979(var1.field2570);
				}

				var1.method3927();
				if (var1.field2571 >= 0) {
					var1.unlink();
					if (var1.field2561 > 0 && var1 == this.field2546[var1.field2563][var1.field2561]) {
						this.field2546[var1.field2563][var1.field2561] = null;
					}
				}

				return true;
			} else {
				var1.field2570.method2214(var1.field2575, this.method3823(var1), this.method3828(var1));
				return false;
			}
		} else {
			var1.method3927();
			var1.unlink();
			if (var1.field2561 > 0 && var1 == this.field2546[var1.field2563][var1.field2561]) {
				this.field2546[var1.field2563][var1.field2561] = null;
			}

			return true;
		}
	}

	public synchronized void method3797(int var1) {
		this.field2527 = var1;
	}

	protected synchronized class117 vmethod4025() {
		return this.field2528;
	}

	void method3869(int var1, int var2) {
		this.field2543[var1] = var2;
		this.field2544[var1] = (int) (2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double) var2) + 0.5D);
	}

	synchronized void method3886(Track1 var1, boolean var2) {
		this.method3803();
		this.field2547.method3968(var1.field2609);
		this.field2548 = var2;
		this.field2532 = 0L;
		int var3 = this.field2547.method3948();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.field2547.method3971(var4);
			this.field2547.method3961(var4);
			this.field2547.method3938(var4);
		}

		this.field2549 = this.field2547.method3945();
		this.field2550 = this.field2547.field2586[this.field2549];
		this.field2554 = this.field2547.method3944(this.field2550);
	}

	void method3830() {
		int var1 = this.field2549;
		int var2 = this.field2550;

		long var3;
		for (var3 = this.field2554; var2 == this.field2550; var3 = this.field2547.method3944(var2)) {
			while (var2 == this.field2547.field2586[var1]) {
				this.field2547.method3971(var1);
				int var5 = this.field2547.method3941(var1);
				if (var5 == 1) {
					this.field2547.method3939();
					this.field2547.method3938(var1);
					if (this.field2547.method3946()) {
						if (!this.field2548 || var2 == 0) {
							this.method3817();
							this.field2547.method3934();
							return;
						}

						this.field2547.method3947(var3);
					}
					break;
				}

				if ((var5 & 128) != 0) {
					this.method3820(var5);
				}

				this.field2547.method3961(var1);
				this.field2547.method3938(var1);
			}

			var1 = this.field2547.method3945();
			var2 = this.field2547.field2586[var1];
		}

		this.field2549 = var1;
		this.field2550 = var2;
		this.field2554 = var3;
	}

	void method3809(class205 var1, boolean var2) {
		int var3 = var1.field2559.field1596.length;
		int var4;
		if (var2 && var1.field2559.field1599) {
			int var5 = var3 + var3 - var1.field2559.field1598;
			var4 = (int) ((long) var5 * (long) this.field2540[var1.field2563] >> 6);
			var3 <<= 8;
			if (var4 >= var3) {
				var4 = var3 + var3 - 1 - var4;
				var1.field2570.method2297();
			}
		} else {
			var4 = (int) ((long) this.field2540[var1.field2563] * (long) var3 >> 6);
		}

		var1.field2570.method2210(var4);
	}

	protected synchronized int vmethod4007() {
		return 0;
	}

	int method3823(class205 var1) {
		class202 var2 = var1.field2560;
		int var3 = this.field2526[var1.field2563] * this.field2531[var1.field2563] + 4096 >> 13;
		var3 = 16384 + var3 * var3 >> 15;
		var3 = 16384 + var3 * var1.field2576 >> 15;
		var3 = var3 * this.field2527 + 128 >> 8;
		if (var2.field2509 > 0) {
			var3 = (int) ((double) var3
					* Math.pow(0.5D, (double) var1.field2568 * 1.953125E-5D * (double) var2.field2509) + 0.5D);
		}

		int var4;
		int var5;
		int var6;
		int var7;
		if (var2.field2516 != null) {
			var4 = var1.field2569;
			var5 = var2.field2516[var1.field2562 + 1];
			if (var1.field2562 < var2.field2516.length - 2) {
				var6 = (var2.field2516[var1.field2562] & 255) << 8;
				var7 = (var2.field2516[var1.field2562 + 2] & 255) << 8;
				var5 += (var2.field2516[var1.field2562 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = 32 + var5 * var3 >> 6;
		}

		if (var1.field2571 > 0 && var2.field2515 != null) {
			var4 = var1.field2571;
			var5 = var2.field2515[var1.field2572 + 1];
			if (var1.field2572 < var2.field2515.length - 2) {
				var6 = (var2.field2515[var1.field2572] & 255) << 8;
				var7 = (var2.field2515[var1.field2572 + 2] & 255) << 8;
				var5 += (var4 - var6) * (var2.field2515[var1.field2572 + 3] - var5) / (var7 - var6);
			}

			var3 = 32 + var3 * var5 >> 6;
		}

		return var3;
	}

	int method3828(class205 var1) {
		int var2 = this.field2530[var1.field2563];
		return var2 < 8192 ? 32 + var2 * var1.field2557 >> 6
				: 16384 - ((128 - var1.field2557) * (16384 - var2) + 32 >> 6);
	}

	public synchronized void method3805(int var1, int var2) {
		this.method3806(var1, var2);
	}

	void method3841(int var1) {
		for (class205 var2 = (class205) this.field2528.field2601
				.getFront(); var2 != null; var2 = (class205) this.field2528.field2601.getNext()) {
			if ((var1 < 0 || var2.field2563 == var1) && var2.field2571 < 0) {
				this.field2545[var2.field2563][var2.field2574] = null;
				var2.field2571 = 0;
			}
		}

	}

	public static Sequence getAnimation(int var0) {
		Sequence var1 = (Sequence) Sequence.sequences.get((long) var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = Sequence.seq_ref.getConfigData(12, var0);
			var1 = new Sequence();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.post();
			Sequence.sequences.put(var1, (long) var0);
			return var1;
		}
	}

	static final void method3924(boolean var0) {
		if (var0) {
			Client.field957 = class90.field1438 ? class149.field2207 : class149.field2212;
		} else {
			LinkedHashMap var1 = class23.preferences.preferences;
			String var3 = class90.username;
			int var4 = var3.length();
			int var5 = 0;

			for (int var6 = 0; var6 < var4; ++var6) {
				var5 = (var5 << 5) - var5 + var3.charAt(var6);
			}

			Client.field957 = var1.containsKey(Integer.valueOf(var5)) ? class149.field2210 : class149.field2209;
		}

	}
}
