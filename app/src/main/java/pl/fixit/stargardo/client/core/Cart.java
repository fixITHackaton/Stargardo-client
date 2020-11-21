package pl.fixit.stargardo.client.core;

import java.util.ArrayList;
import java.util.List;

import pl.fixit.stargardo.common.product.dto.ProductDto;

public class Cart {
    private static List<ProductDto> products;
    private static Long companyId;

    public static void addProduct(ProductDto productDto) {
        if (products == null || companyId != null) { //&& !companyId.equals(productDto.getCompanyId())
            products = new ArrayList<>();
        }
        products.add(productDto);
        companyId = null; //productDto.getCompanyId()
    }

    public static void removeProduct(ProductDto productDto) {
        products.remove(productDto);
    }

    public static void clearCart() {
        products = new ArrayList<>();
    }

    public static List<ProductDto> getProducts() {
        return products;
    }
}
