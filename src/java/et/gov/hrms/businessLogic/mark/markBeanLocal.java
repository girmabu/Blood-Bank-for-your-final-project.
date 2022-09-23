/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.businessLogic.mark;

import et.gov.hrms.entity.Mark;
import et.gov.hrms.entity.Student;
import et.gov.hrms.entity.Subject;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jk
 */
@Local
public interface markBeanLocal {

    public ArrayList<Mark>findByStudId(Mark mark);

    public void create(Mark mark);

    public void update(Mark mark);

    public List<Mark> findAll(Mark mark);

    public List<Subject> findAll(Subject subject);

    /**
     *
     * @param student
     * @return
     */
    public List<Student> findAll(Student student);

}
