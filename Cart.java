package Ecommerce;

public class Cart {
	private String cartID;
	
public String getCartID() {
		return cartID;
	}
	public void setCartID(String cartID) {
		this.cartID = cartID;
	}

//public static Object getListOfProducts;
Product[] listOfProducts;

public Product[] getListOfProducts() {
	return listOfProducts;
}

public void setListOfProducts(Product[] listOfProducts) {
	this.listOfProducts = listOfProducts;
}

public boolean checkOut() {
	
	
	return false;
}
}