package ie.gmit.sw.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import ie.gmit.sw.client.config.ClientConfig;
import ie.gmit.sw.client.config.UnmarshallParser;

/**
 * The Class Client.
 */
public class Client {

	/** declare a socket request. */
	Socket requestSocket;

	/** declare ObjectOutputStream out. */
	ObjectOutputStream out;

	/** The in. */
	ObjectInputStream in;

	/** The message. */
	String message = "";

	/** The ipaddress. */
	String ipaddress;

	/** The stdin. */
	Scanner stdin;

	/**
	 * Instantiates a new client.
	 */
	Client() {
	}

	/**
	 * Run.
	 *
	 * @throws UnknownHostException
	 *             the unknown host exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	void run() throws UnknownHostException, IOException {
		stdin = new Scanner(System.in);

		ClientConfig parse = new ClientConfig();
		UnmarshallParser parseXML = new UnmarshallParser(parse);
		parseXML.Unmarshall();

		ipaddress = parse.getHost();
		int port = parse.getPort();

		// 3: Communicating with the server
		do {

			System.out.println("1. Connect to Server");
			System.out.println("2. Print File Listing");
			System.out.println("3. Download File");
			System.out.println("4. Quit");
			System.out.println("\nType Option [1-4]");

			message = stdin.next();

			if (message.compareTo("1") == 0) {

				// 1. creating a socket to connect to the server

				requestSocket = new Socket(ipaddress, port);
				System.out.println("Connected to " + ipaddress + " port " + port);

				// 2. get Input and Output streams
				out = new ObjectOutputStream(requestSocket.getOutputStream());
				out.flush();
				in = new ObjectInputStream(requestSocket.getInputStream());

			}

			if (message.compareTo("4") == 0) {

				sendMessage("bye");

			}

			// message = (String)in.readObject();
			// System.out.println("Please Enter the Message to send...");
			// message = stdin.next();
			// sendMessage(message);
			//

		} while (!message.equals("4"));

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
	 * @throws UnknownHostException
	 *             the unknown host exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void main(String args[]) throws UnknownHostException, IOException {
		Client client = new Client();
		client.run();
	}
}