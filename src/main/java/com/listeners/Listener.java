package com.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sfd.qa.pages.TestBase;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportUtility;

public class Listener implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtentReportUtility.config();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());

        System.out.println("Test started");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        test.log(Status.FAIL, "Test failed");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test skipped");

    }

}
