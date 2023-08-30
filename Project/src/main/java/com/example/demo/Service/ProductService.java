package com.example.demo.Service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.repository.ProductRepo;

@Service

public class ProductService {
    @Autowired
    private ProductRepo productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    
    public List<Product>sortByAsc(String name){
    	return productRepository.findAll(Sort.by(name).ascending());
    }
    
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    
    public Product updateProduct(long id, Product updatedproduct ) {
    	Product existingproduct=productRepository.findById(id).orElse(null);
    	if(existingproduct!=null) {
    		existingproduct.setName(updatedproduct.getName());
    		return productRepository.save(existingproduct);
    	}
    	return null;
    }
    
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}