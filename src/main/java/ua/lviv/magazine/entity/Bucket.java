package ua.lviv.magazine.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Bucket {

    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @NonNull
    @ManyToOne
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @NonNull
    private LocalDateTime purchaseDate;
}