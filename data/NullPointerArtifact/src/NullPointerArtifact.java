import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.io.*;
public class NullPointerArtifact {
	public static void main(String args[]) throws IOException {  
	      FileInputStream in = null;
	      FileOutputStream out = null;

	      try {
	         //in = new FileInputStream("input.txt");
	         out = new FileOutputStream("output.txt");
	         
	         char c;
	         int f1 = 0;
	         char a[] = new char[5];
	         while (f1 == 0) {
	        	c = a[4];
	            out.write(c);
	            GetNullClass n = new GetNullClass();
	            //String b = Character.toString(n.gore());
	            System.out.println(n.returnNull().toLowerCase());
	            f1 = 1;
	         }
	      }finally {
	         if (in != null) {
	            in.close();
	         }
	         if (out != null) {
	            out.close();
	         }
	      }
	   }
}