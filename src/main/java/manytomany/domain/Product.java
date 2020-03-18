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
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@NonNull
	@Column(name = "description", nullable = false)
	private String description;

	@NonNull
	@Column(name = "price", nullable = false)
	private Double price;

	@ManyToMany(mappedBy = "products")
	private Set<User> users = new HashSet<>();

	public boolean addUser(User user) {
		return this.users.add(user);
	}

}

