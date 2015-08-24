package exel.saveXml;

import java.io.File;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SaveXmlImpl implements SaveXml {

	@Override
	public void saveXml(String name, Map<String, String> mapPro) {
		try {
			File fXmlFile = new File (name);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document doc = documentBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
			
			System.out.println("Dokument doc " + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("product");
			
			for(int i = 0 ; i<nList.getLength() ; i++){
				
				Node nod = nList.item(i);
				Element element = (Element) nod;
				element.setAttribute("price", mapPro.get(i));
				
			}
			
			TransformerFactory transformerr = TransformerFactory.newInstance();
			   Transformer transformer = transformerr.newTransformer();
	            DOMSource source = new DOMSource(doc);
	            StreamResult result = new StreamResult(System.out);
	            transformer.transform(source, result);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
