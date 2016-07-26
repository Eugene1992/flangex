package ua.com.flangex.model;

/**
 * Intermediate class for user search parameters transmitting from
 * {@link ua.com.flangex.web.SearchController} to {@link ua.com.flangex.service.UserServiceImpl}.
 *
 * @author Evgeniy Deyneka
 * @version 1.0
 * @see User
 * @see ua.com.flangex.web.SearchController
 * @see ua.com.flangex.service.UserServiceImpl
 */
public class UserSearchParameters {

    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private String ageFrom;
    private String ageTo;
    private String gender;
    private String practicingLanguage;
    private String facebookCheck;
    private String twitterCheck;
    private String instagramCheck;
    private String linkedinCheck;
    private String googlePlusCheck;
    private String vkontakteCheck;

    public UserSearchParameters(String firstName, String lastName, String country, String city, String ageFrom, String ageTo, String gender, String practicingLanguage, String facebookCheck, String twitterCheck, String instagramCheck, String linkedinCheck, String googlePlusCheck, String vkontakteCheck) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.city = city;
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.gender = gender;
        this.practicingLanguage = practicingLanguage;
        this.facebookCheck = facebookCheck;
        this.twitterCheck = twitterCheck;
        this.instagramCheck = instagramCheck;
        this.linkedinCheck = linkedinCheck;
        this.googlePlusCheck = googlePlusCheck;
        this.vkontakteCheck = vkontakteCheck;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getAgeFrom() {
        return ageFrom;
    }

    public String getAgeTo() {
        return ageTo;
    }

    public String getGender() {
        return gender;
    }

    public String getPracticingLanguage() {
        return practicingLanguage;
    }

    public String getFacebookCheck() {
        return facebookCheck;
    }

    public String getTwitterCheck() {
        return twitterCheck;
    }

    public String getInstagramCheck() {
        return instagramCheck;
    }

    public String getLinkedinCheck() {
        return linkedinCheck;
    }

    public String getGooglePlusCheck() {
        return googlePlusCheck;
    }

    public String getVkontakteCheck() {
        return vkontakteCheck;
    }
}
