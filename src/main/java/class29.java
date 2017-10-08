import java.io.IOException;

import net.runelite.rs.Opcodes;

public final class class29 {

	static IndexedSprite[] field432;

	static Task field435;

	static IndexedSprite field431;
	// $FF: synthetic field

	final class41 this$0;

	int field436;

	int field434;

	int field429;

	int field430;

	class29(class41 var1) {
		this.this$0 = var1;
	}

	static final void flush(boolean var0) {
		class28.method234();
		++Client.audioEffectCount;
		if (Client.audioEffectCount >= 50 || var0) {
			Client.audioEffectCount = 0;
			if (!Client.socketError && class268.rssocket != null) {
				Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_KEEPALIVE);

				try {
					class268.rssocket.queueForWrite(Client.secretPacketBuffer1.payload, 0,
							Client.secretPacketBuffer1.offset);
					Client.secretPacketBuffer1.offset = 0;
				} catch (IOException var2) {
					Client.socketError = true;
				}
			}

		}
	}

	static int method236(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == 5504) {
			class81.intStackSize -= 2;
			var3 = class81.intStack[class81.intStackSize];
			int var4 = class81.intStack[class81.intStackSize + 1];
			if (!Client.field1160) {
				Client.field921 = var3;
				Client.mapAngle = var4;
			}

			return 1;
		} else if (var0 == 5505) {
			class81.intStack[++class81.intStackSize - 1] = Client.field921;
			return 1;
		} else if (var0 == 5506) {
			class81.intStack[++class81.intStackSize - 1] = Client.mapAngle;
			return 1;
		} else if (var0 == 5530) {
			var3 = class81.intStack[--class81.intStackSize];
			if (var3 < 0) {
				var3 = 0;
			}

			Client.field1002 = var3;
			return 1;
		} else if (var0 == 5531) {
			class81.intStack[++class81.intStackSize - 1] = Client.field1002;
			return 1;
		} else {
			return 2;
		}
	}

	public static void method235(int var0, IndexDataBase var1, String var2, String var3, int var4, boolean var5) {
		int var6 = var1.getFile(var2);
		int var7 = var1.getChild(var6, var3);
		class203.field2521 = 1;
		class203.field2522 = var1;
		class203.field2520 = var6;
		Frames.field2138 = var7;
		class148.field2203 = var4;
		BufferProvider.field3778 = var5;
		class288.field3814 = var0;
	}
}
