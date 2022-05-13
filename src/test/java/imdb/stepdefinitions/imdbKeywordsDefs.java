package imdb.stepdefinitions;

import imdb.pages.IMDB;
import imdb.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class imdbKeywordsDefs {
    //Creating an object to reach the WebElements located in BasePage and IMDB classes
    IMDB imdb = new IMDB();


    @Given("the user searches {string} on Google")
    public void theUserSearchesOnGoogle(String movieStar) {
        Driver.get().get("https://www.google.com");
        imdb.googleSearchBox.clear();
        imdb.googleSearchBox.click();
        imdb.googleSearchBox.sendKeys(movieStar + Keys.ENTER);
    }

    @Given("the user clicks on result from {string} webpage")
    public void the_user_clicks_on_result_from_webpage(String nameOfWebpage) {
        imdb.linkImdb.click();
    }

    @Given("the user clicks on the drop down element in the {string} section")
    public void the_user_clicks_on_the_drop_down_element_in_the_section(String sectionName) {
        imdb.dropDownElement.click();
    }

    @Given("the user selects {string} from the drop down element")
    public void the_user_selects_from_the_drop_down_element(String dropDownOption) {
        Select dropDown = new Select(imdb.dropDownElement);
        dropDown.selectByVisibleText("Genre »");
    }

    @Given("the user clicks on the {string} tab from refine section")
    public void the_user_clicks_on_the_tab_from_refine_section(String tabName) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(imdb.keywordsTab)).click();
        //imdb.keywordsTab.click();
    }

    @Then("the keywords are not sorted by name")
    public void the_keywords_are_not_sorted_by_name() {
        //calling method from IMDB class to get keywords on IMDB and checking the number of keywords
        System.out.println("elements.size() = " + imdb.getKeywords().size());
        System.out.println("keywords = " + imdb.getKeywords());

        //creating another List to sort keywords
        List<String> keywordsSorted = new ArrayList<>(imdb.getKeywords());
        Collections.sort(keywordsSorted);
        System.out.println("keywordsSorted = " + keywordsSorted);

        //comparing first elements in keywords/sorted keywords lists to verify keywords are NOT sorted by name on IMDB
        Assert.assertNotEquals("If assertion fails: Keywords are sorted by name", keywordsSorted.get(0), imdb.getKeywords().get(0));
    }

    @Then("{string} is not a word in the keyword list")
    public void is_not_a_word_in_the_keyword_list(String keywordToVerify) {
        //verifying that "Incredible" is NOT a word in the List of keywords from IMDB
        Assert.assertFalse(imdb.getKeywords().contains(keywordToVerify));
    }
}