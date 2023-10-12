package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver

import internal.GlobalVariable

public class myKeywords {
	@Keyword (keywordObject = "total_price")
	def getTotalCartPrice() {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> prices = driver.findElements(By.xpath('/html/body/div[1]/div[2]/table/tbody/tr/td[2]'))

		int sum = 0
		for (price in prices) {
			sum += Integer.parseInt(price.text.split(' ').last())
		}
		return sum
	}

	@Keyword (keywordObject = "sendByChunk")
	def sendByChunk(TestObject input, String text, int chunk_size) {
		for (def chunk : text.split('(?<=\\G.{' + chunk_size + '})')) {
			WebUI.sendKeys(input, chunk)
		}
	}

	@Keyword (keywordObject = "least_expensive")
	def find_least_expensive_item_by_name(String name) {

		List<WebElement> selectedPrices = DriverFactory.getWebDriver().findElements(By.xpath("//p[contains(text(), '${name.toUpperCase()}') or contains(text(), '${name.toLowerCase()}') or contains(text(), '${name.capitalize()}')]/following-sibling::p"))

		List<Integer> prices = []
		selectedPrices.each { priceElement ->
			String priceText = priceElement.text
			int priceValue = Integer.parseInt(priceText.split(' ')[-1])
			prices.add(priceValue)
		}

		int least_expensive_price = prices.min()
		println(least_expensive_price)

		return DriverFactory.getWebDriver().findElement(By.xpath("//button[contains(@onclick, '" + least_expensive_price + "')]"))
	}

	@Keyword (keywordObject = "get_length_invalid_inputs")
	def get_length_invalid_inputs() {

		WebElement frame_element = DriverFactory.getWebDriver().findElement(By.xpath("//iframe[@name='stripe_checkout_app']"))

		DriverFactory.getWebDriver().switchTo().frame(frame_element)

		List<WebElement> invalidInputs = DriverFactory.getWebDriver().findElements(By.xpath("//input[contains(@class, 'invalid')]"))

		DriverFactory.getWebDriver().switchTo().defaultContent()

		return invalidInputs.size()
	}
}
