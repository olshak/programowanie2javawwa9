package lambdaexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books = new ArrayList<>();
    private MoneyLounderingService moneyLounderingService;


    public Library(List<Book> books) {
        if (books.isEmpty()) {
            throw new IllegalArgumentException("Book list cannot not be empty!");
        }
        this.books.addAll(books);
    }

    public Library(List<Book> books, MoneyLounderingService moneyLounderingService) {
        this.books = books;
        this.moneyLounderingService = moneyLounderingService;
    }

    public List<String> getAuthors() {
        return books.stream().map(Book::getAuthor).collect(Collectors.toList());
    }

    public List<String> getTitles() {
        return books.stream().map(Book::getTitle).collect(Collectors.toList());
    }

    public List<Integer> getPrices() {
        return books.stream().map(Book::getPrice).collect(Collectors.toList());
    }

    public int getTotalPrice() {
        return books.stream().map(Book::getPrice).reduce(0, (sum, price) -> sum + price);
    }

    public String getFormattedAuthors() {
        return books.stream().map(Book::getAuthor).reduce("", (raport, author) -> raport + "- " + author + "\n");
    }

    public List<Book> getBooksByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().equals(title)).collect(Collectors.toList());
    }


    public List<Book> getBooksByPrice(int price) {
        return books.stream().filter(book -> book.getPrice() == price).collect(Collectors.toList());
    }

    public List<Book> getBooksByYear(int year) {
        return books.stream().filter(book -> book.getDate().getYear() == year).collect(Collectors.toList());
    }

    public int getPriceForAuthorAndTitle(String author, String title) {
        int result = books.stream()
                .filter(book -> book.getTitle().equals(title))
                .filter(book -> book.getAuthor().equals(author))
                .map(Book::getPrice)
                .reduce(0, (sum, price) -> sum + price);

        return moneyLounderingService.increasePrice(result);
    }
}
