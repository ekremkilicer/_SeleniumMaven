package Test6_JUnitAssertionOrnekler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C01_JUnitAssertion {

    @Test
    public void test01() {
        //1-Launch browser
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2. Navigate to url "'"http://automationexercise.com");
        driver.get("http://automationexercise.com");
        //3. HomePage'nin başarılı bir şekilde gözüktüğünü test et.
        WebElement logoElement = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElement.isDisplayed()); // isDisplayed methodu o methodun görünüp görünmediğini bize döndürür.
        //4. SignUp ya da Login butonuna bas
        WebElement signUpLinki = driver.findElement(By.xpath( "//a[text()=' Signup / Login']"));
        signUpLinki.click();
        //5.Login To your account yazısının görünür olduğunu test et
        WebElement loginYaziElementi = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue((loginYaziElementi.isDisplayed()));
        //6.Sayfaya doğru kullanıcı adı ve şifre yazın.
        WebElement emailAdresKutusu=driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailAdresKutusu.sendKeys("ekremkilicer34@gmail.com");
        WebElement passwordKutusu=driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        passwordKutusu.sendKeys("963852741");
        //7.Login butonuna bas
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        //8.Verify that 'Logged in as username' nin gözüktüğünü test et
        WebElement loggedInYazisi=driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(loggedInYazisi.isDisplayed());
         //9.LogOut butonuna bas
        WebElement logOutLinki = driver.findElement(By.xpath("//a[text()=' Logout']"));
        logOutLinki.click();
        //10. LogIn sayfasına geldiğimizi test edin
        String expectedUrl="https://automationexercise.com/login"; //beklenen url ile gerçekleşen url eşitse ana sayfaya gelmişizdir
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        //11.Dirver Kapat
        driver.close();
    }
}
