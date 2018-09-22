package TestCaseFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import setUp.BasePage;

/**
 * Created by ahmetbaltaci on 21.09.2018.
 */

/****
 * Search items and assert value in detail page
 ****/

public class MatchProductPrice extends BasePage {

    /**
     * Html Resources
     **/

    private By currency = By.xpath("//li[@id='result_0']//*[@class='sx-price-currency']");
    private By priceWhole = By.xpath("//li[@id='result_0']//*[@class='sx-price-whole']");
    private By priceFractional = By.xpath("//li[@id='result_0']//*[@class='sx-price-fractional']");
    /** Getter Setter Variable **/

    private String secondItemPrice = null;
    private String firstItemLastPrice = null;

    public MatchProductPrice(WebDriver driver) {
        super(driver);
    }

    private String getSecondItemPrice() {
        return secondItemPrice;
    }

    private void setSecondItemPrice(String secondItemPrice) {
        this.secondItemPrice = secondItemPrice;
    }

    private String getItemLastPrice() {
        return firstItemLastPrice;
    }

    private void setLastPrice(String firstItemLastPrice) {
        this.firstItemLastPrice = firstItemLastPrice;
    }

    /** Test Case Functions **/

    public void firstProductPrice(){
        setLastPrice(getElement(currency).getText() + getElement(priceWhole).getText() + "." + getElement(priceFractional).getText());
    }

    public void secondProductPrice(){
        setSecondItemPrice(getElement(currency).getText() + getElement(priceWhole).getText() + "." + getElement(priceFractional).getText());
    }

    public void productPriceMatch() {


        if (Double.parseDouble(getItemLastPrice().replace("$","").replace(",","")) > Double.parseDouble(getSecondItemPrice().replace("$","").replace(",",""))) {
            System.out.println("First product is more expensive than second product");
        } else {
            System.out.println("Second product is more expensive than first product");
        }
    }


}
