package Test3_webElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Case1 {

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup(); //gerekli ayarları yapar
        WebDriver driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1-https:www.amazon.com sayfasına gidin
        driver.get("https:www.amazon.com");
        //2-arama çubuğuna "Nutella" yazdırın
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Nutella");
        //3-Nutella yazdıktan sonra ENTER'a basarak arama işlemi yapın
        aramaKutusu.submit();
        //4-Bulunan sonuç sayfasını yazdırın
WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
System.out.println(sonucYaziElementi.getText());
driver.close();
    }
}
