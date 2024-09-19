package com.springboot.webapp.model;

public class ProductDo {
	private String[] productList =
		{"item1", "item2", "item3", "item4", "item5"};
	
	private int num = 10;
	private int price = 10000;
	
	public String[] getProductList() {
		return productList;
	}
	public void setProductList(String[] productList) {
		this.productList = productList;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
