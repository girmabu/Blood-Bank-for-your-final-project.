/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.businessLogic.Stock;

import et.gov.hrms.entity.Stock;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

@Local
public interface StockBeanLocal {

    public List<Stock> findAll();

    public List<Stock> findAll(Stock stock);

    public void create(Stock stock);

    public void update(Stock stock);

    public ArrayList<Stock> findByBGroup(Stock stock);

  
    
}
