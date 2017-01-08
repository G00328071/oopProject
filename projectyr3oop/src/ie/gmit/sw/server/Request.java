package ie.gmit.sw.server;

import java.io.Serializable;
import java.sql.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * The Class Request.
 */
public class Request implements Serializable {
	
	
	/** variables command. */
	private String command;
	
	/** variables host. */
	private String host;
	
	/** variable date d. */
	private Date d;
	
	/** Instantiate blocking  queue. */
	BlockingQueue<Request> queue = new ArrayBlockingQueue<>(7);
	//new Thread(new RequestLogger(q).start());
	
	/**
	 * Instantiates a new request.
	 *
	 * @param command the command
	 * @param host the host
	 * @param d the d
	 */
	public Request(String command, String host, Date d) {
		super();
		this.command = command;
		this.host = host;
		this.d = d;
	}

	
	/**
	 * Getter command
	 *
	 * @return  command
	 */
	public String getCommand() {
		return command;
	}

	
	/**
	 * Setter command.
	 *
	 * @param command the new command
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	
	/**
	 * Gets the host.
	 *
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	
	/**
	 * Sets the host.
	 *
	 * @param host the new host
	 */
	public void setHost(String host) {
		this.host = host;
	}

	
	/**
	 * Gets the date.
	 *
	 * @return the d
	 */
	public Date getD() {
		return d;
	}

	
	/**
	 * Sets the date
	 *
	 * @param d the new d
	 */
	public void setD(Date d) {
		this.d = d;
	}
	
	

}
