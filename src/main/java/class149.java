import net.runelite.rs.Opcodes;

public enum class149 implements RSEnum {

	field2210(2, 0),

	field2207(3, 1),

	field2209(0, 2),

	field2212(1, 3);

	final int field2208;

	public final int field2211;

	static IndexedSprite[] field2214;

	class149(int var3, int var4) {
		this.field2211 = var3;
		this.field2208 = var4;
	}

	public int rsOrdinal() {
		return this.field2208;
	}

	static void method2996() {
		Client.secretPacketBuffer1.offset = 0;
		Client.secretPacketBuffer2.offset = 0;
		Client.packetType = -1;
		Client.lastFrameId = -1;
		Client.secondLastFrameId = -1;
		Client.thridLastFrameId = -1;
		Client.packetLength = 0;
		Client.field969 = 0;
		Client.field983 = 0;
		Client.menuOptionCount = 0;
		Client.isMenuOpen = false;
		Client.field1183 = 0;
		Client.destinationX = 0;

		int var0;
		for (var0 = 0; var0 < 2048; ++var0) {
			Client.cachedPlayers[var0] = null;
		}

		AbstractByteBuffer.localPlayer = null;

		for (var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
			NPC var1 = Client.cachedNPCs[var0];
			if (var1 != null) {
				var1.interacting = -1;
				var1.field1234 = false;
			}
		}

		ItemContainer.itemContainers = new HashTable(32);
		FrameMap.setGameState(30);

		for (var0 = 0; var0 < 100; ++var0) {
			Client.field1118[var0] = true;
		}

		Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_RESIZE_CLIENT_FRAME);
		Client.secretPacketBuffer1.putByte(class19.method142());
		Client.secretPacketBuffer1.putShort(class60.canvasWidth);
		Client.secretPacketBuffer1.putShort(class48.canvasHeight);
	}
}
