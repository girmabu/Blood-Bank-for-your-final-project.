package et.gov.hrms.entity;

import et.gov.hrms.entity.Employees;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-09-08T13:54:54")
@StaticMetamodel(EmpFamilies.class)
public class EmpFamilies_ { 

    public static volatile SingularAttribute<EmpFamilies, String> firstName;
    public static volatile SingularAttribute<EmpFamilies, String> lastName;
    public static volatile SingularAttribute<EmpFamilies, Employees> empId;
    public static volatile SingularAttribute<EmpFamilies, String> relationshipType;
    public static volatile SingularAttribute<EmpFamilies, String> phone;
    public static volatile SingularAttribute<EmpFamilies, String> emergencyContact;
    public static volatile SingularAttribute<EmpFamilies, String> sex;
    public static volatile SingularAttribute<EmpFamilies, Integer> id;

}