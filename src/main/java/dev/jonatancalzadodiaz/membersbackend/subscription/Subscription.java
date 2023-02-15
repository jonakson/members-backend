package dev.jonatancalzadodiaz.membersbackend.subscription;

import dev.jonatancalzadodiaz.membersbackend.member.Member;
import dev.jonatancalzadodiaz.membersbackend.membership.Membership;
import dev.jonatancalzadodiaz.membersbackend.payment.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity(name = "Subscription")
@Table(
        name = "subscription"
)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class Subscription {

    @EmbeddedId
    private SubscriptionKey id;

    @ManyToOne
    @MapsId("memberId")
    @JoinColumn(
            name = "member_id",
            foreignKey = @ForeignKey(name = "subscription_member_id_fk")
    )
    //@JsonIgnore
    private Member member;

    @ManyToOne
    @MapsId("membershipId")
    @JoinColumn(
            name = "membership_id",
            foreignKey = @ForeignKey(name = "subscription_membership_id_fk")
    )
    //@JsonIgnore
    private Membership membership;

    @Column(
            name = "subscription_starting_date",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime subscriptionStartingDate;

    @Column(
            name = "subscription_ending_date",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime subscriptionEndingDate;

    // Relationship with Payment
    @OneToOne
    @JoinColumn(
            name = "payment_id"
    )
    private Payment payment;

}
