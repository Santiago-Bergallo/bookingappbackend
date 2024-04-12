package finalProjectBackEnd.finalProjectBackEnd.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "stage_product")
    private String stage_product;

    @Column(name = "initial_date", nullable = false)
    private LocalDate initial_date;

    @Column(name = "final_date", nullable = false)
    private LocalDate final_date;


    @JsonManagedReference @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "local_user_id", nullable = false)
    private LocalUser localUser;


    @JsonManagedReference @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ElementCollection
    @Column(name = "stay")
    @CollectionTable(name = "reservation_stay", joinColumns = @JoinColumn(name = "owner_id"))
    private List<LocalDate> stay = new ArrayList<>();

    public List<LocalDate> getStay() {
        return stay;
    }

    public void setStay(List<LocalDate> stay) {
        this.stay = stay;
    }

    public Long getId() {
        return id;
    }

    public String getStage_product() {
        return stage_product;
    }

    public void setStage_product(String stage_product) {
        this.stage_product = stage_product;
    }

    public LocalDate getInitial_date() {
        return initial_date;
    }

    public void setInitial_date(LocalDate initial_date) {
        this.initial_date = initial_date;
    }

    public LocalDate getFinal_date() {
        return final_date;
    }

    public void setFinal_date(LocalDate final_date) {
        this.final_date = final_date;
    }

    public LocalUser getLocalUser() {
        return localUser;
    }

    public void setLocalUser(LocalUser localUser) {
        this.localUser = localUser;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}