
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
    public void updatePet(int id,String name, String description, String race, int age){
       PetModel tempPet=rInterface.findById(id).get().orElseThrow(() -> new IllegalStateException("no existe mascota con id "+id));
       if (name.length()>0) {tempPet.setName(name);}
       if (description.length()>0) {tempPet.setDescription(description);}
       if (race.lenght()>0){tempPet.setRace(race)} 
       if (age>-1) {tempPet.setAge(age);}
       rInterface.save(tempPet);

    }
    public void deletePet(int id) {
        rInterface.deleteById(id);
    }

    public List<PetModel> getPetByName(String name) {
        return List.of(rInterface.findByName(name));
    }

    public List<PetModel> getPetById(int id) {
        return List.of(rInterface.findById(id).orElseThrow(() -> new IllegalStateException("no existe Peto con el id "+id)));
    }
    
}