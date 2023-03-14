package Test2_driverMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManageMethod {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();//pencereyi tam sayfa yapar
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 saniye bekletir
       //1A-driver.manage().window().getSize() //içinde olduğu sayfanın pixel olarak ölçülerini döndürür
        System.out.println(driver.manage().window().getSize());//(1050,708)pixel
        System.out.println(driver.manage().window().getSize().height); //708 i verir sadece yükseklik
        //1-B driver.manage().window().getPosition() -->içinde olduğu sayfanın pixel olarak konumunu döndürür
        System.out.println(driver.manage().window().getPosition());//(10,10)


        //1-C driver.manage().window.setPosition(new Point(15,15));
        //icinde olduğu sayfanon sol alt köşesini bizim yazacağımız pixel noktasına taşır
        driver.manage().window().setPosition(new Point(15,15));


        //1-D driver.manage().window.setSize(new Dimension(900,600)
        //içinde olduğu sayfanın sol alt köşesi sabit olarak bizim yazacağımız ölçülere getirir
        driver.manage().window().setSize(new Dimension(516,400));

        System.out.println("yeni pencelere olculeri: " + driver.manage().window().getSize()); //(900,600)
        System.out.println("yeni pencelere olculeri: " + driver.manage().window().getPosition());//(15,15)

        //1-E driver.manage().window().maximize(); --> içinde olduğu sayfayı maximize yapar
        //1-F driver.manage().window().fullscreen();--> içinde olduğu sayfayı fullscreen yapar

        //Farklarını görmek için bu methodları kullanıp baslangıc noktalarını ve boyutlarını yazdıralım

        driver.manage().window().maximize();
        System.out.println("maximize konum:"+ driver.manage().window().getPosition());//(-8,-8)
        System.out.println("maximize boyut:"+driver.manage().window().getSize());//(1382,744)

        driver.manage().window().fullscreen();

        System.out.println("maximize konum:"+ driver.manage().window().getPosition());//(0,0)
        System.out.println("maximize boyut:"+driver.manage().window().getSize());//(1366,768)

        //1-G driver.manage().window().minimize(); --> sayfayi simge durumunda küçültür.
        driver.manage().window().minimize();


        //2-driver.manage().timeouts(). methods

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       /* //implicitlyWait : driver'a sayfanın yüklenmesi ve kullanacağımız web elementlerin bulunması için
        bekleyeceği maximum süreyi belirtir.Driver bu süre içerisinde sayfa yüklenir/web element bulunrsa
        beklemeden calısmaya devam eder.
        bu süre bittiği halde sayfa yüklenmemis/webElement bulunamamışsa expection vererek çalışmayı durdurur

        Duration.ofSeconds(15): Duration class'i Selenium-4 ile gelen zaman classıdır
        Yani driver'a ne kadar bekleyeceğini söyler
        Duration.ofSeconds(15) yerine milis,minutes,hours'da kullanılabilir.*/

       /* NOT: Driver'in istediğimiz işlemleri yaparken sorunla karşılaşmaması için
       * driver.manage() methodlarından
       * maximize() ve implicitlyWait() method'larinin her test'te kullanılması
       * FAYDALI OLACAKTIR.*/

    }
}
