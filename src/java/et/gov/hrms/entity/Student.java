/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ob
 */
@Entity
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id"),
    
    @NamedQuery(name = "Student.findBySname", query = "SELECT s FROM Student s WHERE UPPER(s.sname) LIKE :sname"),
    @NamedQuery(name = "Student.findBySnameLike", query = "SELECT s FROM Student s WHERE s.sname Like :sname"),
    
    @NamedQuery(name = "Student.findBySlname", query = "SELECT s FROM Student s WHERE s.slname = :slname"),
    @NamedQuery(name = "Student.findBySphone", query = "SELECT s FROM Student s WHERE s.sphone = :sphone"),
    @NamedQuery(name = "Student.findBySemail", query = "SELECT s FROM Student s WHERE s.semail = :semail"),
    @NamedQuery(name = "Student.findBySsection", query = "SELECT s FROM Student s WHERE s.ssection = :ssection"),
    @NamedQuery(name = "Student.findBySaddress", query = "SELECT s FROM Student s WHERE s.saddress = :saddress"),
    @NamedQuery(name = "Student.findBySsex", query = "SELECT s FROM Student s WHERE s.ssex = :ssex"),
    @NamedQuery(name = "Student.findBySid", query = "SELECT s FROM Student s WHERE s.sid = :sid"),
    @NamedQuery(name = "Student.findByBirthdate", query = "SELECT s FROM Student s WHERE s.birthdate = :birthdate")})
public class Student implements Serializable {
    @OneToMany(mappedBy = "studId")
    private List<Mark> markList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_SEQ")
    @SequenceGenerator(name = "STUDENT_SEQ", sequenceName = "STUDENT_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "SNAME")
    private String sname;

    @Size(max = 255)
    @Column(name = "SLNAME")
    private String slname;

    @Size(max = 20)
    @Column(name = "SSEX")
    private String ssex;

    @Size(max = 20)
    @Column(name = "SPHONE")
    private String sphone;

    @Size(max = 20)
    @Column(name = "SEMAIL")
    private String semail;

    @Size(max = 20)
    @Column(name = "SSECTION")
    private String ssection;

    @Size(max = 255)
    @Column(name = "SADDRESS")
    private String saddress;

    @Size(max = 20)
    @Column(name = "BIRTHDATE")
    private String birthdate;

    @Size(max = 20)
    @Column(name = "SID")
    private String sid;

    @OneToMany(mappedBy = "studId", cascade = CascadeType.ALL)
    private List<StudAddress> studAddressList = new ArrayList<>();

    public Student() {
    }


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSlname() {
        return slname;
    }

    public void setSlname(String slname) {
        this.slname = slname;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getSsection() {
        return ssection;
    }

    public void setSsection(String ssection) {
        this.ssection = ssection;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @XmlTransient
    public List<StudAddress> getStudAddressList() {
        return studAddressList;
    }

    public void setStudAddressList(List<StudAddress> studAddressList) {
        this.studAddressList = studAddressList;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "et.gov.hrms.entity.Student[ id=" + id + " ]";
    }
    @XmlTransient
    public List<Mark> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Mark> markList) {
        this.markList = markList;
    }

   


  
}
