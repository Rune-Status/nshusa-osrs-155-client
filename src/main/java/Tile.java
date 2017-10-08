public final class Tile extends Node {

	GameObject[] objects;

	int[] entityFlags;

	SceneTilePaint paint;

	ItemLayer itemLayer;

	DecorativeObject decorativeObject;

	WallObject wallObject;

	int entityCount;

	GroundObject groundObject;

	int flags;

	SceneTileModel overlay;

	boolean visible;

	int plane;

	int physicalLevel;

	int x;

	int y;

	int renderLevel;

	Tile bridge;

	boolean draw;

	int wallCullDirection;

	boolean drawEntities;

	int wallUncullDirection;

	int wallDrawFlags;

	int wallCullOppositeDirection;

	Tile(int var1, int var2, int var3) {
		this.objects = new GameObject[5];
		this.entityFlags = new int[5];
		this.flags = 0;
		this.renderLevel = this.plane = var1;
		this.x = var2;
		this.y = var3;
	}
}
