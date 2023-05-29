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
  private  PetService PetService;
 
 

    @RequestMapping(value =  "/api", method = RequestMethod.GET)
    public List<PetModel> main(){
        return PetService.getPets();
    }
    

    @RequestMapping(value = "/api/get", method = RequestMethod.GET)
    @ResponseBody
    public List<PetModel> getAllPets(){
        return PetService.getPets();
    }
    @RequestMapping(value = "/api/sortbyprice", method = RequestMethod.GET)
    @ResponseBody
    public List<PetModel> getSortedPrice(){
        return PetService.getSortedPrice();
    }
    @RequestMapping(value = "/api/getPet/{PetId}", method = RequestMethod.GET)
    public List<PetModel> getPetById(@PathVariable("PetId") String id){
    
        try {
           int tempid= Integer.parseInt(id);
            
            return PetService.getPetbyId(tempid);
        } catch (Exception e) {
            return PetService.getPetbyName(id);
        }
      
    }
      
    @RequestMapping(path="api/put/{PetId}", method = RequestMethod.PUT)
    public void updatePet(@PathVariable("PetId") int id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String description,
                              @RequestParam(required = false) Integer price,
                              @RequestParam(required = false) Integer amount)
                              {
                        
                    PetService.updatePet(id, name==null?"":name, description==null?"":description, amount==null?-1:amount, price==null?-1:price);
                
    }
   
    @RequestMapping(value ="/api/post", method =  RequestMethod.POST)
    public void  registerPet(@RequestBody PetModel Pet){
        PetService.addNewPet(Pet);
    }
 
    @DeleteMapping(path= "api/delete/{PetId}")
    public void deletePet(@PathVariable("PetId")int id){
      PetService.deletePet(id);
    }
        
    
    
}