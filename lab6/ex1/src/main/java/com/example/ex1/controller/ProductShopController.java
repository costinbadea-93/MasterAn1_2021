package com.example.ex1.controller;

import com.example.ex1.exceptions.NoProductFoundException;
import com.example.ex1.exceptions.NoSufficientQuantityException;
import com.example.ex1.model.Product;
import com.example.ex1.model.Shop;
import com.example.ex1.repository.ShopProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/shop")
@Validated
public class ProductShopController {

    private final ShopProductRepository shopProductRepository;

    public ProductShopController(ShopProductRepository shopProductRepository) {
        this.shopProductRepository = shopProductRepository;
    }

    @PostMapping("/product/new")
    public ResponseEntity<?> saveProduct(@RequestBody @Valid Product product){
//        try {
            return ResponseEntity.ok().body(shopProductRepository.saveProduct(product));
//        }catch (NoSufficientQuantityException exception){
//            return ResponseEntity.badRequest().body(exception.getMessage());
//        }
    }

    @GetMapping("/list")
    public ResponseEntity<Shop> shop(){
        return ResponseEntity.ok().body(shopProductRepository.retrieveShop());
    }

    @PostMapping("/product/buy/{productId}")
    public ResponseEntity<String> buyProduct(@PathVariable @Min(3) int productId){
//        try {
            Product product = shopProductRepository.buyProduct(productId);
            return ResponseEntity.ok().body("You can buy more " + product.getQuantity() + " similar producs!!!");
//        }catch (NoSufficientQuantityException | NoProductFoundException exception){
//            return ResponseEntity.badRequest().body(exception.getMessage());
//        }
    }

}
