package dev.jonatancalzadodiaz.membersbackend.membership;

import dev.jonatancalzadodiaz.membersbackend.subscription.Subscription;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "Membership")
@Table(
        name = "membership",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "membership_name_unique",
                        columnNames = "name"
                )
        }
)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class Membership {

    @Id
    @SequenceGenerator(
            name = "membership_id",
            sequenceName = "membership_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "membership_id_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "period",
            nullable = true,
            columnDefinition = "INTEGER"
    )
    private Integer period;

    @Column(
            name = "price",
            precision = 10,
            scale = 2
    )
    private BigDecimal price;

    // Relationship with Subscription
    @OneToMany(
            mappedBy = "membership"
    )
    List<Subscription> subscriptions;

}
