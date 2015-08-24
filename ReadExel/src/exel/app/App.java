package exel.app;

import java.util.Map;

import CompareList.CompareList;
import CompareList.ComparePriceImpl;
import exel.read.ReadExel;
import exel.read.ReadExelImpl;
import exel.readXml.ReadXml;
import exel.readXml.ReadXmlImpl;
import exel.saveXml.SaveXml;
import exel.saveXml.SaveXmlImpl;

public class App {
	

	public static void main(String[] args) {
		Map<String, String> mapProduct;
		Map<String, String> mapPrice;
		
		ReadXml xmlRead = new ReadXmlImpl();
		ReadExel exelRead = new ReadExelImpl();
		CompareList comparePrice = new ComparePriceImpl();
		SaveXml saveXml = new SaveXmlImpl();
		
		mapProduct = xmlRead.readXml("canon.xml");
/*		for(String key : mapProduct.keySet()){
			System.out.println( key +"  ---  "+mapProduct.get(key));
		}*/
		mapPrice = exelRead.readExel("price_test.xls");
		
		comparePrice.comparePrice(mapProduct, mapPrice);
		
		for(String key : mapProduct.keySet()){
			System.out.println( key +"  ---  "+mapProduct.get(key));
		}
		
		saveXml.saveXml("canon.xml", mapProduct);
		

	}

}
