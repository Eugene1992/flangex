package ua.com.flangex.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base parent class for entity classes. Basically designed to reduce {@link BaseEntity#id}
 * declaration code for each entity class.
 *
 * @author Evgeniy Deyneka
 * @version 1.0
 * @see User
 * @see NativeLanguage
 * @see PracticingLanguage
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    public BaseEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
