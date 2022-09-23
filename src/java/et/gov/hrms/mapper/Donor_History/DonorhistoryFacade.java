/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.mapper.Donor_History;

import et.gov.hrms.entity.Donorhistory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jk
 */
@Stateless
public class DonorhistoryFacade extends AbstractFacade<Donorhistory> {
    @PersistenceContext(unitName = "ERP_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DonorhistoryFacade() {
        super(Donorhistory.class);
    }
    
}
