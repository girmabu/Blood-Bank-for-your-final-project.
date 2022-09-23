/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "EMPLOYEES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
    @NamedQuery(name = "Employees.findById", query = "SELECT e FROM Employees e WHERE e.id = :id"),
    @NamedQuery(name = "Employees.findByFirstName", query = "SELECT e FROM Employees e WHERE UPPER(e.firstName) LIKE :firstName"),
    @NamedQuery(name = "Employees.findByFirstNameLike", query = "SELECT e FROM Employees e WHERE e.firstName Like :firstName"),
    @NamedQuery(name = "Employees.findByMiddleName", query = "SELECT e FROM Employees e WHERE e.middleName = :middleName"),
    @NamedQuery(name = "Employees.findByLastName", query = "SELECT e FROM Employees e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Employees.findByAge", query = "SELECT e FROM Employees e WHERE e.age = :age"),

    @NamedQuery(name = "Employees.findBySex", query = "SELECT e FROM Employees e WHERE e.sex = :sex")})
public class Employees implements Serializable {

    @OneToMany(mappedBy = "empId")
    private List<Subject> subjectList;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEMO_EMPLOYEES_SEQ")
    @SequenceGenerator(name = "DEMO_EMPLOYEES_SEQ", sequenceName = "DEMO_EMPLOYEES_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 20)
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Size(max = 20)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Size(max = 20)
    @Column(name = "AGE")
    private String age;
    @Size(max = 20)
    @Column(name = "SEX")
    private String sex;
    @Size(max = 20)
    @Column(name = "BIRTH_DATE")
    private String birth_date;
    @Lob
    @Column(name = "PROFILE")
    private byte[] profile;
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    @ManyToOne
    private Address addressId;
    @OneToMany(mappedBy = "empId", cascade = CascadeType.ALL)
    private List<EmpFamilies> empFamiliesList;

    public Employees() {
    }

    public Employees(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public byte[] getProfile() {
        return profile;
    }

    public void setProfile(byte[] profile) {
        this.profile = profile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "et.gov.hrms.entity.Employees[ id=" + id + " ]";
    }

    @XmlTransient
    public List<EmpFamilies> getEmpFamiliesList() {
        return empFamiliesList;
    }

    public void setEmpFamiliesList(List<EmpFamilies> empFamiliesList) {
        this.empFamiliesList = empFamiliesList;
    }

    public void addToEmpFamliles(EmpFamilies empFamilies) {
        System.out.println("-- add details--" + empFamilies.getEmpId());
        if (empFamilies.getEmpId() != this) {
            this.getEmpFamiliesList().add(empFamilies);
            System.out.println("--add rsult---" + empFamilies.getEmpId());
            empFamilies.setEmpId(this);
        }
    }

    @XmlTransient
    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

}
