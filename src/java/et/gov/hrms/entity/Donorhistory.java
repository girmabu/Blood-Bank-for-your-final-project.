/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "DONORHISTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donorhistory.findAll", query = "SELECT d FROM Donorhistory d"),
    @NamedQuery(name = "Donorhistory.findById", query = "SELECT d FROM Donorhistory d WHERE d.id = :id"),
    @NamedQuery(name = "Donorhistory.findByDonationdate", query = "SELECT d FROM Donorhistory d WHERE d.donationdate = :donationdate"),
    @NamedQuery(name = "Donorhistory.findByPackNo", query = "SELECT d FROM Donorhistory d WHERE d.packNo = :packNo"),
    @NamedQuery(name = "Donorhistory.findByWt", query = "SELECT d FROM Donorhistory d WHERE d.wt = :wt"),
    @NamedQuery(name = "Donorhistory.findByBp", query = "SELECT d FROM Donorhistory d WHERE d.bp = :bp"),
    @NamedQuery(name = "Donorhistory.findByVol", query = "SELECT d FROM Donorhistory d WHERE d.vol = :vol"),
    @NamedQuery(name = "Donorhistory.findByScreenedBy", query = "SELECT d FROM Donorhistory d WHERE d.screenedBy = :screenedBy"),
    @NamedQuery(name = "Donorhistory.findByHgb", query = "SELECT d FROM Donorhistory d WHERE d.hgb = :hgb"),
    @NamedQuery(name = "Donorhistory.findByCheckedBy", query = "SELECT d FROM Donorhistory d WHERE d.checkedBy = :checkedBy"),
    @NamedQuery(name = "Donorhistory.findByDonationType", query = "SELECT d FROM Donorhistory d WHERE d.donationType = :donationType"),
    @NamedQuery(name = "Donorhistory.findByBleedTime", query = "SELECT d FROM Donorhistory d WHERE d.bleedTime = :bleedTime"),
    @NamedQuery(name = "Donorhistory.findByAboRh", query = "SELECT d FROM Donorhistory d WHERE d.aboRh = :aboRh"),
    @NamedQuery(name = "Donorhistory.findByRemark", query = "SELECT d FROM Donorhistory d WHERE d.remark = :remark"),
    @NamedQuery(name = "Donorhistory.findByDonorId", query = "SELECT d FROM Donorhistory d WHERE d.donorId = :donorId")})
public class Donorhistory implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DONOR_HISTORY")
    @SequenceGenerator(name = "DONOR_HISTORY", sequenceName = "DONOR_HISTORY", allocationSize = 1)
    
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 20)
    @Column(name = "DONATIONDATE")
    private String donationdate;
    @Column(name = "PACK_NO")
    private BigInteger packNo;
    @Size(max = 20)
    @Column(name = "WT")
    private String wt;
    @Size(max = 20)
    @Column(name = "BP")
    private String bp;
    @Size(max = 20)
    @Column(name = "VOL")
    private String vol;
    @Size(max = 20)
    @Column(name = "SCREENED_BY")
    private String screenedBy;
    @Size(max = 20)
    @Column(name = "HGB")
    private String hgb;
    @Size(max = 20)
    @Column(name = "CHECKED_BY")
    private String checkedBy;
    @Size(max = 20)
    @Column(name = "DONATION_TYPE")
    private String donationType;
    @Size(max = 20)
    @Column(name = "BLEED_TIME")
    private String bleedTime;
    @Size(max = 20)
    @Column(name = "ABO$RH")
    private String aboRh;
    @Size(max = 20)
    @Column(name = "REMARK")
    private String remark;
    @JoinColumn(name = "DONOR_ID", referencedColumnName = "ID")
    @ManyToOne
    private Donor donorId;
    @JoinColumn(name = "EMP_ID", referencedColumnName = "ID")
    @ManyToOne
    private Employees empId;
    public Donorhistory() {
    }

    public Donorhistory(BigDecimal id) {
        this.id = id;
    }

    public Donor getDonorId() {
        return donorId;
    }

    public void setDonorId(Donor donorId) {
        this.donorId = donorId;
    }

    public Employees getEmpId() {
        return empId;
    }

    public void setEmpId(Employees empId) {
        this.empId = empId;
    }

  
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDonationdate() {
        return donationdate;
    }

    public void setDonationdate(String donationdate) {
        this.donationdate = donationdate;
    }

    public BigInteger getPackNo() {
        return packNo;
    }

    public void setPackNo(BigInteger packNo) {
        this.packNo = packNo;
    }

    public String getWt() {
        return wt;
    }

    public void setWt(String wt) {
        this.wt = wt;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public String getScreenedBy() {
        return screenedBy;
    }

    public void setScreenedBy(String screenedBy) {
        this.screenedBy = screenedBy;
    }

    public String getHgb() {
        return hgb;
    }

    public void setHgb(String hgb) {
        this.hgb = hgb;
    }

    public String getCheckedBy() {
        return checkedBy;
    }

    public void setCheckedBy(String checkedBy) {
        this.checkedBy = checkedBy;
    }

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public String getBleedTime() {
        return bleedTime;
    }

    public void setBleedTime(String bleedTime) {
        this.bleedTime = bleedTime;
    }

    public String getAboRh() {
        return aboRh;
    }

    public void setAboRh(String aboRh) {
        this.aboRh = aboRh;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        if (!(object instanceof Donorhistory)) {
            return false;
        }
        Donorhistory other = (Donorhistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "et.gov.hrms.entity.Donorhistory[ id=" + id + " ]";
    }
    
}
