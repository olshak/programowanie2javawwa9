package lambdaexpressions;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;


public class LibraryTest {

    private Book book1 = new Book("Stefan", "Fajna", 20, LocalDate.of(2000, 1, 1));
    private Book book2 = new Book("Andrzej", "Słaba", 10, LocalDate.of(1999, 1, 1));
    private Book book3 = new Book("Ewa", "Srednia", 15, LocalDate.of(1980, 2, 3));
    private Book book4 = new Book("Anna", "Kijowa", 1, LocalDate.of(1970, 2, 2));
    private Book book5 = new Book("Anna", "Fajna", 1, LocalDate.of(1970, 2, 2));

    private Library library = new Library(Arrays.asList(book1, book2, book3, book4, book5));

    @Test
    public void shouldThowIllegalArgumentExceptionWhenBookListIsEmpty() {
        try {
            new Library(new ArrayList<>());
            Assert.fail("Library should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Book list cannot not be empty!", e.getMessage());
        }
    }

    @Test
    public void shouldReturnAuthorList() {
        Assert.assertEquals(Arrays.asList(
                book1.getAuthor(),
                book2.getAuthor(),
                book3.getAuthor(),
                book4.getAuthor(),
                book5.getAuthor()), library.getAuthors());

    }

    @Test
    public void shouldReturnTotalPrice() {
        Assert.assertEquals(
                book1.getPrice() +
                        book2.getPrice() +
                        book3.getPrice() +
                        book4.getPrice() +
                        book5.getPrice(), library.getTotalPrice());

    }

    @Test
    public void shouldReturnFormattedAuthors() {
        Assert.assertEquals(
                "- " + book1.getAuthor() + "\n" +
                        "- " + book2.getAuthor() + "\n" +
                        "- " + book3.getAuthor() + "\n" +
                        "- " + book4.getAuthor() + "\n" +
                        "- " + book5.getAuthor() + "\n", library.getFormattedAuthors());

    }

    @Test
    public void shouldReturnBooksByTitle() {
        Assert.assertEquals(Arrays.asList(
                book1,
                book5), library.getBooksByTitle("Fajna"));
    }

    @Test
    public void shouldReturnBooksByYear() {
        Assert.assertEquals(Arrays.asList(book1), library.getBooksByYear(2000));
    }

    @Test
    public void shouldReturnPriceByAuthorAndTitle() {
        MoneyLounderingService moneyLounderingService = Mockito.mock(MoneyLounderingService.class);
        Library library = new Library(Arrays.asList(
                book1,
                book2,
                book3,
                book4,
                book5), moneyLounderingService);

        Mockito.when(moneyLounderingService.increasePrice(20)).thenReturn(100);

        Assert.assertEquals(100,
                library.getPriceForAuthorAndTitle("Stefan", "Fajna"));
    }
}
