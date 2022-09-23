/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.businessLogic.student;

import et.gov.hrms.entity.Student;
import et.gov.hrms.mapper.student.StudentFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ob
 */
@Stateless
public class StudentBean implements StudentBeanLocal {

    @EJB
    StudentFacade studentFacade;

    @Override
    public void save(Student student) {
        studentFacade.create(student);
    }

    @Override
    public ArrayList<Student> findByFname(Student student) {
        return studentFacade.findByFname(student);
    }

    @Override
    public List<Student> findAll(Student student) {
        return studentFacade.findAll();
    }

    @Override
    public void update(Student student) {
        studentFacade.edit(student);
    }

}
