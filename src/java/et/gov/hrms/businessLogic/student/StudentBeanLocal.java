/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.businessLogic.student;

import et.gov.hrms.entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ob
 */
@Local
public interface StudentBeanLocal {

    public void save(Student student);

    public ArrayList<Student> findByFname(Student student);

    public List<Student> findAll(Student student);

    public void update(Student student);

 
}
