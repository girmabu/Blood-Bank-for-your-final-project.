/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.mapper.employee;

import et.gov.hrms.entity.Address;
import et.gov.hrms.entity.EmpFamilies;
import et.gov.hrms.entity.Employees;
import et.gov.hrms.mapper.AbstractFacade;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author glory
 */
@Stateless
public class EmpFamiliesFacade extends AbstractFacade<EmpFamilies> {

    @PersistenceContext(unitName = "ERP_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpFamiliesFacade() {
        super(EmpFamilies.class);
    }

    public ArrayList<EmpFamilies> findByEmpID(EmpFamilies employees) {
        Query query = em.createNamedQuery("EmpFamilies.findByEmpIdLike");
        query.setParameter("empId", employees.getEmpId().getId() + '%');
        try {
            ArrayList<EmpFamilies> empList = new ArrayList(query.getResultList());
            return empList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public EmpFamilies findByEmpIdObj(EmpFamilies employees) {
        Query query = em.createNamedQuery("EmpFamilies.findByEmpIdLike");
        query.setParameter("empId", employees.getEmpId().getId());
        try {
            EmpFamilies emp = (EmpFamilies) (query.getResultList().get(0));
            return emp;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
