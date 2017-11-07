package ua.org.autotest;

        import org.junit.AfterClass;
        import org.junit.Assert;
        import org.junit.BeforeClass;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

        import java.util.concurrent.TimeUnit;

public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Android\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://eplaza.panasonic.ru");
        driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/div/ul/li[2]")).click();
    }
    @Test
    public void userLogin() {
        WebElement loginField = driver.findElement(By.xpath("//*[@id=\"inline_enter\"]/form/div/div[2]/div[1]/input"));
        loginField.sendKeys("q@q.ru");
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"inline_enter\"]/form/div/div[2]/div[2]/input"));
        passwordField.sendKeys("123123");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"js_auth_button\"]"));
        loginButton.click();/*
        WebElement profileUser = driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/div/div/div"));
        profileUser.click();
        WebElement personalUser = driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/div/div/ul/li[3]/a"));
        personalUser.click();
        WebElement mailUser = driver.findElement(By.xpath("//*[@id=\"personal_data_form\"]/div/div[4]/div[2]/input[1]"));
        String emailUser = emailUser.getText();
        Assert.assertEquals("q@q.ru", emailUser);*/
    }
    @AfterClass
    public static void tearDown() {
        WebElement menuUser = driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/div/div/div"));
        menuUser.click();
        WebElement logoutButton = driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/div/div/ul/li[4]/a"));
        logoutButton.click();
        driver.quit();
    }
}
