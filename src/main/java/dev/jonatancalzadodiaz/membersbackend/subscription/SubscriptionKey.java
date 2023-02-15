package dev.jonatancalzadodiaz.membersbackend.subscription;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class SubscriptionKey implements Serializable {

    @Column(
            name = "member_id"
    )
    private Long memberId;

    @Column(
            name = "membership_id"
    )
    private Long membershipId;

}
