package ie.gmit.sw.server;

import java.io.Serializable;
import java.sql.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class Request.
 */
public class Request implements Serializable {
	
	
	private String command;
	private String host;
	private Date d;
	
	BlockingQueue<Request> queue = new ArrayBlockingQueue<>(7);
	//new Thread(new RequestLogger(q).start());
	
	public Request(String command, String host, Date d) {
		super();
		this.command = command;
		this.host = host;
		this.d = d;
	}

	
	public String getCommand() {
		return command;
	}

	
	public void setCommand(String command) {
		this.command = command;
	}

	
	public String getHost() {
		return host;
	}

	
	public void setHost(String host) {
		this.host = host;
	}

	
	public Date getD() {
		return d;
	}

	
	public void setD(Date d) {
		this.d = d;
	}
	
	

}
