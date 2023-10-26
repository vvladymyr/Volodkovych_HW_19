package org.example.uitests.pages;

import org.example.uitests.driver.WebDriverHolder;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(WebDriverHolder.getInstance().getDriver(), this);
    }

    public void sleep(long msec) throws InterruptedException {
        Thread.sleep(msec);
    }
}
