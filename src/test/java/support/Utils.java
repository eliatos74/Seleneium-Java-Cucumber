package support;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumberTest;

import java.time.Duration;

public class Utils extends RunCucumberTest {

    public void esperarElemento(By elemento, int tempo){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tempo));
        wait.until(ExpectedConditions.elementToBeClickable(elemento));
    }

}
