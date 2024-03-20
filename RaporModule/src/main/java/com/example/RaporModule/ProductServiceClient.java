package com.example.RaporModule;

import com.example.RaporModule.Models.Offer;
import com.example.RaporModule.Models.Product;
import com.example.RaporModule.Models.ProductCategory;
import com.example.RaporModule.Models.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ProductServiceClient {
    @Autowired
    private WebClient.Builder webClientBuilder;
    public List<Product> getProductList() {
        Flux<Product> products= webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/communication/product")
                .retrieve()
                .bodyToFlux(Product.class);
        return products.collectList().block();
    }
    public Product getProductById(int productId) {
        Mono<Product> product = webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/api/v4/getProductById/{productId}", productId)
                .retrieve()
                .bodyToMono(Product.class);

        return product.block();
    }
    public Product getProductByName(String productName){
        Mono<Product> product = webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/api/v4/getProductByName/{productName}", productName)
                .retrieve()
                .bodyToMono(Product.class);

        return product.block();
    }
    public ProductCategory getCategoryById(int id) {
        Mono<ProductCategory> category = webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/api/v4/getCategoryById/{id}", id)
                .retrieve()
                .bodyToMono(ProductCategory.class);
        return category.block();
    }
    public List<Product> getProductListBySaleId(int saleId) {
        Flux<Product> products= webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/api/v4/getProductsBySaleId/{saleId}",saleId)
                .retrieve()
                .bodyToFlux(Product.class);
        return products.collectList().block();
    }
    public List<Sale> getSaleList() {
        Flux<Sale> sales= webClientBuilder.build()
                .get()
                .uri("http://localhost:8080/saleApi/getSaleList")
                .retrieve()
                .bodyToFlux(Sale.class);
        return sales.collectList().block();
    }
    public List<Product> getProductsById(int productId){
        Flux<Product> product = webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/communication/getProductById/{productId}",productId)
                .retrieve()
                .bodyToFlux(Product.class);

        return product.collectList().block();
    }
    public List<Sale> getSalesByNumber(int sellingNumber) {
        Flux<Sale> sales= webClientBuilder.build()
                .get()
                .uri("http://localhost:8080/saleApi/getSaleByNumber/{sellingNumber}",sellingNumber)
                .retrieve()
                .bodyToFlux(Sale.class);
        return sales.collectList().block();
    }

    public Product getProductBySaleId(Integer saleId) {
        Mono<Product> product = webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/communication/getProductsBySaleId/{saleId}",saleId)
                .retrieve()
                .bodyToMono(Product.class);

        return product.block();
    }
    public Offer getOfferById(Integer offerId) {
        Mono<Offer> offer = webClientBuilder.build()
                .get()
                .uri("http://localhost:8080/saleApi/getOfferById/{offerId}",offerId)
                .retrieve()
                .bodyToMono(Offer.class);

        return offer.block();
    }
}