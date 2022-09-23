/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.businessLogic.mark;

import et.gov.hrms.entity.Mark;
import et.gov.hrms.entity.Student;
import et.gov.hrms.entity.Subject;
import et.gov.hrms.mapper.Subject.SubjectFacade;
import et.gov.hrms.mapper.mark.MarkFacade;
import et.gov.hrms.mapper.student.StudentFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jk
 */
@Stateless
public class markBean implements markBeanLocal {

    @EJB
    MarkFacade markfacade;
    @EJB
    SubjectFacade subjectFacade;
    @EJB
    StudentFacade studentFacade;

    @Override
    public void create(Mark mark) {
        markfacade.create(mark);
    }

    @Override
    public void update(Mark mark) {
        markfacade.edit(mark);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<Mark> findAll(Mark mark) {

        return markfacade.findAll();
    }

    @Override
    public List<Subject> findAll(Subject subject) {
        return subjectFacade.findAll();
    }

    @Override
    public List<Student> findAll(Student student) {
        return studentFacade.findAll();
    }

    @Override
    public ArrayList<Mark> findByStudId(Mark mark) {
        return markfacade.findByStudId(mark);
    }

}
