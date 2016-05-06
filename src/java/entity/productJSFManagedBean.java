/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "productJSFManagedBean")
@RequestScoped
public class productJSFManagedBean {

    @EJB
    private ProductFacadeLocal pro;
    
    public void create(){
        
        pro.create(em);
    }
    
    public void update(){
        pro.edit(em);
    }
     public void delete(){
        pro.remove(em);
    }
     
     
     public List<Product> lister(){
         
         return pro.findAll();
     }
     
     public void select(String productId){
        
        em = new Product(pro.find(productId));
    }
     
     
    Product em = new Product(); 

    public Product getEm() {
        return em;
    }

    public void setEm(Product em) {
        this.em = em;
    }
    
    public productJSFManagedBean() {
    }
    
}
