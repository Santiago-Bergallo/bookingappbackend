package finalProjectBackEnd.finalProjectBackEnd.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import finalProjectBackEnd.finalProjectBackEnd.model.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "feature")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "swimming_pool")
    private Boolean swimmingPool;

    @Column(name = "pet_friendly")
    private Boolean petFriendly;

    @Column(name = "parking_lot")
    private Boolean parkingLot;

    @Column(name = "stars")
    private Integer stars;


    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private Product product;

    public Long getId() {
        return id;
    }


    public Boolean getSwimmingPool() {
        return swimmingPool;
    }

    public void setSwimmingPool(Boolean swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    public Boolean getPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(Boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    public Boolean getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(Boolean parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    @JsonBackReference
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}