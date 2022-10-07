package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DescontosStep {

    WebDriver driver = new ChromeDriver();

    @Dado("^que estou no site qazando$")
    public void acessar_site_qazando() throws InterruptedException {
        driver.get("https://qazando.com.br/curso.html");
        driver.manage().window().maximize();

        Assert.assertEquals("Não acessou a aplicação!",true, driver.findElement(By.id("btn-ver-cursos")).isDisplayed());
    }

    @Quando("^eu preencho meu email$")
    public void eu_preencho_meu_email() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, 10000)");
        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("email@gmail.com");
    }

    @Quando("^clico em ganhar cupom$")
    public void clico_em_ganhar_cupom() throws InterruptedException {

        driver.findElement(By.id("button")).click();
    }

    @Então("^eu vejo o codigo de desconto$")
    public void eu_vejo_o_codigo_de_desconto() {
        String texto_cupom = driver.findElement(By.cssSelector("#cupom > h2 > span")).getText();

        Assert.assertEquals("QAZANDO15OFF", texto_cupom);
        System.out.println(texto_cupom);
    }
}
