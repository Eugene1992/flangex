package ua.com.flangex.util;

import java.util.*;

public class RandomUsersQueryGenerator {
    public static void main(String[] args) {
        generateUserSQLquery(50);
    }

    static void generateUserSQLquery(int numOfUsers){
        for (int i = 0; i < numOfUsers; i++) {
            int genderRand = (int)(Math.random()*2); // вещественное число из [0;5)
            String gender;
            String name;
            String email;
            int age = getAge();
            String country = getCountry();
            String password = getPassword(8);
            String facebookLink = isFacebookLink();
            String twitterkLink = isTwitterLink();
            String instagramkLink = isInstagramLink();
            String vkLink = isVKontakteLink();
            String googlePlusLink = isGooglePlusLink();
            String linkedInLink = isLinkedInLink();
            if (genderRand == 0) {
                gender = "Male";
                name = getMaleName();
                email = getEmail(name);
                System.out.println(String.format("INSERT INTO user (first_name, last_name, email, role, password, confirmed_password, age, city, country, gender, description, facebook_link, twitter_link, google_link, vkontakte_link, linkedIn_link, instagram_link) VALUES ('%s', '', '%s', 'ROLE_USER', '%s', '%s', %d, '', '%s', '%s', 'London is a capital of Great Britain!', '%s', '%s', '%s', '%s', '%s', '%s');", name, email, password, password, age, country, gender, facebookLink, twitterkLink, googlePlusLink, vkLink, linkedInLink, instagramkLink));
            } else {
                gender = "Female";
                name = getFemaleName();
                email = getEmail(name);
                System.out.println(String.format("INSERT INTO user (first_name, last_name, email, role, password, confirmed_password, age, city, country, gender, description, facebook_link, twitter_link, google_link, vkontakte_link, linkedIn_link, instagram_link) VALUES ('%s', '', '%s', 'ROLE_USER', '%s', '%s', %d, '', '%s', '%s', 'London is a capital of Great Britain!', '%s', '%s', '%s', '%s', '%s', '%s');", name, email, password, password, age, country, gender, facebookLink, twitterkLink, googlePlusLink, vkLink, linkedInLink, instagramkLink));
            }
        }
    }

    static String getMaleName(){
        List<String> names = Arrays.asList(
                "Cecil", "Donnell", "Juan", "Don", "Columbus",
                "Vince ", "Napoleon", "Shawn", "Benny", "Chi",
                "Cleo", "Paris", "Rogelio", "Lyle", "Nicolas",
                "Willy", "Philip", "Miguel", "Joesph", "Randy",
                "Sylvester", "Ervin", "Israel", "Chung", "Dominick",
                "Danilo", "Desmond", "Eric", "Sanford", "Clyde",
                "Gerard", "Myron", "Bill", "Graham", "Chadwick",
                "Steven", "Octavio", "Darwin", "Johnie", "Isiahn",
                "Eldridge", "Marvin", "Josue", "Tim", "Pablo",
                "Jerald", "Porter", "Ivan", "Elijah", "Christoper"
        );
        int n = (int)(Math.random()*names.size()); // целое число из [0;4]
        return names.get(n);
    }

    static String getFemaleName(){
        List<String> names = Arrays.asList(
                "Marin", "Marcelene", "Trista", "Consuelo", "Sherlene",
                "Luann", "Ebonie", "Shanice", "Celestina", "Hester",
                "Clarinda", "Therese", "Josette", "Candis", "Kasie",
                "Ara", "Kelsi", "Verla", "Celestine", "Hyun",
                "Beata", "Antoinette", "Corie", "Jacki", "Cherish",
                "Liana", "Geraldine", "Joslyn", "Marica", "Emelina",
                "Mellie", "Dreama", "Mitzi", "Casimira", "Norma",
                "Solange", "Diamond", "Brittny", "Raquel", "Meta",
                "Laura", "Xiomara", "Jodie", "Chiquita", "Jerilyn",
                "Klara", "Chantay", "Katerine", "Toshia", "Katherina"
        );
        int n = (int)(Math.random()*names.size()); // целое число из [0;4]
        return names.get(n);
    }

