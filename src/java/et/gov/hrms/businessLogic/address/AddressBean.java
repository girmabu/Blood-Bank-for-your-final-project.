/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.businessLogic.address;

import et.gov.hrms.entity.Address;
import et.gov.hrms.mapper.AddressFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author user
 */
@Stateless
public class AddressBean implements AddressBeanLocal {

    @EJB
    AddressFacade addressFacade;

    @Override
    public List<Address> findAll() {
        return addressFacade.findAll();
    }

    @Override
    public List<Address> findAllAddressUnit() {
        return addressFacade.findAllAddressUnit();
    }

    @Override
    public List<Address> findAllAddressUnitAndCountries() {
        return addressFacade.findAllAddressUnitAndCountries();
    }

    @Override
    public Address findAllAddressUnitAsOne(Address address) {
        return addressFacade.findAllAddressUnitAsOne(address);
    }

    @Override
    public Address findByAddressId(Address address) {
        return addressFacade.findByAddressId(address);
    }

    @Override
    public void save(Address address) {
        addressFacade.create(address);
    }

    @Override
    public void edit(Address address) {
        addressFacade.edit(address);
    }

    @Override
    public void saveOrUpdate(Address address) {
        addressFacade.saveOrUpdate(address);
    }

    @Override
    public void remove(Address address) {
        addressFacade.remove(address);
    }

}