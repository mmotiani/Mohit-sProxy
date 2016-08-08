import java.io.*;
import java.net.*;
import java.util.*;

public class proxy 
{
	public static void main(String args[]) throws IOException
	{
		try
		{
			int number;
			int temp;
			int var;
			
			//create server socket connection (server for actual client)
			ServerSocket ss = new ServerSocket(7766);
			System.out.println("waiting for the data from client...");
			Socket sock = ss.accept();
			System.out.println();
			
			//Receive data from client
			Scanner sc = new Scanner(sock.getInputStream());
			number = sc.nextInt();
			System.out.println("Received data from client at PORT:: "+ss.getLocalPort());
			System.out.println();
			
			//create socket connection (Client for actual server)
			Socket sock1 = new Socket("127.0.0.1", 2016);
			
			//send data to actual server which received data from actual client
			PrintStream p = new PrintStream(sock1.getOutputStream());
			System.out.println("Sending data to server at PORT:: "+sock1.getPort());
			p.println(number);
			System.out.println();
			
			//receive data from actual server
			Scanner sc1 = new Scanner(sock1.getInputStream());
			System.out.println("Receiving data back from server...");
			var = sc1.nextInt();
			System.out.println();
			
			//send data back to actual client which received from actual server
			PrintStream ps = new PrintStream(sock.getOutputStream());
			ps.println(var);
			System.out.println("Sending data back to client...which I recived from server..");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
