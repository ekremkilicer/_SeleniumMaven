package Test2_driverMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGetMethod {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");
      //içinde olduğu sayfanın baslıgını döndürür
        System.out.println("sayfa title:"+driver.getTitle());
        //içinde olduğu sayfanın URL'ini döndürür
        System.out.println(driver.getCurrentUrl());
        System.out.println("<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>");
        System.out.println(driver.getPageSource()); //Arka planda çalışan sayfa kodlarını yazdırır
        System.out.println("<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>");

    }
}
