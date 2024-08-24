package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MangaPage extends Form {
    // Framework
    private final IElementFactory elementFactory = AqualityServices.getElementFactory();

    // Page Elements
    private final ITextBox searchField = elementFactory.getTextBox(By.id("manga-search"), "Search field");
    private final IButton searchButton = elementFactory.getButton(By.xpath("//*[@id=\"root\"]/div/div[1]/button"), "Search button");
    private final ILabel mangaName = elementFactory.getLabel(By.id("manga-name"), "Manga name");
    private final ILabel noResults = elementFactory.getLabel(By.xpath("//*[@id=\"root\"]/div/div[2]/p"), "No results message");
    private final ILabel mangaCard = elementFactory.getLabel(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]"), "Manga card");

    // Modal Elements
    private final IButton modalDetails = elementFactory.getButton(By.xpath("//*[@id=\"root\"]/div/div[2]/div[4]/p[1]/span"), "Manga details button");
    private final ILabel modal = elementFactory.getLabel(By.xpath("//*[@id=\"root\"]/div/div[3]/div"), "Manga details modal");
    private final ILabel modalImage = elementFactory.getLabel(By.xpath("//*[@id=\"root\"]/div/div[3]/div/img"), "Modal Image");
    private final ILabel modalTitle = elementFactory.getLabel(By.xpath("//*[@id=\"root\"]/div/div[3]/div/h3"), "Modal Title");
    private final ILabel modalSummary = elementFactory.getLabel(By.xpath("//*[@id=\"root\"]/div/div[3]/div/p"), "Modal Summary");
    private final IButton modalClose = elementFactory.getButton(By.xpath("//button[text()='Close']"), "Close button");

    public MangaPage() {
        super(By.id("manga-search"), "Main Page");
    }

    public void searchForManga(String mangaName) {
        searchField.type(mangaName);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public boolean isMangaCardDisplayed() {
        return mangaCard.state().isDisplayed();
    }

    public String getMangaName() {
        return mangaName.getText();
    }

    public String getNoResults() {
        return noResults.getText();
    }

    public void clickMangaDetails() {
        modalDetails.click();
    }

    public boolean isModalDisplayed() {
        return modal.state().isDisplayed();
    }

    public String getModalImageSrc() {
        return modalImage.getAttribute("src");
    }

    public String getModalTitle() {
        return modalTitle.getText();
    }

    public String getModalSummary() {
        return modalSummary.getText();
    }

    public void closeModal() {
        modalClose.click();
    }
}
