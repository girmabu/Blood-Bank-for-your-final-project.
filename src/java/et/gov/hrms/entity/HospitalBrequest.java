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

@Entity
@Table(name = "HOSPITAL_BREQUEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HospitalBrequest.findAll", query = "SELECT h FROM HospitalBrequest h"),
    @NamedQuery(name = "HospitalBrequest.findById", query = "SELECT h FROM HospitalBrequest h WHERE h.id = :id"),
    @NamedQuery(name = "HospitalBrequest.findByHospitalId", query = "SELECT h FROM HospitalBrequest h WHERE h.hospitalid = :hospitalid"),
    @NamedQuery(name = "HospitalBrequest.findCompreq", query = "SELECT h FROM HospitalBrequest h WHERE  h.status ='Complete'"),
    @NamedQuery(name = "HospitalBrequest.findByHospitalIdLike", query = "SELECT h FROM HospitalBrequest h WHERE h.hospitalid.id Like  :hospitalid"),
    @NamedQuery(name = "HospitalBrequest.findByBloodgroup", query = "SELECT h FROM HospitalBrequest h WHERE h.bloodgroupList.id = :bloodgroupList"),
    @NamedQuery(name = "HospitalBrequest.findByStatus", query = "SELECT h FROM HospitalBrequest h WHERE  h.status ='Pending'"),
    @NamedQuery(name = "HospitalBrequest.findByUnits", query = "SELECT h FROM HospitalBrequest h WHERE h.units = :units"),
    @NamedQuery(name = "HospitalBrequest.findByEmpId", query = "SELECT h FROM HospitalBrequest h WHERE h.empId.id = :empId"),
    @NamedQuery(name = "HospitalBrequest.findByRequestDate", query = "SELECT h FROM HospitalBrequest h WHERE h.requestDate = :requestDate")})
