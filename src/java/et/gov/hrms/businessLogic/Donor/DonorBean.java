
package et.gov.hrms.businessLogic.Donor;

import et.gov.hrms.entity.Address;
import et.gov.hrms.entity.Donor;
import et.gov.hrms.entity.Question;
import et.gov.hrms.entity.Role;
import et.gov.hrms.entity.Stock;
import et.gov.hrms.mapper.AddressFacade;
import et.gov.hrms.mapper.Donor.DonorFacade;
import et.gov.hrms.mapper.Question.QuestionFacade;
import et.gov.hrms.mapper.Role.RoleFacade;
import et.gov.hrms.mapper.Stock.StockFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jk
 */
@Stateless
public class DonorBean implements DonorBeanLocal {

    @EJB
    DonorFacade donorFacade;
    @EJB
    QuestionFacade questionFacade;
    @EJB
    AddressFacade addressFacade;
    @EJB
    RoleFacade roleFacade;
    @EJB
    StockFacade stockFacade;

    @Override
    public void create(Donor donor) {
        donorFacade.create(donor);
    }

    @Override
    public void update(Donor donor) {
        donorFacade.edit(donor);
    }

    @Override
    public Question checkUser(String q1, String q2, String q3, String q4, String q5) {
        return questionFacade.checkUser(q1, q2, q3, q4, q5);
    }

    @Override
    public List<Address> findAll(Address address) {
        return addressFacade.findAll();
    }

    @Override
    public void save(Role role) {
        roleFacade.create(role);
    }

    @Override
    public void edit(Role role) {
        roleFacade.edit(role);
    }

    @Override
    public ArrayList<Donor> findByDonorId(Donor logged) {
        return donorFacade.findByDonorId(logged);
    }

    @Override
    public Donor searchById(Donor donor) {
        return donorFacade.searchById(donor);
    }

    @Override
    public List<Stock> findAll(Stock stock) {
        return stockFacade.findAll();
    }

    @Override
    public ArrayList<Role> findByRoleId(Role loggedRole) {
        return roleFacade.findByRoleId(loggedRole);
    }

    @Override
    public void update(Role role) {
        roleFacade.edit(role);
    }

    @Override
    public ArrayList<Donor> findByFname(Donor donor) {
        return donorFacade.findByFname(donor);
    }

}
