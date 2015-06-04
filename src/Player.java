
public class Player {
public int str;
public int vit;
public int def;
public int dex;
public static int health;
public int exp;
public static int maxhp = 250;
public int maxexp = 50;

public Player(int s, int v, int d, int dexl) {
	str = s;
	vit = v;
	def = d;
	dex = dexl;
	
	maxhp = 200 + (vit * 3);
	health = maxhp;
	System.out.println(health);
}
public static void checkHp() {
	if ( health > maxhp )
		health = maxhp;
}


}

