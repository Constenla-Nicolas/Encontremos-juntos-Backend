
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
    PetModel tempPet;
    @Autowired
  private RepositoryInterface rInterface;
   
    public List<PetModel> getPets(){
        return  rInterface.findAll();
    }
 
    
    public void addNewPet(PetModel pet) {
        rInterface.save(pet);
       
    }
    @Transactional
    public void updatePet(int id, String description, String race, int age){
     
        if(rInterface.findById(id).get()!=null)
        {tempPet=rInterface.findById(id).get();}
        else{}
    
       if (description.length()>0) {tempPet.setInfo(description);}
       if (race.length()>0){tempPet.setRace(race);} 
       if (age>-1) {tempPet.setAge(age);}
       rInterface.save(tempPet);

    }
    public void deletePet(int id) {
        rInterface.deleteById(id);
    }

 
    public List<PetModel> getPetById(int id) {
        return List.of(rInterface.findById(id).orElseThrow(() -> new IllegalStateException("no existe Peto con el id "+id)));
    }
    
}