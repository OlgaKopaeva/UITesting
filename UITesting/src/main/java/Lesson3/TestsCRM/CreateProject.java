package Lesson3.TestsCRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CreateProject {
    public static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    public static final String STUDENT_LOGIN = "Applanatest";
    public static final String STUDENT_PASSWORD = "Student2020!";
    public static final String PROJECT_NAME =  "WebDriverProject_6";

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

        driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[@class='dropdown'][1]")).click();
        driver.findElement(By.xpath("//li[@data-route='crm_project_my']")).click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='container-fluid page-title']"))).build().perform();
        driver.findElement(By.xpath("//div[@class='pull-left btn-group icons-holder']")).click();

        actions.moveToElement(driver.findElement(By.xpath("//div[@class='control-group control-group-text']"))).build().perform();
        driver.findElement(By.name("crm_project[name]")).click();
        driver.findElement(By.name("crm_project[name]")).sendKeys(PROJECT_NAME);
        actions.moveToElement(driver.findElement(By.className("controls"))).build().perform();
        actions.moveToElement(driver.findElement(By.className("company-container"))).build().perform();
        driver.findElement(By.className("select2-chosen")).click();
        driver.findElement(By.xpath("//ul[@class='select2-results']/li[4]/div")).click();

        actions.moveToElement(driver.findElement(By.name("crm_project[businessUnit]"))).build().perform();
        Select businessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnit.selectByIndex(1);

        actions.moveToElement(driver.findElement(By.name("crm_project[curator]"))).build().perform();
        Select curator = new Select(driver.findElement(By.name("crm_project[curator]")));
        curator.selectByIndex(1);

        actions.moveToElement(driver.findElement(By.name("crm_project[rp]"))).build().perform();
        Select rp = new Select(driver.findElement(By.name("crm_project[rp]")));
        rp.selectByIndex(1);

        actions.moveToElement(driver.findElement(By.name("crm_project[manager]"))).build().perform();
        Select manager = new Select(driver.findElement(By.name("crm_project[manager]")));
        manager.selectByIndex(1);

        actions.moveToElement(driver.findElement(By.xpath("//div[@class='responsive-cell crm-block responsive-cell-no-blocks']/div[@class='control-group control-group-choice'][1]"))).build().perform();
        Select contactMain = new Select(driver.findElement(By.name("crm_project[contactMain]")));
        contactMain.selectByIndex(1);

        driver.findElement(By.xpath("//button[@data-action='{\"route\":\"crm_project_index\"}']")).click();

        driver.quit();

    }
}

