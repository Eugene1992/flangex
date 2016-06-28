package ua.com.flangex.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.BY_CREDENTIALS, query = "SELECT u FROM User u WHERE u.email=?1 AND u.password=?2"),
        @NamedQuery(name = User.BY_USERNAME, query = "SELECT u FROM User u WHERE u.email=?1"),
        @NamedQuery(name = User.ALL_SORTED, query = "SELECT DISTINCT(u) FROM User u ORDER BY u.firstname, u.email"),
})
@Entity
public class User extends BaseEntity {

    public static final String DELETE = "User.delete";
    public static final String BY_CREDENTIALS = "User.getByCredentials";
    public static final String BY_USERNAME = "User.getByUsername";
    public static final String ALL_SORTED = "User.getAllSorted";

    @NotEmpty(message = "First name is required")
    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @NotNull(message = "Age is required")
    @Min(value = 8, message = "Need to be between 8 and 120")
    @Max(value = 120, message = "Need to be between 8 and 120")
    private Integer age;

    @NotEmpty(message = "Email is required")
    @Email(message = "Not a well-formed email address")
    private String email;

    private String password;

    @Column(name = "confirmed_password")
    private String confirmedPassword;

    @NotEmpty(message = "Gender is required")
    private String gender;

    @NotEmpty(message = "Country is required")
    private String country;

    private String city;

    @NotNull(message = "At least one native language required")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<NativeLanguage> nativeLanguages;

    @NotEmpty(message = "At least one practicing language required")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<PracticingLanguage> practicingLanguages;

    private String description;

    private LocalDate registered = LocalDate.now();

    @Column(name = "facebook_link")
    //@Pattern(regexp = "(?:(?:http|https):\\/\\/)?(?:www.)?facebook.com\\/(?:(?:\\w)*#!\\/)?(?:pages\\/)?(?:[?\\w\\-]*\\/)?(?:profile.php\\?id=(?=\\d.*))?([\\w\\-]*)?", message = "Wrong facebook link")
    private String facebookLink;

    @Column(name = "twitter_link")
    private String twitterLink;

    @Column(name = "google_link")
    private String googlePlusLink;

    @Column(name = "vkontakte_link")
    private String vkontakteLink;

    @Column(name = "linkedin_link")
    private String linkedInLink;

    @Column(name = "instagram_link")
    private String instagramLink;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(String firstname, Integer age, String gender, String country, String city, List<NativeLanguage> nativeLanguages, List<PracticingLanguage> practicingLanguages) {
        this.firstname = firstname;
        this.age = age;
        this.gender = gender;
        this.country = country;
        this.nativeLanguages = nativeLanguages;
        this.city = city;
        this.practicingLanguages = practicingLanguages;
    }

    public User(String firstname, String lastname, Integer age, String email, String password, String confirmedPassword, String gender, String country, String city, Role role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
        this.gender = gender;
        this.country = country;
        this.city = city;
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<NativeLanguage> getNativeLanguages() {
        return nativeLanguages;
    }

    public void setNativeLanguages(List<NativeLanguage> nativeLanguages) {
        this.nativeLanguages = nativeLanguages;
    }

    public List<PracticingLanguage> getPracticingLanguages() {
        return practicingLanguages;
    }

    public void setPracticingLanguages(List<PracticingLanguage> practicingPracticingLanguages) {
        this.practicingLanguages = practicingPracticingLanguages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public void setTwitterLink(String twitterLink) {
        this.twitterLink = twitterLink;
    }

    public String getGooglePlusLink() {
        return googlePlusLink;
    }

    public void setGooglePlusLink(String googlePlusLink) {
        this.googlePlusLink = googlePlusLink;
    }

    public String getVkontakteLink() {
        return vkontakteLink;
    }

    public void setVkontakteLink(String vkontakteLink) {
        this.vkontakteLink = vkontakteLink;
    }

    public String getLinkedInLink() {
        return linkedInLink;
    }

    public void setLinkedInLink(String linkedInLink) {
        this.linkedInLink = linkedInLink;
    }

    public String getInstagramLink() {
        return instagramLink;
    }

    public void setInstagramLink(String instagramLink) {
        this.instagramLink = instagramLink;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmedPassword='" + confirmedPassword + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", nativeLanguages=" + nativeLanguages +
                ", practicingLanguages=" + practicingLanguages +
                ", description='" + description + '\'' +
                ", registered=" + registered +
                ", role=" + role +
                '}';
    }
}
