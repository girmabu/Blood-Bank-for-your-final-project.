package et.gov.hrms.businessLogic.Role;

import et.gov.hrms.entity.Role;
import et.gov.hrms.mapper.Role.RoleFacade;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
@Stateless
public class RoleBean implements RoleBeanLocal {

    @EJB
    RoleFacade roleFacade;

    @Override
    public Role checkUser(String userName, String password) {
          return roleFacade.checkUser(userName, password);
    }

    @Override
    public void create(Role role) {
  roleFacade.saveOrUpdate(role);
    }

    @Override
    public ArrayList<Role> findByPassword(Role role) {
        return roleFacade.findByPassword(role);
    }

    @Override
    public void update(Role role) {
        roleFacade.edit(role);
    }

   
}
