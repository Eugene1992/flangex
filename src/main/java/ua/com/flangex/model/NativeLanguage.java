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
