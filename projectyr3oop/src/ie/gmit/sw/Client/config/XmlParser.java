package ie.gmit.sw.Client.config;


	import java.io.IOException;

	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.parsers.ParserConfigurationException;

	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	import org.w3c.dom.Node;
	import org.w3c.dom.NodeList;
	import org.xml.sax.SAXException;

	public class XmlParser {
		public static void main(String[] args) {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse("config.xml");
				NodeList clientList = doc.getElementsByTagName("client-config");
				for(int i = 0; i < clientList.getLength(); i++){
					Node l = clientList.item(i);
					if(l.getNodeType() == Node.ELEMENT_NODE){
						Element item = (Element) l;
						String username = item.getAttribute("username");
						NodeList childNodes = item.getChildNodes();
						System.out.println("username : "+ username );
						for(int j = 0; j<childNodes.getLength();j++){
							Node n = childNodes.item(j);
							
							if(n.getNodeType()== Node.ELEMENT_NODE){
								Element element = (Element) n;
								System.out.println( element.getTagName()+ " : " +element.getTextContent());
								
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

	}


