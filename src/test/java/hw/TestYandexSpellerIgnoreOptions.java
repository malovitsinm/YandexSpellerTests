package hw;

import beans.YandexSpellerAnswer;
import core.YandexSpellerApi;
import core.YandexSpellerConstants.Languages;
import core.YandexSpellerConstants.Options;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TestYandexSpellerIgnoreOptions {

    @DataProvider(name = "ignoreOptionsTestDP")
    public Object[][] ignoreOptionsTestDP() {
        return new Object[][]
                {
                        {"elit3", Options.IGNORE_DIGITS},
                        {"moscow.org", Options.IGNORE_URLS},
                        {"moscow", Options.IGNORE_CAPITALIZATION}
                };
    }

    @Test(dataProvider = "ignoreOptionsTestDP")
    public void ignoreOptionsTest(String text, Options option) {//String textValue, ErrorCode passedError) {
        List<YandexSpellerAnswer> answersDefault = YandexSpellerApi.getYandexSpellerAnswers(
                YandexSpellerApi
                        .with()
                        .text(text)
                        .language(Languages.EN)
                        .callApi());

        List<YandexSpellerAnswer> answersWithOption = YandexSpellerApi.getYandexSpellerAnswers(
                YandexSpellerApi
                        .with()
                        .text(text)
                        .language(Languages.EN)
                        .options(option.getOptionsCode().toString())
                        .callApi());

        Assert.assertNotEquals(answersDefault.size(), 0, "Empty answer recived");
        Assert.assertEquals(answersWithOption.size(), text.split(" ").length, "Text wasn't ignored");

    }
}
