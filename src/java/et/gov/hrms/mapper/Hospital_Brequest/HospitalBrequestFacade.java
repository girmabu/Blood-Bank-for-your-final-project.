/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.mapper.Hospital_Brequest;

import et.gov.hrms.entity.Employees;
import et.gov.hrms.entity.HospitalBrequest;
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
public class HospitalBrequestFacade extends AbstractFacade<HospitalBrequest> {

    @PersistenceContext(unitName = "ERP_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HospitalBrequestFacade() {
        super(HospitalBrequest.class);
    }

    public ArrayList<HospitalBrequest> findByEmpID(HospitalBrequest hspbr) {

        Query query = em.createNamedQuery("HospitalBrequest.findByHospitalIdLike");
        query.setParameter("hospitalid", hspbr.getHospitalid().getId());
        try {
            ArrayList<HospitalBrequest> hsbrList = new ArrayList(query.getResultList());
            return hsbrList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public HospitalBrequest findByEmpIdObj(HospitalBrequest hspbr) {
        Query query = em.createNamedQuery("HospitalBrequest.findByHospitalIdLike");
        query.setParameter("hospitalid", hspbr.getHospitalid().getId());
        try {
            HospitalBrequest emp = (HospitalBrequest) (query.getResultList().get(0));
            return emp;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<HospitalBrequest> findByStatus(HospitalBrequest hospital_Brequest) {
        Query query = em.createNamedQuery("HospitalBrequest.findByStatus");
        try {
            ArrayList<HospitalBrequest> hsbrList = new ArrayList(query.getResultList());
           
            return hsbrList;
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return null;
    }

    public ArrayList<HospitalBrequest> findComplete(HospitalBrequest hospital_Brequest) {
        Query query = em.createNamedQuery("HospitalBrequest.findCompreq");
        try {
            ArrayList<HospitalBrequest> complete = new ArrayList(query.getResultList());
          
            return complete;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
public ArrayList<HospitalBrequest> findLoggedHistory(Employees logged)
{
     Query query = em.createNamedQuery("HospitalBrequest.findByEmpId");
        query.setParameter("empId", logged.getId());
        try {
            ArrayList<HospitalBrequest> loggedHistoryList = new ArrayList(query.getResultList());
            return loggedHistoryList;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
}
}
