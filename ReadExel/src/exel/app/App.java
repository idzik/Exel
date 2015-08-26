package exel.app;

import java.util.Map;

import exel.read.ReadExel;
import exel.read.ReadExelImpl;
import exel.readXml.ReadXml;
import exel.readXml.ReadXmlImpl;

public class App {
	

	public static void main(String[] args) {
		Map<Integer, String> mapPrice;
		
		ReadXml xmlRead = new ReadXmlImpl();
		ReadExel exelRead = new ReadExelImpl();
		
		mapPrice = exelRead.readExel("price_test.xls");		
		xmlRead.readXml("canon.xml", mapPrice);

	}

}
