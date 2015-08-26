package exel.readXml;

import java.io.File;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import exel.saveXml.SaveXml;
import exel.saveXml.SaveXmlImpl;

public class ReadXmlImpl implements ReadXml {

	private SaveXml saveXml;

	@Override
	public void readXml(String file, Map<Integer, String> mapPrice) {
		
		saveXml = new SaveXmlImpl();		
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
				NamedNodeMap model = nod.getAttributes();
				Node price = model.getNamedItem("price");
				
				Element element = (Element) nod;	
				Integer idx = Integer.parseInt(element.getAttribute("idx"));
				
				for(Integer key : mapPrice.keySet()){
					if(idx.equals(key)){
						price.setTextContent(mapPrice.get(key));
					}
				}
				
			}
			
			saveXml.saveXml("test.xml", doc);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	

}
