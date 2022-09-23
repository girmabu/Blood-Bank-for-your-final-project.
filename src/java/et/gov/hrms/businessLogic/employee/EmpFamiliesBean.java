/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.businessLogic.employee;

import et.gov.hrms.entity.EmpFamilies;
import et.gov.hrms.entity.Employees;
import et.gov.hrms.mapper.employee.EmpFamiliesFacade;
import et.gov.hrms.mapper.employee.EmployeesFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author glory
 */
@Stateless
public class EmpFamiliesBean implements EmpFamiliesBeanLocal {

    @EJB
    EmpFamiliesFacade EmpFamiliesFacade;
    @EJB
    EmployeesFacade employeeFacade;

    @Override
    public ArrayList<EmpFamilies> findByEmpID(EmpFamilies empFamilies) {
        return EmpFamiliesFacade.findByEmpID(empFamilies);
    }

    @Override
    public EmpFamilies findByEmpIdObj(EmpFamilies empFamilies) {
        return EmpFamiliesFacade.findByEmpIdObj(empFamilies);
    }

    @Override
    public List<Employees> findAll(Employees employees) {
        return employeeFacade.findAll();
    }

    @Override
    public void update(EmpFamilies empFamilies) {
        EmpFamiliesFacade.edit(empFamilies);
    }

    @Override
    public void create(EmpFamilies empFamilies) {
        EmpFamiliesFacade.create(empFamilies);
    }

    @Override
    public void remove(EmpFamilies empFamilies) {
        EmpFamiliesFacade.remove(empFamilies);
    }

}
