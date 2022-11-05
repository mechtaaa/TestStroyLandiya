import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
public class FirstClass {
    SelenideElement banner1 = $(By.xpath("//img[@src='//static.stroylandiya.ru/upload/rk/8a4/qlt2jwd7954kcum8os1hxzo1m0afhqne.jpg?166729891699860']"));
    SelenideElement banner2 = $(By.xpath("//img[@src='//static.stroylandiya.ru/upload/rk/c12/xd81c818ydafly0fhnvepo6scdnkxtsb.jpg?166505536685452']"));
    SelenideElement banner3 = $(By.xpath("//img[@src='//static.stroylandiya.ru/upload/rk/af4/i5u0gbnovkurf09kwml39w30riiw54d8.jpg?1666956766114024']"));
    SelenideElement banner4 = $(By.xpath("//img[@src='//static.stroylandiya.ru/upload/rk/74b/kiac7323drhmhm0cgi87r7pcw8zjpuf7.jpg?1666097958100621']"));
    SelenideElement banner5 = $(By.xpath("//img[@src='//static.stroylandiya.ru/upload/rk/a5d/wb1wseyy298w1nyls2x1wu2xkuyxiojg.jpg?1667279512102005']"));
    ElementsCollection banner6 = $$(By.xpath("//img[@src='//static.stroylandiya.ru/upload/rk/9f4/fdc0m1dds7ce3jqvnx3i93ag9rexnu6q.jpg?1666338282316134']"));

    ElementsCollection itemsDay = $$(By.xpath("//div[@class='item-of-a-day--first']"));
    SelenideElement buttonNext = $(By.cssSelector(".main__banners-items-navigation-next-svg"));

    ElementsCollection hitsItems = $$(By.xpath("//div[@class='hits__item js-article-item']"));

    SelenideElement promo1 = $(By.xpath("//img[@src='//static.stroylandiya.ru/upload/rk/ad7/rpz4nvdv8fp3e2x6y1uka0vwmwwhpqrc.jpg?1667285296259183']"));
    SelenideElement promo2 = $(By.xpath("//img[@src='//static.stroylandiya.ru/upload/rk/19b/1laz6pbhwf2mpg343vbc3ommuxj5ojvc.jpg?1667459542168827']"));
    ElementsCollection promo3 = $$(By.xpath("//img[@src='//static.stroylandiya.ru/upload/rk/086/c2b1m6831rtuulfdxe1xeqrthpip8p1b.jpg?1666858362104236']"));
    SelenideElement buttonCatalog = $(By.xpath("//a[@class='dropdown-toggle header-v2-catalog']"));
    SelenideElement search = $(By.xpath("//input[@class='search-input digi-instant-search jc-ignore']"));

    ElementsCollection collectionElementsCategorys = $$(By.xpath("//a[@class='fb-header-catalog-menu__parent-link']"));
    ElementsCollection collectionElementsCatalogCategorys = $$(By.xpath("//a[@class='fb-category-image-link']"));
    SelenideElement countElements = $(By.cssSelector(".fb-catalog-listing-page__product-views-total"));

    SelenideElement searchTextCategory = $(By.xpath("//h1[@id='pagetitle']"));

    @Step("Проверка товаров дня")
    public void items(){
        itemsDay.get(0).shouldBe(Condition.visible);
        buttonNext.click();
        itemsDay.get(1).shouldBe(Condition.visible);
        buttonNext.click();
        itemsDay.get(2).shouldBe(Condition.visible);
        buttonNext.click();
        itemsDay.get(3).shouldBe(Condition.visible);
        buttonNext.click();
        itemsDay.get(4).shouldBe(Condition.visible);
        buttonNext.click();
        itemsDay.get(5).shouldBe(Condition.visible);
        buttonNext.click();
        itemsDay.get(6).shouldBe(Condition.visible);
        buttonNext.click();
        itemsDay.get(7).shouldBe(Condition.visible);
        buttonNext.click();
        itemsDay.get(8).shouldBe(Condition.visible);
    }
    @Step("Проверка баннеров")
    public void bannersVisible(){
        banner1.shouldBe(Condition.visible);
        banner2.shouldBe(Condition.visible);
        banner3.shouldBe(Condition.visible);
        banner4.shouldBe(Condition.visible);
        banner5.shouldBe(Condition.visible);
        banner6.get(1).shouldBe(Condition.visible);
    }
    @Step("Проверка хитов продаж")
    public void hitsItemsVisible(){
        hitsItems.get(0).shouldBe(Condition.visible);
        hitsItems.get(1).shouldBe(Condition.visible);
        hitsItems.get(2).shouldBe(Condition.visible);
        hitsItems.get(3).shouldBe(Condition.visible);
    }
    @Step("Проверка подписок")
    public void promoVisible(){
        promo1.shouldBe(Condition.visible);
        promo2.shouldBe(Condition.visible);
        promo3.get(1).shouldBe(Condition.visible);
    }
    @Step("Проверка кнопки каталога и строки поиска")
    public void catalogAndSearchVisible() {
        buttonCatalog.shouldBe(Condition.visible);
        search.shouldBe(Condition.visible);
    }
@Step("Открытие каталога и выбор рандомной категории")
    public void catalog(){
        buttonCatalog.click();
        int min = 0;
        int max = 17;
        max -= min;
        int rnd = (int) ((Math.random() * ++max) + min);
        collectionElementsCategorys.get(rnd).scrollTo().click();
    }
@Step("Выбор рандомной подкатегории, открытие и вывод названия категории")
@Attachment(value = "Название категории", type = "text/html")
    public void catalogCategory() {
        int min = 0;
        int max = collectionElementsCatalogCategorys.size();
        max -= min;
        int rnd = (int) ((Math.random() * ++max) + min);
        collectionElementsCatalogCategorys.get(rnd).click();
        String text = searchTextCategory.getText();

    }
@Step("Вывод колличества элементов категорий")
@Attachment(value = "Колличество эелементов категорий", type = "text/html")
    public String catalogSizeElements(){
        return countElements.getText();
    }


}