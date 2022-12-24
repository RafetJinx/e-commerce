package design.ecommerce.core.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    @Email
    @NotBlank
    @NotNull
    private String email;

    // Custom validation & password hash and salt çalışmalarının yapılması ve eklenmesi gerekli.
    @Column(name = "password")
    @NotBlank
    @NotNull
    private String password; // hash & salt olacak onun nasıl yapıldığını araştırmalısın
}
