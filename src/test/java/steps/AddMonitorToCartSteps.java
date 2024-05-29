package steps;

import io.cucumber.java.en.*;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.*;

public class AddMonitorToCartSteps {
	WebDriver driver = Hooks.driver;
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	ProductPage productPage;
	CartPage cartPage;
	String firstItemPrice;
	String secondItemPrice;

	String frameworkPath = System.getProperty("user.dir");

	public static String chromeDriverPath = System.getProperty("user.dir") + "/resources/chromedriver";

	@Given("I open Amazon website for the first")
	public void loadAmazonForFirstSearch() {

		System.out.println("path is " + chromeDriverPath);
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();

		driver.get("https://www.amazon.in");
		homePage = new HomePage(driver);
	}

	@When("I search for {string} first")
	public void firstSearch(String item) {
		homePage.searchForItem(item);
	}

	@When("I select the first item in the list first")
	public void selectFirstItemInList() {
		searchResultsPage = new SearchResultsPage(driver);
		searchResultsPage.selectFirstItem();
	}

	@When("I add the item to the cart first")
	public void addItemtoCart() {
		productPage = new ProductPage(driver);
	}

	@When("I open the cart first")
	public void openFirstCart() {
		cartPage = new CartPage(driver);
		cartPage.openCart();
	}

	@Then("the product price should match the cart price first")
	public void productPriceShouldMatchTheCartPriceForFirstProduct() {
		String productPrice = productPage.getProductPrice();
		String cartPrice = cartPage.getCartPrice();
		assertEquals(productPrice, cartPrice, "Product price and cart price do not match");
	}

	@Then("the sub total should match the product price first")
	public void subTotalShouldMatchTheProductPriceForFirstProduct() {
		String productPrice = productPage.getProductPrice();
		String subTotal = cartPage.getSubTotal();
		assertEquals(productPrice, subTotal, "Product price and cart sub total do not match");
		driver.quit();
	}

//     Second Scenario

	@Given("I open Amazon website second")
	public void loadAmazonForSecondSearch() {

		System.out.println("path is " + chromeDriverPath);
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();

		driver.get("https://www.amazon.in");
		homePage = new HomePage(driver);
	}

	@When("I search for {string} second")
	public void secondSearch(String item) {
		homePage.searchForItem(item);
	}

	@And("I select the second item in the list second")
	public void addSecondItemToList() throws InterruptedException {
		searchResultsPage = new SearchResultsPage(driver);
		searchResultsPage.selectSecondItem();
	}

	@And("I add the item to the cart second")
	public void selectSecondItemInList() {
		productPage = new ProductPage(driver);
	}

	@And("I open the cart second")
	public void openSecondCart() {
		cartPage = new CartPage(driver);
		cartPage.openCart();
	}

	@Then("the product price should match the cart price second")
	public void productPriceShouldMatchTheCartPriceForSecondProduct() {
		String productPrice = productPage.getProductPrice();
		String cartPrice = cartPage.getCartPrice();
		assertEquals(productPrice, cartPrice, "Product price and cart price do not match");
	}

	@And("the sub total should match the product price second")
	public void subTotalShouldMatchTheProductPriceForSecondProduct() {
		String productPrice = productPage.getProductPrice();
		String subTotal = cartPage.getSubTotal();
		assertEquals(productPrice, subTotal, "Product price and cart sub total do not match");
		driver.quit();
	}

//     Third Scenario

	@Given("I open Amazon website third")
	public void i_open_amazon_website() {

		System.out.println("path is " + chromeDriverPath);
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();

		driver.get("https://www.amazon.in");
		homePage = new HomePage(driver);
	}

	@When("I search for {string} third")
	public void i_search_for(String item) {
		homePage.searchForItem(item);
	}

	@And("I select the first item in the list third")
	public void i_select_the_first_item_in_the_list() throws InterruptedException {
		searchResultsPage = new SearchResultsPage(driver);
		searchResultsPage.selectFirstItem1();
	}

	@And("I add the first item to the cart third")
	public void i_add_the_first_item_to_the_cart() {
		productPage = new ProductPage(driver);

		cartPage = new CartPage(driver);
		cartPage.openCart();
		firstItemPrice = productPage.getProductPrice();

	}

	@And("I search again for {string} third")
	public void i_search_again_for(String item) {
		homePage.searchForItem(item);
	}

	@And("I select the second item in the list third")
	public void i_select_the_second_item_in_the_list() throws InterruptedException {
		searchResultsPage.selectFirstItem1();
	}

	@And("I add the second item to the cart third")
	public void i_add_the_second_item_to_the_cart() {
		cartPage.openCart();

		secondItemPrice = productPage.getProductPrice();
	}

	@And("I open the cart third")
	public void i_open_the_cart() {
		cartPage = new CartPage(driver);
	}

	@Then("each item price should match the product page price third")
	public void each_item_price_should_match_the_product_page_price() {
		String cartItemPrice = cartPage.getCartPrice();
		String productPrice = productPage.getProductPrice();
		assertEquals(productPrice, cartItemPrice, "Product price and cart price do not match");

	}

	@And("the sub total should be the sum of both item prices third")
	public void the_sub_total_should_be_the_sum_of_both_item_prices() {
		String productPrice = productPage.getTotalCartPrice();
		String subTotal = cartPage.getSubTotal();
		assertEquals(productPrice, subTotal, "Product price and cart sub total do not match");
		driver.quit();

	}

}
