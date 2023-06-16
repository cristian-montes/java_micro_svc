package mymicro.example.productservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mymicro.example.productservice.dto.ProductRequest;
import mymicro.example.productservice.model.Product;
import mymicro.example.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // this constructs the product on compile time
@Slf4j  // this allows you to do the log.info
public class ProductService {

    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest){
        Product product  = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product); //this is what saves it to the Mongo DataBase
        log.info("Product {} is saved", product.getId());

    }
}
