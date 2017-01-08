package ie.gmit.sw.client.config;

import javax.xml.bind.*;

import java.io.*;

public class UnmarshallParser {

	ClientConfig parse;

	public UnmarshallParser(ClientConfig parse) {
		this.parse = parse;
	}

	public void Unmarshall() {

		try {

			InputStream file = new FileInputStream("config.xml");

			JAXBContext jaxc = JAXBContext.newInstance(ClientConfig.class);

			Unmarshaller um = jaxc.createUnmarshaller();

			ClientConfig cf = (ClientConfig) um.unmarshal(file);

			parse.setUsername(cf.getUsername());
			parse.setHost(cf.getHost());
			parse.setPort(cf.getPort());
			parse.setDir(cf.getDir());

		} catch (JAXBException e) {

			System.out.println("" + e.getMessage());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
