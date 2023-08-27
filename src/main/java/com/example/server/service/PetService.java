
package com.example.server.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.server.service.PetModelInterface;
import com.example.server.model.LocationModel;
import com.example.server.model.PetModel;
 
@Service
public class PetService {
    PetModel tempPet;
    @Autowired
  private PetModelInterface petInterface;
  @Autowired
   private PetLocationInterface locationInterface;
    public List<PetModel> getPets(){
        return  petInterface.findAll();
    }
 
    
    public void addNewPet(PetModel pet) {
        petInterface.save(pet);
       
    }
    @Transactional
    public void updatePet(int id, String description, String race, int age){
     
        if(petInterface.findById(id).get()!=null)
        {tempPet=petInterface.findById(id).get();}
        else{}
    
       if (description.length()>0) {tempPet.setInfo(description);}
       if (race.length()>0){tempPet.setRace(race);} 
       if (age>-1) {tempPet.setAge(age);}
       petInterface.save(tempPet);

    }
    public void deletePet(int id) {
        petInterface.deleteById(id);
    }

    public List<LocationModel> getLocations(){
        return locationInterface.findAll();
    }

 
    public List<PetModel> getPetById(int id) {
        return List.of(petInterface.findById(id).orElseThrow(() -> new IllegalStateException("no existe Pet con el id "+id)));
    }
    
}