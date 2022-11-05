import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {
    @BeforeTest
    public static void settings() {
        timeout = 30000;
        browser = "chrome";
        Configuration.browserSize = "1280x1024"; // на весь экран
        open("https://stroylandiya.ru/");
    }
}