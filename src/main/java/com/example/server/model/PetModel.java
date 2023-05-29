package com.example.server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 

@Entity
@Table(name="PET")
public class PetModel {
    
    private int id;
    private String name;
    private String description;
    private String race;
    private int age;
     

    public PetModel(){
       
    }

    public PetModel(int id,String name, String description, String race, int age){
        this.name=name;
        this.description=description;
        this.id=id;
        this.race=race;
        this.age=age;
       

    }
//.

public PetModel(String name, String description,String race, int age){
    this.name=name;
    this.description=description;
    this.race=race;
    this.age=age;
 
}
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getRace() {
        return race;
    }
    public int getAge() {
        return age;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public void setAge(int age) {
        this.age = age;
    }





}