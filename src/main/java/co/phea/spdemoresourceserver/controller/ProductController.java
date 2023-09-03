package co.phea.spdemoresourceserver.controller;

import co.phea.spdemoresourceserver.dto.ProductDto;
import co.phea.spdemoresourceserver.entity.Product;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class ProductController {

    @GetMapping("/product")
    @PreAuthorize("hasAnyAuthority('SCOPE_openid')")
    public List<Product> getProduct() {

        List<Product> products = new ArrayList<>() {{

            add(new Product(1, "Book", 1, 10));
            add(new Product(2, "Pencil", 1, 10));
            add(new Product(3, "Pen", 1, 10));
            add(new Product(4, "Rules", 1, 10));
        }};
        return products;
    }

    @GetMapping("/product-type")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public  List<ProductDto> getProductType(){

        return List.of(new ProductDto(UUID.randomUUID(),"Car"));

    }
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public  UUID createProduct(@RequestBody String productType){

        return UUID.randomUUID();
    }
}
