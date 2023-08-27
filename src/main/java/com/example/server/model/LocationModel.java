package com.example.server.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="DOGLOCATION")
public class LocationModel {

    private int id;
    private BigDecimal la;
    private BigDecimal lo;
    private String calle1;
    private String calle2;
    private int alturaDeCalle;
    private Date fecha;
     

    public LocationModel(){
       
    }

    public LocationModel(int id, BigDecimal la, BigDecimal lo, String calle1, String calle2, int alturaDeCalle, Date fecha){
       this.id=id;
       this.la=la;
       this.lo=lo;
       this.calle1=calle1;
       this.calle2=calle2;
       this.alturaDeCalle=alturaDeCalle;
       this.fecha=fecha;     
    }
    public LocationModel(String calle1, String calle2, int alturaDeCalle){
       this.calle1=calle1;
       this.calle2=calle2;
       this.alturaDeCalle=alturaDeCalle;
    }
    public LocationModel(BigDecimal la,BigDecimal lo){
       this.la=la;
       this.lo=lo;
    }

public LocationModel(BigDecimal la, BigDecimal lo, String calle1, String calle2, int alturaDeCalle){
        this.la=la;
       this.lo=lo;
       this.calle1=calle1;
       this.calle2=calle2;
       this.alturaDeCalle=alturaDeCalle;
     
}
public LocationModel(BigDecimal la, BigDecimal lo, String calle1, String calle2, int alturaDeCalle, Date fecha){
        this.la=la;
       this.lo=lo;
       this.calle1=calle1;
       this.calle2=calle2;
       this.alturaDeCalle=alturaDeCalle;
       this.fecha=fecha;
 
}
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name = "Locationid")
    public int getId() {
        return id;
    }
    public BigDecimal getLa() {
        return la;
    }
    public BigDecimal getLo() {
        return lo;
    }
    public String getCalle1() {
        return calle1;
    }
    public String getCalle2() {
        return calle2;
    }
    public int getalturaDeCalle() {
        return alturaDeCalle;
    }
  @Column(name ="dateAdded")
    public Date getFecha() {
        return fecha;
    }

  
    public void setId(int id) {
        this.id = id;
    }
    public void setLa(BigDecimal la) {
        this.la = la;
    }
    public void setLo(BigDecimal lo) {
        this.lo = lo;
    }
    public void setCalle1(String calle1) {
        this.calle1 = calle1;
    }
    public void setCalle2(String calle2) {
        this.calle2 = calle2;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public void setalturaDeCalle(int alturaDeCalle) {
        this.alturaDeCalle = alturaDeCalle;
    }


}