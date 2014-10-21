package com.example.myproject02.data;

public class Product
{
    public int ID;
    public String Type;
    public String Name;
    public String Desc;
    public int Price1;
    public int Price2; 
    public int Qty;
    public String ImagePath;

	
    public Product(int ID, String Type, String Name, String Desc, int Price1, int Price2, int Qty, String ImagePath)
    {
		this.ID = ID;
		this.Type = Type;
		this.Name = Name;
		this.Desc = Desc;
		this.Price1 = Price1;
		this.Price2 = Price2; 
		this.Qty = Qty;
		this.ImagePath = ImagePath;
	}
}