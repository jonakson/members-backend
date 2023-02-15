package dev.jonatancalzadodiaz.membersbackend.member;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;

@Entity(name = "Member")
@Table(
        name = "member",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "member_email_unique",
                        columnNames = "email"
                ),
                @UniqueConstraint(
                        name = "member_id_card_number_unique",
                        columnNames = "id_card_number"
                )
        }
)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class Member {

    @Id
    @SequenceGenerator(
            name = "member_id",
            sequenceName = "member_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_id_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "id_card_number",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String idCardNumber;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "surname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String surname;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "phone",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String phone;

    @Column(
            name = "dob",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime dob;

    @Column(
            name = "entry_date",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime entryDate;

    @Column(
            name = "is_admin",
            nullable = false,
            columnDefinition = "BOOLEAN DEFAULT FALSE"
    )
    private Boolean isAdmin;
}
