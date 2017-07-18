package access;

class Connection{
	Connection(){}
	
	private static int counter = 0;
	private int id = counter++;
	public String toString(){
		return "Connection "+id;
	}
	public void doSomething(){}
}

public class ConnectionManager {

	private static Connection[] pool = new Connection[10];
	private  static int counter = 0;
	static{
		for(int i = 0; i < pool.length; i++)
			pool[i] = new Connection();
	}
	public static Connection getConnection(){
		if(counter < pool.length)
			return pool[counter++];
		else 
			return null;
	}
	public static void main(String[] args){
		Connection c = ConnectionManager.getConnection();
		while(c != null) {
			System.out.println(c);
			c.doSomething();
			c = ConnectionManager.getConnection();
			}
	}

}
