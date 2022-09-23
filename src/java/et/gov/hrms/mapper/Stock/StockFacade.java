/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.mapper.Stock;

import et.gov.hrms.entity.Stock;
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
public class StockFacade extends AbstractFacade<Stock> {
    @PersistenceContext(unitName = "ERP_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockFacade() {
        super(Stock.class);
    }
     public ArrayList<Stock> findByBGroup(Stock stock) {
        Query query = em.createNamedQuery("Stock.findByBloodgroup");
        query.setParameter("bloodgroup", stock.getBloodgroup());
        try {
            ArrayList<Stock> stList = new ArrayList(query.getResultList());
            System.out.println("employee employee---------------------=" + stock.getBloodgroup());
            System.out.println("empList---------------------=" + stList.size());
        
            return stList;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
