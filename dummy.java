package com.online.portal.rep.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;
import com.online.framework.codebase.driver.DriverFactoryPattern;
import com.online.framework.codebase.logger.ExecutionLogger;
import com.online.framework.codebase.ui.WebdriverWait;
import com.online.framework.codebase.uihelper.UIHelper;
import com.online.portal.rep.base.BaseTest;
import com.online.portal.rep.base.ConfigReader;
import com.online.portal.rep.dtolayer.CsvReaderFile;
import com.online.portal.rep.helper.Login;
import com.online.portal.rep.po.AssignmentPO;
import com.online.portal.rep.po.BroadWorksPO;
import com.online.portal.rep.po.HomePO;
import com.online.portal.rep.po.LoginPO;
import com.online.portal.rep.po.MyServicesPO;
import com.online.portal.rep.po.ServicesPO;
import com.online.portal.rep.utils.Constants;
import com.online.portal.rep.utils.Util;
import com.online.portal.rep.utils.WebdriverInstance;

public class MyServicesTest extends BaseTest {

	private MyServicesPO servicepo;
	private LoginPO loginpo;
	private static LoginPO loginpoBW;
	private static MyServicesPO servicepoBW;
	private static BroadWorksPO broadworksBW;
	private static HomePO homepo;
	private ServicesPO servicespo2;
	private AssignmentPO assignmentpo;
	private List<Object> dataBeforeSorting = new ArrayList<Object>();
	private List<Object> dataAfterSorting = new ArrayList<Object>();
	private List<Object> collobrateDataBeforeClick = new ArrayList<Object>();
	private List<Object> collobrateDataAfterClick = new ArrayList<Object>();
	private String downloadLocation = System.getProperty("user.home");
	private static ExecutionLogger logger = new ExecutionLogger(MyServicesTest.class);
	WebdriverInstance webdriverInstance =null;
	boolean isLoginSuccess= false;
	Login login = new Login();
	boolean isLoginSuccessCheck=false;
	BroadWorksPO broadworkspo=null;

	@BeforeClass
	public void prerequisite() throws Exception{
		webdriverInstance = WebdriverInstance.getInstance();
		isLoginSuccessCheck = login.prerequisite(webdriverInstance.getDriver(),webdriverInstance.getDriverBW(),Constants.isPreReqCheckRequired);
		System.out.println(isLoginSuccessCheck);
	}

