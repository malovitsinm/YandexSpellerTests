package core;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by yulia_atlasova@epam.com on 22/06/2017.
 * Expanded upon by maksim_malovitsin@epam.com on 25/02/2018.
 * Constants of YandexSpeller
 */
public abstract class YandexSpellerConstants {

    //useful constants for API under test
    public static final String YANDEX_SPELLER_API_URI = "https://speller.yandex.net/services/spellservice.json/checkText";
    public static final String PARAM_TEXT = "text";
    public static final String PARAM_OPTIONS = "options";
    public static final String PARAM_LANG = "lang";
    public static final String PARAM_FORMAT = "format";
    public static final String WRONG_WORD_EN = "requisitee";
    public static final String RIGHT_WORD_EN = "requisite";
    public static final String WRONG_WORD_UK = "питаня";
    public static final String WORD_WITH_WRONG_CAPITAL = "moscow";
    public static final String WORD_WITH_LEADING_DIGITS = "11" + RIGHT_WORD_EN;


    //answer structure constants
    public static final String ERROR_CODE = "code";
    public static final String WORD_POSITION = "pos";
    public static final String ROW = "row";
    public static final String COLUMN = "col";
    public static final String LENGTH = "len";
    public static final String ORIGINAL_WORD = "word";
    public static final String SUGESTIONS = "s";

    public static final String DATA_PATH = System.getProperty("user.dir");

    @AllArgsConstructor
    @Getter
    public enum Languages {
        RU("ru"),
        UK("uk"),
        EN("en");

        String languageCode;
    }

    @AllArgsConstructor
    @Getter
    public enum Options {
        DEFAULT(0),
        IGNORE_DIGITS(2),
        IGNORE_URLS(4),
        FIND_REPEAT_WORDS(8),
        IGNORE_CAPITALIZATION(512);

        Integer optionsCode;
    }

    @AllArgsConstructor
    @Getter
    public enum Format {
        PLAIN("plain"),
        HTML("html");

        String formatParam;
    }

    @AllArgsConstructor
    @Getter
    public enum ErrorCode {
        ERROR_UNKNOWN_WORD(1),
        ERROR_REPEAT_WORD(2),
        ERROR_CAPITALIZATION(3),
        ERROR_TOO_MANY_ERRORS(4);

        Integer value;
    }
}
