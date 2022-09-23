package et.gov.hrms.mapper.Role;

import et.gov.hrms.entity.Role;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class RoleFacade extends AbstractFacade<Role> {

    @PersistenceContext(unitName = "ERP_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoleFacade() {
        super(Role.class);
    }

    public Role checkUser(String userName, String password) {
        Query query = em.createNamedQuery("Role.findByUsernameandpassword");
        query.setParameter("userName", userName);
        query.setParameter("password", password);

        try {
            Role s = (Role) query.getResultList().get(0);
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Role> findByPassword(Role role) {
        Query query = em.createNamedQuery("Role.findByPassword");
        query.setParameter("password", role.getPassword().toUpperCase() + '%');
        try {
            ArrayList<Role> roleList = new ArrayList(query.getResultList());
            System.out.println("Role role---------------------=" + role.getPassword());
            System.out.println("roleList---------------------=" + roleList.size());
            return roleList;

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return null;
    }

    public ArrayList<Role> findByRoleId(Role loggedRole) {
        Query query = em.createNamedQuery("Role.findById");
        query.setParameter("id", loggedRole.getId());
        try {
            ArrayList<Role> roleList = new ArrayList(query.getResultList());
            return roleList;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
