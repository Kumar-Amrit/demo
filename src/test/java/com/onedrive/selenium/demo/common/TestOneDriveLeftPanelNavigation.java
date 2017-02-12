package com.onedrive.selenium.demo.common;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.onedrive.selenium.demo.toolkit.TestOneDriveException;

/**
 * @author amrit kumar
 */

public class TestOneDriveLeftPanelNavigation extends CommonHelper {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	//	MasterHelper.init();
	//	new CommonPageMap(MasterHelper.getWebdriver());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_example() throws Exception {

		try {

		} catch (Exception e) {
			throw new TestOneDriveException(e.getMessage());
		}
	}

}
