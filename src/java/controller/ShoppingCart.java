
package controller;

import entity.*;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="sp")
@SessionScoped
public class ShoppingCart {
    
    private List<Item> cart = new ArrayList<Item>();
    private float total,cashAmount,bal;
   

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    public float getTotal() {
        total =0;
         for(Item item : cart){
           total = total+(item.getQuantity()*item.getP().getProductPrice().floatValue());
        }    
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }
    
   public float getCashAmount(){
       return cashAmount;
   }
   
   public void setCashAmount(float cashAmount){
       this.cashAmount=cashAmount;
   }
   
   public float getBal(){
       bal=0;
       bal = total- getCashAmount();
       
       return bal;
   }
   
   public void setBal(float bal) {
        this.bal = bal;
    }
      
    public String addToCart(Product p){
        
        //increament quantity if duplicate product
        for(Item item : cart){
            if(item.getP().getProductId().equals(p.getProductId())){
                
                item.setQuantity(item.getQuantity()+1);
                return "cart";
            }
        }     
        // create new item in cart
        Item i = new Item();
        i.setQuantity(1);
        i.setP(p);
        cart.add(i);
        return "cart";
    }
    
    public void update(){
        
        // reload the page
    }
    
    public void remove(Item i){
         for(Item item : cart){
             if(item.equals(i))
             {
                 cart.remove(item);
                 break;
             }
             
         }
    }
    
    public String payment(){
        
        return "payment";
    }

}
