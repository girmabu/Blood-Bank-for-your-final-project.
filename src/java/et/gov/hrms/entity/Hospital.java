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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author jk
 */
@Entity
@Table(name = "HOSPITAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospital.findAll", query = "SELECT h FROM Hospital h"),
    @NamedQuery(name = "Hospital.findById", query = "SELECT h FROM Hospital h WHERE h.id = :id"),
    @NamedQuery(name = "Hospital.findByName", query = "SELECT h FROM Hospital h WHERE h.name = :name"),
    @NamedQuery(name = "Hospital.findByEmail", query = "SELECT h FROM Hospital h WHERE h.email = :email"),
    @NamedQuery(name = "Hospital.findByPhone", query = "SELECT h FROM Hospital h WHERE h.phone = :phone"),

    @NamedQuery(name = "Hospital.findByHospitalId", query = "SELECT h FROM Hospital h WHERE h.phone = :phone"),

    @NamedQuery(name = "Hospital.findByType", query = "SELECT h FROM Hospital h WHERE h.type = :type")})
public class Hospital implements Serializable {

    @OneToMany(mappedBy = "hospitalid", cascade = CascadeType.ALL)
    private List<HospitalBrequest> hospitalBrequestList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOSPITAL_SEQ")
    @SequenceGenerator(name = "HOSPITAL_SEQ", sequenceName = "HOSPITAL_SEQ", allocationSize = 1)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 20)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 20)
    @Column(name = "PHONE")
    private String phone;

    @Size(max = 30)
    @Column(name = "COUNTRY")
    private String country;

    @Size(max = 30)
    @Column(name = "REGION")
    private String region;
    @Size(max = 20)
    @Column(name = "CITY")
    private String city;
    @Size(max = 20)
    @Column(name = "WOREDA")
    private String woreda;
    @Size(max = 30)
    @Column(name = "ZONE")
    private String ZONE;
    @Size(max = 20)
    @Column(name = "TYPE")
    private String type;

    public Hospital() {
    }

    public Hospital(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWoreda() {
        return woreda;
    }

    public void setWoreda(String woreda) {
        this.woreda = woreda;
    }

    public String getZONE() {
        return ZONE;
    }

    public void setZONE(String ZONE) {
        this.ZONE = ZONE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof Hospital)) {
            return false;
        }
        Hospital other = (Hospital) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "et.gov.hrms.entity.Hospital[ id=" + id + " ]";
    }

    @XmlTransient
    public List<HospitalBrequest> getHospitalBrequestList() {
        if (hospitalBrequestList == null) {
            hospitalBrequestList = new ArrayList<>();
        }
        return hospitalBrequestList;
    }

    public void setHospitalBrequestList(List<HospitalBrequest> hospitalBrequestList) {
        this.hospitalBrequestList = hospitalBrequestList;
    }

    public void addRequestList(HospitalBrequest hospital_Brequest) {
        System.out.println("inside add Entity class");
        if (hospital_Brequest.getHospitalid() == this) {
            System.out.println("inside if");
            this.getHospitalBrequestList().add(hospital_Brequest);
            System.out.println("getHospitalBrequestList()==size==" + getHospitalBrequestList().size());
            hospital_Brequest.setHospitalid(this);
        }
    }

}
