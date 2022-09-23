/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.mapper.student;

import et.gov.hrms.entity.Student;
import et.gov.hrms.mapper.AbstractFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ob
 */
@Stateless
public class StudentFacade extends AbstractFacade<Student> {

    @PersistenceContext(unitName = "ERP_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }
 @Override
    public List<Student> findAll() {
        Query query = em.createNamedQuery("Student.findAll");
        try {
            List<Student> getAllStudent = (List<Student>) query.getResultList();
            return getAllStudent;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public ArrayList<Student> findByFname(Student student) {
        Query query = em.createNamedQuery("Student.findBySname");
        query.setParameter("sname", student.getSname().toUpperCase()+'%');
        try {
            ArrayList<Student> StudList = new ArrayList(query.getResultList());
            System.out.println("Student student---------------------=" + student.getSname());
            System.out.println("StudList---------------------=" + StudList.size());
            return StudList;

        } catch (Exception ex) {
            System.out.println("Error "+ex.getMessage());
        }
        return null;
    }

  
}
