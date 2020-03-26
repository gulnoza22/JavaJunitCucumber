package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

public class Steps {

    public WebDriver driver;
    public LoginPage lp;

    @Given("the user navigates to login page {string}")
    public void the_user_navigates_to_login_page(String string) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("enable-features=NetworkServiceInProcess");
//        options.addArguments("enable-automation");
//        options.addArguments("--headless");
//        options.addArguments("--window-size=1920,1080");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-extensions");
//        options.addArguments("--dns-prefetch-disable");
//        options.addArguments("--disable-gpu");
//        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver = new ChromeDriver();
        lp=new LoginPage(driver);
        driver.get("https://admin-demo.nopcommerce.com/login");
    }

    @When("the user enters username as {string} and password as {string}")
    public void the_user_enters_username_as_and_password_as(String email, String password) {
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @When("the user click on login button")
    public void the_user_click_on_login_button() {
        lp.clickLogin();
    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            Assert.assertTrue(false);
        }else{
            Assert.assertEquals(title, driver.getTitle());
        }
    }

    @When("the user clicks on log out link")
    public void the_user_clicks_on_log_out_link() throws InterruptedException {
        lp.clickLogout();
        Thread.sleep(3000);
//        driver.close();
    }
}
