/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author glory
 */
@Entity
@Table(name = "EMP_FAMILIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpFamilies.findAll", query = "SELECT e FROM EmpFamilies e"),
    @NamedQuery(name = "EmpFamilies.findById", query = "SELECT e FROM EmpFamilies e WHERE e.id = :id"),
    @NamedQuery(name = "EmpFamilies.findByEmpId", query = "SELECT e FROM EmpFamilies e WHERE e.empId = :empId"),
    @NamedQuery(name = "EmpFamilies.findByEmpIdLike", query = "SELECT e FROM EmpFamilies e WHERE e.empId.id Like :empId"),
    @NamedQuery(name = "EmpFamilies.findByRelationshipType", query = "SELECT e FROM EmpFamilies e WHERE e.relationshipType = :relationshipType"),
    @NamedQuery(name = "EmpFamilies.findByFirstName", query = "SELECT e FROM EmpFamilies e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "EmpFamilies.findByLastName", query = "SELECT e FROM EmpFamilies e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "EmpFamilies.findByEmergencyContact", query = "SELECT e FROM EmpFamilies e WHERE e.emergencyContact = :emergencyContact"),
    @NamedQuery(name = "EmpFamilies.findBySex", query = "SELECT e FROM EmpFamilies e WHERE e.sex = :sex")})
public class EmpFamilies implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPFAMILIES_SEQ")
    @SequenceGenerator(name = "EMPFAMILIES_SEQ", sequenceName = "EMPFAMILIES_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "RELATIONSHIP_TYPE")
    private String relationshipType;
    @Size(max = 20)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 20)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 20)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Size(max = 20)
    @Column(name = "EMERGENCY_CONTACT")
    private String emergencyContact;
    @Size(max = 20)
    @Column(name = "SEX")
    private String sex;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "ID")
    @ManyToOne
    private Employees empId;

    public EmpFamilies() {
    }

    public EmpFamilies(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Employees getEmpId() {
        return empId;
    }

    public void setEmpId(Employees empId) {
        this.empId = empId;
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
        if (!(object instanceof EmpFamilies)) {
            return false;
        }
        EmpFamilies other = (EmpFamilies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "et.gov.hrms.entity.EmpFamilies[ id=" + id + " ]";
    }

}
