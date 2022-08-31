package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.log.Log;
import páginas.HomePage;
import páginas.LoginPage;

import java.time.Duration;

public class LoginSteps {

    private WebDriver driver;
    @Given("o usuário está na página de Login")
    public void oUsuárioEstáNaPáginaDeLogin() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_103\\chromedriver.exe");
        driver = (WebDriver) new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com");
    }

    @When("^o usuário preenche os campos de (.*) e (.*)$")
    public void oUsuárioPreencheOsCamposDeUsernameEPassword(String username, String password) {

        new LoginPage(driver)
                .preenhcerUsuario(username)
                .preencherSenha(password);
    }

    @And("e aperta o botão de login")
    public void eApertaOBotãoDeLogin() {
        new LoginPage(driver)
                .apertarOBotãoDeLogin();
    }

    @Then("o usuário é levado para a página inicial")
    public void oUsuárioÉLevadoParaAPáginaInicial() {
        String homePageMessage = new HomePage(driver)
                .páginaInicial();

        Assertions.assertEquals("PRODUCTS", homePageMessage);

        driver.quit();
    }

    @Given("o usuário inválido está na página de Login")
    public void oUsuárioInválidoEstáNaPáginaDeLogin() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_103\\chromedriver.exe");
        driver = (WebDriver) new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com");
    }

    @When("^o usuário inválido preenche os campos de (.*) e (.*)$")
    public void oUsuárioInválidoPreencheOsCamposDeUsernameInválidoEPasswordInválido(String usernameInválido, String passwordInválido) {
        new LoginPage(driver)
                .preenhcerUsuario(usernameInválido)
                .preencherSenha(passwordInválido);
    }

    @And("o usuário aperta o botão de login")
    public void oUsuárioApertaOBotãoDeLogin() {
        new LoginPage(driver)
                .apertarOBotãoDeLogin();
    }

    @Then("o usuário é impedido de seguir em frente")
    public void oUsuárioÉImpedidoDeSeguirEmFrente() {
        String unsuccessfulMessage = new HomePage(driver)
                .errorLogin();

        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service",
                unsuccessfulMessage);

        driver.quit();

    }
}
