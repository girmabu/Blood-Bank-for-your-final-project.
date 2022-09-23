/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.businessLogic.Donor;

import et.gov.hrms.entity.Address;
import et.gov.hrms.entity.Donor;
import et.gov.hrms.entity.Question;
import et.gov.hrms.entity.Role;
import et.gov.hrms.entity.Stock;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jk
 */
@Local
public interface DonorBeanLocal {

    public void create(Donor donor);

    public void update(Donor donor);

    public Question checkUser(String q1, String q2, String q3, String q4, String q5);

    public List<Address> findAll(Address address);

    public void save(Role role);

    public void edit(Role role);

    public ArrayList<Donor> findByDonorId(Donor logged);

    public Donor searchById(Donor donor);

    public List<Stock> findAll(Stock stock);

    public  ArrayList<Role> findByRoleId(Role loggedRole);

    public void update(Role role);

    public ArrayList<Donor> findByFname(Donor donor);

   
    
}
