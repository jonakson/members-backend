package dev.jonatancalzadodiaz.membersbackend.payment;

import dev.jonatancalzadodiaz.membersbackend.subscription.Subscription;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "Payment")
@Table(
        name = "payment"
)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class Payment {

    @Id
    @SequenceGenerator(
            name = "payment_id",
            sequenceName = "payment_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_id_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "amount",
            nullable = false,
            precision = 10,
            scale = 2
    )
    private BigDecimal amount;

    @Enumerated(
            EnumType.STRING
    )
    @Column(
            name = "payment_method",
            nullable = false
    )
    private PaymentMethod paymentMethod;

    @Column(
            name = "date",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime date;


    // Fields for Stripe Payment
    @Column(
            name = "stripe_payment_id",
            columnDefinition = "TEXT"
    )
    private String stripePaymentId;

    @Column(
            name = "stripe_fee",
            precision = 10,
            scale = 2
    )
    private BigDecimal stripeFee;

    // Fields for Bank Payment
    @Column(
            name = "bank_payment_reference",
            columnDefinition = "TEXT"
    )
    private String bankPaymentReference;

    // Relationship with Subscription
    @OneToOne(
            mappedBy = "payment"
    )
    @PrimaryKeyJoinColumn
    private Subscription subscription;
}
