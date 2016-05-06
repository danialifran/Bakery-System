/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import javax.inject.Named;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;


//@Named(value = "empJSFManagedBean")
@ManagedBean
@RequestScoped
public class empJSFManagedBean {

    @EJB
    private EmployeeFacadeLocal tef;
    
    public void create(){
        
        tef.create(em);
    }
    
    public void update(){
        tef.edit(em);
    }
     public void delete(){
        tef.remove(em);
    }
     
     public List<Employee> lister(){
         
         return tef.findAll();
     }
    
    public void select(int employeeId){
        
        em = new Employee(tef.find(employeeId));
    }

   Employee em = new Employee(); 

    public Employee getEm() {
        return em;
    }

    public void setEm(Employee em) {
        this.em = em;
    }
    
    
    public empJSFManagedBean() {
    }
    
}
 