package ua.lviv.magazine.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import ua.lviv.magazine.enumeration.UserRole;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
public class Role implements GrantedAuthority {

    @Id
    @NonNull
    @EqualsAndHashCode.Exclude
    private Long id;

    @NonNull
    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    @EqualsAndHashCode.Exclude
    private Set<User> users = new HashSet<>();

    public Role(UserRole role) {
        this.id = role.getId();
        this.name = role.getName();
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
