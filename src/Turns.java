import java.awt.Color;


public class Turns {
	public int whatturn = 0;
	public boolean eneisdead;
	public boolean pisdead;
	private boolean isDodge = false;
	private boolean waitagain;
	public static int x = 0;
	private int ppw;
	
	

 public void evaded() {
	 if( whatturn % 2 == 0) { 
		 whatturn++; 
		 BattleFight.upisnot.setText("");
		 waitagain = false;
		 if (Rolls.dodge(Classroom.thep.dex, Classroom.thug.dex)) {
			 isDodge = true;
		 }
		 BattleFight.updateHp();
		 execAttk(); 
	 }


}
 
public void pwait() {
	if (whatturn % 2 == 0)
	whatturn++;
	 BattleFight.upisnot.setText("");
	if (waitagain == false) {
		double healamt = (((double)Classroom.thep.maxhp - (double)Classroom.thep.health ) * (.3 * Math.random() + .07) );
	Classroom.thep.health += healamt;
	System.out.println(healamt);
	BattleFight.upisnot.setText("Healed " + (int)healamt + " Health Points");
	waitagain = true;
	 BattleFight.updateHp();
	 Player.checkHp();
	} 
	else if (waitagain == true) {
		BattleFight.upisnot.setText("You cannot wait again!");
	}
		execAttk();
}
 public void attk() {
	 if (whatturn % 2 == 0) {
		 whatturn++;
		 BattleFight.upisnot.setText("");
		 waitagain = false;
		  x = Rolls.attkRoll(Classroom.thep.str, Classroom.thep.dex) + Classroom.thug.def;
		 Classroom.thug.health -= x;
		 BattleFight.updateMessage("You dealt " + x + " damage");
		 if (Classroom.thug.health <= 0) {
			 ppw++;
			 Rolls.getExp();
			 BattleFight.pdefeated.setText("Classmates Defeated : " + ppw);
			 BattleFight.removeEnemy();
			 BattleFight.updateExp();
			 Classroom.thug.vit++;
			 Classroom.thug.dex++;
			 Classroom.thug.def++;
			 Classroom.thug.str++;
			 Classroom.thug.health = 60 + (Classroom.thug.vit * 3);
			 Classroom.thug.health += 20;
			 Classroom.thug.maxhp = Classroom.thug.health;
		 }
			 System.out.println("Enemy Health " + Classroom.thug.health); 
			 execAttk();
		 
		 
			
		 }
	 
 }
	 private void execAttk() { 
		 whatturn++;
		 if (isDodge == false) {
			 int y = Rolls.attkRolle(Classroom.thug.str) + Classroom.thep.def;
		 Classroom.thep.health -= y;
		 checkDead();
		 if (BattleFight.sawyerSummoned == false ) {
		 BattleFight.updateMessage("You took " + y + " points of damage" + " and dealt " + x + " points of damage!");
		 }
		 else if (BattleFight.sawyerSummoned == true) {
			 BattleFight.updateMessage("You face DSawyer, the Computer Science Teacher of Methacton ");
		 } 
		 BattleFight.updateEhp();
		 BattleFight.updateHp();
		 System.out.println(" P health: " + Classroom.thep.health );
		 
		 
		 
		 } else if (isDodge == true) { 
			 BattleFight.updateMessage("You have successfully dodged!");
			 Classroom.thep.health += Classroom.thep.dex * 4;
			 Classroom.thep.checkHp();  
			BattleFight.updateHp();
			
			// BattleFight.updateEhp();
			 System.out.println(Classroom.thep.health);
			 isDodge = false;
			 System.out.println("perfect dodge");
		 }
	 }
	 public void checkDead() {
		  if (Classroom.thep.health <= 0) {
			  Classroom.thep.health = 0;
			  BattleFight.lvl.setVisible(false);
			  BattleFight.upisnot.setVisible(false);
			  BattleFight.myname.setVisible(false);
			  BattleFight.btnAtk.setVisible(false);
			  BattleFight.btnEva.setVisible(false);
			  BattleFight.btnWait.setVisible(false);
			  BattleFight.hp.setVisible(false);
			  BattleFight.ehp.setVisible(false);
			  BattleFight.mexp.setVisible(false);
			  BattleFight.message.setVisible(false);
			  BattleFight.enemyNameTag.setVisible(false);
			 
			  BattleFight.loss.setVisible(true);

			
 }
	 }
}
