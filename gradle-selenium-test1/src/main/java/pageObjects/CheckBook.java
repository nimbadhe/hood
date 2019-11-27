package pageObjects;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Iterator;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckBook {
    private final static Logger LOGGER = LoggerFactory.getLogger(CheckBook.class);

    public CheckBook() {

    }

    private static SelenideElement books = $(By.className("col-sm-10"));

    public static void checkBooks(String bookIDValue) {

        ElementsCollection anchors = $$(By.tagName("a"));
        Iterator<SelenideElement> i = anchors.iterator();

        while(i.hasNext()) {
            WebElement anchor = i.next();
            if(anchor.getAttribute("href").contains(bookIDValue)) {
                LOGGER.info("Book found: "+anchor);
                LOGGER.info("Opening Book with ID "+bookIDValue+" from Books Page!");
                anchor.click();
                break;
            }
        }
    }
}