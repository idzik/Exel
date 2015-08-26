package exel.read;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExelImpl implements ReadExel {
	
	private Map<Integer, String> mapPrice = new HashMap<Integer, String>();

	@Override
	public Map<Integer, String> readExel(String name) {
		
		Workbook sk;
		Sheet arkusz = null;
		try {
			sk = Workbook.getWorkbook(new File(name));
			arkusz = sk.getSheet(0);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i = 0 ; i<3 ; i++){
			Cell id = arkusz.getCell(0,i);
     		Cell price = arkusz.getCell(1,i);
			int idx = Integer.parseInt(id.getContents());
			mapPrice.put(idx, price.getContents());
			
		}
		return mapPrice;
	}

}
