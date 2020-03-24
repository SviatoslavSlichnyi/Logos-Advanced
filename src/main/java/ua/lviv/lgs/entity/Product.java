package ua.lviv.lgs.entity;

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
public class Product {

	@Id
	@GeneratedValue
	private Integer id;

	@NonNull
	private String name;

	@NonNull
	private String description;

	@NonNull
	private Double price;

	@OneToMany(targetEntity = Bucket.class, cascade = CascadeType.ALL)
	@Builder.Default
	@EqualsAndHashCode.Exclude
	@Transient private Set<Bucket> bucket = new HashSet<>();

}

