package testCases;

import TestCaseFunction.MatchProductPrice;
import TestCaseFunction.ProductSearch;

import listener.TestExecution;
import org.junit.Test;
import org.junit.runner.RunWith;
import setUp.BaseTest;

/**
 * Created by ahmetbaltaci on 21.09.2018.
 */

@RunWith(TestExecution.class)
public class MatchProductPriceTestExecution extends BaseTest{


    @Test
    public void matchProductPrice(){
        ProductSearch items = new ProductSearch(driver);
        MatchProductPrice matchProductPrice = new MatchProductPrice(driver);
        items.titleControl();
        items.searchItem("macbook air");
        matchProductPrice.firstProductPrice();
        driver.navigate().back();
        items.searchItem("macbook pro");
        matchProductPrice.secondProductPrice();
        matchProductPrice.productPriceMatch();

    }


}
