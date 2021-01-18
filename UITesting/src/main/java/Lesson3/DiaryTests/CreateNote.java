package Lesson3.DiaryTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class CreateNote {
    public static final String PAGE_URL = "https://www.diary.ru/";
    public static final String STUDENT_LOGIN = "testMyDiary3";
    public static final String STUDENT_PASSWORD = "testPassword";
    public static final String NOTE_HEADER = "MyDayToday";
    public static final String MESSAGE = "Day is good!";

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[@class='navbar navbar-inverse']/div[@class='container']/ul[@class='nav navbar-nav navbar-index']/li[1]")).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@id='loginform']"))).build().perform();

        driver.findElement(By.cssSelector("input[name='user_login']")).sendKeys(STUDENT_LOGIN);
        driver.findElement(By.cssSelector("input[name='user_pass']")).sendKeys(STUDENT_PASSWORD);

        actions.moveToElement(driver.findElement(By.xpath("//div[@id='loginform']/form/button"))).build().perform();
        driver.findElement(By.xpath("//div[@id='loginform']/form/button")).click();

        driver.findElement(By.xpath("//div[@class='navbar navbar-inverse']/div[@class='container']/ul[@class='nav navbar-nav navbar-user']/li[2]")).click();

        driver.findElement(By.cssSelector("input[id='postTitle']")).sendKeys(NOTE_HEADER);

        driver.findElement(By.cssSelector("textarea[id='message']")).sendKeys(MESSAGE);
        driver.findElement(By.cssSelector("input[id='rewrite']")).click();


        driver.quit();
    }

}
