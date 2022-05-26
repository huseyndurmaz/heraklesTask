package com.imdb.pages;

import com.imdb.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class IMDB extends BasePage{                                         //INHERITANCE

//    @FindBy(xpath = "(//h3[@class='LC20lb MBeuO DKV0Md'])[1]")
//    public WebElement linkImdb;

    @FindBy(xpath = "//h3[@class='LC20lb MBeuO DKV0Md' and .='Bruce Willis - IMDb']")
    public WebElement linkImdb;

    @FindBy(name = "sort")
    public WebElement dropDownElement;

    @FindBy(css = "[data-for='keywords']")
    public WebElement keywordsTab;



    //method returning all keywords as a List
    public List<String> getKeywords(){
        //locating each keyword elements
        List<WebElement> elements = Driver.get().findElements(By.xpath("(//div[@style='display: block;'])[2]//label/span[@class='faceter-facet-text']"));

        //getting keyword texts from keyword elements and storing in a List
        List<String> keywords = new ArrayList<>();                           //POLYMORPHISM: Interface = Child Class
        for (WebElement element : elements) {
            keywords.add(element.getText());
        }
        return keywords;

    }
}