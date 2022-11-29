import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NegTest extends TestBase {



    @Test
    public void negAuthTest() throws InterruptedException {
        //попробуйте авторизоваться с плохими кредитами
        negAuth();

        //убедитесь, что отображается сообщение об ошибке
        checkForIncorrectData();
    }

    @Test
    public void managerAuthTest() throws InterruptedException {
        //авторизоваться как менеджер
        managerAuth();

        //Убедитесь, что на экране нет сообщения об ошибке
        checkClientsLink();
    }

    @Test
    public void GoodAuthBadAuth() throws InterruptedException {
        //попробуйте плохую авторизацию
        negAuth();
        Thread.sleep(2000);


        //попробуйте авторизацию менеджера
        managerAuth();
        //Убедитесь, что на экране нет сообщения об ошибке
        checkClientsLink();
    }

}






