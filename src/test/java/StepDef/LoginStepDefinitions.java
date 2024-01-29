package StepDef;

import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginStepDefinitions {

    private WebDriver driver;

    private LoginPage loginPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","D:\\Web Testing\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }


    @Given("I am on the ParaBank login page")
    public void I_am_on_the_Para_Bank_login_page() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage(driver);

    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.enterUsername("talalhassan");
        loginPage.enterPassword("talal12345");
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals(loginPage.checkLogoutLink(), true);
    }



    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMessage) {
        // Assert that an error message is displayed on the page matching the expected error message
        Assert.assertEquals( driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
    }

    @When("I click on the \"Forgot login info?\" link")
    public void i_click_on_the_forgot_login_info_link() {
        loginPage.clickForgottenPasswordLink();
    }

    @Then("I should be redirected to the customer lookup form")
    public void i_should_be_redirected_to_the_customer_lookup_form() {
        // Assert that the current URL contains the password reset page route
        Assert.assertTrue(loginPage.getForgotPwdPageUrl().contains("account/forgotten"));
    }


}
