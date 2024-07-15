import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class herokuapp {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("btn-make-appointment")).click();
        Thread.sleep(3000);
        String CurrentURL = driver.getCurrentUrl();
        Assert.assertEquals(CurrentURL, "https://katalon-demo-cura.herokuapp.com/profile.php#login");

        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();

        String CurrentURL2 = driver.getCurrentUrl();
        Assert.assertEquals(CurrentURL2, "https://katalon-demo-cura.herokuapp.com/#appointment");

        System.out.println(driver.findElement(By.className("col-sm-12")).getText());
    }
}
