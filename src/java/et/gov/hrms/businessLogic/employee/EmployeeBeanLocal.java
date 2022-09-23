/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.businessLogic.employee;

import et.gov.hrms.entity.Address;
import et.gov.hrms.entity.Employees;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author user
 */
@Local
public interface EmployeeBeanLocal {

    public void create(Employees employees);

    public void update(Employees employees);

    public Employees findByEmpFnameObj(Employees employee);

    public List<Address> findAll(Address address);

    public ArrayList<Employees> findByFname(Employees employees);

    public Employees searchById(Employees employees);

    public List<Employees> findAll(Employees employees);

  
}
