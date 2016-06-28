package ua.com.flangex.util;

import ua.com.flangex.model.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserUtil {

    public static List<User> getFilteredByParams(
            List<User> users,
            String country,
            String city,
            int fromAge, int toAge,
            String gender,
            String firstName
    ){

        if (firstName != null) {
            users = users.stream().filter(u -> u.getFirstname().equals(firstName)).collect(Collectors.toList());
        }

        if (gender != null) {
            users = users.stream().filter(u -> u.getGender().equals(gender)).collect(Collectors.toList());
        }

        if (fromAge != 0 && toAge != 0) {
            users = users.stream().filter(u -> (u.getAge() >= fromAge && u.getAge() <= toAge)).collect(Collectors.toList());
        }

        if (country != null) {
            users = users.stream().filter(u -> u.getCountry().equals(country)).collect(Collectors.toList());
        }

        if (city != null) {
            users = users.stream().filter(u -> u.getCity().equals(city)).collect(Collectors.toList());
        }

        return users;
    }

    public static List<User> getFilteredByLangs(List<User> users, String nativeLang, String practLang){
        Stream<User> userStream = users.stream();
        List<User> result;

        if (nativeLang != null) {
            users = users.stream()
                    .filter(u -> u.getNativeLanguages().stream().anyMatch(nl -> nl.equals(nativeLang))).collect(Collectors.toList());
        }
        if (practLang != null) {
            users = users.stream()
                    .filter(u -> u.getPracticingLanguages().stream().anyMatch(nl -> nl.equals(practLang))).collect(Collectors.toList());
        }

        return users;
    }
}
