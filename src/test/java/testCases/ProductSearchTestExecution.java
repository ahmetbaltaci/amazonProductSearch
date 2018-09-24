package testCases;

import listener.ListenerTestNG;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import setUp.BaseTest;
import testCaseFunction.ProductSearch;


/**
 * Created by ahmetbaltaci on 21.09.2018.
 */

@Listeners(ListenerTestNG.class)
public class ProductSearchTestExecution extends BaseTest {


    @Test
    public void productSearchTest(){
        ProductSearch items = new ProductSearch(driver);
        items.titleControl();
        items.searchItem("macbook air");
        items.itemSearchInfo();
        items.clickForDetailPage();
        items.detailPageAssert();
    }



}
