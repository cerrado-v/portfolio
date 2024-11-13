package com.example.portfolio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.portfolio.dto.ItemsDto;
import com.example.portfolio.model.Items;
import com.example.portfolio.service.ItemsService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/items")
public class ShopController {

    @Autowired
    ItemsService itemsService;

    @PostMapping
    public ResponseEntity<ItemsDto> addProduct(@RequestBody ItemsDto itemsDto){
        ItemsDto newProduct = itemsService.addProduct(itemsDto);

        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PostMapping("/addmanyproducts")
    public ResponseEntity<List<ItemsDto>> addMultipleProducts(@RequestBody List<ItemsDto> itemsDtos){
        List<ItemsDto> addAllProducts = itemsService.addManyProducts(itemsDtos);
        return new ResponseEntity<>(addAllProducts, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ItemsDto>> getAllProducts(){
        List<ItemsDto> products = itemsService.getAllProducts();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/section/{section}")
    public ResponseEntity<List<ItemsDto>> getWomensProducts(@PathVariable(name="section") String section){
        List<ItemsDto> productDto = itemsService.getProductsBySection(section);
        
            return ResponseEntity.ok(productDto);
    }

    @GetMapping("/categorysection/{section}/{category}")
    public ResponseEntity<List<ItemsDto>> getProductsByCategoryAndSection(
            @PathVariable(name="category") String category,
            @PathVariable(name="section") String section) {

        List<ItemsDto> productsDto = itemsService.getProductsByCategoryAndSection(category, section);
        return ResponseEntity.ok(productsDto);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ItemsDto>> getProductsByCategory(
            @PathVariable(name="category") String category){
        
        List<ItemsDto> productsDto = itemsService.getProductsByCategory(category);
        return ResponseEntity.ok(productsDto);
    }
}
