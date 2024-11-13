package based_on_oop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductSalesAnanlysis {
	 public static List<ProductSales> performSalesAnalysis(List<Sale> sales) {
	        return sales.stream()
	                .filter(sale -> sale.getQuantity() > 10)
	                
	                .map(sale -> new ProductSales(sale.getProductId(), sale.getQuantity() * sale.getPrice()))
	                
	                .sorted(Comparator.comparing(ProductSales::getTotalRevenue).reversed())
	                
	                .limit(5)
	                
	               .collect(Collectors.toList());
	    }

	    public static void main(String[] args) {
	        List<Sale> sales = Arrays.asList(
	                new Sale(1, 15, 20.0),
	                new Sale(2, 5, 30.0),
	                new Sale(3, 12, 25.0),
	                new Sale(4, 20, 10.0),
	                new Sale(5, 8, 50.0),
	                new Sale(6, 25, 15.0),
	                new Sale(7, 18, 40.0)
	        );

	        List<ProductSales> topProducts = performSalesAnalysis(sales);
	        
	        System.out.println("Top 5 Products by Total Revenue:");
	        topProducts.forEach(System.out::println);
	    }

}
