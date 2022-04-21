package Q27;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Customer {
	private String name;
	private int age;
	public Customer(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Customer{name='" + name +"', age="+age+"}";
	}
	
	public static void main(String[] args) {
		List<Customer> customersList = Arrays.asList(
				 new Customer("Tom", 30),
				 new Customer("Steve", 31),
				 new Customer("Peter", 34),
				 new Customer("Simon", 23));
		Implementation implementation=new Implementation();
		System.out.println(implementation.withDelimeters(customersList));
		System.out.println(implementation.sortCustomerList(customersList));
	}
}
class Implementation{
	public List<Customer> sortCustomerList(List<Customer> customersList){
		Collections.sort(customersList, Comparator.comparing(Customer::getName));
		return customersList;
	}
	public String withDelimeters(List<Customer> customersList){
		StringBuffer sb=new StringBuffer(); 
		int n=customersList.size();
		sb.append(customersList.get(0));
		for(int i=1;i<n;i++) {
			sb.append("@");
			sb.append(customersList.get(i));
		}
		return sb.toString();
	}
	
}