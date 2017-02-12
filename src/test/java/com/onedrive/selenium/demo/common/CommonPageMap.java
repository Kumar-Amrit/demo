package com.onedrive.selenium.demo.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contain WebElement locator used in the tests and helper methods of
 * this package. It suppose to contain web element which are transversal such as
 * common navigation , sign in, sign out etc.
 * 
 * @author amrit kumar 
 */

public class CommonPageMap {

	public CommonPageMap(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}

	// WebElement locator which will get initialized by PageFactory

	// Home Page Content
	@FindBy(css = "div[class='Header-navBar NavBar']")
	public static WebElement oneDriveHomePage;
	
	// Solution Overview Page Content
	@FindBy(css = "a[class='NavBar-link js-openSignInDialog']")
	public static WebElement openSignInLink;
	
	// Solution Overview Page Content
	@FindBy(css = "a[href='/about/en-us/business/']")
	public static WebElement testSignInLink;
	
	// SignIn email text box
	@FindBy(css = "input[class='SignInDialog-input SignInDialog-input--email']")
	public static WebElement signInEmail;
	
	// SignIn next submit button
	@FindBy(css = "span[class='ms-Button-label SignInDialog-buttonLabel']")
	public static WebElement signInNextSubmit;
	
	// SignIn Password text box
	@FindBy(css = "input[name='passwd']")
	public static WebElement signInPasswd;
	
	// SignIn Submit button
	@FindBy(css = "input[id='idSIButton9']")
	public static WebElement signInSubmit;
	
	// Welcome page top menu
	@FindBy(css = "div[id='O365_TopMenu']")
	public static WebElement oneDriveWelcomePageTopMenu;
	
	// Left Navigation files tab
	@FindBy(css = "div.LeftNav-subLinksClip > div > a:nth-child(2) > span > span")
	public static WebElement filesTab;
	
	// My Account top menu
	@FindBy(css = "button[id='O365_MeFlexPane_ButtonID']")
	public static WebElement oneDriveMyAccountMenu;
	
	// My Account sing out menu
	@FindBy(css = "span[id='_ariaId_12']")
	public static WebElement oneDriveSignOut;
	
	// ----------------------------------------------------

	// CSS selector constants. We need CSS selector sometime as required by
	// WebDriver api

}
