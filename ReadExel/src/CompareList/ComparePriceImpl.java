package CompareList;

import java.util.Map;

public class ComparePriceImpl implements CompareList {

	@Override
	public void comparePrice(Map<String, String> mapProduct,
			Map<String, String> mapPrice) {
		
		int z = 0;
		
		for(String key : mapProduct.keySet()){
			
			for(String keyPrice : mapPrice.keySet()){
				
				if(key.equals(keyPrice)){
					mapProduct.replace(key, mapPrice.get(keyPrice));
				}
			}
		}
		
		System.out.println("ilość porównań " + z);

	}

}