    static String getEmail(String name){
        List<String> mails = Arrays.asList(
                "gmail.com", "ukr.net", "rambler.ru", "mail.ru"
        );
        int n = (int)(Math.random()*mails.size()); // целое число из [0;4]
        return name + "@" + mails.get(n);
    }

    static int getAge(){
        int age = (int) (Math.random() * 112 + 8);
        return age;
    }

    static String getCountry(){
        List<String> countries = Arrays.asList(
                "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
                "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
                "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas",
                "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize",
                "Benin", "Bermuda", "Bhutan", "Bolivia", "Bonaire, Sint Eustatius and Saba",
                "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil",
                "British Indian Ocean Territory", "British Virgin Islands", "Brunei",
                "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada",
                "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile",
                "China", "Christmas Island", "Cocos Islands", "Colombia", "Comoros", "Congo",
                "Cook Islands", "Costa Rica", "Croatia", "Cuba", "Curaçao", "Cyprus",
                "Czech Republic", "Côte d'Ivoire", "Denmark", "Djibouti", "Dominica",
                "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea",
                "Eritrea", "Estonia", "Ethiopia", "Falkland Islands", "Faroe Islands", "Fiji",
                "Finland", "France", "French Guiana", "French Polynesia",
                "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana",
                "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala",
                "Guernsey", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard Island And McDonald Islands",
                "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq",
                "Ireland", "Isle Of Man", "Israel", "Italy", "Jamaica", "Japan", "Jersey", "Jordan",
                "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon",
                "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macao",
                "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta",
                "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico",
                "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Montserrat", "Morocco",
                "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles",
                "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island",
                "North Korea", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Palestine",
                "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland",
                "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russia", "Rwanda", "Saint Barthélemy",
                "Saint Helena", "Saint Kitts And Nevis", "Saint Lucia", "Saint Martin", "Saint Pierre And Miquelon",
                "Saint Vincent And The Grenadines", "Samoa", "San Marino", "Sao Tome And Principe", "Saudi Arabia",
                "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Sint Maarten (Dutch part)", "Slovakia",
                "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia And The South Sandwich Islands",
                "South Korea", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Svalbard And Jan Mayen",
                "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania",
                "Thailand", "The Democratic Republic Of Congo", "Timor-Leste", "Togo", "Tokelau",
                "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan",
                "Turks And Caicos Islands", "Tuvalu", "U.S. Virgin Islands", "Uganda", "Ukraine",
                "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay",
                "Uzbekistan", "Vanuatu", "Vatican", "Venezuela", "Vietnam", "Wallis And Futuna", "Western Sahara", "Yemen",
                "Zambia", "Zimbabwe", "Åland Islands"
        );
        int n = (int)(Math.random()*countries.size()); // целое число из [0;4]
        return countries.get(n);
    }

    static String getPassword(int n){
        int rand; // вещественное число из [8;120)
        String res = "";

        while (res.length() < n){
            rand = (int)(Math.random()*112+74);
            if ((rand >= 48 && rand <= 57) || (rand >= 65 && rand <= 90) || (rand >= 97 && rand <= 122)){
                res = res + (char)rand;
            }
        }
        return res;
    }

    static String isFacebookLink(){
        int rand = (int)(Math.random()*2);
        if (rand == 0) return "https://www.facebook.com/";
        return "";
    }

    static String isTwitterLink(){
        int rand = (int)(Math.random()*2);
        if (rand == 0) return "https://www.twitter.com/";
        return "";
    }

    static String isGooglePlusLink(){
        int rand = (int)(Math.random()*2);
        if (rand == 0) return "https://plus.google.com/";
        return "";
    }

    static String isLinkedInLink(){
        int rand = (int)(Math.random()*2);
        if (rand == 0) return "https://plus.google.com/";
        return "";
    }

    static String isVKontakteLink(){
        int rand = (int)(Math.random()*2);
        if (rand == 0) return "https://vk.com/";
        return "";
    }

    static String isInstagramLink(){
        int rand = (int)(Math.random()*2);
        if (rand == 0) return "https://www.instagram.com/";
        return "";
    }
}
