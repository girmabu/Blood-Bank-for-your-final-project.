/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.mapper.Donor;

import et.gov.hrms.entity.Donor;
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
public class DonorFacade extends AbstractFacade<Donor> {

    @PersistenceContext(unitName = "ERP_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DonorFacade() {
        super(Donor.class);
    }

    public ArrayList<Donor> findByDonorId(Donor logged) {
        Query query = em.createNamedQuery("Donor.findById");
        query.setParameter("id", logged.getId());
        try {
            ArrayList<Donor> donorList = new ArrayList(query.getResultList());
            return donorList;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Donor searchById(Donor donor) {
        Query query = em.createNamedQuery("Donor.findById");
        query.setParameter("id", donor.getId());
        try {
            Donor emp = (Donor) query.getResultList().get(0);
            return emp;
        } catch (Exception ex) {

        }
        return null;
    }

    public ArrayList<Donor> findByFname(Donor donor) {
        Query query = em.createNamedQuery("Donor.findByName");
        query.setParameter("name", donor.getName().toUpperCase() + '%');
        try {
            ArrayList<Donor> donorList = new ArrayList(query.getResultList());
            return donorList;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
