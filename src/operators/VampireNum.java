package operators;

public class VampireNum {
	public static void main(String[] args){
		for(int i=1000;i<10000;i++){
		int a ,b,c,d;
		if (i % 100 == 0) {  
            continue;  
        }  
		a = i%10;
		b = i%100-10*a;
		c = i%1000-100*b-10*a;
		d = i/1000;
		if(c==b+c+d||d==b+c+d){
			continue;
		}
		}
	}
}
