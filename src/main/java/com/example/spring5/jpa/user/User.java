package com.example.spring5.jpa.user;

import com.example.spring5.jpa.company.Company;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
//import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;

@NamedEntityGraph(name = "User.company", attributeNodes = @NamedAttributeNode("company"))
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@ToString
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class User extends AuditingEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private String firstname;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;
    private String image;
    private String password;
}

 enum Role  {

    USER, ADMIN;

//     @Override
//     public String getAuthority() {
//         return name();
//     }
 }