package com.qa.test;

import com.qa.base.TestBase;
import com.qa.config.*;
import com.qa.util.Utilities;
import com.qa.pages.*;
 

	public class LoginHubTest {

		public static void main(String[] args) throws Exception {
		
			LoginHub  lh = new LoginHub();
			lh.launchWalletHub();
			lh.writeReview();
			lh.hoverOnStars();
			lh.clickOnStar();
			lh.selectDropDown();
			lh.enterText();
			lh.closeWalletHub();
			lh.lauchReview();
			lh.checkReview();
			lh.closeWalletHub();
		
		}

	}
