import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helpers.TestBase;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pageObjects.CheckBook;
import pageObjects.CreateAuthor;
import pageObjects.CreateBook;
import static com.codeborne.selenide.Selenide.open;
public class TestClass1 extends TestBase {

    private final Logger LOGGER = LoggerFactory.getLogger(TestClass1.class);
    private CreateAuthor authorPage = new CreateAuthor();
    private CreateBook bookPage = new CreateBook();
    private CheckBook booksPage = new CheckBook();

    String firstName = "Cartul";
    String familyName = "Peet";
    String birth = "22/05/1922";
    String death = "13/02/2019";
    String bookTitle = "Laughing Yoga";
    String bookSummary = "The funniest book ever";
    String ISBN = "87654321";
    String genre = "Fiction"; //"Fiction" or "nonFiction"

    String authorID = null;
    String bookID = null;

    @Test
    public void Test1() {

        Configuration.holdBrowserOpen=true;
        LOGGER.info("Let's open up the browser with Library page!");
        open("https://raamatukogu.herokuapp.com/");

        LOGGER.info("Create the Author!");
        open("https://raamatukogu.herokuapp.com/catalog/author/create");
        authorPage.fillAuthorPage(firstName, familyName, birth, death);

        String authPageURL= WebDriverRunner.url();
        authorID = FilenameUtils.getName(authPageURL);
        LOGGER.info("Author ID is: "+authorID);

        LOGGER.info("Create the Book with that Author!");
        open("https://raamatukogu.herokuapp.com/catalog/book/create");
        bookPage.fillBookPage(bookTitle, bookSummary, ISBN, genre, authorID);

        String bookPageURL= WebDriverRunner.url();
        bookID = authorID = FilenameUtils.getName(bookPageURL);
        LOGGER.info("Book ID is: "+bookID);

        LOGGER.info("Check the Book from Books page!");
        open("https://raamatukogu.herokuapp.com/catalog/books/");
        booksPage.checkBooks(bookID, bookTitle, ISBN);

    }

   // @Test
  //  public void Test2() {
       // LOGGER.info("This is Test2");
   // }

}
