package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//SPAN[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[2]")
	WebElement productPrice;

	@FindBy(xpath = "//INPUT[@id='add-to-cart-button']")
	WebElement addToCartButton;

	@FindBy(xpath = "(//SPAN[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[1]")
	WebElement cartTotalPrice;

	public String getProductPrice() {
		String productPagePrice = productPrice.getText();
		System.out.println("Product page price is " + productPagePrice);
		return productPagePrice;
	}

	public String getTotalCartPrice() {
		String cartPrice = cartTotalPrice.getText();
		System.out.println("Total Cart price is " + cartPrice);
		return cartPrice;
	}
}
