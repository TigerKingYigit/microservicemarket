package com.example.ProductModule.Controller;
import com.example.ProductModule.DAO.CategoryDAO;
import com.example.ProductModule.Models.Product;
import com.example.ProductModule.Models.ProductCategory;
import com.example.ProductModule.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("communication")
public class ProductController {
    //Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryDAO categoryDAO;
    @PostMapping("add")
    public void addProduct(@RequestBody Product product){
        productService.AddProduct(product);
    }
    @GetMapping("product")
    public List<Product> GetListProduct(){
        List<Product> productList =productService.GetListProduct();
        //log.info("all products are listed !");
        return productList;
    }
    @GetMapping("getProductById/{productId}")
    public Optional<Product> getProductById(@PathVariable int productId){
        return productService.getProductById(productId);
    }
    @GetMapping("getAllProductsWithPagination/{no}/{size}")
    public List<Product> getAllProductsWithPagination(@PathVariable int no,
                                                      @PathVariable int size){
        return productService.getAllProductsWithPagination(no,size);
    }
    @GetMapping("getAllProductsBySorting/{field}")
    public List<Product> getAllProductsBySorting(@PathVariable String field){
        return productService.getAllProductsBySorting(field);
    }
    @GetMapping("category")
    public List<ProductCategory> GetListCategory(){
        List<ProductCategory> categoryList =categoryDAO.GetList();
        return categoryList;
    }
    @GetMapping("getProductsByFirstLetter/{firstLetter}")
    public List<Product> GetListProductsByLetter(@PathVariable char firstLetter)
    {
        List<Product> products= productService.GetListByFirstLetter(firstLetter);
        return products;
    }
    @GetMapping("getProductByName/{productName}")
    public Product getProductByName(@PathVariable String productName){
        return productService.getProductByName(productName);
    }
    @GetMapping("softDeleteById/{id}")
    public void softDeleteProductById(@PathVariable int id){
        productService.softDeleteProduct(id);
    }
} 
