package com.joaoibarra.ibarrabeer.model;

import java.util.List;

/**
 * Created by joaoibarra on 08/04/18.
 */

public class Product {
    List<ProductVariant> productVariants;

    public List<ProductVariant> getProductVariants() {
        return productVariants;
    }

    public void setProductVariants(List<ProductVariant> productVariants) {
        this.productVariants = productVariants;
    }
}
