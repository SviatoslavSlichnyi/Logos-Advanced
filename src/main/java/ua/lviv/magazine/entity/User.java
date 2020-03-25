package ua.lviv.magazine.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String role;

    @NonNull
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @Builder.Default
    @EqualsAndHashCode.Exclude
    @Transient private Set<Bucket> buckets = new HashSet<>();

}