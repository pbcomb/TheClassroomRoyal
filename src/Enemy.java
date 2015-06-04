
public class Enemy {
	public int str;
	public int vit;
	public int def;
	public int dex;
	public int health;
	public int maxhp;
	
	public Enemy(int s, int v, int d, int dexl) {
		str = s;
		vit = v;
		def = d;
		dex = dexl;
		
		health = 65 + (vit * 3);
		maxhp = health;
	}
}
