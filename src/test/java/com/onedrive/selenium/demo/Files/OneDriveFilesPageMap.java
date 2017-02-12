package com.onedrive.selenium.demo.Files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.onedrive.selenium.demo.common.CommonPageMap;

/**
 * This class contain WebElement locator used in the tests and helper methods of
 * this package. It suppose to contain web element which are specific to
 * "Files" page
 * 
 * @author amrit kumar
 */

public class OneDriveFilesPageMap extends CommonPageMap {

	public OneDriveFilesPageMap(WebDriver webDriver) {
		super(webDriver);
	}

	// WebElement locator which will get initialized by PageFactory

	// Upload menu item
	@FindBy(css = "div > div.CommandBar-mainArea > div:nth-child(2)")
	public static WebElement uploadMenu;
	
	// Upload- file menu item
	//@FindBy(css = "input[class='ContextualMenu-fileInput']")
//	public static WebElement uploadFile;
	
	@FindBy(css = "div[data-automationid='fileInput0']")
	public static WebElement uploadFile;
	

	// ----------------------------------------------------

	// CSS selector constants. We need CSS selector sometime as required by
	// WebDriver api

}
