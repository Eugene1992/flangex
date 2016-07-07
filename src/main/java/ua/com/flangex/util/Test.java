package ua.com.flangex.util;

import ua.com.flangex.model.Language;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        /*List<String> langs = Language.getLanguages();
        for (String lang : langs) {
            System.out.print("\"" + lang + "\"" + ", ");
        }*/

        /*for (int i = 0; i < 100; i++) {
            List<String> langs = RandomUsersQueryGenerator.getLanguages();
            for (String lang : langs) {
                System.out.println(lang);
            }
            System.out.println();
        }*/

        RandomUsersQueryGenerator.generateUserSQLquery(100);


    }
}
