package onetomany.domain;

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

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	@Transient private Set<Bucket> bucket = new HashSet<>();

}

