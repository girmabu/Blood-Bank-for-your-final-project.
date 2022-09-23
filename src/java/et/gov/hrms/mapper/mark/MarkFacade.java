/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.mapper.mark;

import et.gov.hrms.entity.Mark;
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
public class MarkFacade extends AbstractFacade<Mark> {
    @PersistenceContext(unitName = "ERP_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarkFacade() {
        super(Mark.class);
    }
      public ArrayList<Mark> findByStudId(Mark mark) {
        Query query = em.createNamedQuery("Mark.findBySid");
        query.setParameter("sid", mark.getSid());
        query.setParameter("sid", mark.getSid());
        
        try {
            ArrayList<Mark> markList = new ArrayList(query.getResultList());
             System.out.println("Mark mark---------------------=" + mark.getSid());
            System.out.println("markList---------------------=" + markList.size());
            return markList;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
       @Override
    public List<Mark> findAll() {
        Query query = em.createNamedQuery("Mark.findAll");
        try {
            List<Mark> getAllStudent = (List<Mark>) query.getResultList();
            return getAllStudent;
        } catch (Exception ex) {
            return null;
        }
    }

}
