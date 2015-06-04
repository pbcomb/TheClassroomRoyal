import java.awt.Color;


public class ClassBattle   {
	private Object x;
private BattlePanel bp;

//public ClassBattle() {
	
//}

	public ClassBattle(BattlePanel bp) {
	this.bp = bp;
	System.out.println("delfdfi");
	
	}
	
	public Object findClass() {
	if (bp.getDel()) {
		 x = new Delinquent();
		 System.out.println("deli");
		 return x;
		 	} 
	

	else if (bp.getStu()) {
		x = new Student();
		System.out.println("pizza");
		return x;
	 } 
		
	
else if (bp.getPea()){
		x = new Peasant();
		System.out.println("sandwich");
		return x;

}	else
	return null;
	 
	 
	}	

	public Object getclass() {
		return x;
	}
}
