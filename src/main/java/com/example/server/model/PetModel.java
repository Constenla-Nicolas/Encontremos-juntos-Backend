package com.example.server.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 

@Entity
@Table(name="DOGMODEL")
public class PetModel {

    private int id;
    private String info;
    private String race;
    private int age;
    private int locationId;
     

    public PetModel(){
       
    }

    public PetModel(int id, String info, String race, int age){
       
        this.info=info;
        this.id=id;
        this.race=race;
        this.age=age;
       

    }
//.

public PetModel( String info,String race, int age,int locationId){
    this.locationId=locationId;
    this.info=info;
    this.race=race;
    this.age=age;
 
}
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name = "dogid")
    public int getId() {
        return id;
    }
  
    public String getInfo() {
        return info;
    }
    public String getRace() {
        return race;
    }
    public int getAge() {
        return age;
    }

    public void setlocationId(int locationId) {
        this.locationId = locationId;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    public void setInfo(String info) {
        this.info = info;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public void setAge(int age) {
        this.age = age;
    }
   @Column(name = "positionid")
    public int getlocationId() {
        return locationId;
    }




}