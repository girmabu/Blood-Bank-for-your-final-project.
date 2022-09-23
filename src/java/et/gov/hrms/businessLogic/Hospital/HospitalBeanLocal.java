/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.businessLogic.Hospital;

import et.gov.hrms.entity.Address;
import et.gov.hrms.entity.Employees;
import et.gov.hrms.entity.Hospital;
import et.gov.hrms.entity.HospitalBrequest;
import et.gov.hrms.entity.Stock;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jk
 */
@Local
public interface HospitalBeanLocal {

    public List<Address> findAll(Address address);

    public void create(Hospital hospital);

    public void update(Hospital hospital);

    public List<Hospital> findAll(Hospital hospital);

    public ArrayList<Hospital> findByHospId(Hospital loggedinHosp);

    public void remove(HospitalBrequest hbr);

    public void update(HospitalBrequest hospital_Brequest);
    
    public List<Stock> findAll(Stock stock);

}
