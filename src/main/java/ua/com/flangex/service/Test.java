package ua.com.flangex.service;

import ua.com.flangex.model.Language;

/**
 * Created by Евгений on 04.07.2016.
 */
public class Test {
    public static void main(String[] args) {
        /*String q = "FROM ua.com.flangex.model.User u WHERE ]";

        q = q.concat("u.facebookLink IS NOT EMPTY AND "); // cause populate users got empty values in socials fields
        q = q.concat("u.facebookLink IS NOT NULL AND "); // registered users will have null values if not input links

        if (q.endsWith("AND ")) {
            q = q.substring(0, q.length() - 5);
        }
        //q = q.substring(0, q.length() - 5);

        System.out.println(q);*/

        for (Language language : Language.values()) {
            System.out.println(language.getLangName());
        }
    }
}
