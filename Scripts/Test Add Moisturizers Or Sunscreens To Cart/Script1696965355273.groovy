import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import ch.qos.logback.core.joran.conditional.ElseAction as ElseAction
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

if (GlobalVariable.PAGE_SHOP == 'Moisturizers') {
    WebUI.verifyElementPresent(findTestObject('Page_The Best Moisturizers in the World/h2_Moisturizers'), 15)

    aloe_btn = CustomKeywords.'common.myKeywords.find_least_expensive_item_by_name'('Aloe')

    aloe_btn.click()

    almond_btn = CustomKeywords.'common.myKeywords.find_least_expensive_item_by_name'('almond')

    almond_btn.click()
} else if (GlobalVariable.PAGE_SHOP == 'Sunscreens') {
    WebUI.verifyElementPresent(findTestObject('Page_The Best Sunscreens in the World/h2_Sunscreens'), 15)

    spf_50_btn = CustomKeywords.'common.myKeywords.find_least_expensive_item_by_name'('SPF-50')

    spf_50_btn.click()

    spf_30_btn = CustomKeywords.'common.myKeywords.find_least_expensive_item_by_name'('SPF-30')

    spf_30_btn.click()
}

WebUI.click(findTestObject('Object Repository/Page_The Best Sunscreens in the World/button_Cart'))

WebUI.verifyElementPresent(findTestObject('Page_Cart Items/h2_Checkout'), 15)

