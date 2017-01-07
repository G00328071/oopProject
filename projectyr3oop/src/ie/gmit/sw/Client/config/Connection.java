/**
 *@author Alan Doyle-G00328071 
 */
package ie.gmit.sw.Client.config;

import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * The Class Connection.
 */
public class Connection {

	/** The request socket. */

	Socket requestSocket;

	/** The out. */
	ObjectOutputStream out;

	/** The in. */
	ObjectInputStream in;

	/** The message. */
	String message = "";

	/** The ipaddress. */
	static String ipaddress;

	static String port;

	/** The stdin. */
	Scanner stdin;

	/**
	 * Instantiates a new connection.
	 */
	Connection() {
	}

	/**
	 * Run.
	 */
	void run() {
		stdin = new Scanner(System.in);
		/**
		 * instantiate xml parser
		 */
		XmlParser p = new XmlParser();
		p.XmlParser();
		/**
		 * set the ipaddress and the port from the xml file
		 */
		ipaddress = p.getList().get(0);
		port = p.getList().get(1);
		try {

			/**
			 * parse the port from a String to an int as required by the socket
			 */
			int portNo = Integer.parseInt(port);
			requestSocket = new Socket(ipaddress, portNo);
			System.out.println("Connected to " + ipaddress + " and " + portNo);
			// 2. get Input and Output streams
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			System.out.println("Hello");
			// 3: Communicating with the server
			do {
				try {
					
					
					

					message = (String) in.readObject();
					System.out.println("Please Enter the Message to send...");
					message = stdin.next();
					sendMessage(message);

					
					
					
					
					
				} catch (ClassNotFoundException classNot) {
					System.err.println("data received in unknown format");
				}
			} while (!message.equals("bye"));
		} catch (UnknownHostException unknownHost) {
			System.err.println("You are trying to connect to an unknown host!");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			// 4: Closing connection
			try {
				in.close();
				out.close();
				requestSocket.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
	}

	/**
	 * Send message.
	 *
	 * @param msg
	 *            the msg
	 */
	void sendMessage(String msg) {
		try {
			out.writeObject(msg);
			out.flush();
			System.out.println("client>" + msg);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String args[]) {
		final int sentinal = 4;
		int choice = 0;
		
		Scanner console = new Scanner(System.in);
		Connection client = new Connection();
		System.out.println(
				"Please enter choice\n\n(1) Connect to server \n(2) Print File listing \n(3) Download File \n(4) Quit ");
		choice = console.nextInt();
		while (choice != sentinal) {
			
			if(choice == 1){
				
				 client.run();
				
			}else if(choice == 2){
				
			}else if(choice == 3){
				
			}else if(choice == 4){
				
				client.sendMessage("bye");
			}
			System.out.println(
					"Please enter choice\n\n(1) Connect to server \n(2) Print File listing \n(3) Download File \n(4) Quit ");
			choice = console.nextInt();
		}

	}

}// class
