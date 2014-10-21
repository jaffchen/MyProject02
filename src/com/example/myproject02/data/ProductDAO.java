package com.example.myproject02.data;

public interface ProductDAO {
	public void add(Product p);
	//public Product[] getAll();
	public Product[] getAll_A();
	public Product[] getAll_B();
	public Product[] getAll_C();
	public Product getProduct(int ID);
	public void removeAll();
}
