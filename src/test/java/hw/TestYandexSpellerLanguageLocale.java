package hw;

import beans.YandexSpellerAnswer;
import core.YandexSpellerApi;
import core.YandexSpellerConstants.Languages;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TestYandexSpellerLanguageLocale {
    @DataProvider(name = "languageLocaleTestDP")
    public Object[][] languageLocaleTestDP() {
        return new Object[][]
                {
                        {"великалепие", "великолепие", Languages.RU},
                        {"пишность", "пишність", Languages.UK},
                        {"spleendor", "splendor", Languages.EN},
                };
    }

    @Test(dataProvider = "languageLocaleTestDP")
    public void languageLocaleTest(String originalText, String expectedText, Languages localeName) {
        List<YandexSpellerAnswer> answers =
                YandexSpellerApi.getYandexSpellerAnswers(
                        YandexSpellerApi
                                .with()
                                .text(originalText)
                                .language(localeName)
                                .callApi());

        Assert.assertNotEquals(answers.size(), 0, "Empty answer recived");
        answers.forEach(
                e -> Assert.assertTrue(e.s.contains(expectedText), "Answer doesn't contain expected text"));

    }

}
