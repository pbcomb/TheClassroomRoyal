
//public class Rolls  extends Classroom   {
	public class Rolls    {
		private static int whatlvl = 1;

/*
public Rolls(BattlePanel bp) {
	super(bp);
	// TODO Auto-generated constructor stub
}
*/

public static int attkRoll(int str, int dex) {
	if (crit(dex) == true) {
	return (int)(((str * 2) * Math.random() + str/2)) * 4;
	} else
		return (int)((str * 1.5) * Math.random() + str/2);
		
}
public static int attkRolle(int str) {
	if (crite() == true) {
	return (int)(((str * 2) * Math.random() + str/2)) * 4;
	} else
		return (int)((str * 1.5) * Math.random() + str/2);
		
}

private static boolean crite() {
	if ((int)((100) * Math.random() + 1 ) == 99) {
		BattleFight.upisnot.setText("Enemy Critical Hit! Dealt 4x normal damage");
		System.out.println("Critical Hit! Dealt 4x regular damage");
		return true;
	}
	else
		return false;
}

private static boolean crit(int dex) {
	if ((int)((100) * Math.random()  ) >= 99 - dex) {
		BattleFight.upisnot.setText("Critical Hit! Dealt 4x normal damage");
		System.out.println("Critical Hit! Dealt 4x regular damage");
		return true;
	}
	else
		return false;
}

public static boolean dodge(int dex, int edex) {
	if ( ((50 + dex ) * Math.random() + dex) - (edex / 2)  >= 75 - dex) {
	
			//(100 + dex) * Math.random() + 5 
		return true;
	} else
		return false;
}

public static void getExp() {
	Classroom.thep.exp += (int)(70 * Math.random() + 10);
		if ( Classroom.thep.exp >= Classroom.thep.maxexp ) {
			whatlvl++;
			Classroom.thep.str++;
			Classroom.thep.vit++;
			Classroom.thep.def++;
			Classroom.thep.dex++;
			Classroom.thep.maxhp += (Classroom.thep.vit * 3);
			Classroom.thep.health += 50;
			Classroom.thep.maxexp += 100;
			Classroom.thep.exp = 0;
			BattleFight.updatelvl(whatlvl);
			BattleFight.upisnot.setText("You Have Leveled Up! All stats increased by one and restored 50 health points");
		}
}


}