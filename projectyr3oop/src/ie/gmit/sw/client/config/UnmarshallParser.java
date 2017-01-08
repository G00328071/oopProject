package ie.gmit.sw.client.config;

import javax.xml.bind.*;

import java.io.*;

/**
 * @author Alan Doyle-G00328071
 * The Class UnmarshallParser.
 */
public class UnmarshallParser {

	/** The parse. */
	ClientConfig parse;

	/**
	 * Instantiates a new unmarshall parser.
	 *
	 * @param parse
	 *           
	 */
	public UnmarshallParser(ClientConfig parse) {
		this.parse = parse;
	}

	/**
	 * Unmarshall.
	 * parses the config file.
	 */
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
