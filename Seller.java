package Ecommerce;

public class Seller extends User{
	Product[] listedProducts;
	public Product[] getListedProducts() {
		return listedProducts;
	}
	public void setListedProducts(Product[] listedProducts) {
		this.listedProducts = listedProducts;
	}

	public Boolean verifyUser() {
		return true;
	}
	public void setProductsListed(Product[] sellerAddProduct) {
		
	}
}
