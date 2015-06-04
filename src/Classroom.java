public class Classroom extends ClassBattle {

	public static Player thep;
	public static Enemy thug;

	public Object p;

	public Classroom(BattlePanel bp) { 
		super(bp);

		p = findClass(); // gets the class from the classbattle
		
		if (p instanceof Peasant) {
			thep = new Player(12, 12, 12, 12); // str, vit, def, dex
		} else if (p instanceof Delinquent) {

			thep = new Player(16, 26, 9, 6);
		}

		else if (p instanceof Student) {

			thep = new Player(11, 12, 10, 17);
		}

		thug = new Enemy(4, 4, 4, 4);
	}

	

}

