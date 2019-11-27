package pageObjects;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Selenide.$;
import org.testng.annotations.Test;


public class CreateAuthor {
    private final static Logger LOGGER = LoggerFactory.getLogger(CreateAuthor.class);

    public CreateAuthor() {

    }

    private static SelenideElement firstName = $(By.id("first_name"));
    private static SelenideElement familyName = $(By.id("family_name"));
    private static SelenideElement birth = $(By.id("date_of_birth"));
    private static SelenideElement death = $(By.id("date_of_death"));
    private static SelenideElement submitButton = $(By.xpath("//button[@class='btn btn-primary']"));

    @Test
    public static void fillAuthorPage(String firstNameValue, String familyNameValue, String birthValue, String deathValue) {

        LOGGER.info("Filling Author First Name with: " + firstNameValue);
        firstName.setValue(firstNameValue);
        LOGGER.info("Filling Author Family Name with: " + familyNameValue);
        familyName.setValue(familyNameValue);
        LOGGER.info("Filling Author birth date with: " + birthValue);
        birth.setValue(birthValue);
        LOGGER.info("Filling Author death date with: " + deathValue);
        death.setValue(deathValue);

        submitButton.click();

    }
}