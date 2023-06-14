package com.example.test2.service.impl;

import com.example.test2.dao.ProductDAO;
import com.example.test2.dto.ProductDto;
import com.example.test2.entity.Product;
import com.example.test2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @Override
    public ProductDto getProduct(Long number) {
        Product product = productDAO.selectProduct(number);

        ProductDto productResponseDto = new ProductDto();
        productResponseDto.setName(product.getName());
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());
        return productResponseDto;
    }

    @Override
    public ProductDto changeProduct(Long number, String name, int price, int stock) throws Exception {
        Product changeProduct = productDAO.changeProduct(number, name, price, stock);

        ProductDto productDto = new ProductDto();
        productDto.setName(changeProduct.getName());
        productDto.setNumber(changeProduct.getNumber());
        productDto.setPrice(changeProduct.getPrice());
        productDto.setStock(changeProduct.getStock());
        return productDto;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product saveProduct = productDAO.insertProduct(product);

        productDto.setName(saveProduct.getName());
        productDto.setNumber(saveProduct.getNumber());
        productDto.setPrice(saveProduct.getPrice());
        productDto.setStock(saveProduct.getStock());
        return productDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }

    @Override
    public List<ProductDto> listProduct() {
        List<Product> products = productDAO.listProduct();
        List<ProductDto> productDtoList = products.stream().map(product -> new ProductDto(product)).collect(Collectors.toList());
        return productDtoList;
    }

    @Override
    public List<ProductDto> listProductByPrice() {
        List<Product> products = productDAO.listProductByPrice();
        List<ProductDto> productDtoList = products.stream().map(product -> new ProductDto(product)).collect(Collectors.toList());
        return productDtoList;
    }

    @Override
    public List<ProductDto> listProductByName(String name) {
        List<Product> products = productDAO.listProductByName(name);
        List<ProductDto> productDtoList = products.stream().map(product -> new ProductDto(product)).collect(Collectors.toList());
        return productDtoList;
    }

    @Override
    public List<ProductDto> listProductById(Long number) {
        Optional<Product> products = productDAO.listProductById(number);
        List<ProductDto> productDtoList = products.stream().map(product -> new ProductDto(product)).collect(Collectors.toList());
        return productDtoList;
    }
}
