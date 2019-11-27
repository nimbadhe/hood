package pageObjects;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Iterator;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreateBook {
    private final static Logger LOGGER = LoggerFactory.getLogger(CreateBook.class);
    public CreateBook() {

    }

    private static SelenideElement bookTitle = $(byName("title"));
    private static SelenideElement authorChoice = $(byName("author"));
    private static SelenideElement bookSummary = $(byName("summary"));
    private static SelenideElement ISBN = $(byName("isbn"));
    private static SelenideElement submitButton = $(By.xpath("//button[@class='btn btn-primary']"));

    public static void fillBookPage(String bookTitleValue, String bookSummaryValue, String ISBNValue, String genreValue, String authorIDValue) {

        LOGGER.info("Filling Book Title with: " + bookTitleValue);
        bookTitle.setValue(bookTitleValue);
        LOGGER.info("Filling Book Summary with: " + bookSummaryValue);
        bookSummary.setValue(bookSummaryValue);
        LOGGER.info("Filling ISBN with: " + ISBNValue);
        ISBN.setValue(ISBNValue);
        LOGGER.info("Selecting Author by ID: " + authorIDValue);
        authorChoice.selectOptionByValue(authorIDValue);

        String genreID = null;
        if(genreValue=="Fiction"){
            genreID = "5b6714c93809970014e31c9a";
        }
        else{
            genreID = "5b6714c73809970014e31c99";
        }

        LOGGER.info("Selecting genre: " + genreValue);
        LOGGER.info("(Genre ID is: " + genreID + " )");

        ElementsCollection genres = $$(By.xpath("//input[@class='checkbox-input']"));
        Iterator<SelenideElement> i = genres.iterator();
        while(i.hasNext()) {
            WebElement genre = i.next();
            if (genre.getAttribute("id").contains(genreID)) {
                genre.click();
                break;
            }
        }

        submitButton.click();

    }
}