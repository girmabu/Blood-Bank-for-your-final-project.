/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.businessLogic.employee;

import et.gov.hrms.entity.EmpFamilies;
import et.gov.hrms.entity.Employees;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author glory
 */
@Local
public interface EmpFamiliesBeanLocal {

    public EmpFamilies findByEmpIdObj(EmpFamilies empFamilies);

    public ArrayList<EmpFamilies> findByEmpID(EmpFamilies empFamilies);

    public List<Employees> findAll(Employees employees);

    public void create(EmpFamilies empFamilies);

    public void update(EmpFamilies empFamilies);

    public void remove(EmpFamilies empFamilies);

  
    
}
