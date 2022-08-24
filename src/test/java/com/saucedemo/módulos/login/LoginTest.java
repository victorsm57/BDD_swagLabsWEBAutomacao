package com.saucedemo.módulos.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import páginas.LoginTestPages.HomePage;
import páginas.LoginTestPages.LoginPage;

import java.time.Duration;

public class LoginTest {

    private WebDriver driver;

    @Given("o usuário está na página de Login")
    public void oUsuárioEstáNaPáginaDeLogin() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_103\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com");
    }

    @When("o usuário preenche os campos de usuername e password")
    public void oUsuárioPreencheOsCamposDeUsuernameEPassword() {

        new LoginPage(driver)
                .preenhcerUsuario("standard_user")
                .preencherSenha("secret_sauce");
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
    }


}
