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
 * @author Ob
 */
@Entity
@Table(name = "STUD_ADDRESS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudAddress.findAll", query = "SELECT s FROM StudAddress s"),
    @NamedQuery(name = "StudAddress.findById", query = "SELECT s FROM StudAddress s WHERE s.id = :id"),
    @NamedQuery(name = "StudAddress.findByPhoneNumber", query = "SELECT s FROM StudAddress s WHERE s.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "StudAddress.findByHouseNumber", query = "SELECT s FROM StudAddress s WHERE s.houseNumber = :houseNumber")})
public class StudAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUD_ADDRESS_SEQ")
    @SequenceGenerator(name = "STUD_ADDRESS_SEQ", sequenceName = "STUD_ADDRESS_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;
    @Size(max = 255)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @JoinColumn(name = "STUD_ID", referencedColumnName = "ID")
    @ManyToOne
    private Student studId;

    public StudAddress() {
    }

    public StudAddress(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Student getStudId() {
        return studId;
    }

    public void setStudId(Student studId) {
        this.studId = studId;
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
        if (!(object instanceof StudAddress)) {
            return false;
        }
        StudAddress other = (StudAddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id.toString();
    }

}
