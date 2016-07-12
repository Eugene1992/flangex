package ua.com.flangex.model;

import javax.persistence.*;

@Entity
@Table(name = "native_language")
public class NativeLanguage extends BaseEntity{

    private String name;

    public NativeLanguage() {
    }

    public NativeLanguage(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NativeLanguage that = (NativeLanguage) o;

        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
