package com.onedrive.selenium.demo.Files;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.onedrive.selenium.demo.common.CommonHelper;
import com.onedrive.selenium.demo.toolkit.MasterHelper;

/**
 * @description If the code of tests is reusable then it should probably become
 *              a helper. This class contain helper for Files page functionality
 * @author amrit kumar
 */
public abstract class FilesHelper extends CommonHelper {

	/**
	 * This method is to count the number of files in file listing area.
	 * 
	 */	
	public int getFileCount() {		
		List<WebElement> elementsList =  MasterHelper.getWebdriver().findElements(By.cssSelector("div.List-cell"));
		return elementsList.size();		
	}
	
	/**
	 * This method is to upload local file in file upload workflow.
	 * Parameter input need to be provided from test data file
	 * 
	 */
	public void uploadLocalFile(String filePath) throws AWTException {
		this.waitAndClick(OneDriveFilesPageMap.uploadMenu);
		this.waitAndClick(OneDriveFilesPageMap.uploadFile);
		
		StringSelection path = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
}
