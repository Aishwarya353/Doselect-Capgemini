package Q28_32;

import java.util.*;

public class Product {
	int id;
	String name;
	double price;

	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	public static void main(String[] args) {
		Product pr5 = new Product(1, "Bruchotte", 5.0);
		Product pr6 = new Product(4, "Banana", 1305.0);
		Product pr7 = new Product(3, "Banana", 132.0);

		List<Product> pr= Arrays.asList(pr5, pr6, pr7);
		Implementation implementation=new Implementation();
		System.out.println(implementation.getProductName(pr));
		System.out.println(implementation.getSum(pr));

	}

}
