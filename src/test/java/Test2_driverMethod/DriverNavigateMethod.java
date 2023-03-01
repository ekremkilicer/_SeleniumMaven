package Test2_driverMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverNavigateMethod {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.navigate().to("https://www.facebook.com");// navigate ile yapınca geriye gitmek ve ileri sayfaya gitmek mümkün olur
        driver.navigate().back();//amazona geri dönmemizi sağlar
        driver.navigate().forward();//back ile geldiği sayfaya yeniden gider.
        driver.navigate().refresh();//içinde olduğu sayfayı yeniler.
        //driver.close();//driver oluşturduğumuzda açılan sayfayı kapatmamızı sağlar.(içinde bulunduğu browseri kapatır
        driver.quit();//Açılan birden fazla tab veya window açtıysa tümünü kapatır.

    }

}
