
package com.example.server.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.server.service.RepositoryInterface;
import com.example.server.model.PetModel;
 
@Service
public class PetService {
    @Autowired
  private RepositoryInterface rInterface;
   
    public List<PetModel> getPets(){
        return  rInterface.findAll();
    }
 
    
    public void addNewPet(PetModel pet) {
        rInterface.save(pet);
       
    }
    @Transactional
    public void updateProduct(int id,String name, String description, Integer amount, Integer price){
        
       if(!rInterface.existsById(id)){
        throw new IllegalStateException("no existe producto con id "+id);
       }
       PetModel tempProduct=rInterface.findById(id).get();
       if (name.length()>0) {tempProduct.setName(name);}
       if (description.length()>0) {tempProduct.setDescription(description);}
     
 
       if (amount>-1) {tempProduct.setAmount(amount);}
       if (price>-1) {tempProduct.setPrice(price);}
       rInterface.save(tempProduct);

    }
    public void deletePet(int id) {
        rInterface.deleteById(id).orElseThrow(() -> new IllegalStateException("no existe producto con id "+id));
    }

    public List<PetModel> getPetByName(String name) {
        return List.of(rInterface.findByName(name));
    }

    public List<PetModel> getPetById(int id) {
        return List.of(rInterface.findById(id).orElseThrow(() -> new IllegalStateException("no existe producto con el id "+id)));
    }


	public List<PetModel> getSortedPrice() {


		return rInterface.findAll(Sort.by(Sort.Direction.DESC, "price"));
	}
    
}