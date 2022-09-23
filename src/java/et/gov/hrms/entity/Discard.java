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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jk
 */
@Entity
@Table(name = "DISCARD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discard.findAll", query = "SELECT d FROM Discard d"),
    @NamedQuery(name = "Discard.findById", query = "SELECT d FROM Discard d WHERE d.id = :id"),
    @NamedQuery(name = "Discard.findByReason", query = "SELECT d FROM Discard d WHERE d.reason = :reason"),
    @NamedQuery(name = "Discard.findByVenue", query = "SELECT d FROM Discard d WHERE d.venue = :venue"),
    @NamedQuery(name = "Discard.findByDiscardDate", query = "SELECT d FROM Discard d WHERE d.discardDate = :discardDate"),
    @NamedQuery(name = "Discard.findByScreenedBy", query = "SELECT d FROM Discard d WHERE d.screenedBy = :screenedBy"),
    @NamedQuery(name = "Discard.findByDonorId", query = "SELECT d FROM Discard d WHERE d.donorId = :donorId")})
public class Discard implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 200)
    @Column(name = "REASON")
    private String reason;
    @Size(max = 200)
    @Column(name = "VENUE")
    private String venue;
    @Size(max = 20)
    @Column(name = "DISCARD_DATE")
    private String discardDate;
    @Size(max = 20)
    @Column(name = "SCREENED_BY")
    private String screenedBy;
    @JoinColumn(name = "DONOR_ID", referencedColumnName = "ID")
    @ManyToOne
    private Donor donorId;

    public Discard() {
    }

    public Discard(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Donor getDonorId() {
        return donorId;
    }

    public void setDonorId(Donor donorId) {
        this.donorId = donorId;
    }

    public String getDiscardDate() {
        return discardDate;
    }

    public void setDiscardDate(String discardDate) {
        this.discardDate = discardDate;
    }

    public String getScreenedBy() {
        return screenedBy;
    }

    public void setScreenedBy(String screenedBy) {
        this.screenedBy = screenedBy;
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
        if (!(object instanceof Discard)) {
            return false;
        }
        Discard other = (Discard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "et.gov.hrms.entity.Discard[ id=" + id + " ]";
    }
    
}
