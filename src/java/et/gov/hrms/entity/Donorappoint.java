/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jk
 */
@Entity
@Table(name = "DONORAPPOINT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donorappoint.findAll", query = "SELECT d FROM Donorappoint d"),
    @NamedQuery(name = "Donorappoint.findById", query = "SELECT d FROM Donorappoint d WHERE d.id = :id"),
    @NamedQuery(name = "Donorappoint.findByAppointDate", query = "SELECT d FROM Donorappoint d WHERE d.appointDate = :appointDate"),
    @NamedQuery(name = "Donorappoint.findByRemark", query = "SELECT d FROM Donorappoint d WHERE d.remark = :remark")})
public class Donorappoint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DONORACCOUNT_SEQ")
    @SequenceGenerator(name = "DONORACCOUNT_SEQ", sequenceName = "DONORACCOUNT_SEQ", allocationSize = 1)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 20)
    @Column(name = "APPOINT_DATE")
    private String appointDate;
    @Size(max = 200)
    @Column(name = "REMARK")
    private String remark;
    @JoinColumn(name = "CENTER", referencedColumnName = "ADDRESS_ID")
    @ManyToOne
    private Address center;
    @JoinColumn(name = "DONOR_ID", referencedColumnName = "ID")
    @ManyToOne
    private Donor donorId;
    @JoinColumn(name = "BLOODGROUP", referencedColumnName = "ID")
    @ManyToOne
    private Stock bloodgroup;

    public Donorappoint() {
    }

    public Donorappoint(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(String appointDate) {
        this.appointDate = appointDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Address getCenter() {
        return center;
    }

    public void setCenter(Address center) {
        this.center = center;
    }

    public Donor getDonorId() {
        return donorId;
    }

    public void setDonorId(Donor donorId) {
        this.donorId = donorId;
    }

    public Stock getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(Stock bloodgroup) {
        this.bloodgroup = bloodgroup;
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
        if (!(object instanceof Donorappoint)) {
            return false;
        }
        Donorappoint other = (Donorappoint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "et.gov.hrms.entity.Donorappoint[ id=" + id + " ]";
    }

}
