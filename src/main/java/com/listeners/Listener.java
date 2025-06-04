package com.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.nar.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportUtility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Listener extends TestBase implements ITestListener{

//    public static WebDriver driver;
    ExtentTest test;
    ExtentReports extent = ExtentReportUtility.config();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());

        System.out.println("Test started");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test case:" + result.getMethod().getMethodName() + " is Passed.");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test case:" + result.getMethod().getMethodName() + " is Failed.");
        test.log(Status.FAIL, result.getThrowable());

        //add Screenshot for Failure
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);

        String screenshotPath = System.getProperty("user.dir") + "/Reports/Screenshots/" + actualDate + ".jpeg";
        File dest = new File(screenshotPath);

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test case:" + result.getMethod().getMethodName() + " is Skipped.");
        test.log(Status.SKIP, result.getThrowable());

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("Test finished");

    }


}

