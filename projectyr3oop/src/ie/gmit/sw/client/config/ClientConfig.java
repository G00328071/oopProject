package ie.gmit.sw.client.config;

import javax.xml.bind.annotation.*;

/**
 * @author Alan Doyle-G00328071
 * The Class ClientConfig.
 * Bean class
 */
@XmlRootElement
public class ClientConfig {

	/** variable username. */
	private String username;

	/** variable host. */
	private String host;

	/** variable port. */
	private int port;

	/** variable dir. */
	private String dir;

	/**
	 * Instantiates a new client config.
	 */
	public ClientConfig() {

	}

	/**
	 * Instantiates a new client config.
	 * constructor with fields
	 * @param username
	 *            
	 * @param host
	 *            
	 * @param port
	 *           
	 * @param dir
	 *            
	 */
	public ClientConfig(String username, String host, int port, String dir) {

		this.username = username;
		this.host = host;
		this.port = port;
		this.dir = dir;
	}

	/**
	 * Getter username.
	 *	return fron xml file username
	 * @return the username
	 */
	@XmlAttribute
	public String getUsername() {
		return username;
	}

	/**
	 * Setter username.
	 *
	 * @param username
	 *            the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter the host.
	 *
	 * @return the host
	 */
	@XmlElement
	public String getHost() {
		return host;
	}

	/**
	 * Setter host.
	 *
	 * @param host
	 *           
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	@XmlElement
	public int getPort() {
		return port;
	}

	/**
	 * Setter port.
	 *
	 * @param port
	 *          
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * Getter dir.
	 *
	 * @return the dir
	 */
	@XmlElement
	public String getDir() {
		return dir;
	}

	/**
	 * Setter dir.
	 *
	 * @param dir
	 *            
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}

}