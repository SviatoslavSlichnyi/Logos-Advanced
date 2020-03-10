package ua.lviv.lgs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {

	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private String description;
	@NonNull
	private Double price;
}
