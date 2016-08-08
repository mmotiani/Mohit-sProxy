import java.io.*;
import java.net.*;
import java.util.*;

public class server 
{
	public static void main(String args[]) throws IOException
	{
		try
		{
			//Variable declaration
			int number;
			int temp;
			
			// Create server socket
			ServerSocket ss = new ServerSocket(2016);
			System.out.println("Waiting for the data from Mohit's Proxy...");
			Socket sock = ss.accept();
			System.out.println();
			System.out.println("Recevied data from Mohit's Proxy....");
			
			//Accept data from Proxy (Client for server) and perform computation
			Scanner sc = new Scanner(sock.getInputStream());
			number = sc.nextInt();
			temp = number*2;
			
			//Send data back to Proxy (client for server) 
			PrintStream p = new PrintStream(sock.getOutputStream());
			System.out.println();
			System.out.println("Computation performed");
			System.out.println();
			System.out.println("Sending data back to Mohit's Proxy...");
			p.println(temp);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
