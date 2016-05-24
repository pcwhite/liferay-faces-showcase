/**
 * Copyright (c) 2000-2016 Liferay, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.faces.test.showcase.selectmanycheckbox;

import org.junit.Test;

import com.liferay.faces.test.selenium.Browser;
import com.liferay.faces.test.selenium.assertion.SeleniumAssert;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class SelectManyCheckboxImmediateTester extends SelectManyCheckboxTester {

	@Test
	public void runSelectManyCheckboxImmediateTest() throws Exception {
		Browser browser = Browser.getInstance();
		browser.get(selectmanycheckboxURL + "/immediate");

		// Wait to begin the test until the submit button is rendered.
		browser.waitForElementVisible(submitButton1Xpath);

		// Test that the first checkbox has not yet been clicked.
		SeleniumAssert.assertElementNotPresent(browser, modelValueElement1Xpath);

		// Test that the checked values submit successfully.
		String answer1 = "1";
		String answer3 = "3";
		String answer4 = "4";
		testManyCheckboxes(browser, answer1, answer3, answer4);
		SeleniumAssert.assertElementVisible(browser, immediateMessage1Xpath);

		// Test that the second checked values submit successfully.
		String manyCheckbox1Xpath2 = "(//input[contains(@id,':selectManyCheckbox')])[6]";
		String manyCheckbox3Xpath2 = "(//input[contains(@id,':selectManyCheckbox')])[8]";
		String manyCheckbox4Xpath2 = "(//input[contains(@id,':selectManyCheckbox')])[9]";
		browser.click(manyCheckbox1Xpath2);
		browser.click(manyCheckbox3Xpath2);
		browser.click(manyCheckbox4Xpath2);
		browser.clickAndWaitForAjaxRerender(submitButton2Xpath);
		SeleniumAssert.assertElementTextVisible(browser, modelValue2Xpath, answer1);
		SeleniumAssert.assertElementTextVisible(browser, modelValue2Xpath, answer3);
		SeleniumAssert.assertElementTextVisible(browser, modelValue2Xpath, answer4);
		SeleniumAssert.assertElementVisible(browser, immediateMessage2Xpath);
	}
}
