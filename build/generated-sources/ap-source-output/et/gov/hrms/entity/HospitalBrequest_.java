package et.gov.hrms.entity;

import et.gov.hrms.entity.Hospital;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-09-08T13:54:54")
@StaticMetamodel(HospitalBrequest.class)
public class HospitalBrequest_ { 

    public static volatile SingularAttribute<HospitalBrequest, String> bloodgroup;
    public static volatile SingularAttribute<HospitalBrequest, Hospital> hospitalid;
    public static volatile SingularAttribute<HospitalBrequest, String> requestDate;
    public static volatile SingularAttribute<HospitalBrequest, BigDecimal> id;
    public static volatile SingularAttribute<HospitalBrequest, BigInteger> units;
    public static volatile SingularAttribute<HospitalBrequest, String> status;

}