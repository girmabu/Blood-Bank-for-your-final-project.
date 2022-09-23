/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.mapper;

import et.gov.hrms.entity.Address;
import et.gov.hrms.mapper.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author user
 */
@Stateless
public class AddressFacade extends AbstractFacade<Address> {

    @PersistenceContext(unitName = "ERP_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AddressFacade() {
        super(Address.class);
    }

    @Override
    public List<Address> findAll() {
        Query query = em.createNamedQuery("Address.findAll");
        try {
            List<Address> getAllAddress = (List<Address>) query.getResultList();
            return getAllAddress;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Address> findAllAddressUnit() {
        Query query = em.createNativeQuery("SELECT ADDRESS.*, "
                + "LEVEL, LPAD(' ', 5* LEVEL - 1)|| ADDRESS_DESCRIPTION || '    ' "
                + "FROM ADDRESS "
                + "WHERE (PARENT_ID != 0 OR ADDRESS_ID = 1) AND STATUS = 1 "
                + "START WITH ADDRESS_ID = 1 "
                + "CONNECT BY nocycle "
                + "PRIOR ADDRESS_ID = PARENT_ID", Address.class);
        try {
            return (List<Address>) query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Address> findAllAddressUnitAndCountries() {
        Query query = em.createNativeQuery("SELECT ADDRESS.*, "
                + "LEVEL, LPAD(' ', 5* LEVEL - 1)|| ADDRESS_DESCRIPTION || '    ' "
                + "FROM ADDRESS "
                + "START WITH ADDRESS_ID = 0 "
                + "CONNECT BY nocycle "
                + "PRIOR ADDRESS_ID = PARENT_ID", Address.class);
        try {
            return (List<Address>) query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public Address findByAddressId(Address address) {
        Query query = em.createNamedQuery("Address.findByAddressId");
        query.setParameter("addressId", address.getAddressId());
        try {
            Address getAddress = (Address) query.getResultList().get(0);
            return getAddress;
        } catch (Exception ex) {
            return null;
        }
    }

    public Address findAllAddressUnitAsOne(Address address) {
        Query query = em.createNativeQuery("SELECT ADDRESS.ADDRESS_ID, SUBSTR(sys_connect_by_path( "
                + "ADDRESS.ADDRESS_NAME, ' , ' ), 3) as ADDRESS_NAME "
                + "FROM ADDRESS "
                + "WHERE ADDRESS_ID = ? "
                + "START WITH ADDRESS.PARENT_ID = 0 "
                + "CONNECT BY PRIOR ADDRESS_ID = PARENT_ID", Address.class);
        query.setParameter(1, address.getAddressId());
        try {
            return (Address) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
}
