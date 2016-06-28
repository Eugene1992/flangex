package ua.com.flangex.model;

import javax.persistence.*;

@Entity
@Table(name = "practicing_language")
public class PracticingLanguage extends BaseEntity{

    private String name;

    public PracticingLanguage() {
    }

    public PracticingLanguage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PracticingLanguages{" +
                name + '\'' +
                '}';
    }
}
