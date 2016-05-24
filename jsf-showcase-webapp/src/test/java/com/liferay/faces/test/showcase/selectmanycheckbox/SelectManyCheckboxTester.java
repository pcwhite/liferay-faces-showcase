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

import com.liferay.faces.test.selenium.Browser;
import com.liferay.faces.test.selenium.assertion.SeleniumAssert;
import com.liferay.faces.test.showcase.select.SelectTester;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class SelectManyCheckboxTester extends SelectTester {

	protected static final String selectmanycheckboxURL = TEST_CONTEXT_URL + "/selectmanycheckbox";
	protected static final String manyCheckbox1Xpath = "(//input[contains(@id,':selectManyCheckbox')])[1]";
	protected static final String manyCheckbox2Xpath = "(//input[contains(@id,':selectManyCheckbox')])[2]";
	protected static final String manyCheckbox3Xpath = "(//input[contains(@id,':selectManyCheckbox')])[3]";
	protected static final String manyCheckbox4Xpath = "(//input[contains(@id,':selectManyCheckbox')])[4]";

	protected void testManyCheckboxes(Browser browser, String answer1, String answer3, String answer4) {
		browser.click(manyCheckbox1Xpath);
		browser.click(manyCheckbox3Xpath);
		browser.click(manyCheckbox4Xpath);
		browser.clickAndWaitForAjaxRerender(submitButton1Xpath);
		SeleniumAssert.assertElementTextVisible(browser, modelValue1Xpath, answer1);
		SeleniumAssert.assertElementTextVisible(browser, modelValue1Xpath, answer3);
		SeleniumAssert.assertElementTextVisible(browser, modelValue1Xpath, answer4);
	}
}
