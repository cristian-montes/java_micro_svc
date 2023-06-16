package mymicro.example.productservice.controller;

import lombok.RequiredArgsConstructor;
import mymicro.example.productservice.dto.ProductRequest;
import mymicro.example.productservice.model.Product;
import mymicro.example.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor  //this injects the product service
public class ProductContoller {

    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }
}
