package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CategoryPage {

    ElementsCollection collectionElementsCatalogCategorys = $$(By.xpath("//a[@class='fb-category-image-link']"));
    SelenideElement countElements = $(By.cssSelector(".fb-catalog-listing-page__product-views-total"));
    SelenideElement searchTextCategory = $(By.xpath("//h1[@id='pagetitle']"));
    ElementsCollection filterPrice = $$(By.xpath("//input[@data-split-digits='1']"));
    ElementsCollection items = $$(By.xpath("//div[@class='fb-product-card__title']"));

    @Step("Выбор рандомной подкатегории, открытие и вывод названия категории")
    public void selectRandomaSubcategory() {
        int min = 0;
        int max = collectionElementsCatalogCategorys.size() - 1;
        max -= min;
        int rnd = (int) ((Math.random() * ++max) + min);
        collectionElementsCatalogCategorys.get(rnd).shouldBe(Condition.visible).click();
        Allure.addAttachment("Название категории", searchTextCategory.getText());
        Allure.addAttachment("Количество элементов", countElements.getText());
    }

    @Step("Фильтр товара")
    public void setFiltersPrice() {
        filterPrice.get(0).shouldBe(Condition.visible).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        filterPrice.get(0).shouldBe(Condition.visible).sendKeys(Keys.BACK_SPACE);
        filterPrice.get(0).shouldBe(Condition.visible).sendKeys("30");
        filterPrice.get(1).shouldBe(Condition.disabled).shouldBe(Condition.enabled).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        filterPrice.get(1).shouldBe(Condition.visible).sendKeys(Keys.BACK_SPACE);
        filterPrice.get(1).shouldBe(Condition.visible).sendKeys("1000");
        Allure.addAttachment("Название фильтра", "Цена");
        Allure.addAttachment("Количество товаров", countElements.getText());
    }

    @Step("Выбор рандомного товара")
    public void selectRandomItem() {
        int min = 0;
        int max = items.size() - 1;
        max -= min;
        int rnd = (int) ((Math.random() * ++max) + min);
        items.get(rnd).shouldBe(Condition.enabled).click();
    }

}
