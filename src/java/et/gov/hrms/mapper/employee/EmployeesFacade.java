/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.mapper.employee;

import et.gov.hrms.entity.Employees;
import et.gov.hrms.mapper.AbstractFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author user
 */
@Stateless
public class EmployeesFacade extends AbstractFacade<Employees> {

    @PersistenceContext(unitName = "ERP_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeesFacade() {
        super(Employees.class);
    }

    @Override
    public List<Employees> findAll() {
        Query query = em.createNamedQuery("Employees.findAll");
        try {
            List<Employees> empList = (List<Employees>) query.getResultList();
            System.out.println("-----after query search---" + empList);
            
            return empList;
        } catch (Exception ex) {
            return null;
        }
    }

    public ArrayList<Employees> findByFname(Employees employee) {
        Query query = em.createNamedQuery("Employees.findByFirstName");
        query.setParameter("firstName", employee.getFirstName().toUpperCase() + '%');
        try {
            ArrayList<Employees> empList = new ArrayList(query.getResultList());
            System.out.println("employee employee---------------------=" + employee.getFirstName());
            System.out.println("empList---------------------=" + empList.size());
        
            return empList;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
public ArrayList<Employees> Count(Employees employees)
{
    Query query = em.createNamedQuery("Employees.findAll");
    query.setParameter("id", employees.getId());
    try{
        ArrayList<Employees> emplist = new ArrayList(query.getResultList());
       int count=0;
        ArrayList<Employees> array=emplist;
        ListIterator<Employees> a= array.listIterator();
        while(a.hasNext())
        {
            count++;
        }
        System.out.println("Count "+count);
    }
    catch(Exception ex)
    {
        
    }
       
    return null;
}
    public Employees findByEmpFnameObj(Employees employee) {
        Query query = em.createNamedQuery("Employees.findByFirstName");
        query.setParameter("firstName", employee.getFirstName());
        try {
            Employees emp = (Employees) query.getResultList().get(0);
            return emp;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Employees searchById(Employees employees) {
        Query query= em.createNamedQuery("Employees.findById");
        query.setParameter("id", employees.getId());
        try{
          Employees emp=(Employees) query.getResultList().get(0);
          return emp;
        } catch(Exception ex)
        {
            
        }
        return null;
    }

}
