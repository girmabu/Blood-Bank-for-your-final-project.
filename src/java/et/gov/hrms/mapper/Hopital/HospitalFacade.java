/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.mapper.Hopital;

import et.gov.hrms.entity.Hospital;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jk
 */
@Stateless
public class HospitalFacade extends AbstractFacade<Hospital> {
    @PersistenceContext(unitName = "ERP_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HospitalFacade() {
        super(Hospital.class);
    }

    public ArrayList<Hospital> findByHospId(Hospital loggedinHosp) {
       Query query = em.createNamedQuery("Hospital.findById");
        query.setParameter("id", loggedinHosp.getId());
        try {
            ArrayList<Hospital> hospitalList = new ArrayList(query.getResultList());
            return hospitalList;

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
       return null;
    }
    
}
