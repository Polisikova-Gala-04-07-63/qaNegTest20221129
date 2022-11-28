import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    WebDriver wd;

    @BeforeTest
    public void Prepare() {
        wd = new ChromeDriver();
        wd.get("https://derrick686.softr.app/login");
        wd.manage().window().maximize();
    }
    @AfterTest
    public void afterTest() {
        wd.close();
    }
    public void negAuth() throws InterruptedException {
        //Введите неправильный eMail
        WebElement eMail = wd.findElement(By.id("sw-form-capture-email-input"));
        eMail.click();
        eMail.clear();
        eMail.sendKeys("bill222mp5le.com");
        Thread.sleep(2000);

        //Введите неправильный пароль
        WebElement passWord = wd.findElement(By.id("sw-form-password-input"));
        passWord.click();
        passWord.clear();
        passWord.sendKeys("password");
        Thread.sleep(2000);

        //Отправить форму
        WebElement signIn = wd.findElement(By.id("sw-sign-in-submit-btn"));
        signIn.click();
        Thread.sleep(2000);
    }

    public void managerAuth() throws InterruptedException{

        //Введите адрес электронной почты менеджера
        WebElement eMail = wd.findElement(By.id("sw-form-capture-email-input"));
        eMail.click();
        eMail.clear();
        eMail.sendKeys("billye@example.com");
        Thread.sleep(2000);

        //Введите password менеджера
        WebElement passWord = wd.findElement(By.id("sw-form-password-input"));
        passWord.click();
        passWord.clear();
        passWord.sendKeys("123456");
        Thread.sleep(2000);

        //Отправить форму
        WebElement signIn = wd.findElement(By.id("sw-sign-in-submit-btn"));
        signIn.click();
        Thread.sleep(2000);

    }

    public void checkClientsLink(){
        //Ссылка «Проверить наличие клиентов» на странице
        WebElement clients = wd.findElement(By.xpath("//*[@id=\"home-header1\"]/div/div[1]/ul/li[2]/a"));
    }

    public void declareVariables(){
        //Объяление переменных
        String source = wd.getPageSource();
        String errorMessage = "Invalid email or password";
        System.out.println(source.contains(errorMessage));
        Boolean containsText = source.contains(errorMessage);
        Assert.assertEquals(containsText, Boolean.TRUE);
    }

}
