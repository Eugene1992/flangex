package ua.com.flangex.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User extends BaseEntity {

    @NotEmpty(message = "{validation.required.firstname}")
    @Size(max = 10, message = "{validation.length.firstname}")
    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @NotNull(message = "{validation.required.age}")
    @Min(value = 8, message = "{validation.size.age.required}")
    @Max(value = 120, message = "{validation.size.age.required}")
    private Integer age;

    @NotEmpty(message = "{validation.required.email}")
    @Email(message = "validation.wrong-formed.email")
    private String email;

    @Size(min = 6, max = 20, message = "{validation.length.password}")
    @NotEmpty(message = "{validation.required.password}")
    private String password;

    @NotEmpty(message = "{validation.required.confirmed-password}")
    @Column(name = "confirmed_password")
    private String confirmedPassword;

    @NotEmpty(message = "{validation.required.gender}")
    private String gender;

    @NotEmpty(message = "{validation.required.country}")
    private String country;

    private String city;

    @NotEmpty(message = "{validation.required.native-language}")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<NativeLanguage> nativeLanguages;

    @NotEmpty(message = "{validation.required.practicing-language}")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<PracticingLanguage> practicingLanguages;

    private String description;

    @Column(name = "facebook_link")
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

    public User(String firstname, String lastname, Integer age, String email, String password, String confirmedPassword, String gender, String country, String city, List<NativeLanguage> nativeLanguages, List<PracticingLanguage> practicingLanguages, String description, Role role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
        this.gender = gender;
        this.country = country;
        this.city = city;
        this.nativeLanguages = nativeLanguages;
        this.practicingLanguages = practicingLanguages;
        this.description = description;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (firstname != null ? !firstname.equals(user.firstname) : user.firstname != null) return false;
        if (lastname != null ? !lastname.equals(user.lastname) : user.lastname != null) return false;
        if (age != null ? !age.equals(user.age) : user.age != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (confirmedPassword != null ? !confirmedPassword.equals(user.confirmedPassword) : user.confirmedPassword != null)
            return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        if (country != null ? !country.equals(user.country) : user.country != null) return false;
        if (city != null ? !city.equals(user.city) : user.city != null) return false;
        if (nativeLanguages != null) {
            if (this.nativeLanguages.size() != user.nativeLanguages.size()) {
                return false;
            } else {
                for (int i = 0; i < nativeLanguages.size(); i++) {
                    if (!this.nativeLanguages.get(i).equals(user.nativeLanguages.get(i))) {
                        return false;
                    }
                }
            }
        } else {
            if (user.nativeLanguages != null) return false;
        }
        if (practicingLanguages != null) {
            if (this.practicingLanguages.size() != user.practicingLanguages.size()) {
                return false;
            } else {
                for (int i = 0; i < practicingLanguages.size(); i++) {
                    if (!this.practicingLanguages.get(i).equals(user.practicingLanguages.get(i))) {
                        return false;
                    }
                }
            }
        } else {
            if (user.practicingLanguages != null) return false;
        }
        if (description != null ? !description.equals(user.description) : user.description != null) return false;
        if (facebookLink != null ? !facebookLink.equals(user.facebookLink) : user.facebookLink != null) return false;
        if (twitterLink != null ? !twitterLink.equals(user.twitterLink) : user.twitterLink != null) return false;
        if (googlePlusLink != null ? !googlePlusLink.equals(user.googlePlusLink) : user.googlePlusLink != null)
            return false;
        if (vkontakteLink != null ? !vkontakteLink.equals(user.vkontakteLink) : user.vkontakteLink != null)
            return false;
        if (linkedInLink != null ? !linkedInLink.equals(user.linkedInLink) : user.linkedInLink != null) return false;
        if (instagramLink != null ? !instagramLink.equals(user.instagramLink) : user.instagramLink != null)
            return false;
        return role == user.role;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (confirmedPassword != null ? confirmedPassword.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (nativeLanguages != null ? nativeLanguages.hashCode() : 0);
        result = 31 * result + (practicingLanguages != null ? practicingLanguages.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (facebookLink != null ? facebookLink.hashCode() : 0);
        result = 31 * result + (twitterLink != null ? twitterLink.hashCode() : 0);
        result = 31 * result + (googlePlusLink != null ? googlePlusLink.hashCode() : 0);
        result = 31 * result + (vkontakteLink != null ? vkontakteLink.hashCode() : 0);
        result = 31 * result + (linkedInLink != null ? linkedInLink.hashCode() : 0);
        result = 31 * result + (instagramLink != null ? instagramLink.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
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
                ", registered=" +
                ", role=" + role +
                '}';
    }
}
