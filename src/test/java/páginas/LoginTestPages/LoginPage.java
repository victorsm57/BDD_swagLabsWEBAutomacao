package páginas.LoginTestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "user-name")
    WebElement inputUser;
    @FindBy(id = "password")
    WebElement inputPassword;
    @FindBy (id = "login-button")
    WebElement btt_click;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public LoginPage preenhcerUsuario(String user){
        inputUser.sendKeys(user);
        return this;
    }
    public LoginPage preencherSenha(String password){
        inputPassword.sendKeys(password);
        return this;
    }
    public HomePage apertarOBotãoDeLogin(){
        btt_click.click();
        return new HomePage(driver);
    }
}
