/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.businessLogic.Stock;

import et.gov.hrms.entity.Stock;
import et.gov.hrms.mapper.Stock.StockFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jk
 */
@Stateless
public class StockBean implements StockBeanLocal {
    
    @EJB
    StockFacade stockFacade;
    
    @Override
    public List<Stock> findAll() {
        return stockFacade.findAll();
    }
    
    @Override
    public List<Stock> findAll(Stock stock) {
        
        return stockFacade.findAll();
    }
    
    @Override
    public void create(Stock stock) {
        stockFacade.create(stock);
    }
    
    @Override
    public void update(Stock stock) {
        stockFacade.edit(stock);
    }

    @Override
    public ArrayList<Stock> findByBGroup(Stock stock) {
        return stockFacade.findByBGroup(stock);
    }
    
}
