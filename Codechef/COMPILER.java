import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

public class COMPILER {
	public static void main(String[] args) throws Exception {
		//Scanner scan = new Scanner(System.in);
		Scanner scan  = new Scanner( new DataInputStream(
				new FileInputStream("..\\problemsolvingrepository\\Codechef\\io\\COMPILER.txt")));
		int T  =  scan.nextInt();
		while(T-- > 0){
		    String s = scan.next();
		    int count = 0, temp  =  0;
		    for(int i = 0; i < s.length(); i++){
		        char ch = s.charAt(i);
		        temp = (ch == '<')? temp + 1 : temp - 1;
		        
		        if(temp<0)
		            break;		        
		        if(temp == 0)
		            count  =  i+1;		       
		    }
		    if(temp == 0)
	            count = s.length();
	        
		    System.out.println(count);
		}
	}
	

}
