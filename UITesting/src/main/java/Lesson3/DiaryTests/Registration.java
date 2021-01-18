package Lesson3.DiaryTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Registration {

    public static final String PAGE_URL = "https://www.diary.ru/";
    public static final String STUDENT_LOGIN = "testMyDiary4";
    public static final String STUDENT_PASSWORD = "testPassword";
    public static final String STUDENT_EMAIL = "testMyDiary4@mail.ru";


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[@class='navbar navbar-inverse']/div[@class='container']/ul[@class='nav navbar-nav navbar-index']/li[2]")).click();

        driver.switchTo().frame("modal-register");

        driver.findElement(By.cssSelector("input[id='usrlog']")).sendKeys(STUDENT_LOGIN);

        driver.findElement(By.cssSelector("input[id='usrpass']")).clear();
        driver.findElement(By.cssSelector("input[id='usrpass']")).sendKeys(STUDENT_PASSWORD);
        driver.findElement(By.cssSelector("input[id='usremail']")).sendKeys(STUDENT_EMAIL);

        driver.findElement(By.xpath("//input[@tabindex='6']")).click();
        driver.findElement(By.xpath("//button[@tabindex='5']")).click();

        driver.findElement(By.xpath("//a[@tabindex='9']")).click();

        driver.quit();

    }
}
