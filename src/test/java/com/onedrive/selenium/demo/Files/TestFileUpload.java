package com.onedrive.selenium.demo.Files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.onedrive.selenium.demo.common.CommonPageMap;
import com.onedrive.selenium.demo.toolkit.MasterHelper;
import com.onedrive.selenium.demo.toolkit.TestOneDriveException;

/**
 * @author amrit kumar
 */

public class TestFileUpload extends FilesHelper {

	private int timeOut = 30000;
	private int waitDuration = 6000;
	private String userEmail;
	private String userPassword;
	private String filePath;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		MasterHelper.init();
		new OneDriveFilesPageMap(MasterHelper.getWebdriver());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// Data driven test, read test data from a file
		Properties globalProps = MasterHelper.loadProperties(MasterHelper.m_dataFolder
				+ "global.properties");
		userEmail = globalProps.getProperty("userEmail").trim();
		userPassword = globalProps.getProperty("userPassword").trim();
		
		Properties prop = MasterHelper.loadProperties(MasterHelper.m_dataFolder
				+ "fileUpload.properties");
		filePath = prop.getProperty("filePath").trim();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void upload_pptxFile_with_validInfo()
			throws Exception {

		try {
			// open browser with given application
			this.openBrowser(MasterHelper.m_appUrl);
			// Home Page Validation
			assertTrue(this.waitAndCheckDisplay(CommonPageMap.oneDriveHomePage));
			// SignIn with given credentials
			this.signIn(userEmail, userPassword);
			// Welcome page validation
			assertTrue(this
					.waitAndCheckDisplay(CommonPageMap.oneDriveWelcomePageTopMenu));
			// navigate to Files Tab in left navigation panel
			this.navigateLeftPanelTab("Files");
			// Retrieve the total number of file before upload
			int fileCountBeforeUpload = this.getFileCount();
		//	String filePath = "C:\\OneDriveFiles\\AmritExperienceinSlide.pptx";
			this.uploadLocalFile(filePath);
            // Wait for file upload to complete as per given timeout
			boolean bWait = true;
			while (bWait) {
				Thread.sleep(waitDuration);
				timeOut -= waitDuration;
				// Retrieve the total number of file after upload
				int fileCountAfterUpload = this.getFileCount();
				try {
					// validate the file upload
					assertEquals(fileCountBeforeUpload + 1,
							fileCountAfterUpload);
					bWait = false;
				} catch (Exception ex) {
					if (timeOut < 0)
						throw ex;
				}
			}
			Thread.sleep(2000);
			this.signOut();
			Thread.sleep(10000);
			this.closeBrowser();
		} catch (Exception e) {
			throw new TestOneDriveException(e.getMessage());
		}
	}
}
