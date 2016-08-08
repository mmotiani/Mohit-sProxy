import java.io.*;
import java.net.*;
import java.util.*;

public class client {
	public static void main(String args[]) throws IOException{
		try{
		
			//Variable declaration
			int number;
			int temp;
			
			//Input from Keyboard
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the number:: ");
			number = sc.nextInt(); 
			
			//create socket connection
			Socket sock = new Socket("127.0.0.1", 7766);
			
			//Send data to the Proxy (server for this client)
			PrintStream p = new PrintStream(sock.getOutputStream());
			p.println(number);
			System.out.println();
			
			//Receive data from proxy (server for this client)
			Scanner ssock = new Scanner(sock.getInputStream());
			temp = ssock.nextInt();
			System.out.println("Result = " + temp);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
