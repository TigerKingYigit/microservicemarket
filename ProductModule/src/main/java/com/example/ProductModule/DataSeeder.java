package com.example.ProductModule;

import com.example.ProductModule.Models.Product;
import com.example.ProductModule.Models.ProductCategory;
import com.example.ProductModule.Repository.CategoryRepository;
import com.example.ProductModule.Repository.ProductRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {


            ProductCategory productCategory1=new ProductCategory();
            productCategory1.setId(1);
            productCategory1.setCategoryName("sebze");

            ProductCategory productCategory2=new ProductCategory();
            productCategory1.setId(2);
            productCategory1.setCategoryName("meyve");

            ProductCategory productCategory3=new ProductCategory();
            productCategory1.setId(3);
            productCategory1.setCategoryName("baklagil");


            categoryRepository.save(productCategory1);
            categoryRepository.save(productCategory2);
            categoryRepository.save(productCategory3);


            Product product1=new Product();
            product1.setId(1);
            product1.setName("armut");
            product1.setPrice(8);
            product1.setCategoryId(1);


            Product product2=new Product();
            product2.setId(2);
            product2.setName("kivi");
            product2.setPrice(12);
            product2.setCategoryId(2);


            Product product3=new Product();
            product3.setId(3);
            product3.setName("muz");
            product3.setPrice(25);
            product3.setCategoryId(1);

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);


    }
}
