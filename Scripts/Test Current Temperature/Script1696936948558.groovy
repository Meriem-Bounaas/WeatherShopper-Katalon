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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.URL_BASE)

WebUI.maximizeWindow()

WebUI.verifyElementPresent(findTestObject('Page_Current Temperature/h2_Current temperature'), 15)

temperature = (WebUI.getText(findTestObject('Object Repository/Page_Current Temperature/span_temperature')).split(' ')[0])

if (Integer.parseInt(temperature) < 19) {
    WebUI.click(findTestObject('Object Repository/Page_Current Temperature/button_Buy moisturizers'))

    WebUI.verifyElementPresent(findTestObject('Page_The Best Moisturizers in the World/h2_Moisturizers'), 15)

    GlobalVariable.PAGE_SHOP = 'Moisturizers'

    println(GlobalVariable.PAGE_SHOP)
} else {
    WebUI.click(findTestObject('Object Repository/Page_Current Temperature/button_Buy sunscreens'))

    WebUI.verifyElementPresent(findTestObject('Page_The Best Sunscreens in the World/h2_Sunscreens'), 15)

    GlobalVariable.PAGE_SHOP = 'Sunscreens'

    println(GlobalVariable.PAGE_SHOP)
}

