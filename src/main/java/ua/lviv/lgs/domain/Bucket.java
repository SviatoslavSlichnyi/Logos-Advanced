package ua.lviv.lgs.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Bucket {

    private Integer id;
    private Integer userId;
    private Integer productId;
    private LocalDateTime purchaseDate;

    public Bucket(Integer userId, Integer productId, LocalDateTime purchaseDate) {
        this.userId = userId;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
    }

    public Bucket(Integer id, Integer userId, Integer productId, LocalDateTime purchaseDate) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return Objects.equals(id, bucket.id) &&
                Objects.equals(userId, bucket.userId) &&
                Objects.equals(productId, bucket.productId) &&
                Objects.equals(purchaseDate, bucket.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, productId, purchaseDate);
    }
}
