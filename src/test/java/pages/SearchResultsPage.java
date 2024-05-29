package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lnw.genericlib.Constants;

public class SearchResultsPage {
	WebDriver driver;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//BUTTON[@id='a-autoid-1-announce']")
	WebElement firstItem;

	@FindBy(xpath = "//BUTTON[@id='a-autoid-2-announce']")
	WebElement secondItem;

	@FindBy(xpath = "//BUTTON[@id='a-autoid-3-announce']")
	WebElement firstItem1;

	@FindBy(xpath = "//div[@data-cel-widget='MAIN-SEARCH_RESULTS-4']//div[3]/div/div/div[@class='a-section a-spacing-none a-spacing-top-mini']/div/div/div/span/div/span/span/button[text()='Add to cart']")
	WebElement addToCart;

	@FindBy(xpath = "//div[@cel_widget_id='MAIN-SEARCH_RESULTS-3']//div[3]/div/div/div[@class='a-section a-spacing-none a-spacing-top-mini']/div/div/div/span/div/span/span/button[text()='Add to cart']")
	WebElement addToCart1;

	@FindBy(xpath = "//div[@cel_widget_id='MAIN-SEARCH_RESULTS-3']//div[2]/div/div/div[@class='a-section a-spacing-none a-spacing-top-mini']/div/div/div/span/div/span/span/button[text()='Add to cart']")
	WebElement addToCart2;

	@SuppressWarnings("deprecation")
	public void selectFirstItem() {
		driver.manage().timeouts().implicitlyWait(Constants.implicitWait, TimeUnit.SECONDS);

		try {

			if (firstItem.isDisplayed() == true)

				firstItem.click();

		} catch (Exception e) {
			firstItem1.click();
		}
	}

	public void selectFirstItem1() throws InterruptedException {
		Thread.sleep(1000);

		try {
			if (addToCart.isDisplayed()) {
				addToCart.click();
				Thread.sleep(1000);
			} else if (addToCart1.isDisplayed()) {
				addToCart1.click();
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			addToCart2.click();
			Thread.sleep(1000);

		}
	}

	public void selectSecondItem() throws InterruptedException {

		secondItem.click();
		Thread.sleep(1000);
	}
}
