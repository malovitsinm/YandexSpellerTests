package hw;

import beans.YandexSpellerAnswer;
import core.YandexSpellerApi;
import core.YandexSpellerConstants.ErrorCode;
import core.YandexSpellerConstants.Languages;
import core.YandexSpellerConstants.Options;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class TestYandexSpellerErrorCodes {

    @DataProvider(name = "errorCodesTestDP")
    public Object[][] errorCodesTestDP() {
        return new Object[][]
                {
                        {"сабака", Options.DEFAULT, ErrorCode.ERROR_UNKNOWN_WORD},
                        {"магазин магазин", Options.FIND_REPEAT_WORDS, ErrorCode.ERROR_REPEAT_WORD},
                        {"москва", Options.DEFAULT, ErrorCode.ERROR_CAPITALIZATION},
                        {String.join("", Collections.nCopies(50, "прасти миня аликсондр пушкын"))
                                , Options.DEFAULT, ErrorCode.ERROR_TOO_MANY_ERRORS}
                };
    }

    @Test(dataProvider = "errorCodesTestDP")
    public void errorCodesTest(String text, Options option, ErrorCode error) {//String textValue, ErrorCode passedError) {
        List<YandexSpellerAnswer> answers =
                YandexSpellerApi.getYandexSpellerAnswers(
                        YandexSpellerApi
                                .with()
                                .text(text)
                                .language(Languages.RU)
                                .options(option.getOptionsCode().toString())
                                .callApi());

        Assert.assertNotEquals(answers.size(), 0, "Empty answer recived");
        answers.forEach(
                e -> Assert.assertEquals(e.code, error.getValue(), "Invalid error code"));

    }
}
