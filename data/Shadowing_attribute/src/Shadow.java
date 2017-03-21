import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
public class Shadow {
	static String firstName = "Wrong";
	 public static void main(String[] args) throws Exception {
		 String P = "";
		 Assign AN = new Assign();
		 P = AN.returnName(P);
		 setName("Correct");
		 System.out.println(firstName);
	 }
	 static public void setName(String firstName) {
		 String a = "Correct";
		 firstName = a;
		 
	 }
}
