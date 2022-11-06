import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MenuPage {
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

    @Step("Проверка баннеров")
    public void bannersVisible() {
        banner1.shouldBe(Condition.visible);
        banner2.shouldBe(Condition.visible);
        banner3.shouldBe(Condition.visible);
        banner4.shouldBe(Condition.visible);
        banner5.shouldBe(Condition.visible);
        banner6.get(1).shouldBe(Condition.visible);
    }
    @Step("Проверка товаров дня")
    public void itemsDayVisible() {
        for (int i = 0; i < 9; i++) {
            itemsDay.get(i).shouldBe(Condition.visible);
            if (i < 8)
                buttonNext.click();
        }
    }
    @Step("Проверка хитов продаж")
    public void hitsItemsVisible() {
        for (int i = 0; i < 4; i++)
            hitsItems.get(i).scrollTo().shouldBe(Condition.visible);
    }
    @Step("Проверка подписок")
    public void promoVisible() {
        promo1.shouldBe(Condition.visible);
        promo2.shouldBe(Condition.visible);
        promo3.get(1).shouldBe(Condition.visible);
    }
    @Step("Проверка кнопки каталога и строки поиска")
    public void catalogAndSearchVisible() {
        buttonCatalog.shouldBe(Condition.visible);
        search.shouldBe(Condition.visible);
    }
    @Step("Открытие каталога и выбор категории")
    public void openCatalogAndSelectRandomСategory() {
        buttonCatalog.shouldBe(Condition.visible).click();
        int min = 0;
        int max = 17;
        max -= min;
        int rnd = (int) ((Math.random() * ++max) + min);
        collectionElementsCategorys.get(rnd).shouldBe(Condition.visible).click();
    }
}