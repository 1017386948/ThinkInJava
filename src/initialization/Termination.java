package initialization;
import static net.mindview.util.Print.*;

class Tank{
	String statu = "empty";
	Tank(String s){
		this.statu = s;
	}
	void pull(){
		statu = "empty";
	}
	protected void finalize(){
		if(statu=="empty")
			print("It's finalize.");
	}
}

public class Termination {
	public static void main(String[] args) throws InterruptedException{
		Tank t1 = new Tank("full");
		t1.pull();
		Tank t2 = new Tank("full");
		t1=t2=null;
		System.gc();
//		Thread.sleep(10000);
		while(true);
	}

}
