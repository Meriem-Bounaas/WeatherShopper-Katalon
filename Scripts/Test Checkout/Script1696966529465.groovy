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

WebUI.verifyMatch(WebUI.getUrl(), url, false)

WebUI.verifyElementText(findTestObject('Page_Cart Items/h2_Checkout'), header)

int total_price = CustomKeywords.'common.myKeywords.getTotalCartPrice'()

WebUI.verifyElementText(findTestObject('Object Repository/Page_Cart Items/p_Total Rupees'), 'Total: Rupees ' + total_price)

WebUI.click(findTestObject('Object Repository/Page_Cart Items/span_Pay with Card'))

WebUI.setText(findTestObject('Object Repository/Page_Cart Items/input_Payer_email'), email)

CustomKeywords.'common.myKeywords.sendByChunk'(findTestObject('Object Repository/Page_Cart Items/input_Payer_card_number'), 
    card_number, 4)

CustomKeywords.'common.myKeywords.sendByChunk'(findTestObject('Page_Cart Items/input_Payer_cc-exp'), card_expires, 2)

WebUI.setText(findTestObject('Object Repository/Page_Cart Items/input_Payer_cc-csc'), card_cvv)

WebUI.setText(findTestObject('Object Repository/Page_Cart Items/input_Payer_zip'), zip_code)

WebUI.click(findTestObject('Object Repository/Page_Cart Items/span_Payer'))

WebUI.verifyElementPresent(findTestObject('Page_Confirmation/p_Your payment was successful. You should receive a follow-up call from our sales team'), 
    15)

WebUI.verifyElementText(findTestObject('Page_Confirmation/p_Your payment was successful. You should receive a follow-up call from our sales team'), 
    GlobalVariable.CONFIRMATION_SUCCESS_MESSAGE)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Confirmation/h2_PAYMENT SUCCESS'), GlobalVariable.CONFIRMATION_HEADER)

WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.CONFIRMATION_URL, false)

WebUI.closeBrowser()

