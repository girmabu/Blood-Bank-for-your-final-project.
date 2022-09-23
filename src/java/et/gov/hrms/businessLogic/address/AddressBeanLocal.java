/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.businessLogic.address;

import et.gov.hrms.entity.Address;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author user
 */
@Local
public interface AddressBeanLocal {

    public List<Address> findAll();

    public List<Address> findAllAddressUnit();

    public List<Address> findAllAddressUnitAndCountries();

    public Address findAllAddressUnitAsOne(Address address);

    public Address findByAddressId(Address address);

    public void save(Address address);

    public void edit(Address address);

    public void saveOrUpdate(Address address);

    public void remove(Address address);
}

