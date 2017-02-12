package com.onedrive.selenium.demo.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.onedrive.selenium.demo.toolkit.MasterHelper;

/**
 * @description If the code of tests is reusable then it should probably become
 *              a helper. This class contain helper for common functionality in
 *              One Drive application.
 * @author amrit kumar
 */

public abstract class CommonHelper extends MasterHelper {

	private WebElement getLinkBasedOnHref(String href) {
		WebElement linkElement = MasterHelper.getWebdriver().findElement(
				(By.cssSelector("a[href='" + href + "']")));
		return linkElement;
	}

	private WebElement getLinkBasedOnClass(String classId) {
		WebElement linkElement = MasterHelper.getWebdriver().findElement(
				(By.cssSelector("a[class='" + classId + "']")));
		return linkElement;
	}

	public void openLinkFromHomePage(String link) throws Exception {
		String href = null;
		String classId = null;
		// TODO move the constant to single file
		if (link.equalsIgnoreCase("SignIn")) {
			classId = "NavBar-link js-openSignInDialog";
		} else if (link.equalsIgnoreCase("Home")) {
			href = "/about/en-us/";
		} else if (link.equalsIgnoreCase("Business")) {
			href = "/about/en-us/business/";
		} else if (link.equalsIgnoreCase("Plans")) {
			href = "/about/en-us/plans/";
		} else if (link.equalsIgnoreCase("Download")) {
			href = "/about/en-us/download/";
		} else if (link.equalsIgnoreCase("HowTo")) {
			href = "/about/en-us/support/";
		}
		WebElement linkElement = null;
		if (href != null) {
			linkElement = this.getLinkBasedOnHref(href);
		} else if (classId != null) {
			linkElement = this.getLinkBasedOnClass(classId);
		}
		if (linkElement != null) {
			linkElement.click();
		} else {
			throw new Exception("Unsupported link: " + link);
		}
	}

	public void navigateLeftPanelTab(String tab) throws Exception {
		// TODO move the constant to single file
		String index = null;
		if (tab.equalsIgnoreCase("Files")) {
			index = "1";
		} else if (tab.equalsIgnoreCase("Recent")) {
			index = "2";
		} else if (tab.equalsIgnoreCase("Photos")) {
			index = "3";
		} else if (tab.equalsIgnoreCase("Shared")) {
			index = "4";
		} else if (tab.equalsIgnoreCase("RecycleBin")) {
			index = "5";
		}
		WebElement linkElement = null;
		if (index != null) {
			linkElement = this.getLeftNavigationTabWebElement(index);
			linkElement.click();
		} else {
			throw new Exception("Unsupported tab: " + tab);
		}
	}

	private WebElement getLeftNavigationTabWebElement(String tabIndex) {
		WebElement tabId = MasterHelper
				.getWebdriver()
				.findElement(
				// (By.cssSelector("div.LeftNav-subLinksClip > div > a:nth-child("
				// + 2 + ") > span > span")));
						(By.cssSelector("div.LeftNav-subLinksClip > div > a:nth-child(1) > span > span")));
		return tabId;
	}

	public void signIn(String userEmail, String userPassword) throws Exception {
		this.openLinkFromHomePage("SignIn");
		this.waitAndClick(CommonPageMap.signInEmail);
		this.setText(CommonPageMap.signInEmail, userEmail);
		this.waitAndClick(CommonPageMap.signInNextSubmit);
		this.waitAndClick(CommonPageMap.signInPasswd);
		this.setText(CommonPageMap.signInPasswd, userPassword);
		this.waitAndClick(CommonPageMap.signInSubmit);
	}

	public void signOut() {
		this.waitAndClick(CommonPageMap.oneDriveMyAccountMenu);
		this.waitAndClick(CommonPageMap.oneDriveSignOut);
	}

}
