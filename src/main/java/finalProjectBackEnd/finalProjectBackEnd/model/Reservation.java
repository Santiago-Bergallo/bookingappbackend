package finalProjectBackEnd.finalProjectBackEnd.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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


    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "local_user_id", nullable = false)
    private LocalUser localUser;


    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}