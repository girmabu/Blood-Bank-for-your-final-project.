package et.gov.hrms.entity;

import et.gov.hrms.entity.Address;
import et.gov.hrms.entity.EmpFamilies;
import et.gov.hrms.entity.Subject;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-09-08T13:54:54")
@StaticMetamodel(Employees.class)
public class Employees_ { 

    public static volatile SingularAttribute<Employees, String> firstName;
    public static volatile SingularAttribute<Employees, String> lastName;
    public static volatile ListAttribute<Employees, Subject> subjectList;
    public static volatile SingularAttribute<Employees, String> sex;
    public static volatile SingularAttribute<Employees, String> birth_date;
    public static volatile SingularAttribute<Employees, byte[]> profile;
    public static volatile SingularAttribute<Employees, String> middleName;
    public static volatile SingularAttribute<Employees, Integer> id;
    public static volatile ListAttribute<Employees, EmpFamilies> empFamiliesList;
    public static volatile SingularAttribute<Employees, String> age;
    public static volatile SingularAttribute<Employees, Address> addressId;

}