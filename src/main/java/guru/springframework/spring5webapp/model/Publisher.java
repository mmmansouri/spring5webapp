package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by mmm on 08/04/19.
 */
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;



    public Publisher(String name, String address, Book book) {
        this.name = name;
        this.address = address;

    }

    public Publisher() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return id.equals(publisher.id) &&
                name.equals(publisher.name) &&
                address.equals(publisher.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }
}
