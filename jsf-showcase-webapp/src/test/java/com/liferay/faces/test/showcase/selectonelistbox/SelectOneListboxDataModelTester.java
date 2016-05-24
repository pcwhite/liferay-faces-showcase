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
package com.liferay.faces.test.showcase.selectonelistbox;

import org.junit.Test;

import com.liferay.faces.test.selenium.Browser;
import com.liferay.faces.test.showcase.selectonemenu.SelectOneMenuTester;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class SelectOneListboxDataModelTester extends SelectOneMenuTester {

	@Test
	public void runSelectOneListboxDataModelTest() throws Exception {
		Browser browser = Browser.getInstance();
		browser.get(TEST_CONTEXT_URL + "/selectonelistbox/data-model");

		String answer1 = "1";
		runSelectOneMenuDataModelTest1(browser, answer1);

		// Click the same listbox option to deselect:
		// https://github.com/seleniumhq/selenium-google-code-issue-archive/issues/1899#issuecomment-191480860
		browser.click(option1Xpath);

		String answer4 = "4";
		runSelectOneMenuDataModelTest2(browser, answer1, answer4);
	}
}
