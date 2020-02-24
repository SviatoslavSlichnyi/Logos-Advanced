package ua.lviv.lgs.magazine.domain;

import lombok.*;

@Data
@NoArgsConstructor
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
