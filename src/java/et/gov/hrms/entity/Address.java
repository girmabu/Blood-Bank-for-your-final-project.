
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
 * @author user
 */
@Entity
@Table(name = "ADDRESS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a ORDER BY a.addressName ASC"),
    @NamedQuery(name = "Address.findByAddressId", query = "SELECT a FROM Address a WHERE a.addressId = :addressId"),
    @NamedQuery(name = "Address.findByAddressName", query = "SELECT a FROM Address a WHERE a.addressName = :addressName"),
    @NamedQuery(name = "Address.findByAddressNameLike", query = "SELECT a FROM Address a WHERE a.addressName LIKE :addressName"),
    @NamedQuery(name = "Address.findByAddressDescription", query = "SELECT a FROM Address a WHERE a.addressDescription = :addressDescription"),
    @NamedQuery(name = "Address.findByAddressType", query = "SELECT a FROM Address a WHERE a.addressType = :addressType"),
    @NamedQuery(name = "Address.findAllCountryFromDescription", query = "SELECT a FROM Address a WHERE a.addressType = 'Country'"),
    @NamedQuery(name = "Address.findByParentId", query = "SELECT a FROM Address a WHERE a.parentId = :parentId")})
public class Address implements Serializable {
    @OneToMany(mappedBy = "center")
    private List<Donorappoint> donorappointList;
    @Column(name = "PARENT_ID")
    private Long parentId;
    
   

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQ")
    @SequenceGenerator(name = "ADDRESS_SEQ", sequenceName = "ADDRESS_SEQ", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADDRESS_ID")
    private Integer addressId;
    @Size(max = 100)
    @Column(name = "ADDRESS_NAME")
    private String addressName;
    @Size(max = 200)
    @Column(name = "ADDRESS_DESCRIPTION")
    private String addressDescription;
    @Size(max = 20)
    @Column(name = "ADDRESS_TYPE")
    private String addressType;
    @Column(name = "STATUS")
    private BigInteger status;
    @OneToMany(mappedBy = "addressId", cascade = CascadeType.ALL)
    private List<Employees> employeesList;

    public Address() {
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    @XmlTransient
    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "et.gov.hrms.entity.Address[ addressId=" + addressId + " ]";
    }

   

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @XmlTransient
    public List<Donorappoint> getDonorappointList() {
        return donorappointList;
    }

    public void setDonorappointList(List<Donorappoint> donorappointList) {
        this.donorappointList = donorappointList;
    }

 
    
}
