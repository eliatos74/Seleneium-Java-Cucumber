package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import pages.HomePage;
import runner.RunCucumberTest;

public class DescontosStep extends RunCucumberTest {

    HomePage homePage = new HomePage(driver);

    By email = By.id("email");
    By cliqueEmail = By.id("button");
    By cupom = By.cssSelector("#cupom > h2 > span");

    @Dado("^que estou no site qazando$")
    public void acessar_site_qazando() throws InterruptedException {
        homePage.acessarAplicacao();
    }

    @Quando("^eu preencho meu email$")
    public void eu_preencho_meu_email() throws InterruptedException {
        homePage.scrollDown();
        homePage.preencherEmail(email);
    }

    @Quando("^clico em ganhar cupom$")
    public void clico_em_ganhar_cupom() throws InterruptedException {
        homePage.cliqueGanharDesconto(cliqueEmail);
    }

    @Então("^eu vejo o codigo de desconto$")
    public void eu_vejo_o_codigo_de_desconto() {
        homePage.verificarCupomDesconto(cupom);
    }
}
