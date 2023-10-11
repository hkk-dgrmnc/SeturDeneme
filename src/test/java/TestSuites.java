import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestSuites extends BaseTest {

    public HomePage homePage;
    public SearchPage searchPage;


    @BeforeEach
    public void getAlls() {
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    @DisplayName("Anasayfayı temizle.")
    @Order(1)
    public void specialFonkOne(){
        homePage.cleanHomePage();
    }

    @Test
    @DisplayName("Setur url’nin geldiği kontrol edilir.")
    @Order(2)
    public void specialFonkTwo() {
        Assertions.assertTrue((homePage.getCurrentUrl().contains("setur.com")),"Url dogru degil !");
    }

    @Test
    @DisplayName("Ana sayfada Otel tabının default geldiği kontrol edilir")
    @Order(3)
    public void specialFonkThree() {
        Assertions.assertTrue(homePage.verifyChoosedHotelFonk().contains("Otel"),"Otel tabı secili degil !");
    }

    @Test
    @DisplayName("Nereye Gideceksiniz? alanına Antalya yazılır ve en üsteki Antalya seçeneğine tıklanılır.")
    @Order(4)
    public void specialFonkFour() {
        homePage.fillHotelNameOrLocation("Antalya");
        homePage.chooseHotelNameOrLocation();
    }

    @Test
    @DisplayName("Tarih alanında Nisan’ın ilk haftası için bir haftalık aralık seçilir.")
    @Order(5)
    public void specialFonkFive() throws InterruptedException {
        homePage.chooseTimeInterval();
    }

    @Test
    @DisplayName("Yetişkin sayısı 1 artırılır ve Yetişkin sayısının değiştiği kontrol edilir.")
    @Order(6)
    public void specialFonkSix() {
        homePage.chooseGuests();
        Assertions.assertTrue(homePage.checkGuest(),"Yetiskin sayısı arttırılmamıs !");
    }

    @Test
    @DisplayName("Ara butonu’nun görünürlüğü kontrol edilir ve tıklanılır.")
    @Order(7)
    public void specialFonkSeven() {
         homePage.verifyAndClickSearchButton();
    }

    @Test
    @DisplayName("Açılan url içinde antalya kelimesini içerdiği kontrol edilir.")
    @Order(8)
    public void specialFonkEight() {
        searchPage.waitSearchPageLoading();
        Assertions.assertTrue((homePage.getCurrentUrl().contains("antalya")),"Url dogru degil !");
    }

    @Test
    @DisplayName("Diğer Bölgeleri Göster alanında rastgele tıklama metotu kullanılarak bir seçim yapılır ve () içerisinde bulunan sayı kaydedilir.")
    @Order(9)
    public void specialFonkNine() throws InterruptedException {
        searchPage.findElementsGetCountAndChooseRandomOne();
    }

    @Test
    @DisplayName("Sayfanın altında bulunan Antalya Otelleri ve En Uygun Antalya Otel Fiyatları alanına kadar ekranda kaydırma yapılır, kaydedilen değerin dogrulugu kontrol edilir.")
    @Order(10)
    public void specialFonkTen() throws InterruptedException {
        Assertions.assertTrue(searchPage.findElementsWitScrollAndCheckValue(),"Diger bölgelerden seçilen arama sayıları esit degil !");
    }

}
