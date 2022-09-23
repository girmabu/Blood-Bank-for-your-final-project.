/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.businessLogic.Hospital;

import et.gov.hrms.entity.Address;
import et.gov.hrms.entity.Hospital;
import et.gov.hrms.entity.HospitalBrequest;
import et.gov.hrms.entity.Stock;
import et.gov.hrms.mapper.AddressFacade;
import et.gov.hrms.mapper.Hopital.HospitalFacade;
import et.gov.hrms.mapper.Hospital_Brequest.HospitalBrequestFacade;
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
public class HospitalBean implements HospitalBeanLocal {
    
    @EJB
    HospitalFacade hospitalFacade;
    @EJB
    AddressFacade addressFacade;
    @EJB
    HospitalBrequestFacade hospitalBrequestFacade;
    @EJB
    StockFacade stockFacade;
    @Override
    public List<Address> findAll(Address address) {
        return addressFacade.findAll();
    }
    
    @Override
    public void create(Hospital hospital) {
        hospitalFacade.create(hospital);
    }
    
    @Override
    public void update(Hospital hospital) {
        
        hospitalFacade.edit(hospital);
    }

    @Override
    public ArrayList<Hospital> findByHospId(Hospital loggedinHosp) {
        return hospitalFacade.findByHospId(loggedinHosp);
    }
   
    
    @Override
    public List<Hospital> findAll(Hospital hospital) {
        return hospitalFacade.findAll();
    }
    
    @Override
    public void remove(HospitalBrequest hbr) {
        hospitalBrequestFacade.remove(hbr);
    }
    
    @Override
    public void update(HospitalBrequest hospital_Brequest) {
        hospitalBrequestFacade.edit(hospital_Brequest);
    }

    @Override
    public List<Stock> findAll(Stock stock) {
        return stockFacade.findAll();
    }
}