public class HospitalBrequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOSPITAL_BREQUEST_SEQ")
    @SequenceGenerator(name = "HOSPITAL_BREQUEST_SEQ", sequenceName = "HOSPITAL_BREQUEST_SEQ", allocationSize = 1)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "UNITS")
    private Integer units;
    @Size(max = 20)
    @Column(name = "REQUEST_DATE")
    private String requestDate;
    @Size(max = 20)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 20)
    @Column(name = "BLOOD_PRODUCT")
    private String blood_Product;
    @Size(max = 20)
    @Column(name = "EXPIRY_DATE")
    private String expiry_Date;
    @Size(max = 20)
    @Column(name = "CROSS_MATCHED")
    private String cross_matched;
    @Size(max = 20)
    @Column(name = "CROSSMATCHED_DATE")
    private String crossmatched_date;
    @Size(max = 20)
    @Column(name = "UNIT_TRANSFUSED_TO")
    private String unit_transfused_to;
    @Size(max = 20)
    @Column(name = "WARD")
    private String ward;
    @Size(max = 20)
    @Column(name = "MRN")
    private String mrn;
    @Size(max = 20)
    @Column(name = "AGE")
    private String age;
    @Size(max = 20)
    @Column(name = "TIME_START")
    private String time_start;
    @Size(max = 20)
    @Column(name = "SUPPLIED_DATE")
    private String supplied_date;
    @Size(max = 20)
    @Column(name = "SUPPLIED_UNIT")
    private String supplied_unit;
    @Size(max = 20)
    @Column(name = "TIME_END")
    private String Time_End;
    @Size(max = 20)
    @Column(name = "NAME_OF_TRANSFUSING_NURSE")
    private String Transfusing_nurse;
    @Size(max = 20)
    @Column(name = "REACTION_EVENT")
    private String reaction;
    @Size(max = 20)
    @Column(name = "PATIENT_ID")
    private String patient_Id;
    @Size(max = 200)
    @Column(name = "REMARK")
    private String remark;

    @Size(max = 200)
    @Column(name = "SUPPLIED_REMARK")
    private String s_remark;

    @JoinColumn(name = "HOSPITALID", referencedColumnName = "ID")
    @ManyToOne
    private Hospital hospitalid;
    @JoinColumn(name = "BLOODGROUP", referencedColumnName = "ID")
    @ManyToOne
    private Stock bloodgroupList;
    @JoinColumn(name = "EMP_ID", referencedColumnName="ID" )
    @ManyToOne
    private Employees empId;

    //<editor-fold defaultstate="collapsed" desc="Setter and getter">
    public HospitalBrequest() {
    }
    
    public HospitalBrequest(BigDecimal id) {
        this.id = id;
    }
    
    public BigDecimal getId() {
        return id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }
    
    public String getBlood_Product() {
        return blood_Product;
    }
    
    public void setBlood_Product(String blood_Product) {
        this.blood_Product = blood_Product;
    }
    
    public String getExpiry_Date() {
        return expiry_Date;
    }
    
    public void setExpiry_Date(String expiry_Date) {
        this.expiry_Date = expiry_Date;
    }
    
    public String getCross_matched() {
        return cross_matched;
    }
    
    public void setCross_matched(String cross_matched) {
        this.cross_matched = cross_matched;
    }
    
    public String getCrossmatched_date() {
        return crossmatched_date;
    }
    
    public void setCrossmatched_date(String crossmatched_date) {
        this.crossmatched_date = crossmatched_date;
    }
    
    public Employees getEmpId() {
        return empId;
    }
    
    public void setEmpId(Employees empId) {
        this.empId = empId;
    }
    
    public String getUnit_transfused_to() {
        return unit_transfused_to;
    }
    
    public void setUnit_transfused_to(String unit_transfused_to) {
        this.unit_transfused_to = unit_transfused_to;
    }
    
    public String getWard() {
        return ward;
    }
    
    public void setWard(String ward) {
        this.ward = ward;
    }
    
    public String getMrn() {
        return mrn;
    }
    
    public void setMrn(String mrn) {
        this.mrn = mrn;
    }
    
    public String getAge() {
        return age;
    }
    
    public void setAge(String age) {
        this.age = age;
    }
    
    public String getTime_start() {
        return time_start;
    }
    
    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }
    
    public String getTime_End() {
        return Time_End;
    }
    
    public void setTime_End(String Time_End) {
        this.Time_End = Time_End;
    }
    
    public String getTransfusing_nurse() {
        return Transfusing_nurse;
    }
    
    public void setTransfusing_nurse(String Transfusing_nurse) {
        this.Transfusing_nurse = Transfusing_nurse;
    }
    
    public String getReaction() {
        return reaction;
    }
    
    public void setReaction(String reaction) {
        this.reaction = reaction;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getPatient_Id() {
        return patient_Id;
    }
    
    public void setPatient_Id(String patient_Id) {
        this.patient_Id = patient_Id;
    }
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public Stock getBloodgroupList() {
        return bloodgroupList;
    }
    
    public Stock setBloodgroupList(Integer bloodgroupList) {
     
       this.bloodgroupList.setUnits(units);
        return null;
    }
    
    public Integer getUnits() {
        return units;
    }
    
    public void setUnits(Integer units) {
        this.units = units;
    }
    
    public String getRequestDate() {
        return requestDate;
    }
    
    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }
    
    public Hospital getHospitalid() {
        return hospitalid;
    }
    
    public void setHospitalid(Hospital hospitalid) {
        this.hospitalid = hospitalid;
    }
    
    public String getSupplied_date() {
        return supplied_date;
    }
    
    public void setSupplied_date(String supplied_date) {
        this.supplied_date = supplied_date;
    }
    
    public String getSupplied_unit() {
        return supplied_unit;
    }
    
    public void setSupplied_unit(String supplied_unit) {
        this.supplied_unit = supplied_unit;
    }
    
    public String getS_remark() {
        return s_remark;
    }
    
    public void setS_remark(String s_remark) {
        this.s_remark = s_remark;
    }
//</editor-fold>
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HospitalBrequest)) {
            return false;
        }
        HospitalBrequest other = (HospitalBrequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "et.gov.hrms.entity.HospitalBrequest[ id=" + id + " ]";
    }

}
