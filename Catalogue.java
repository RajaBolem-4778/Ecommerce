package Ecommerce;


public class Catalogue {

	public Product[] listofAllElements;

	public Product[] getListofAllElements() {
		
		Product prd1 = new Product();
		prd1.setProductId("1");
		prd1.setProductName(" T-Shirt");
		prd1.setCost(200);
		Product prd2 = new Product();
		prd2.setProductId("2");
		prd2.setProductName(" Joggers");
		prd2.setCost(300);
		listofAllElements = new Product[2];
		listofAllElements[0] = prd1;
		listofAllElements[1] = prd2;
		return listofAllElements;
	}

	public void setListofAllElements(Product[] listofAllElements) {
		this.listofAllElements = listofAllElements;
	}

}
