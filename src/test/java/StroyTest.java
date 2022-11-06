import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.back;

public class StroyTest  extends BasePage {
    MenuPage menuPage = new MenuPage();
    CategoryPage categoryPage = new CategoryPage();
    ItemPage itemPage = new ItemPage();

    @Test
    public void scenarioTest() {
        menuPage.bannersVisible();
        menuPage.itemsDayVisible();
        menuPage.hitsItemsVisible();
        menuPage.promoVisible();
        menuPage.catalogAndSearchVisible();
        menuPage.openCatalogAndSelectRandomСategory();
        categoryPage.selectRandomaSubcategory();
        categoryPage.setFiltersPrice();
        categoryPage.selectRandomItem();
        itemPage.addItemToCart();
        back();
        categoryPage.selectRandomItem();
        itemPage.addItemToCart();
    }
}