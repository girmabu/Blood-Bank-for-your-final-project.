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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "DONOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donor.findAll", query = "SELECT d FROM Donor d"),
    @NamedQuery(name = "Donor.findById", query = "SELECT d FROM Donor d WHERE d.id = :id"),
    @NamedQuery(name = "Donor.findByName", query = "SELECT d FROM Donor d WHERE UPPER(d.name) LIKE  :name"),
    @NamedQuery(name = "Donor.findByNameLike", query = "SELECT d FROM Donor d WHERE d.name Like  :name"),
    @NamedQuery(name = "Donor.findByLname", query = "SELECT d FROM Donor d WHERE d.lname = :lname"),
    @NamedQuery(name = "Donor.findByDob", query = "SELECT d FROM Donor d WHERE d.dob = :dob"),
    @NamedQuery(name = "Donor.findByAge", query = "SELECT d FROM Donor d WHERE d.age = :age"),
    @NamedQuery(name = "Donor.findByOccupation", query = "SELECT d FROM Donor d WHERE d.occupation = :occupation"),
    @NamedQuery(name = "Donor.findByPhonenumber", query = "SELECT d FROM Donor d WHERE d.phonenumber = :phonenumber"),
    @NamedQuery(name = "Donor.findBySex", query = "SELECT d FROM Donor d WHERE d.sex = :sex"),})
public class Donor implements Serializable {

    @OneToMany(mappedBy = "donorId")
    private List<Donorhistory> donorHistoryList;
    @OneToMany(mappedBy = "donorId", cascade = CascadeType.ALL)
    private List<Discard> discardList;
    @OneToMany(mappedBy = "donorId", cascade = CascadeType.ALL)
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DONOR_SEQ")
    @SequenceGenerator(name = "DONOR_SEQ", sequenceName = "DONOR_SEQ", allocationSize = 1)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 30)
    @Column(name = "NAME")
    private String name;
    @Size(max = 30)
    @Column(name = "LNAME")
    private String lname;
    @Size(max = 20)
    @Column(name = "SURNAME")
    private String surname;
    @Size(max = 20)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 50)
    @Column(name = "CITY")
    private String city;
    @Size(max = 50)
    @Column(name = "REGION")
    private String region;
    @Size(max = 50)
    @Column(name = "ZONE")
    private String zone;
    @Size(max = 50)
    @Column(name = "WOREDA")
    private String woreda;
    @Lob
    @Column(name = "PROFILE")
    private byte[] profile;
    @Size(max = 20)
    @Column(name = "DOB")
    private String dob;
    @Size(max = 12)
    @Column(name = "AGE")
    private String age;

    @Size(max = 50)
    @Column(name = "OCCUPATION")
    private String occupation;
    @Size(max = 20)
    @Column(name = "PHONENUMBER")
    private String phonenumber;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 7)
    @Column(name = "SEX")
    private String sex;

    public Donor() {
    }

    public Donor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getWoreda() {
        return woreda;
    }

    public void setWoreda(String woreda) {
        this.woreda = woreda;
    }

    public byte[] getProfile() {
        return profile;
    }

    public void setProfile(byte[] profile) {
        this.profile = profile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
        if (!(object instanceof Donor)) {
            return false;
        }
        Donor other = (Donor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "et.gov.hrms.entity.Donor[ id=" + id + " ]";
    }

    @XmlTransient

    public List<Donorhistory> getDonorHistoryList() {
        if (donorHistoryList == null) {
            donorHistoryList = new ArrayList<>();
        }
        return donorHistoryList;
    }

 

    public void setDonorHistoryList(List<Donorhistory> donorHistoryList) {
        this.donorHistoryList = donorHistoryList;
    }

    public void addRequestList(Donorhistory donorHistory) {
        System.out.println("inside add Entity class");
        if (donorHistory.getDonorId() == this) {
            System.out.println("inside if");
            this.getDonorHistoryList().add(donorHistory);
            System.out.println("getDonorappointList()==size==" + getDonorHistoryList().size());
            donorHistory.setDonorId(this);
        }
    }
       public List<Discard> getDiscardList() {
           if(discardList==null)
           {
               discardList= new ArrayList<>();
           }
        return discardList;
    }

    public void setDiscardList(List<Discard> discardList) {
        this.discardList = discardList;
    }
     public void addDiscard(Discard discard) {
        System.out.println("inside add Entity class");
        if (discard.getDonorId()== this) {
            System.out.println("inside if");
            this.getDiscardList().add(discard);
            System.out.println("getDonorappointList()==size==" + getDiscardList().size());
            discard.setDonorId(this);
        }
    }

}
