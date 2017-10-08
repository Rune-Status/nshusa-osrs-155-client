public final class Occluder {

	static byte clanChatRank;

	static int field2140;

	int testDirection;

	int minX;

	int minNormalX;

	int type;

	int minZ;

	int minTileX;

	int maxZ;

	int field2152;

	int maxNormalX;

	int minTileZ;

	int minY;

	int maxX;

	int minNormalY;

	int field2159;

	int maxY;

	int maxNormalY;

	int maxTileZ;

	int maxTIleX;

	public static ObjectComposition getObjectDefinition(int var0) {
		ObjectComposition var1 = (ObjectComposition) ObjectComposition.objects.get((long) var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
			var1 = new ObjectComposition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.post();
			if (var1.isSolid) {
				var1.interactType = 0;
				var1.field3456 = false;
			}

			ObjectComposition.objects.put(var1, (long) var0);
			return var1;
		}
	}
}
