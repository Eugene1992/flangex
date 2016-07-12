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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PracticingLanguage that = (PracticingLanguage) o;

        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
