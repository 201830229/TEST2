package com.example.test2.controller;

import com.example.test2.dto.ChangeProductDto;
import com.example.test2.dto.ProductDto;
import com.example.test2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProductDto> changeProduct(@RequestBody ChangeProductDto changeProductDto) throws Exception {
        ProductDto productDto = productService.changeProduct(changeProductDto.getNumber(), changeProductDto.getName(), changeProductDto.getPrice(), changeProductDto.getStock());
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.saveProduct(productDto));
    }

    @DeleteMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteProduct(Long number) throws Exception {
        productService.deleteProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> listProduct() {
        List <ProductDto> productDto = productService.listProduct();
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @GetMapping("/listOrderByPrice")
    public ResponseEntity<List<ProductDto>> listProductByPrice() {
        List <ProductDto> productDto = productService.listProductByPrice();
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @GetMapping("/byName")
    public ResponseEntity<List<ProductDto>> listProductByName(String name) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.listProductByName(name));
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> listProductById(Long number) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.listProductById(number));
    }
}
