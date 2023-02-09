package com.gridu.izbrodin.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
@Setter
public class Product {

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
