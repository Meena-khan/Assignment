package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lnw.genericlib.Constants;

public class CartPage {
	WebDriver driver;


	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "span#sc-subtotal-amount-activecart span")
	WebElement subTotal;

	@FindBy(xpath = "(//SPAN[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[1]")
	WebElement cartPrice;

	@FindBy(xpath = "//div[@data-cart-type='Retail_Cart']/div[2]/span/span")
	WebElement viewCart;

	@FindBy(xpath = "//A[@id='attach-close_sideSheet-link']")
	WebElement cartCrossIcon;

	@SuppressWarnings("deprecation")
	public void openCart() {
		driver.manage().timeouts().implicitlyWait(Constants.implicitWait, TimeUnit.SECONDS);
		viewCart.click();

	}

	public String getSubTotal() {
		return subTotal.getText();
	}

	public String getCartPrice() {
		return cartPrice.getText();
	}
}
