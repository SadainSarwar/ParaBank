package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

        private By usernameInputLocator = By.name("username");
        private By passwordInputLocator = By.name("password");
        private By loginButtonLocator = By.xpath("*//input[@type=\"submit\"]");
        private By forgotPasswordLinkLocator = By.linkText("Forgot login info?");
        private By logoutLinkLocator = By.linkText("Log Out");


                                    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
                                    // Methods
    public void enterUsername(String username) {
        WebElement usernameInput = driver.findElement(usernameInputLocator);
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public void clickForgottenPasswordLink() {
        WebElement forgottenPasswordLink = driver.findElement(forgotPasswordLinkLocator);
        forgottenPasswordLink.click();
    }

    public boolean checkForgotPwdLink(){
        return driver.findElement(forgotPasswordLinkLocator).isDisplayed();
    }

    public boolean checkLogoutLink(){
        return driver.findElement(logoutLinkLocator).isDisplayed();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getForgotPwdPageUrl(){
        String forgotPwdPageUrl = driver.getCurrentUrl();
        return forgotPwdPageUrl;
    }


}

