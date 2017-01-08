package ie.gmit.sw.Client.config;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class ClientConfig {
	
	private String username;
	private String host;
	private int port;
	private String dir;
	
	public ClientConfig() {
		
	}
	
	
	public ClientConfig(String username, String host, int port, String dir) {
	
		this.username = username;
		this.host = host;
		this.port = port;
		this.dir = dir;
	}

	@XmlAttribute
	public String getUsername() {
		return username;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@XmlElement
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	@XmlElement
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	@XmlElement
	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
	
	
	
	
	
}