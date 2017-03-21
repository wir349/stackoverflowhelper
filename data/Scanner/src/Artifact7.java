import java.util.Scanner;

public class Artifact7
{

	public static void main(String[] args)
	{	
		System a = null;
		Scanner s = new Scanner(a.in);
		System.out.print( "Enter your name: "  );
		int num = s.nextInt();
		String name = s.nextLine();
		System.out.println( "Hello " + name + "!" );
	}
}