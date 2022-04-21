package Q28_32;

import java.util.*;

public class Implementation {
	
	public Map<String,List<Product>> getProductName(List<Product> product) {
		Map<String,List<Product>> tempMap=new HashMap<String,List<Product>>();
		for(Product p:product) {
			List<Product> ProductList=new ArrayList<>();
			if(p.getPrice()>20.0) {
				if(!tempMap.containsKey(p.getName())) {
					ProductList.add(p);
					tempMap.put(p.getName(),ProductList);
				}
				else {
					List<Product> temp=new ArrayList<>();
					ProductList.add(p);
					temp=tempMap.get(p.getName());
					temp.addAll(ProductList);
					tempMap.put(p.getName(),temp) ;
				}
			}
		}
		return tempMap;
	}
	
	public Map<String,Double> getSum(List<Product> product){
		Map<String, Double> tempMap = new HashMap<String, Double>();
		for(Product p:product) {
			if(!tempMap.containsKey(p.getName())) {
				tempMap.put(p.getName(),p.getPrice());
			}
			else {
				double temp=tempMap.get(p.getName());
				temp+=p.getPrice();
				tempMap.put(p.getName(),temp);
			}
		}
		return tempMap;
	}

}
