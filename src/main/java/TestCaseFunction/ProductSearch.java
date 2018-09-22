package TestCaseFunction;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import setUp.BasePage;

import static setUp.ReadJsonFile.readJsonFile;

/**
 * Created by ahmetbaltaci on 21.09.2018.
 */


public class ProductSearch extends BasePage {


    /** Html Resources**/

    private By productName = By.xpath("//li[@id='result_0']//h2");
    private By searchInput = By.id("twotabsearchtextbox");
    private By searchIcon = By.xpath("//input[@value='Go']");
    private By currency = By.xpath("//li[@id='result_0']//*[@class='sx-price-currency']");
    private By priceWhole = By.xpath("//li[@id='result_0']//*[@class='sx-price-whole']");
    private By priceFractional = By.xpath("//li[@id='result_0']//*[@class='sx-price-fractional']");
    private By retailPrice = By.xpath("//li[@id='result_0']//span[contains(@aria-label,'Suggested Retail Price:')]");
    private By productTitleDetail = By.id("productTitle");
    private By productPriceDetail = By.id("priceblock_ourprice");
    private By retailPriceDetail = By.className("a-text-strike");

    /** Getter Setter Variable **/

    private String firstItemName = null;
    private String firstItemPrice = null; //Retail Price
    private String firstItemLastPrice = null;

    public ProductSearch(WebDriver driver) {
        super(driver);
    }

    private String getItemName() {
        return firstItemName;
    }

    private void setItemName(String firstItemName) {
        this.firstItemName = firstItemName;
    }

    private String getItemPrice() {
        return firstItemPrice;
    }

    private void setItemPrice(String firstItemPrice) {
        this.firstItemPrice = firstItemPrice;
    }

    private String getItemLastPrice() {
        return firstItemLastPrice;
    }

    private void setLastPrice(String firstItemLastPrice) {
        this.firstItemLastPrice = firstItemLastPrice;
    }

    /** Test Case Functions **/

    public boolean titleControl() {
        return readJsonFile("title").equals(driver.getTitle());
    }

    public void searchItem(String item) {
        WebElement input = getElement(searchInput);
        input.clear();
        input.sendKeys(item);
        getElement(searchIcon).click();
    }

    public void itemSearchInfo() {
        getElement(productName);
        setItemName(getElement(productName).getText());
        setLastPrice(getElement(currency).getText() + getElement(priceWhole).getText() + "." + getElement(priceFractional).getText());

        /**** if product has retail price****/

        if (isDisplayed(retailPrice)) {
            setItemPrice(getElement(retailPrice).getText());
        }

    }

    public void clickForDetailPage() {
        getElement(productName).click();
    }

    public void detailPageAssert() {
        /** Product Title Assert in Detail Page**/
        Assert.assertEquals(getItemName(), getElement(productTitleDetail).getText());
        /** Product Price Assert in Detail Page**/
        Assert.assertEquals(getItemLastPrice(), getElement(productPriceDetail).getText());
        /** Product Retail Price Assert in Detail Page**/
        if (isDisplayed(retailPriceDetail)) {
            Assert.assertEquals(getItemPrice(), getElement(retailPriceDetail).getText());
        }

    }

}
