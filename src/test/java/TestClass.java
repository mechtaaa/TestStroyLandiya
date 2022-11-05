import org.testng.annotations.Test;

public class TestClass extends BasePage {
    FirstClass firstClass = new FirstClass();
    @Test
    public void firstTest(){
//        firstClass.bannersVisible();
//        firstClass.items();
//        firstClass.hitsItemsVisible();
//        firstClass.promoVisible();
        firstClass.catalogAndSearchVisible();
        firstClass.catalog();
        firstClass.catalogCategory();
        firstClass.catalogSizeElements();
    }

}