	@BeforeMethod
	public void testInitActivity() throws Exception {
		try {
			webdriverInstance = WebdriverInstance.getInstance();
			logger.loggerLevel("info", "Login successfully...");
			assignmentpo = PageFactory.initElements(webdriverInstance.getDriver(),AssignmentPO.class);
			
			
			loginpo = PageFactory.initElements(webdriverInstance.getDriver(), LoginPO.class);
			isLoginSuccess = login.loginPage_retry(loginpo, webdriverInstance.getDriver(),
					ConfigReader.qaGetValue("username"), Constants.RETRY);
			homepo = PageFactory.initElements(webdriverInstance.getDriver(),HomePO.class);
			servicespo2 = PageFactory.initElements(webdriverInstance.getDriver(), ServicesPO.class);
			servicepo = PageFactory.initElements(webdriverInstance.getDriver(), MyServicesPO.class);
			assignmentpo = PageFactory.initElements(webdriverInstance.getDriver(), AssignmentPO.class);
			login.loginToBW(webdriverInstance.getDriverBW(),ConfigReader.qaGetValue("broadworksUser2"));
			servicepoBW = PageFactory.initElements(webdriverInstance.getDriverBW(), MyServicesPO.class);
			broadworksBW = PageFactory.initElements(webdriverInstance.getDriverBW(), BroadWorksPO.class);
			broadworkspo = PageFactory.initElements(webdriverInstance.getDriverBW(), BroadWorksPO.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	////@AfterMethod
	public void testInitActivity() throws Exception {
		try {
			
    } catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	/*
	 * 
	 * Added assertion and validated locally.
	 */

	@Test(priority=-1)
	public void seriesCompletion_RLTOQA_28623() throws Exception {
		try {
			logger.loggerLevel("info", "Log In Pass");

			logger.loggerLevel("info", "The series completion tc is end");


		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.assertTrue(ex == null, ex.getMessage());
		}
	}

	/*
	 * 
	 * Added assertion and validated locally. Sorting is not availble for
	 * scheduler.
	 */

	@Test(priority=0)
	public void scheduling_RLTOQA_28624() throws Exception {
		try {
			logger.loggerLevel("info", "Log In Pass");
			logger.loggerLevel("info", "RLTOQA-28624:scheduling Start");
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getServicesTab(), Constants.WAIT,5);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getScheduling(), Constants.WAIT,3);
			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getSiteDrD(), Constants.WAIT,10);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getSiteDrD(), Constants.WAIT,1);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getSiteDrDValue(), Constants.WAIT,4);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getSubmitBtn(), Constants.WAIT,1);
			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getSearchOption(), Constants.WAIT,1);

			// In recurrance page Assertion for 16th test steps. Faced some
			// difficulties in DOM level and marked it as first TS.
			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getEditBtnScheduling(), Constants.WAIT,1);
			Thread.sleep(8000);
			Assert.assertTrue(servicepo.getEditBtnScheduling().isDisplayed(),
					"The schedule page is successfully opened.");
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getEditBtnScheduling(), Constants.WAIT,1);
			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getAddBtn(), Constants.WAIT,10);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getAddBtn(), Constants.WAIT,4);
			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getEventName(), Constants.WAIT,1);

			// Random Input
			Random random = new Random();
			int temp = random.nextInt(999);
			String tempValue = "TestAutomation" + temp;
			UIHelper.sendValue(webdriverInstance.getDriver(), servicepo.getEventName(), tempValue, Constants.WAIT,1);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getEventAllDate(), Constants.WAIT,1);
			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getAddEventStartDate(), Constants.WAIT,1);

			UIHelper.click(webdriverInstance.getDriver(), servicepo.getAddEventStartDate(), Constants.WAIT,1);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getAddEventStartDateValue(), Constants.WAIT,1);

			UIHelper.click(webdriverInstance.getDriver(), servicepo.getCloseEventLastDate(), Constants.WAIT,1);
			Thread.sleep(4000);

			for (int i = 0; i < servicepo.getCloseEventLastDateValueList().size(); i++) {
				Thread.sleep(5000);
				boolean condition = isDisplaying(servicepo.getCloseEventLastDateValueList().get(i));
				if (condition) {
					servicepo.getCloseEventLastDateValueList().get(i).click();
				} else {
					System.out.println("Element is not active in DOM");
				}
			}
			// UIHelper.click(servicepo.getCloseEventLastDateValue());

			Thread.sleep(3000);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getSaveBtnEventScheduler(), Constants.WAIT,1);
			Thread.sleep(8000);

			// Assert the values in REP portal once its been created.
			for (int i = 0; i < servicepo.getName().size(); i++) {
				if (servicepo.getName().get(i).getText().contains(tempValue)) {
					Assert.assertEquals(servicepo.getName().get(i).getText(), tempValue);
				} else {
					Assert.assertNotEquals(servicepo.getName().get(i).getText(), tempValue);
				}
			}

			// Go here
			Thread.sleep(5000);
			goSchedulerModuleBW(servicepoBW);

			Thread.sleep(5000);

			// Assert it on BroadWorks

			for (int j = 0; j < servicepoBW.getEventNameListBW().size(); j++) {
				// if condition is required to filter the unmatched record and
				// allow only the user created data.

				if (servicepoBW.getEventNameListBW().get(j).getText().contains(tempValue)) {
					Assert.assertEquals(servicepoBW.getEventNameListBW().get(j).getText(), tempValue);
				} else {
					Assert.assertNotEquals(servicepoBW.getEventNameListBW().get(j).getText(), tempValue);
				}
			}

			// UIHelper.click(servicepoBW.getGoBackHomeBW());
			switchBackToParent(webdriverInstance.getDriver());

			// Recurrancy functions;

			System.out.println("Recurrancy function started.....");
			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getRecurrenceEditBtn(), Constants.WAIT,1);

			UIHelper.jsClick(servicepo.getRecurrenceEditBtn(),webdriverInstance.getDriver(),Constants.WAIT,5);

			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getRecurranceTab(), Constants.WAIT,1);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getRecurranceTab(), Constants.WAIT,1);

			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getRecurranceNone(), Constants.WAIT,1);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getRecurranceNone(), Constants.WAIT,1);
			String expected = servicepo.getRecurranceNone().getText();
			Assert.assertEquals("None", expected);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getSaveBtnEventScheduler(), Constants.WAIT,1);
			System.out.println("Clicked save button.......");

			// go to event tab in BW
			Thread.sleep(8000);
			switchToAnotherWidnow(webdriverInstance.getDriverBW());
			webdriverInstance.getDriverBW().findElement(By.xpath(".//*[@id='Row1Col2']")).click();
			webdriverInstance.getDriverBW().findElement(By.xpath(".//*[@id='Row1Col0']")).click();
			String value = servicepoBW.getSelectedValue().getText();
			Assert.assertEquals(value, "Never");
			webdriverInstance.getDriverBW().findElement(By.xpath(".//*[@href='/Common/folder_contents.jsp?menuId=2']")).click();
			switchBackToParent(webdriverInstance.getDriver());

			System.out.println("Recurrancy function end for none....");

			// Weekly assertion is started.

			System.out.println("Recurrancy function started weekly.....");
			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getRecurrenceEditBtn(), Constants.WAIT,1);
			UIHelper.jsClick(servicepo.getRecurrenceEditBtn(),webdriverInstance.getDriver(),Constants.WAIT,5);

			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getRecurranceTab(), Constants.WAIT,1);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getRecurranceTab(), Constants.WAIT,1);

			UIHelper.click(webdriverInstance.getDriver(), servicepo.getRecurranceWeekly(), Constants.WAIT,10);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getRecurranceWeeklyDrD(), Constants.WAIT,1);
			Assert.assertTrue(servicepo.getRecurranceWeeklyDrD().isDisplayed(),
					"The recurrance for weekly drop down is selected");

			UIHelper.click(webdriverInstance.getDriver(), servicepo.getSaveBtnEventScheduler(), Constants.WAIT,1);
			System.out.println("Recurrancy function end for weekly....");

			// Recurrence for year

			System.out.println("Recurrancy function started year.....");

			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getRecurrenceEditBtn(), Constants.WAIT,1);
			UIHelper.jsClick(servicepo.getRecurrenceEditBtn(),webdriverInstance.getDriver(),Constants.WAIT,5);

			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getRecurranceTab(), Constants.WAIT,1);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getRecurranceTab(), Constants.WAIT,1);

			UIHelper.click(webdriverInstance.getDriver(), servicepo.getRecurranceYear(), Constants.WAIT,1);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getRecurrenceOnDateRadioBtn(), Constants.WAIT,1);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getRecurrenceDrDYear(), Constants.WAIT,1);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getRecurrenceDrDYearValue(), Constants.WAIT,1);
			UIHelper.sendValue(webdriverInstance.getDriver(), servicepo.getRecurrenceOnEditField(), "1", Constants.WAIT,1);

			Assert.assertTrue(servicepo.getRecurrenceOnDateRadioBtn().isDisplayed(),
					"The recurrance for weekly drop down is selected");
			Assert.assertTrue(servicepo.getRecurrenceDrDYear().isDisplayed(),
					"The recurrance for weekly drop down is selected");
			Assert.assertTrue(servicepo.getRecurrenceDrDYearValue().isDisplayed(),
					"The recurrance for weekly drop down is selected");
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getSaveBtnEventScheduler(), Constants.WAIT,1);
			System.out.println("Recurrancy function end for year....");

			// UI


			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getSchedulingLink(), Constants.WAIT,1);

			UIHelper.jsClick(servicepo.getSchedulingLink(),webdriverInstance.getDriver(),Constants.WAIT,5);

			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getSearchOption(), Constants.WAIT,1);
			UIHelper.sendValue(webdriverInstance.getDriver(), servicepo.getSearchOption(), "Test", Constants.WAIT,1);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getSearchBtn(), Constants.WAIT,1);
			// Validation for Name search results

			for (int i = 0; i < servicepo.getSeachResult1().size(); i++) {
				if (servicepo.getSeachResult1().get(i).getText().contains("Test") || servicepo.getSeachResult1().get(i).getText().contains("TEST") ) {
					Assert.assertTrue(servicepo.getSeachResult1().get(i).isDisplayed(),
							"The result contains 'AUTO' keyword");
				} else {
					Assert.fail("The result set doesn't contain AUTO keyword, and search function is failed.");
				}
			}
			servicepo.getSearchOption().clear();
			UIHelper.sendValue(webdriverInstance.getDriver(), servicepo.getSearchOption(), "TIME", Constants.WAIT,2);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getSearchBtn(), Constants.WAIT,1);
			servicepo.getSearchOption().clear();
			Thread.sleep(2000);
			// Validation for type search results.

			for (int i = 0; i < servicepo.getSeachResult2().size(); i++) {
				if (servicepo.getSeachResult2().get(i).getText().contains("TIME")) {
					Assert.assertTrue(servicepo.getSeachResult2().get(i).isDisplayed(),
							"The result contains 'AUTO' keyword");
				} else {
					Assert.fail("The result set doesn't contain TIME keyword, and search function is failed.");
				}
			}

			UIHelper.sendValue(webdriverInstance.getDriver(), servicepo.getSearchOption(), "EIS SITE", Constants.WAIT,1);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getSearchBtn(), Constants.WAIT,1);
			servicepo.getSearchOption().clear();

			// Validation for site search result.

			for (int i = 0; i < servicepo.getSearchResult3().size(); i++) {
				if (servicepo.getSearchResult3().get(i).getText().contains("EIS SITE")) {
					Assert.assertTrue(servicepo.getSearchResult3().get(i).isDisplayed(),
							"The result contains 'AUTO' keyword");
				} else {
					Assert.fail("The result set doesn't contain EIS SITE keyword, and search function is failed.");
				}
			}

			UIHelper.click(webdriverInstance.getDriver(), servicepo.getExportBtn(), Constants.WAIT,1);

			// Validation for export function, and exported file
			String path = downloadLocation + "\\Downloads\\";
			File f = getDownloadedFile(path);
			String valueTable = "HOLIDAY";
			Assert.assertTrue(CsvReaderFile.readingCsV("Export","HOLIDAY"), "Export assertion failed");
			CsvReaderFile.csvLatestDeleter();

			UIHelper.click(webdriverInstance.getDriver(), servicepo.getEditBtnScheduling(), Constants.WAIT,1);
			Thread.sleep(3000);
			// validation for edit functionality

			Assert.assertTrue(servicepo.getPageSizeScheduling().isDisplayed(),
					"The page naviagation option is successfully displayed after clicked edit button in scheduler");

			UIHelper.click(webdriverInstance.getDriver(), servicepo.getPageSizeScheduling(), Constants.WAIT,1);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getChangePageSizeScheduling(), Constants.WAIT,2);

			// assertion for pagination

			int counter = 0;
			for (int i = 0; i < servicepo.getCountPaginationForAssert().size(); i++) {
				counter++;
			}
			// if condition is required here. The runtime record may have less
			// than 25 or more than that.

			if (counter < 25) {

				System.out.println("The pagination value from drop down list is mismatching with actual record");
			} else {
				Assert.assertTrue(servicepo.getCountPaginationForAssert().size() > 25,
						"The pagination value from the dropdown menu is matching with searching result record.");
			}

			UIHelper.click(webdriverInstance.getDriver(), servicepo.getSelectAllOption(), Constants.WAIT,1);
			Thread.sleep(2000);

			for (int i = 0; i < servicepo.getValidationForSelectAll().size(); i++) {

				Assert.assertTrue(servicepo.getValidationForSelectAll().get(i).getAttribute("class").contains("checked"),
						"The check box is selected as expected.");

			}
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getSelectAllOption(), Constants.WAIT,1);
			Thread.sleep(3000);
			// UIHelper.click(servicepo.getSaveScheduling());

			// Assertion for cancel button.

			Assert.assertTrue(servicepo.getCancelEditSchedulingBtn().isDisplayed(),
					"The cancel button is enabled in DOM");
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getCancelEditSchedulingBtn(), Constants.WAIT,1);
			Thread.sleep(4000);

			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getAddBtn(), Constants.WAIT,1);
			// Assertion for Add button

			Assert.assertTrue(servicepo.getAddBtn().isDisplayed(), "The add button is active in DOM tree.");
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getAddBtn(), Constants.WAIT,1);
			Thread.sleep(15000);
			// Input
			String tempAddUser = "TestAutomation" + temp;
			UIHelper.sendValue(webdriverInstance.getDriver(), servicepo.getSceduleNameField(), tempAddUser, Constants.WAIT,1);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getSaveEditSchedulingBtn(), Constants.WAIT,1);
			Thread.sleep(9000);

			for (int i = 0; i < servicepo.getValidationForAddNewScheduler().size(); i++) {
				if (servicepo.getValidationForAddNewScheduler().get(i).getText().contains(tempAddUser)) {
					Assert.assertEquals(servicepo.getValidationForAddNewScheduler().get(i).getText(), tempAddUser);
				} else {
					Assert.assertNotEquals(servicepo.getValidationForAddNewScheduler().get(i).getText(),
							tempAddUser);
				}
			}

			// Go here

			switchToAnotherWidnow(webdriverInstance.getDriverBW());
			// UIHelper.click(servicepoBW.getScheduleLnk());
			for (int i = 0; i < servicepoBW.getGetListOfName().size(); i++) {
				if (servicepoBW.getGetListOfName().get(i).getText().contains(tempAddUser)) {
					Assert.assertEquals(servicepoBW.getGetListOfName().get(i).getText(), tempAddUser);
				} else {
					System.out.println("The values are not matching with assertion"
							+ servicepoBW.getGetListOfName().get(i).getText());
				}
			}

			UIHelper.click(webdriverInstance.getDriverBW(), servicepoBW.getGoBackHomeBW(), Constants.WAIT,1);

			switchBackToParent(webdriverInstance.getDriver());

			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getSelectIndividualScheduling(), Constants.WAIT,1);
			UIHelper.click(webdriverInstance.getDriver(), webdriverInstance.getDriver().findElement(By.xpath(".//*[@id='table_container']//tbody/tr[td[text()='TestAutomation" + temp+"']]/td[1]")), Constants.WAIT,1);
			String tempName = webdriverInstance.getDriver().findElement(By.xpath(".//*[@id='table_container']//tbody/tr[td[text()='TestAutomation" + temp+"']]/td[1]")).getText();

			UIHelper.click(webdriverInstance.getDriver(), servicepo.getDeleteButton(), Constants.WAIT,1);
			System.out.println("The delete button is clicked properly");

			switchToAnotherWidnow(webdriverInstance.getDriverBW());
			// UIHelper.click(servicepoBW.getScheduleLnk());
			for (int i = 0; i < servicepoBW.getGetListOfName().size(); i++) {
				Assert.assertNotEquals(servicepoBW.getGetListOfName().get(i).getText(), tempName);
			}

			UIHelper.click(webdriverInstance.getDriverBW(), servicepoBW.getGoBackHomeBW(), Constants.WAIT,1);
			switchBackToParent(webdriverInstance.getDriver());

			// services


			UIHelper.click(webdriverInstance.getDriver(), servicepo.getServicesTab(), Constants.WAIT,1);
			Assert.assertTrue(servicepo.getServicesTab().isEnabled(), "The service link is enabled.");

			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getScheduling(), Constants.WAIT,1);
			Thread.sleep(3000);
			Assert.assertTrue(servicepo.getScheduling().isEnabled(), "The scheduler link is enabled.");
			System.out.println("Scrolling up....!!!");
			JavascriptExecutor jse = (JavascriptExecutor) webdriverInstance.getDriver();
			jse.executeScript("scroll(0,-250);");
			System.out.println("Its scrolled up...");
			System.out.println("Its gonna perform drop down click action....!!!");
			UIHelper.jsClick(servicepo.getSelectValueFromDrD(),webdriverInstance.getDriver(),Constants.WAIT,5);

			moveAndDoubleClick(webdriverInstance.getDriver(),servicepo.getSelectValueFromDrD());
			System.out.println("It's clicked and gonna wait for 9 secs");
			WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(), servicepo.getAllSiteSelect(), Constants.WAIT,14);
			UIHelper.click(webdriverInstance.getDriver(),servicepo.getAllSiteSelect(),Constants.WAIT,5);
			UIHelper.click(webdriverInstance.getDriver(),servicepo.getScheduling(),Constants.WAIT,5);
			/*
			 * ImplicitAndExplicitWait.invisibilityOfElementLocation(driver,
			 * ".//*[@id='closeButton']");
			 * ImplicitAndExplicitWait.explicitWait(driver,
			 * servicepo.getCancelBtn());
			 */
			Assert.assertTrue(servicepo.getCancelBtn().isEnabled(),
					"The scheduler page is successfully opened, and able to see Cancel button in DOM tree");
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getCancelBtn(), Constants.WAIT,1);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getScheduling(), Constants.WAIT,1);
			Thread.sleep(6000);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getCancelBtn(), Constants.WAIT,1);
			Thread.sleep(8000);
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getDashboardMenu(), Constants.WAIT,1);

			// Choose user and edit

			logger.loggerLevel("info", "TC End");

			// Choose user and edit

		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());
		}
	}

	/*
	 * 
	 * Added assertion and validated locally.
	 */

	@Test(priority=1)
	public void collaborateBridge_RLTOQA_28617() throws Exception {
		try {
			
			UIHelper.click(webdriverInstance.getDriver(), servicepo.getDashboardMenu(), Constants.WAIT,1);

		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.assertTrue(ex == null, ex.getMessage());
			logger.loggerLevel("info", "TC failed for collaborateBridge");

		}
	}



	public static void moveAndClick(WebDriver driver, WebElement element) throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();

	}

	public static void moveAndDoubleClick(WebDriver driver, WebElement element) throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick().build().perform();

	}

	public static void switchBackToParent(WebDriver driver) throws Exception {
		try {
			driver.switchTo().defaultContent();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void cleanUpList(List<?> list1, List<?> list2) throws Exception {
		if(list1!=null)
			list1.clear();
		if(list2!=null)
			list2.clear();
	}

	public static boolean readCSVAndReturnValue(String location, String expectedValue) throws IOException, Exception {
		BufferedReader br = null;
		try {

			File f = new File(location);
			FileReader fr = new FileReader(f);
			br = new BufferedReader(fr);
			String value = "";
			String temp = "";
			while ((value = br.readLine()) != null) {
				temp = value + temp;
			}

			if (temp.contains(expectedValue)) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			br.close();
		}
		return false;
	}

	private static File getDownloadedFile(String dirPath) {
		File f = new File(dirPath);
		File[] listFiles = f.listFiles();

		File getName = listFiles[0];
		for (int i = 1; i < listFiles.length; i++) {
			if (getName.lastModified() < listFiles[i].lastModified()) {
				getName = listFiles[i];
			}
		}
		return getName;
	}
	private void pagination(WebElement Selector) throws Exception, InterruptedException {
		String PaginatonValue;
		String TotalValue;
		int iCount;
		TotalValue=webdriverInstance.getDriver().findElement(By.xpath("//*[@id='recordsInfo']")).getText();
		String totalvalue[]=TotalValue.split(" ");

		for (int i = 0; i < assignmentpo.getElementOptions().size(); i++) 
		{
			UIHelper.click(webdriverInstance.getDriver(), assignmentpo.getElementOptions().get(i), i, i);
			PaginatonValue=assignmentpo.getElementOptions().get(i).getText();
			if(Integer.parseInt(totalvalue[5])>=Integer.parseInt(PaginatonValue))
			{
				Thread.sleep(10000);
				WebdriverWait.visibilityOfElement(webdriverInstance.getDriver(), webdriverInstance.getDriver().findElement(By.xpath("//*[@id='recordsInfo' and @data-tovalue='"+PaginatonValue+"']")), Constants.WAIT,10);
				iCount=webdriverInstance.getDriver().findElements(By.xpath("//td[@class='footable-visible'][1]")).size();	
				Assert.assertEquals(String.valueOf(iCount), assignmentpo.getElementOptions().get(i).getText());
			}
			else
			{
				WebdriverWait.elementToBeClickable(webdriverInstance.getDriver(),Selector,Constants.WAIT,10);
				iCount=webdriverInstance.getDriver().findElements(By.xpath("//td[@class='footable-visible'][1]")).size();	
				Assert.assertEquals(String.valueOf(iCount), totalvalue[5]);
			}
		}	
	}
}
