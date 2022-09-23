package et.gov.hrms.businessLogic.Role;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import et.gov.hrms.entity.Role;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author user
 */
@Local
public interface RoleBeanLocal {

    public Role checkUser(String userName, String password);

    public void create(Role role);

    public ArrayList<Role> findByPassword(Role role);

    public void update(Role role);
    
}
