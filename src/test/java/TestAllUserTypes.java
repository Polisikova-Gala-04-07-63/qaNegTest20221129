import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAllUserTypes extends TestBase {




    @Test
    public void managerAuthTest() throws InterruptedException {
        System.out.println("Running test LoginAsManager");

        //авторизоваться как менеджер
        managerAuth();

        ////Проверяем наличие ссылок на разделы портала на странице,
        // доступной менеджеру
        wd.findElement(By.partialLinkText("PROJECT OVERVIEW"));
        wd.findElement(By.partialLinkText("CLIENTS"));
        wd.findElement(By.partialLinkText("TEAM"));
        wd.findElement(By.partialLinkText("INVOICES"));
    }

    @Test
    public void clientAuthTest() throws InterruptedException{
        System.out.println("Running test LoginAsClient");

        //авторизоваться как клиент
        clientAuth();

        //Убедитесь, что ссылки на разделы портала представлены на
        // странице, доступной для клиента
        wd.findElement(By.partialLinkText("PROJECTS OVERVIEW"));
        wd.findElement(By.partialLinkText("INVOICES"));

        //Убедитесь, что больше нет ссылок от менеджера/консультанта:
        // **первый способ**


        org.testng.Assert.assertFalse(searchInPageSource("CLIENTS"));
        org.testng.Assert.assertFalse(searchInPageSource("TEAM"));

        //Убедитесь, что больше нет ссылок от менеджера/консультанта:
        // **второй способ**
        //Внимание к тому, что findElements используется вместо
        // findElement для получения пустого массива (ожидается)
        org.testng.Assert.assertTrue(wd.findElements(By.partialLinkText("CLIENTS")).isEmpty());
        org.testng.Assert.assertTrue(wd.findElements(By.partialLinkText("TEAM")).isEmpty());

    }

    @Test
    public void consultantAuthTest() throws InterruptedException {
        System.out.println("Running test LoginAsConsultant");

        //авторизоваться как консультант
        consultantAuth();

        //Проверяем наличие ссылок на разделы портала на странице,
        // доступной консультанту
        wd.findElement(By.partialLinkText("PROJECT OVERVIEW"));
        wd.findElement(By.partialLinkText("CLIENTS"));
        wd.findElement(By.partialLinkText("TEAM"));
        wd.findElement(By.partialLinkText("INVOICES"));
    }

    @AfterTest
    public void afterMLogout(){
        logout();
        System.out.println("Running after method: logging current user out");
    }
}


