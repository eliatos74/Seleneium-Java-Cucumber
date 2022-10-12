package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import support.Utils;

public class HomePage extends Utils {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarAplicacao() {
        driver.get("https://qazando.com.br/curso.html");
        driver.manage().window().maximize();
        esperarElemento(By.id("btn-ver-cursos"),10);
        Assert.assertEquals("Não acessou a aplicação!", true, driver.findElement(By.id("btn-ver-cursos")).isDisplayed());
    }

    public void scrollDown() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, 10000)");
        Thread.sleep(2000);
    }

    public void preencherEmail(By email) {
        driver.findElement(email).sendKeys("email@gmail.com");
    }

    public void cliqueGanharDesconto(By cliqueEmail) {
        driver.findElement(cliqueEmail).click();
    }

    public void verificarCupomDesconto(By cupom) {
        String texto_cupom = driver.findElement(cupom).getText();
        Assert.assertEquals("O cupom esta errado!", "QAZANDO15OFF", texto_cupom);
    }
}
