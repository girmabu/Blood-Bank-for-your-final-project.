/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.businessLogic.Subject;

import et.gov.hrms.entity.Employees;
import et.gov.hrms.entity.Subject;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
@Local
public interface SubjectBeanLocal {

    public void create(Subject subject);

    public void update(Subject subject);

    public ArrayList<Subject> findBySubjCode(Subject subject);

    public List<Employees> findAll(Employees employees);

}
