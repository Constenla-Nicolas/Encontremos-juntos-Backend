package com.example.server.controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.JpaSort.Path;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import com.example.model.PetModel;
import com.example.service.PetService;

@RestController

public class MainController {
    
    
  @Autowired
  private  ProductService productService;
 
 

    @RequestMapping(value =  "/api", method = RequestMethod.GET)
    public List<ProductModel> main(){
        return productService.getProducts();
    }
    

    @RequestMapping(value = "/api/get", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductModel> getAllProducts(){
        return productService.getProducts();
    }
    @RequestMapping(value = "/api/sortbyprice", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductModel> getSortedPrice(){
        return productService.getSortedPrice();
    }
    @RequestMapping(value = "/api/getProduct/{productId}", method = RequestMethod.GET)
    public List<ProductModel> getProductById(@PathVariable("productId") String id){
    
        try {
           int tempid= Integer.parseInt(id);
            
            return productService.getProductbyId(tempid);
        } catch (Exception e) {
            return productService.getProductbyName(id);
        }
      
    }
      
    @RequestMapping(path="api/put/{productId}", method = RequestMethod.PUT)
    public void updateProduct(@PathVariable("productId") int id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String description,
                              @RequestParam(required = false) Integer price,
                              @RequestParam(required = false) Integer amount)
                              {
                        
                    productService.updateProduct(id, name==null?"":name, description==null?"":description, amount==null?-1:amount, price==null?-1:price);
                
    }
   
    @RequestMapping(value ="/api/post", method =  RequestMethod.POST)
    public void  registerProduct(@RequestBody ProductModel product){
        productService.addNewProduct(product);
    }
 
    @DeleteMapping(path= "api/delete/{productId}")
    public void deleteProduct(@PathVariable("productId")int id){
      productService.deleteProduct(id);
    }
        
    
    
}