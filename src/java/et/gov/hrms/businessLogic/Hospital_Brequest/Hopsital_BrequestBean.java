/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.businessLogic.Hospital_Brequest;

import et.gov.hrms.entity.Employees;
import et.gov.hrms.entity.Hospital;
import et.gov.hrms.entity.HospitalBrequest;
import et.gov.hrms.entity.Stock;
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
public class Hopsital_BrequestBean implements Hopsital_BrequestBeanLocal {

    @EJB
    HospitalFacade hospitalFacade;
    @EJB
    HospitalBrequestFacade hospital_BrequestFacade;
    @EJB
    StockFacade stockFacade;

    @Override
    public List<Hospital> findAll(Hospital hospital) {
        return hospitalFacade.findAll();
    }
    @Override
    public void create(HospitalBrequest hospital_Brequest) {
        hospital_BrequestFacade.create(hospital_Brequest);
    }

    @Override
    public void update(HospitalBrequest hospital_Brequest) {
        hospital_BrequestFacade.edit(hospital_Brequest);
    }

    @Override
    public HospitalBrequest findByEmpIdObj(HospitalBrequest hspbr) {
        return hospital_BrequestFacade.findByEmpIdObj(hspbr);
    }

    @Override
    public ArrayList<HospitalBrequest> findByEmpID(HospitalBrequest hspbr) {
        return hospital_BrequestFacade.findByEmpID(hspbr);
    }

    @Override
    public ArrayList<HospitalBrequest> findByStatus(HospitalBrequest hospital_Brequest) {
        return hospital_BrequestFacade.findByStatus(hospital_Brequest);
    }

    @Override
    public ArrayList<HospitalBrequest> findComplete(HospitalBrequest hospital_Brequest) {
        return hospital_BrequestFacade.findComplete(hospital_Brequest);
    }

    @Override
    public void edit(Stock stock) {
        stockFacade.edit(stock);
    }

    @Override
    public ArrayList<HospitalBrequest> findLoggedHistory(Employees loggedId) {
        return hospital_BrequestFacade.findLoggedHistory(loggedId);
    }

}
