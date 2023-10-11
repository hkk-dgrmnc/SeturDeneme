import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class SearchPage extends BasePage{

    private final By otherLocations = By.cssSelector("div.styled__DesktopItems-sc-xe39ep-2>div>div");
    private final By getOtherLocationsCount = By.cssSelector("div.styled__DesktopItems-sc-xe39ep-2>div>div>span>span>span");
    private final By searchListnumber = By.cssSelector("div.styled__TextContainer-sc-g6lxf7-1");


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private static String result="fdkfkdkfdk";

    public void waitSearchPageLoading() {
        find(getOtherLocationsCount);
    }

    public void findElementsGetCountAndChooseRandomOne(){

        List<WebElement> elementsOfOtherLocations = findAll(otherLocations);

        int elementCount = elementsOfOtherLocations.size()-1;
        Random rand = new Random();
        int randomValueOfElements = rand.nextInt(elementCount);

        List<WebElement> elementsOfOtherLocationsCount = findAll(getOtherLocationsCount);
        String text = elementsOfOtherLocationsCount.get(randomValueOfElements).getText();
        result = text.replaceAll("[^0-9]", "");
        System.out.println(result);
        elementsOfOtherLocations.get(randomValueOfElements).click();
    }

    public boolean findElementsWitScrollAndCheckValue() throws InterruptedException {
        Thread.sleep(6000);
        scrollDownUntilFindElement(searchListnumber);
        String yyy = find(searchListnumber).getText();
        System.out.println(yyy);

        return find(searchListnumber).getText().contains(result);
    }

}
