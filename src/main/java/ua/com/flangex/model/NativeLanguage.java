package ua.com.flangex.model;

import javax.persistence.*;

/**
 * Represents {@link User} native language. According to the project users
 * can have multiple native languages. {@link NativeLanguage} also acts as a
 * mandatory property during registration and search for other users.
 *
 * @author Evgeniy Deyneka
 * @version 1.0
 * @see User
 * @see BaseEntity
 */
@Entity
@Table(name = "native_language")
public class NativeLanguage extends BaseEntity {

    private String name;

    public NativeLanguage() {
    }

    public NativeLanguage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
}
