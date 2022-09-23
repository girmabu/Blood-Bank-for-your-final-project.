
package et.gov.hrms.businessLogic.Subject;

import et.gov.hrms.entity.Employees;
import et.gov.hrms.entity.Subject;
import et.gov.hrms.mapper.Subject.SubjectFacade;
import et.gov.hrms.mapper.employee.EmployeesFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jk
 */
@Stateless
public class SubjectBean implements SubjectBeanLocal {
    
    @EJB
    SubjectFacade subjectFacade;
    @EJB
    EmployeesFacade employeeFacade;
    
    @Override
    public void create(Subject subject) {
        subjectFacade.create(subject);
    }
    
    @Override
    public void update(Subject subject) {
        subjectFacade.edit(subject);
    }

    @Override
    public ArrayList<Subject>findBySubjCode(Subject subject) {
        return subjectFacade.findBySubjCode(subject);
    }

 

    @Override
    public List<Employees> findAll(Employees employees) {
        return employeeFacade.findAll();
    }

  
    
}
