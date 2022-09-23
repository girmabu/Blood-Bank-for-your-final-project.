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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jk
 */
@Local
public interface Hopsital_BrequestBeanLocal {

    public List<Hospital> findAll(Hospital hospital);

    public void create(HospitalBrequest hospital_Brequest);

    public void update(HospitalBrequest hospital_Brequest);

    public HospitalBrequest findByEmpIdObj(HospitalBrequest hspbr);

    public ArrayList<HospitalBrequest> findByEmpID(HospitalBrequest hspbr);

    public ArrayList<HospitalBrequest> findByStatus(HospitalBrequest hospital_Brequest);

    public ArrayList<HospitalBrequest> findComplete(HospitalBrequest hospital_Brequest);

    public void edit(Stock stock);

    public ArrayList<HospitalBrequest> findLoggedHistory(Employees loggedId);

}
