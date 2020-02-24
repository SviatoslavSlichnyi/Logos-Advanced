package ua.lviv.lgs.magazine.domain;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Bucket {

    private Integer id;
    @NonNull
    private Integer userId;
    @NonNull
    private Integer productId;
    @NonNull
    private Date purchaseDate;
    
}
