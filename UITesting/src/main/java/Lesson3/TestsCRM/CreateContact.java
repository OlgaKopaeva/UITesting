package Lesson3.TestsCRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class CreateContact {
    public static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    public static final String STUDENT_LOGIN = "Applanatest";
    public static final String STUDENT_PASSWORD = "Student2020!";
    public static final String CONTACT_LASTNAME = "Test1_LastName";
    public static final String CONTACT_FIRSTNAME = "Test1_FirstName";
    public static final String CONTACT_JOBTITLE =  "Test1_jobTitle";




    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(LOGIN_PAGE_URL);
        driver.manage().window().maximize();
        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);
        WebElement passwordTextInput = driver.findElement(By.cssSelector("input[id='prependedInput2']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);
        driver.findElement(By.name("_submit")).click();


        driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[@class='dropdown first']")).click();
        driver.findElement(By.xpath("//li[@data-route='crm_contact_index']")).click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='pull-left btn-group icons-holder']"))).build().perform();
        driver.findElement(By.xpath("//div[@class='pull-left btn-group icons-holder']")).click();

        driver.findElement(By.name("crm_contact[lastName]")).click();
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys(CONTACT_LASTNAME);

        driver.findElement(By.name("crm_contact[firstName]")).click();
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys(CONTACT_FIRSTNAME);

        actions.moveToElement(driver.findElement(By.className("company-container"))).build().perform();
        driver.findElement(By.className("select2-chosen")).click();
        driver.findElement(By.xpath("//ul[@class='select2-results']/li[4]/div")).click();

        actions.moveToElement(driver.findElement(By.xpath("//div[@class='control-group control-group-text']"))).build().perform();
        driver.findElement(By.name("crm_contact[jobTitle]")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys(CONTACT_JOBTITLE);

        driver.findElement(By.xpath("//button[@data-action='{\"route\":\"crm_contact_index\"}']")).click();

        driver.quit();

    }

}
