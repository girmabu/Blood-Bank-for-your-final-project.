/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.businessLogic.employee;

import et.gov.hrms.entity.Address;
import et.gov.hrms.entity.Employees;
import et.gov.hrms.mapper.AddressFacade;

import et.gov.hrms.mapper.employee.EmployeesFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author user
 */
@Stateless
public class EmployeeBean implements EmployeeBeanLocal {

    @EJB
    EmployeesFacade employeesFacade;
    @EJB
    AddressFacade addressFacade;

    @Override
    public void create(Employees employees) {
        employeesFacade.create(employees);
    }

    @Override
    public void update(Employees employees) {
        employeesFacade.edit(employees);
    }

    @Override
    public ArrayList<Employees> findByFname(Employees employee) {
        return employeesFacade.findByFname(employee);
    }

    @Override
    public Employees findByEmpFnameObj(Employees employee) {
        return employeesFacade.findByEmpFnameObj(employee);
    }

    @Override
    public List<Address> findAll(Address address) {
        return addressFacade.findAll();
    }

    @Override
    public Employees searchById(Employees employees) {
        return employeesFacade.searchById(employees);
    }

    @Override
    public List<Employees> findAll(Employees employees) {
        return employeesFacade.findAll();
    }

}
