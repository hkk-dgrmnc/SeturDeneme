import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By verifyChoosedHotel = By.cssSelector("button[class=\"Tab__StyledTab-sc-1gyyeis-1 eDgwud\"]>span.Tab__TabText-sc-1gyyeis-2");
    private final By inputHotelNameOrLocation = By.cssSelector("input[placeholder=\"Otel Adı Veya Konum\"]");
    private final By dropdownAntalya = By.xpath("//strong[text()='Antalya']");
    private final By acceptCookies = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By closeButtonFirstPopUp = By.cssSelector("span.ins-close-button");
    private final By inputTimeInterval = By.xpath("//div[text()='Giriş - Çıkış Tarihleri']");
    private final By timeApril = By.xpath("//strong[contains(text(),'Nisan')]");
    private final By nextButtonMonth = By.cssSelector("button.DatePickerStyle__NavNextButton-sc-1yq2271-2");
    private final By intervalTimeFirst = By.xpath("//td[@aria-label=\"Choose Pazartesi, 15 Nisan 2024 as your check-in date. It’s available.\"]");
    private final By intervalTimeSecond = By.xpath("//td[@aria-label=\"Choose Cuma, 19 Nisan 2024 as your check-out date. It’s available.\"]");
    private final By guestInput = By.xpath("//span[contains(text(),'1 Oda, 2 Yetişkin')]");
    private final By guestAdultIncrement = By.cssSelector("button[data-testid=\"increment-button\"]");
    private final By verifyGuestInput = By.xpath("//span[contains(text(),'1 Oda, 3 Yetişkin')]");
    private final By searchButton = By.cssSelector("div.BookerSearchButton__Wrapper-sc-hf9sbn-0>button.styled__StyledButton-sc-1i7jkmi-0");








    public HomePage(WebDriver driver) {
        super(driver);
    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String verifyChoosedHotelFonk() {
        return find(verifyChoosedHotel).getText();
    }

    public void fillHotelNameOrLocation(String location) {
        find(inputHotelNameOrLocation).sendKeys(location);
    }
    public void chooseHotelNameOrLocation() {
        click(inputHotelNameOrLocation);
        click(dropdownAntalya);
    }

    public void cleanHomePage() {
        try {
            click(closeButtonFirstPopUp);
        }
        catch(Exception e) {}
        click(acceptCookies);
    }

    public void chooseTimeInterval() throws InterruptedException {
        click(inputTimeInterval);
        untilVisibleClick(timeApril,nextButtonMonth);
        click(intervalTimeFirst);
        click(intervalTimeSecond);
    }

    public void chooseGuests() {
        click(guestInput);
        click(guestAdultIncrement);
    }

    public boolean checkGuest(){
       boolean check = true;
        try {
            find(verifyGuestInput);
        }
        catch(Exception e) { check=false; }

        return check;
    }

    public void verifyAndClickSearchButton() {
        click(searchButton);
    }



}
