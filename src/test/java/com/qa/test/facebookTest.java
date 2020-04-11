package com.qa.test;

import com.qa.base.TestBase;
import com.qa.config.*;
import com.qa.util.Utilities;
import com.qa.pages.*;
 
public class facebookTest {

	public static void main(String[] args) throws Exception {
		
		facebook fb = new facebook();
		fb.launchFacebook();
		fb.loginFacebook();
		String title= fb.getFaceBookTitle();
		System.out.println("After logging In title of page is " + title);
		fb.postMessage();
		fb.closeFacebook();

	}

}
