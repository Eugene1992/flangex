package ua.com.flangex.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Language {
    AFRIKANS("Afrikans"),
    AINU("Ainu"),
    ALBANIAN("Albanian"),
    ARABIC("Arabic"),
    ARMENIAN("Armenian"),
    AZERBAIJANIAN("Azerbaijanian"),
    BASQUE("Basque"),
    BENGALI("Bengali"),
    BIHARI("Bihari"),
    BOSNIAN("Bosnian"),
    BRETON("Breton"),
    BULGARIAN("Bulgarian"),
    BURMESE("Burmese"),
    CANTONESE("Cantonese"),
    CATALAN("Catalan"),
    CHEINESE_TRADITIONAL("Chinese Traditional"),
    CROATIAN("Croatian"),
    CZECH("Czech"),
    DANISH("Danish"),
    DUTCH("Dutch"),
    ENGLISH("English"),
    ESPERANTO("Esperanto"),
    ESTONIAN("Estonian"),
    FAROESE("Faroese"),
    FINNISH("Finnish"),
    FLEMISH("Flemish"),
    GAELIC("Gaelic"),
    GEORGIAN("Georgian"),
    GERMAN("German"),
    GREEK("Greek"),
    HAITIAN("Haitian"),
    HAWAIIAN("Hawaiian"),
    HEBREW("Hebrew"),
    HINDI("Hindi"),
    HUNGARIAN("Hungarian"),
    ICELANDIC("Icelandic"),
    INDONESIAN("Indonesian"),
    IRISH("Irish"),
    ITALIAN("Italian"),
    JAPANESE("Japanese"),
    JAVANESE("Javanese"),
    KANNADA("Kannada"),
    KHMER("Khmer"),
    KIRGHIZ("Kirghiz"),
    KOREAN("Korean"),
    KURDISH("Kurdish"),
    LAOTIAN("Laotian"),
    LATIN("Latin"),
    LATVIAN("Latvian"),
    LITHUANIAN("Lithuanian"),
    LOJBAN("Lojban"),
    MACEDONIAN("Macedonian"),
    MALAY("Malay"),
    MALTESE("Maltese"),
    MANDARIN("Mandarin"),
    MARATHI("Marathi"),
    MONGOLIAN("Mongolian"),
    MYANMAR("Myanmar"),
    NAVAJO("Navajo"),
    NORWEGIAN("Norwegian"),
    OSSETIC("Ossetic"),
    PANJABI("Panjabi"),
    PASHTO("Pashto"),
    PERSIAN("Persian"),
    POLISH("Polish"),
    PORTUGUESE_BRAZIL("Portuguese (Brazil)"),
    PORTUGUESE_PORTUGAL("Portuguese (Portugal)"),
    ROMANI("Romani"),
    ROMANIAN("Romanian"),
    RUSSIAN("Russian"),
    SANSKRIT("Sanskrit"),
    SERBIAN("Serbian"),
    SINHALESE("Sinhalese"),
    SLAVIC("Slavic"),
    SLOVAK("Slovak"),
    SLOVENIAN("Slovenian"),
    SPANISH("Spanish"),
    SWAHILI("Swahili"),
    SWEDISH("Swedish"),
    TAGALOG("Tagalog"),
    TAMIL("Tamil"),
    TELUGU("Telugu"),
    THAI("Thai"),
    TIBETAN("Tibetan"),
    TONGAN("Tongan"),
    TURKISH("Turkish"),
    TURKMEN("Turkmen"),
    UDMURT("Udmurt"),
    UKRAINIAN("Ukrainian"),
    URDU("Urdu"),
    UYGHUR("Uyghur"),
    UZBEK("Uzbek"),
    VIETNAMESE("Vietnamese"),
    WELSH("Welsh"),
    YIDDISH("Yiddish"),
    ZULU("Zulu");

    private String langName;

    Language(String langName) {
        this.langName = langName;
    }

    public String getLangName() {
        return langName;
    }

    public static List<String> getLanguages(){
        return Stream
                .of(Language.values())
                .map(Language::getLangName)
                .collect(Collectors.toList());
    }
}
