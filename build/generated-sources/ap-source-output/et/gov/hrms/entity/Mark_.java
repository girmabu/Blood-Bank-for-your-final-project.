package et.gov.hrms.entity;

import et.gov.hrms.entity.Student;
import et.gov.hrms.entity.Subject;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-09-08T13:54:54")
@StaticMetamodel(Mark.class)
public class Mark_ { 

    public static volatile SingularAttribute<Mark, Double> quiz;
    public static volatile SingularAttribute<Mark, Double> final1;
    public static volatile SingularAttribute<Mark, Double> total;
    public static volatile SingularAttribute<Mark, Double> assessment2;
    public static volatile SingularAttribute<Mark, Integer> markId;
    public static volatile SingularAttribute<Mark, Double> mid;
    public static volatile SingularAttribute<Mark, Subject> subjId;
    public static volatile SingularAttribute<Mark, Double> assessment1;
    public static volatile SingularAttribute<Mark, Student> studId;
    public static volatile SingularAttribute<Mark, String> sid;

}