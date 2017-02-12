package com.onedrive.selenium.demo.toolkit;

/**
 * @description Generic exception used to signify a failure. Use this exception
 *              in your test or Helper whenever a test fails, test class should
 *              automatically catch this exception
 * @author amrit kumar
 */

public class TestOneDriveException extends RuntimeException {

	public TestOneDriveException() {
		super();
	}

	public TestOneDriveException(String error) {
		super(error);
	}

}
