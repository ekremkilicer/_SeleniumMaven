package Test3_webElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Case2 {

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup(); //gerekli ayarları yapar
        WebDriver driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1-https://www.facebook.com adresine gidin
        driver.get("https:www.facebook.com");
        //2-cookies cikarsa kabul et butonuna basın
       /* driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']")).click();*/
        //3-e posta kutusuna rastgele bir mail girin
        WebElement epostaKutusu=driver.findElement(By.xpath("//input[@id='email']"));
        epostaKutusu.sendKeys("opropworo");
        //4-sifre kısmına rastgele bir şifre girin
        WebElement passKutusu=driver.findElement(By.xpath("//input[@id='pass']"));
        passKutusu.sendKeys("asdasdasd");
        //5-giris yap butonbuna basın
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //6-uyarı olarak "The mail or mobile number vs.." mesajının çıktığını test edin
        WebElement sonucYaziElemeti=driver.findElement(By.xpath("//div[@class='_9ay7']"));
        String expectedSonucYazisi="Girdiğin e-posta veya cep telefonu numarası bir hesaba bağlı değil. Hesabını bul ve giriş yap.";
        String actualSonucYazisi=sonucYaziElemeti.getText();
        if (expectedSonucYazisi.equals(actualSonucYazisi)){
            System.out.println("girilemedi testi passed");
        }else{
            System.out.println("girilemedi testi failed");
        }
        //7-sayfayı kapatın
        driver.close();
    }
}
