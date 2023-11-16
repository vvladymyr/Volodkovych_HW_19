package org.example.uitests;

import org.apache.commons.io.FileUtils;
import org.example.uitests.driver.WebDriverHolder;
import org.example.uitests.utils.ConfigProvider;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static org.example.uitests.utils.MyFilesUtils.clearScreenshotsFolder;

@Listeners({TestListener.class})
public class BaseTests {
    @BeforeSuite
    public void beforeClass() {
        WebDriverHolder.getInstance().getDriver();
       // clearScreenshotsFolder();
    }
//    @AfterMethod(alwaysRun = true)
//    public void afterMethod(ITestResult result){
//        if (result.isSuccess()) {
//            makeScreenshot(result.getName() + new Date().getTime());
//        }
//    }

//    public File makeScreenshot(String screenshotName){
//        WebDriver driver = WebDriverHolder.getInstance().getDriver();
//        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//        File file = new File("screenshots", screenshotName + ".png");
//        try {
//            FileUtils.copyFile(screenshot, file);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return file;
//    }


    @AfterSuite
    public void afterClass() {
        WebDriverHolder.getInstance().driverQuit();
    }

    public void goToUrl(String url) {
        WebDriverHolder.getInstance().getDriver().get(url);
    }

    public void goToUrl() {
        goToUrl(ConfigProvider.getInstance().getProperty("app.shop.url"));
    }

    public void goToPart(String part) {
        goToUrl(ConfigProvider.getInstance().getProperty("app.shop.url") + part);
    }
}
