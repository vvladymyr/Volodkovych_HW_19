package org.example.uitests;

import org.apache.commons.io.FileUtils;
import org.example.uitests.driver.WebDriverHolder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static org.example.uitests.utils.MyFilesUtils.clearScreenshotsFolder;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
     //   ITestListener.super.onTestSuccess(result);
        makeScreenshot(result.getName() + new Date().getTime());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
       // ITestListener.super.onStart(context);
        clearScreenshotsFolder();
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
    public File makeScreenshot(String screenshotName){
        WebDriver driver = WebDriverHolder.getInstance().getDriver();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File file = new File("screenshots", screenshotName + ".png");
        try {
            FileUtils.copyFile(screenshot, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }
}
