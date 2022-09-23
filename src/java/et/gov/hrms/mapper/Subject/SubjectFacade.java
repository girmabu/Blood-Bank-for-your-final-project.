/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.mapper.Subject;

import et.gov.hrms.entity.Subject;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jk
 */
@Stateless
public class SubjectFacade extends AbstractFacade<Subject> {
    @PersistenceContext(unitName = "ERP_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubjectFacade() {
        super(Subject.class);
    }
       @Override
    public List<Subject> findAll() {
        Query query = em.createNamedQuery("Subject.findAll");
        try {
            List<Subject> getAllSubject = (List<Subject>) query.getResultList();
            return getAllSubject;
        } catch (Exception ex) {
            return null;
        }
    }
    
    
      public ArrayList<Subject> findBySubjCode(Subject subject) {
        Query query = em.createNamedQuery("Subject.findBySubjCode");
        query.setParameter("subjCode", subject.getSubjCode().toUpperCase() + '%');
        try {
            ArrayList<Subject> subjList = new ArrayList(query.getResultList());
             System.out.println("Subject subject code---------------------=" + subject.getSubjCode());
            System.out.println("subjList---------------------=" + subjList.size());
            return subjList;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
