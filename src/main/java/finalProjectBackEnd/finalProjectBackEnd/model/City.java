package finalProjectBackEnd.finalProjectBackEnd.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @JsonIgnore
    @OneToMany(mappedBy = "city", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<LocalUser> localUsers = new ArrayList<>();


    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", localUsers=" + localUsers +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @JsonBackReference
    public List<LocalUser> getLocalUsers() {
        return localUsers;
    }

    public void setLocalUsers(List<LocalUser> localUsers) {
        this.localUsers = localUsers;
    }
}