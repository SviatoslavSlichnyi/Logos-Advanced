package ua.lviv.lgs.magazine.domain;

import java.util.Date;

public class Bucket {

    private Integer id;
    private Integer userId;
    private Integer productId;
    private Date purchaseDate;

    public Bucket() {
    }

    public Bucket(Integer userId, Integer productId, Date purchaseDate) {
        this.userId = userId;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
    }

    public Bucket(Integer id, Integer userId, Integer productId, Date purchaseDate) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
    }


}
