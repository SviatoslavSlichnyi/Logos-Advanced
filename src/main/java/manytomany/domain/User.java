package manytomany.domain;

import lombok.*;
import onetomany.domain.Bucket;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NonNull
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NonNull
    @Column(name = "role", nullable = false)
    private String role;

    @NonNull
    @Column(name = "password", nullable = false)
    private String password;

    @NonNull
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

    public boolean addProduct(Product product) {
        return this.products.add(product);
    }
}