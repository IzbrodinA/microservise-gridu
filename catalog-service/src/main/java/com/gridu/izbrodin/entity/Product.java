package com.gridu.izbrodin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "uniq_id", nullable = false)
    String id;
    String sku;
    String nameTitle;
    String description;
    String listPrice;
    String salePrice;
    String category;
    String categoryTree;
    String averageProductRating;
    String productUrl;
    String productImageUrls;
    String brand;
    String totalNumberReviews;
    String reviews;

}
