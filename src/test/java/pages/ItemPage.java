package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ItemPage {
    SelenideElement buttonAddToCart = $(By.xpath("//div[@class='p_product_shoping--wrapper']"));
    SelenideElement nameItem = $(By.xpath("//h1[@class='dcol-8']"));
    SelenideElement redPriceItem = $(By.xpath("//div[@class=\"h1 color-red \"]"));
    SelenideElement whitePriceItem = $(By.xpath("//div[@class=\"h1 \"]"));
    SelenideElement scoreItem = $(By.xpath("//div[@class='p_product_shoping--wrapper']//input[@class='product_card_qty--input ']"));

    @Step("Добавление товара в корзину")
    public void addItemToCart() {
        //        Проверка, что товар в наличии
        if (buttonAddToCart.exists()) {
            buttonAddToCart.shouldBe(Condition.visible).click();
            Allure.addAttachment("Наименование товара", nameItem.getText());
//            Проверка, что у товара есть красная цена
            if (redPriceItem.exists())
                Allure.addAttachment("Цена", redPriceItem.getText());
            else
                Allure.addAttachment("Цена", whitePriceItem.getText());
            Allure.addAttachment("Количество товара", scoreItem.getValue());
        } else {
            Allure.addAttachment("Наименование товара", nameItem.getText());
            Allure.addAttachment("Наличие в продаже", "Товар временно отсутствует в продаже");
        }
    }
}
