package exel.saveXml;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class SaveXmlImpl implements SaveXml {

	@Override
	public void saveXml(String name, Document doc) {

			
			TransformerFactory transformerr = TransformerFactory.newInstance();
			   
			try {
				 Transformer transformer;
				 transformer = transformerr.newTransformer();
				 DOMSource source = new DOMSource(doc);
		         StreamResult result = new StreamResult(new File(name));
		         transformer.transform(source, result);
		         
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           
			
			

		
	}

}
