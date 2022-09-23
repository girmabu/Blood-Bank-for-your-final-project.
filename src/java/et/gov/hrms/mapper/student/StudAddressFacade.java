/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.mapper.student;

import et.gov.hrms.entity.StudAddress;
import et.gov.hrms.mapper.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ob
 */
@Stateless
public class StudAddressFacade extends AbstractFacade<StudAddress> {
    @PersistenceContext(unitName = "ERP_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudAddressFacade() {
        super(StudAddress.class);
    }
    
}
