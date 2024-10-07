package com.amazon.itemservice.controller;


import com.amazon.itemservice.dto.Product;
import com.amazon.itemservice.service.InboundItemsServiceKafkaPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/seller")
public class InboundItemsServiceController {

    @Autowired
    InboundItemsServiceKafkaPublisher inboundItemsServiceKafkaPublisher;

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody  Product product)
    {
        Product publishedProduct=inboundItemsServiceKafkaPublisher.publishProduct(product);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(publishedProduct);
    }
}
