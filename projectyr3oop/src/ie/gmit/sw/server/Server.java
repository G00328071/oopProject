/**
 * Author Alan Doyle-G00328071
 */
package ie.gmit.sw.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The Class Server.
 */
public class Server {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
	public static void main(String[] args) throws Exception {
		/**
		 * create a new server socket on port 7777 and max of 10 threads
		 * 
		 */
		ServerSocket m_ServerSocket = new ServerSocket(7777, 10);
		int id = 0;
		while (true) {
			Socket clientSocket = m_ServerSocket.accept();
			/**
			 * new instance of ClientServiceThread class.
			 * create a new client thread
			 * and start the thread
			 */
			ClientServiceThread cliThread = new ClientServiceThread(clientSocket, id++);
			cliThread.start();
		}
	}
}

class ClientServiceThread extends Thread {

	/** declares a client socket. */
	Socket clientSocket;
	String message;
	int clientID = -1;
	boolean running = true;
	ObjectOutputStream out;
	ObjectInputStream in;

	ClientServiceThread(Socket s, int i) {
		clientSocket = s;
		clientID = i;
	}

	/**
	 * Send message method.
	 *
	 * @param msg
	 * 
	 */
	void sendMessage(String msg) {
		try {
			out.writeObject(msg);
			out.flush();
			System.out.println("client> " + msg);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	/**
	 * run method.
	 * 
	 */

	public void run() {
		System.out.println(
				"Accepted Client : ID - " + clientID + " : Address - " + clientSocket.getInetAddress().getHostName());
		try {
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(clientSocket.getInputStream());
			System.out.println("Accepted Client : ID - " + clientID + " : Address - "
					+ clientSocket.getInetAddress().getHostName());

			sendMessage("Connection successful");
			do {
				try {

					System.out.println("client>" + clientID + "  " + message);

					sendMessage("server got the following: " + message);
					message = (String) in.readObject();

				} catch (ClassNotFoundException classnot) {
					System.err.println("Data received in unknown format");
				}
				/**
				 * keep alive until message "bye" received
				 */
			} while (!message.equals("bye"));

			System.out.println(
					"Ending Client : ID - " + clientID + " : Address - " + clientSocket.getInetAddress().getHostName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
