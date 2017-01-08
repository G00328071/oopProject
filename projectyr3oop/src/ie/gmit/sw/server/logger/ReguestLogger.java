package ie.gmit.sw.server.logger;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import ie.gmit.sw.server.Request;


/**
 * @author Alan Doyle-G00328071
 * The Class ReguestLogger.
 */
public class ReguestLogger implements Runnable {
	
	/** variable fw. */
	private FileWriter fw;
	
	/** variable q. */
	private BlockingQueue q;
	 
	
	/**
	 * Instantiates a new reguest logger.
	 *
	 * @param q the q
	 */
	public ReguestLogger(BlockingQueue q) {
		
		this.q = q;
		
		try {
			fw = new FileWriter(new File("log.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 
	
	
	public void run() {
		while(true){
			try {
				Request r = (Request) q.take();
				fw.write(r.toString());
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}
 

}
