package com.imdb.pages;

import com.imdb.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {                    //ABSTRACTION
    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(name= "q")
    public WebElement googleSearchBox;




}