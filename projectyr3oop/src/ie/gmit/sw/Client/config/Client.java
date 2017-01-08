/**
 *@author Alan Doyle-G00328071 
 */
package ie.gmit.sw.Client.config;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	Socket requestSocket;
	ObjectOutputStream out;
	ObjectInputStream in;
	String message = "";

	String ipaddress;
	String port;

	Scanner stdin;

	Client() {
	}

	void run() {
		stdin = new Scanner(System.in);

		try {

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

	void sendMessage(String msg) {
		try {
			out.writeObject(msg);
			out.flush();
			System.out.println("client>" + msg);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	public static void main(String args[]) {
		final int sentinal = 4;
		int choice = 0;

		Scanner console = new Scanner(System.in);

		/*
		 * Connection client = new Connection(); System.out.println(
		 * "Please enter choice\n\n(1) Connect to server \n(2) Print File listing \n(3) Download File \n(4) Quit "
		 * ); choice = console.nextInt(); while (choice != sentinal) {
		 * 
		 * if (choice == 1) {
		 * 
		 * client.run();
		 * 
		 * } else if (choice == 2) {
		 * 
		 * } else if (choice == 3) {
		 * 
		 * } else if (choice == 4) {
		 * 
		 * client.sendMessage("bye"); } System.out.println(
		 * "Please enter choice\n\n(1) Connect to server \n(2) Print File listing \n(3) Download File \n(4) Quit "
		 * ); choice = console.nextInt(); }
		 */

		Unmarshall u = new Unmarshall();
		u.Unmarshall();
	
		

	}

}// class
