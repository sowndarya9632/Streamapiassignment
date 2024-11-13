package based_on_oop;

public class Book {
	 private String title;
	    private String author;
	    private String genre;
	    private double rating;

	    public Book(String title, String author, String genre, double rating) {
	        this.title = title;
	        this.author = author;
	        this.genre = genre;
	        this.rating = rating;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public String getGenre() {
	        return genre;
	    }

	    public double getRating() {
	        return rating;
	    }

}
class BookRecommendation {
    private String title;
    private double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "BookRecommendation{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }

	public double getRating() {
		// TODO Auto-generated method stub
		return 0;
	}
}
