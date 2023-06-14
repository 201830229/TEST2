package com.example.test2.dao.impl;

import com.example.test2.dao.ProductDAO;
import com.example.test2.entity.Product;
import com.example.test2.repository.ProductRepository;
import com.example.test2.repository.QProductRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.example.test2.entity.QProduct.product;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;
    private final JPAQueryFactory jpaQueryFactory;
    private final QProductRepository qProductRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository, JPAQueryFactory jpaQueryFactory, QProductRepository qProductRepository){
        this.productRepository = productRepository;
        this.jpaQueryFactory = jpaQueryFactory;
        this.qProductRepository = qProductRepository;
    }

    @Override
    public Product selectProduct(Long number) {
        Predicate predicate = product.number.eq(number);
        Optional<Product> selectProduct = qProductRepository.findOne(predicate);
        return selectProduct.isPresent() ? selectProduct.get() : null;
    }

    @Override
    public Product changeProduct(Long number, String name, int price, int stock) throws Exception {
        Optional<Product> selectProduct = productRepository.findById(number);
        Product updateProduct;
        if(selectProduct.isPresent()){
            Product product = selectProduct.get();
            product.setName(name);
            product.setPrice(price);
            product.setStock(stock);
            product.setUpdatedAt(LocalDateTime.now());
            updateProduct = productRepository.save(product);
        } else {
            throw new Exception();
        }
        return updateProduct;
    }

    @Override
    public Product insertProduct(Product product) {
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectProduct = productRepository.findById(number);
        if(selectProduct.isPresent()) {
            Product product = selectProduct.get();
            productRepository.delete(product);
        } else {
            throw new Exception();
        }
    }

    @Override
    public List<Product> listProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> listProductByPrice() {
        return productRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public List<Product> listProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Optional<Product> listProductById(Long number) {
        return productRepository.findById(number);
    }
}
