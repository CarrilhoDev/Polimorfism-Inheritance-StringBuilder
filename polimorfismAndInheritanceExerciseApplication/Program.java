package polimorfismAndInheritanceExerciseApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import polimorfismAndInheritanceExerciseEntities.ImportedProduct;
import polimorfismAndInheritanceExerciseEntities.Product;
import polimorfismAndInheritanceExerciseEntities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		Scanner sc = new Scanner(System.in);
		
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data: ");
			
			System.out.print("Commom, used or imported (c/u/i)? ");
			
			char choice = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(choice == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				products.add(new ImportedProduct(name, price, customsFee));
				
			} else if(choice == 'u') {
				System.out.print("Manufacture date: (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				products.add(new UsedProduct(name, price, manufactureDate));
			} else {
				products.add(new Product(name, price));
			}
		}
		System.out.println();
		
		System.out.println("PRICE TAGS:");
		for(Product pro : products) {
			System.out.println(pro.priceTag());
			
		}
		
		sc.close();
	}

}
