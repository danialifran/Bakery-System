package model;

import java.util.*;
import entity.*;
import org.hibernate.*;

public class Product_dao {
    
    public List<Product> getAll(){
        
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Product> lst = new ArrayList<>();
        
        try{
            
            s.beginTransaction();
            lst = s.createCriteria(Product.class).list();
            s.getTransaction().commit();
            
        }catch(Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
            
        }
        
        return lst;
    }
    
}
