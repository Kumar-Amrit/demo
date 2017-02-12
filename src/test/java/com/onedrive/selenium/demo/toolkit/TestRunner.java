package com.onedrive.selenium.demo.toolkit;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.onedrive.selenium.demo.Files.OneDriveFilesSuite;

/**
 * @author amrit kumar
 */
public class TestRunner {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Result result = JUnitCore.runClasses(OneDriveFilesSuite.class);
        for (Failure failure : result.getFailures()) {
           System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());

    }

}
