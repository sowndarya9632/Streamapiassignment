package based_on_oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookRecomendation {
	 public static List<List<BookRecommendation>> getTopRecommendations(List<Book> books) {
	        List<BookRecommendation> filteredBooks = books.stream()
	                .filter(book -> "Science Fiction".equals(book.getGenre()) && book.getRating() > 4.0)
	                
	                .map(book -> new BookRecommendation(book.getTitle(), book.getRating()))
	                
	                .sorted((b1, b2) -> Double.compare(b2.getRating(), b1.getRating()))
	                
	                .limit(10)
	                
	                .collect(Collectors.toList());

	        return paginate(filteredBooks, 5);
	    }

	 private static List<List<BookRecommendation>> paginate(List<BookRecommendation> recommendations, int pageSize) {
	        List<List<BookRecommendation>> pages = new ArrayList<>();
	        for (int i = 0; i < recommendations.size(); i += pageSize) {
	            pages.add(recommendations.subList(i, Math.min(i + pageSize, recommendations.size())));
	        }
	        return pages;
	    }

	    public static void main(String[] args) {
	        List<Book> books = Arrays.asList(
	                new Book("Dune", "Frank Herbert", "Science Fiction", 4.8),
	                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.7),
	                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.3),
	                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.5),
	                new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.6),
	                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.4),
	                new Book("The Expanse", "James S.A. Corey", "Science Fiction", 4.2),
	                new Book("Altered Carbon", "Richard K. Morgan", "Science Fiction", 4.1),
	                new Book("The Three-Body Problem", "Liu Cixin", "Science Fiction", 4.3),
	                new Book("The Martian", "Andy Weir", "Science Fiction", 4.4),
	                new Book("Solaris", "Stanislaw Lem", "Science Fiction", 4.0)
	        );

	        List<List<BookRecommendation>> paginatedRecommendations = getTopRecommendations(books);

	        System.out.println("Top Book Recommendations (Paginated):");
	        for (int i = 0; i < paginatedRecommendations.size(); i++) {
	            System.out.println("Page " + (i + 1) + ": " + paginatedRecommendations.get(i));
	        }
	    }
}
