/**
 * @author Alan Doyle-G00328071
 */
package ie.gmit.sw.Client.config;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * The Class XmlParser.
 */
public class XmlParser {
	private String username;
	private String ipAddress;

	private Node port;

	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	ArrayList<String> list = new ArrayList<>(); 

	public void XmlParser() {

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("config.xml");
			NodeList clientList = doc.getElementsByTagName("client-config");
			for (int i = 0; i < clientList.getLength(); i++) {
				Node l = clientList.item(i);

				if (l.getNodeType() == Node.ELEMENT_NODE) {
					Element item = (Element) l;
					username = item.getAttribute("username");
					//System.out.println("username : " + username);

					NodeList childNodes = item.getChildNodes();

					for (int j = 0; j < childNodes.getLength(); j++) {
						Node n = childNodes.item(j);

						if (n.getNodeType() == Node.ELEMENT_NODE) {
							Element element = (Element) n;

						 list.add(element.getTextContent());
						
							

						}
					}

				}
			}
		} catch (ParserConfigurationException e) {

			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

}
