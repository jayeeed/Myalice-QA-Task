package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.MangaPage;

import static constants.ExpectedValues.*;
import static io.qameta.allure.Allure.step;

public class MangaPageSteps {
    private final MangaPage mangaPage = new MangaPage();

    // Manga Page Steps
    @Then("the user is redirected to the manga search page")
    public void theUserIsRedirectedToTheMangaSearchPage() {
        step("The user is redirected to the manga search page", () -> {
            Assert.assertTrue(mangaPage.state().isDisplayed(), "Manga search page is not displayed");
        });
    }

    @When("the user enters {string} into the search box")
    public void theUserEntersIntoTheSearchBox(String mangaName) {
        step("The user enters " + mangaName + " into the search box", () -> {
            mangaPage.searchForManga(mangaName);
        });
    }

    @And("clicks the {string} button on the manga search page")
    public void clicksTheSearchButton(String buttonName) {
        step("Clicks the " + buttonName + " button", () -> {
            if (buttonName.equals("Search")) {
                mangaPage.clickSearch();
            }
        });
    }

    @Then("manga card with the name {string} is displayed or {string} message is shown")
    public void mangaCardWithTheNameIsDisplayedOrNoResultsMessageIsShown(String mangaName, String noResultsMessage) {
        step("Checking results for: " + mangaName, () -> {
            if (mangaPage.isMangaCardDisplayed()) {
                step("Manga card with the name " + mangaName + " is displayed");
                Assert.assertEquals(mangaPage.getMangaName(), mangaName, "Manga name is incorrect");
            } else {
                step(noResultsMessage + " message is shown");
                Assert.assertEquals(mangaPage.getNoResults(), noResultsMessage, "No results message is incorrect");
            }
        });
    }

    // Manga Modal Steps
    @When("the user clicks the {string} link on a manga card")
    public void theUserClicksTheLinkOnAMangaCard(String details) {
        step("The user clicks the " + details + " link on a manga card", () -> {
            mangaPage.clickMangaDetails();
        });
    }

    @Then("the modal appears and displays the correct manga information")
    public void theModalAppearsAndDisplaysCorrectMangaInfo() {
        step("The modal appears and displays the correct manga information", () -> {
            Assert.assertTrue(mangaPage.isModalDisplayed(), "Modal is not displayed");

            Assert.assertEquals(mangaPage.getModalTitle(), EXPECTED_MODAL_TITLE, "Modal title is incorrect");
            Assert.assertEquals(mangaPage.getModalSummary(), EXPECTED_MODAL_SUMMARY, "Modal summary is incorrect");
            Assert.assertEquals(mangaPage.getModalImageSrc(), EXPECTED_MODAL_IMAGE_SRC, "Modal image source is incorrect");
        });
    }

    @When("the user clicks the {string} button on the modal")
    public void theUserClicksTheButtonOnTheModal(String button) {
        step("The user clicks the " + button + " button on the modal", () -> {
            mangaPage.closeModal();
        });
    }

    @Then("the modal is closed and no longer visible")
    public void theModalIsClosedAndNoLongerVisible() {
        step("The modal is closed and no longer visible", () -> {
            Assert.assertFalse(mangaPage.isModalDisplayed(), "Modal is still displayed");
        });
    }
}
