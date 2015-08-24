package exel.readXml;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXmlImpl implements ReadXml {
	
	private Map<String, String> mapProduct = new HashMap<String, String>();

	@Override
	public Map<String, String> readXml(String file) {
				
		try {
			File fXmlFile = new File (file);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document doc = documentBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
			
			System.out.println("Dokument doc " + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("product");
			
			for(int i = 0 ; i<nList.getLength() ; i++){
				
				Node nod = nList.item(i);
				Element element = (Element) nod;	
				mapProduct.put(element.getAttribute("idx"), element.getAttribute("price"));
				
			}
			
			System.out.println(mapProduct.size());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapProduct;

	}
	
	

}
