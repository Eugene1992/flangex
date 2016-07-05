package ua.com.flangex.service;

/**
 * Created by Евгений on 04.07.2016.
 */
public class Test {
    public static void main(String[] args) {
        String q = "FROM User u WHERE u.firstname = :firstname AND ";

        q = q.substring(0, q.length() - 5);

        System.out.println(q);
    }
}
