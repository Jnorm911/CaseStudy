package perscholas.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid", nullable = false)
    private Integer id;
    @Column(name="type")
    private String type;
    @Column(name="renew")
    private boolean renew;
    @Column(name="renewdate")
    private LocalDate renewDate;
    @Column(name="cycle")
    private Integer cycle;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card")
    private Billing card;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private User user;
}