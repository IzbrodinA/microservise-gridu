CREATE TABLE product (
   uniq_id VARCHAR(255) NOT NULL,
   sku VARCHAR(255),
   name_title VARCHAR(255),
   description  CHARACTER LARGE OBJECT,
   list_price VARCHAR(255),
   sale_price VARCHAR(255),
   category VARCHAR(255),
   category_tree VARCHAR(255),
   average_product_rating VARCHAR(255),
   product_url  CHARACTER LARGE OBJECT,
   product_image_urls CHARACTER LARGE OBJECT,
   brand VARCHAR(255),
   total_number_reviews VARCHAR(255),
   reviews CHARACTER LARGE OBJECT,
   CONSTRAINT pk_product PRIMARY KEY (uniq_id)
) as select * from CSVREAD('classpath:data/jcpenney_com-ecommerce_sample.csv');