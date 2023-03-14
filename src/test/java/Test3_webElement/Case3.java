package Test3_webElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

public class Case3 {

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup(); //gerekli ayarları yapar
        WebDriver driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1-https://www.bestbuy.com adresine gidin
        driver.get("https:www.bestbuy.com");
        //2-cookies cikarsa kabul et butonuna basin
        //3-sayfada kaç adet buton bulunduğunu yazdırın
        List<WebElement> buttonListesi=driver.findElements(By.tagName("button")); // bütün butonları liste olarak getirir elements olmasına dikkat et
        System.out.println(buttonListesi.size());
        //4-sayfadaki herbir buton üzerindeki yazıları yazdırın
        for (WebElement each :buttonListesi
             ) {
            System.out.println(each.getText());

        }
    }
}
