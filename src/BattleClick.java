import java.awt.Color;


public class BattleClick  {
private BattleFight bb;
private Turns pp = new Turns();
public BattleClick(BattleFight bf) {

	bb = bf;
	
	if (bb.pattk == true) {
		bb.pattk = false;
		pp.attk();
		
	}
	else if (bb.pevade == true) {
		bb.pevade = false;
		pp.evaded();
	}
	else if (bb.pwait == true) {
		bb.pwait = false;
		pp.pwait();
		
	}



}

}