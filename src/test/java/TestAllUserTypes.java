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
        logger.info("печать текста : запуск теста LoginAsManager");

        //авторизоваться как менеджер
        managerAuth();
        logger.info("авторизоваться как менеджер");

        //Проверяем наличие ссылок на разделы портала на странице,
        // доступной менеджеру
        wd.findElement(By.partialLinkText("PROJECT OVERVIEW"));
        wd.findElement(By.partialLinkText("CLIENTS"));
        wd.findElement(By.partialLinkText("TEAM"));
        wd.findElement(By.partialLinkText("INVOICES"));
        logger.info("наличие ссылок на разделы портала на странице,доступной менеджеру");
    }

    @Test
    public void clientAuthTest() throws InterruptedException{
        System.out.println("Running test LoginAsClient");
        logger.info("печать текста : запуск теста LoginAsClient");

        //авторизоваться как клиент
        clientAuth();
        logger.info("авторизоваться как клиент");

        //Убедитесь, что ссылки на разделы портала представлены на
        // странице, доступной для клиента
        wd.findElement(By.partialLinkText("PROJECTS OVERVIEW"));
        wd.findElement(By.partialLinkText("INVOICES"));
        logger.info("ссылки представлены на странице, доступной клиенту");

        //Убедитесь, что больше нет ссылок от менеджера/консультанта:
        // **первый способ**
        org.testng.Assert.assertFalse(searchInPageSource("CLIENTS"));
        org.testng.Assert.assertFalse(searchInPageSource("TEAM"));
        logger.info("больше нет ссылок от менеджера/консультанта");
        //Убедитесь, что больше нет ссылок от менеджера/консультанта:
        // **второй способ**
        //Внимание к тому, что findElements используется вместо
        // findElement для получения пустого массива (ожидается)
        org.testng.Assert.assertTrue(wd.findElements(By.partialLinkText("CLIENTS")).isEmpty());
        org.testng.Assert.assertTrue(wd.findElements(By.partialLinkText("TEAM")).isEmpty());
        logger.info("больше нет ссылок от менеджера/консультанта");
    }

    @Test
    public void consultantAuthTest() throws InterruptedException {
        System.out.println("Running test LoginAsConsultant");
        logger.info("печать текста : запуск теста LoginAsConsultant");

        //авторизоваться как консультант
        consultantAuth();
        logger.info("авторизоваться как консультант");

        //Проверяем наличие ссылок на разделы портала на странице,
        // доступной консультанту
        wd.findElement(By.partialLinkText("PROJECT OVERVIEW"));
        wd.findElement(By.partialLinkText("CLIENTS"));
        wd.findElement(By.partialLinkText("TEAM"));
        wd.findElement(By.partialLinkText("INVOICES"));
        logger.info("наличие ссылок на разделы портала на странице,доступной консультарту");
    }

    @AfterTest
    public void afterMLogout(){
        logout();
        System.out.println("Running after method: logging current user out");
        logger.info("выход из системы текущего пользователя");
    }

}


