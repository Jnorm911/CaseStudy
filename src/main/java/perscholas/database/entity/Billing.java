package perscholas.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "billing")
public class Billing {
    @Id
    @Column(name = "cardnum", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @Column(name = "fname", nullable = false, length = 45)
    private String fname;

    @Column(name = "lname", nullable = false, length = 45)
    private String lname;

    @Column(name = "expire", nullable = false)
    private LocalDate expire;

    @Column(name = "cvv", nullable = false)
    private Integer cvv;

    @Column(name = "brand", nullable = false, length = 45)
    private String brand;

    @OneToMany(mappedBy = "card")
    private Set<Product> products = new LinkedHashSet<>();

}