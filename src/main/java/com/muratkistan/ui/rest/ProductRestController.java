package com.muratkistan.ui.rest;

import com.muratkistan.entity.ProductEntity;
import com.muratkistan.exception.ResourceNotFoundException;
import com.muratkistan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docker/v1")
@CrossOrigin
public class ProductRestController {

    @Autowired
    ProductRepository productRepository;


    //EKLEME
    //http://localhost:8080/docker/v1/create/product
    @PostMapping("/create/product")
    public ResponseEntity<ProductEntity> addProduct(@RequestBody ProductEntity productEntity){
        return ResponseEntity.ok(productRepository.save(productEntity));
    }

    // SELECT
    //http://localhost:8080/docker/v1/list/product
    @GetMapping("/list/product")
    public ResponseEntity<List<ProductEntity>> listProducts(){
        return ResponseEntity.ok(productRepository.findAll());
    }

    //BULMA
    //http://localhost:8080/docker/v1/find/product/1
    @GetMapping("/find/product/{id}")
    public ResponseEntity<ProductEntity> findProductById(@PathVariable("id") Long id){
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id + " numarali product id bulunmadi!!!"));
        return ResponseEntity.ok(productEntity);
    }

    //SILME
    //http://localhost:8080/docker/v1/delete/product/1
    @DeleteMapping("/delete/product/{id}")
    public ResponseEntity<Void> deleteProductId(@PathVariable("id") Long id){
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id + " numarali product id bulunmadi!!!"));
        productRepository.delete(productEntity);
        return ResponseEntity.ok().build();
    }

}
