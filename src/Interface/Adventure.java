package Interface;
import static net.mindview.util.Print.print;

interface CanFight{
	void fight();
}

interface CanSwim{
	void swim();
}

interface CanFly{
	void fly();
}

interface CanClimb{
	void climb();
}

class ActionCharacter{
	public void fight(){};
}

class Hero extends ActionCharacter implements CanFight,CanSwim,CanFly,CanClimb{


	
	@Override
	public void fly() {}

	@Override
	public void swim() {}

	@Override
	public void climb() {
		// TODO Auto-generated method stub
		
	}

	
}

public class Adventure {
	public static void t(Hero x){
		x.fight();
	}
	public static void main(String[] args){
		ActionCharacter ac = new Hero(); 
		ac.fight();
		CanFight cf = new Hero();
		cf.fight();
	}
	

}
