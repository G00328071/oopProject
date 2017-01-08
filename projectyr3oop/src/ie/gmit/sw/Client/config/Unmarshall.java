package ie.gmit.sw.Client.config;

import javax.xml.bind.*;
import java.io.*;

public class Unmarshall {

	public void Unmarshall() {
		
		try {

			InputStream file = new FileInputStream("config.xml");

			JAXBContext jaxc = JAXBContext.newInstance(ClientConfig.class);

			Unmarshaller um = jaxc.createUnmarshaller();

			ClientConfig cf = (ClientConfig) um.unmarshal(file);

			String user= cf.getUsername();
			System.out.println("username : " + user);
			
			
			System.out.println("host : " + cf.getHost());
			//cf.setHost(host);
			System.out.println("port : " + cf.getPort());
			//cf.setPort(port);
			
			System.out.println("dir : " + cf.getDir());
		} catch (JAXBException e) {

			System.out.println("" + e.getMessage());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
