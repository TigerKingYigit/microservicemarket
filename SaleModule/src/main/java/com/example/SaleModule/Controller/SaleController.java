package com.example.SaleModule.Controller;
import com.example.SaleModule.Models.*;
import com.example.SaleModule.OfferService.OfferService;
import com.example.SaleModule.ProductServiceClient;
import com.example.SaleModule.SaleService.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//for offers, pagination,sorting and filtering
@RestController
@RequestMapping("saleApi")
public class SaleController {
    @Autowired
    private SaleService saleService;
    @Autowired
    private OfferService offerService;
    @Autowired
    private ProductServiceClient productServiceClient;
    @RequestMapping("getProductList")
    public List<Product> getProductList() {
          return productServiceClient.getProductList();
    }
    @RequestMapping("getProductById/{productId}")
    public Product getProductById(@PathVariable int productId){
        Product product= productServiceClient.getProductById(productId);
        return product;
    }
    @GetMapping("getProductsBySaleId/{saleId}")
    public List<Product>getProductsBySaleId(@PathVariable int saleId){
        List<Product>products=productServiceClient.getProductListBySaleId(saleId);
        return products;
    }
    @PostMapping("sale")
    public void sale(@RequestBody List<SaleDTOSet> saleDTOSet){
        saleService.sale(saleDTOSet);

    }
    @GetMapping("getSaleDTOByProductId/{id}")
    public List<SaleDTOGet> getSales(@PathVariable int id){
        return saleService.getSaleDTOByProductId(id);
    };
    @GetMapping("getOffersWithSorting/{field}")
    public List<Offer> getOffersWithSorting(@PathVariable String field){
        return offerService.getOffersWithSorting(field);
    }
    @GetMapping("getAllOffersWithPagination/{pageNumber}/{pageSize}")
    public List<Offer> getAllOffersWithPagination(@PathVariable int pageNumber,
                                                  @PathVariable int pageSize){
        return offerService.getAllOffersWithPagination(pageNumber,pageSize);
    }
    @GetMapping("getOfferListByFirstLetter/{letter}")
    public List<Offer> getOfferListByFirstLetter(@PathVariable char letter){
        return offerService.getOfferListByFirstLetter(letter);
    }
    @GetMapping("getSaleList")
    public List<Sale> getSaleList(){
        return saleService.getSaleList();
    }
    @GetMapping("getOfferById/{offerId}")
    public Optional<Offer> getOfferById(@PathVariable int offerId){
        return offerService.getOfferById(offerId);
    }
    @GetMapping("getSaleByNumber/{sellingNumber}")
    public List<Sale> getSaleByNumber(@PathVariable int sellingNumber){
        return saleService.getSaleByNumber(sellingNumber);
    }
    @GetMapping("softDeleteSaleById/{id}")
    public void softDeleteSaleById(@PathVariable int id){
        saleService.softDeleteSaleById(id);
    }
}