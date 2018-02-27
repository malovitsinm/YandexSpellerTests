package hw;

import beans.YandexSpellerAnswer;
import core.YandexSpellerApi;
import core.YandexSpellerConstants.Languages;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static core.YandexSpellerConstants.Format;

public class TestYandexSpellerFormat {

    @DataProvider(name = "formatTestDP ")
    public Object[][] formatTestDP() {
        return new Object[][]
                {
                        {"<bady>smol error</bady>", Format.HTML, 1},
                        {"<bady>smol error</bady>", Format.PLAIN, 3}
                };
    }

    @Test(dataProvider = "formatTestDP ")
    public void formatTest(String text, Format format, int expectedErrorCount) {
        List<YandexSpellerAnswer> answers =
                YandexSpellerApi.getYandexSpellerAnswers(
                        YandexSpellerApi
                                .with()
                                .text(text)
                                .language(Languages.EN)
                                .format(format)
                                .callApi());

        Assert.assertNotEquals(answers.size(), 0, "Empty answer recived");
        Assert.assertEquals(answers.size(), expectedErrorCount, "Error count does not match expected by format");

    }
}
