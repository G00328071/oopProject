/**
 *@author Alan Doyle-G00328071 
 */
package ie.gmit.sw.Client.config;
import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Connection.
 */
public class Connection {

	

		/** The request socket. */
		//54.245.158.25
			Socket requestSocket;
			
			/** The out. */
			ObjectOutputStream out;
		 	
	 		/** The in. */
	 		ObjectInputStream in;
		 	
	 		/** The message. */
	 		String message="";
		 	
	 		/** The ipaddress. */
	 		String ipaddress;
		 	
	 		/** The stdin. */
	 		Scanner stdin;
		 	
	 		/**
	 		 * Instantiates a new connection.
	 		 */
	 		Connection(){}
			
			/**
			 * Run.
			 */
			void run()
			{
				stdin = new Scanner(System.in);
				try{
					//1. creating a socket to connect to the server
					System.out.println("Please Enter your IP Address");
					ipaddress = stdin.next();
					requestSocket = new Socket(ipaddress, 7777);
					System.out.println("Connected to "+ipaddress+" in port 2004");
					//2. get Input and Output streams
					out = new ObjectOutputStream(requestSocket.getOutputStream());
					out.flush();
					in = new ObjectInputStream(requestSocket.getInputStream());
					System.out.println("Hello");
					//3: Communicating with the server
					do{
						try
						{
								
								message = (String)in.readObject();
								System.out.println("Please Enter the Message to send...");
								message = stdin.next();
								sendMessage(message);
								
								
								
						}
						catch(ClassNotFoundException classNot)
						{
							System.err.println("data received in unknown format");
						}
					}while(!message.equals("bye"));
				}
				catch(UnknownHostException unknownHost){
					System.err.println("You are trying to connect to an unknown host!");
				}
				catch(IOException ioException){
					ioException.printStackTrace();
				}
				finally{
					//4: Closing connection
					try{
						in.close();
						out.close();
						requestSocket.close();
					}
					catch(IOException ioException){
						ioException.printStackTrace();
					}
				}
			}
			
			/**
			 * Send message.
			 *
			 * @param msg the msg
			 */
			void sendMessage(String msg)
			{
				try{
					out.writeObject(msg);
					out.flush();
					System.out.println("client>" + msg);
				}
				catch(IOException ioException){
					ioException.printStackTrace();
				}
			}
			
			/**
			 * The main method.
			 *
			 * @param args the arguments
			 */
			public static void main(String args[])
			{
				Connection client = new Connection();
				client.run();
			}
		
		
		

	}// class

	
	
	
	
	
	
	
	
	
	

