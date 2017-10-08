
public class class90 {

	static int field1419;

	static int loginWindowX;

	static int[] field1418;

	static int loginIndex;

	static int field1423;

	static int field1420;

	static int field1421;

	static int field1441;

	static int field1413;

	static int field1422;

	static int loadingBarPercentage;

	static String loadingText;

	static String field1428;

	static String loginMessage1;

	static String loginMessage2;

	static String loginMessage3;

	static String username;

	static String password;

	static boolean worldSelectShown;

	static boolean field1414;

	static boolean field1435;

	static boolean field1436;

	static boolean field1438;

	static int field1439;

	static int field1429;

	static IndexedSprite logoSprite;

	static IndexedSprite field1411;

	static IndexedSprite field1412;

	static String field1437;

	static IndexedSprite field1415;

	static IndexedSprite[] titlemuteSprite;

	static boolean field1409;

	static {
		field1419 = 0;
		loginWindowX = field1419 + 202;
		field1418 = new int[256];
		field1423 = 0;
		field1420 = 0;
		field1421 = 0;
		field1441 = 0;
		field1413 = 0;
		field1422 = 0;
		loadingBarPercentage = 10;
		loadingText = "";
		loginIndex = 0;
		field1428 = "";
		loginMessage1 = "";
		loginMessage2 = "";
		loginMessage3 = "";
		username = "";
		password = "";
		field1414 = false;
		field1435 = false;
		field1436 = false;
		field1438 = true;
		field1439 = 0;
		worldSelectShown = false;
		field1429 = -1;
	}

	public static String method1796(int var0) {
		return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
	}
}
