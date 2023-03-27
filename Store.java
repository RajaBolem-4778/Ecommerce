package Ecommerce;

import java.util.Scanner;

//	Ask the type of user? Customer,Seller,Admin
//  User -- Customer,Seller,Admin
//  Customer : View products,Add cart, Contact Us
//		View Products-- Add product to cart, Add Cart -- checkout
//	Seller  : View your product, Add a product, Contact Us
//		View Products -- delete this product, Add product --Submit details of product
//
//Product
//Category
//Cart
//Order
//

public class Store {

	public static void main(String[] args) {
		System.out.println("Welcome to the Ecommerce Store..!");
		System.out.println("Ask the type of user ? 1. Customer 2.Seller 3. Admin");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		String typeofUser;
		if (choice == 1) {
			typeofUser = "Customer";
			Customer current = new Customer();
			System.out.println("What is your UserID");
			sc.nextLine();
			current.setUserID(sc.nextLine());
			System.out.println("What is your Password");
			sc.nextLine();
			current.setPassword(sc.nextLine());
			if (current.verifyUser() == true) {
				System.out.println("User verified");
				while (true) {
					System.out.println("Do you want to -- 1.View Products 2. View Cart 3. Contact us 4.Exit");
					choice = sc.nextInt();
					if (choice == 1) {
						System.out.println("Please choose the Product");
						Catalogue cat = new Catalogue();
						Product[] allProducts = cat.getListofAllElements();
						/*
						 * System.out.println("1.Clothes  2. Laptops 3. Mobiles"); sc.nextLine(); int
						 * chooseCategory = sc.nextInt(); String choose = " "; if (chooseCategory == 1)
						 * { choose = "Clothes"; } else if (chooseCategory == 2) { choose = "Laptops"; }
						 * else if (chooseCategory == 3) { choose = "Mobiles"; }
						 */
						for (int i = 0; i < allProducts.length; i++) {
							System.out.println(allProducts[i].getProductId() + " " + allProducts[i].getProductName()
									+ " " + allProducts[i].getCost());
						}
						System.out.println(" Do you want add any product to cart Y/N");
						sc.nextLine();
						String AddtoCart = sc.nextLine();
						if (AddtoCart.equals("Y")) {
							System.out.println(" Input the product id of the product which you want to add");
							String productId = sc.nextLine();
							Product[] cartProducts = new Product[1];
							int pro = cat.getListofAllElements().length;
							for (int i = 0; i < pro; i++) {

								if (allProducts[i].getProductId().equals(productId)) {
									cartProducts[0] = allProducts[i];
								}

								Cart cart = new Cart();
								cart.setCartID("1");
								cart.setListOfProducts(cartProducts);
								current.setCart(cart);
							}
							System.out.println("Product successfully added to the cart\n");

						}
					} else if (choice == 2) {
						Product[] cartProducts = current.getCart().getListOfProducts();
						System.out.println(current.getCart().getCartID());
						for (int i = 0; i < cartProducts.length; i++) {

							System.out.println(cartProducts[i].getProductId() + " " + cartProducts[i].getProductName()
									+ " " + cartProducts[i].getCost() + " ");
							System.out.println("Do you want to checkout? Y/N");
							sc.nextLine();
							String checkout = sc.nextLine();
							if (checkout.equals("Y")) {

								System.out.println("Amount to be paid : " + cartProducts[i].getCost());
								System.out.println("Your order is placed successfully\n");

							}
						}
					} else if (choice == 3) {
						System.out.println("Please contact us, reachout to Ecom@store.com");
					} else if (choice == 4)
						break;

					else
						System.out.println("Invalid Choice");
				}
			}

		} else if (choice == 2) {
			typeofUser = "Seller";
			Seller current = new Seller();
			System.out.println("What is your UserID");
			sc.nextLine();
			current.setUserID(sc.nextLine());
			System.out.println("What is your Password");
			sc.nextLine();
			current.setPassword(sc.nextLine());
			if (current.verifyUser() == true) {
				System.out.println("Seller verified");
				while (true) {
					System.out.println("Do you want to -- 1.View your product 2.Add a product 3.Contact Us 4.Exit");
					choice = sc.nextInt();
					if (choice == 1) {
						Catalogue cat = new Catalogue();
						Product[] allProducts = cat.getListofAllElements();
						for (int i = 0; i < allProducts.length; i++) {
							System.out.println(allProducts[i].getProductId() + " " + allProducts[i].getProductName()
									+ " " + allProducts[i].getCost());
						}
					} else if (choice == 2) {
						int total = 0;

						System.out.println(" Input the product id of the product which you want to sell");
						String getId = sc.nextLine();
						sc.nextLine();
						Catalogue catSeller = new Catalogue();
						Product[] sellerProduct = catSeller.getListofAllElements();
						Product[] sellerAddProduct = new Product[1];

						for (int i = 0; i <= sellerAddProduct.length + 1; i++) {

							if (sellerProduct[i].getProductId().equals(getId)) {
								sellerAddProduct[0] = sellerProduct[i];
							}
							current.setListedProducts(sellerAddProduct);

							total = total + sellerProduct[i].getCost();
							System.out.println("Amount to be paid for " + sellerProduct[i].getProductId()
									+ " products : " + total);
						}
						System.out.println("Product Added Successfully");

					} else if (choice == 3) {
						System.out.println("Please contact us on store@ecommerce.com\n");
					} else if (choice == 4)
						break;
					else
						System.out.println("Invalid Choice");

				}
			}
		} else if (choice == 3) {
			typeofUser = "Admin";
			Admin current = new Admin();
			System.out.println("What is your UserID\n");
			sc.nextLine();
			sc.nextLine();
			System.out.println("What is your Password\n");
			sc.nextLine();

			if (current.verifyAdmin() == true) {
				System.out.println("Admin verified");

			}
		} else
			System.out.println("Invalid Option");
	}
}
