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
 * @author jk
 */
@Entity
@Table(name = "MARK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mark.findAll", query = "SELECT m FROM Mark m"),
    @NamedQuery(name = "Mark.findByStudId", query = "SELECT m FROM Mark m WHERE m.studId = :studId"),
    @NamedQuery(name = "Mark.findBySid", query = "SELECT m FROM Mark m WHERE UPPER(m.sid) LIKE :sid"),
    @NamedQuery(name = "Mark.findBySidLike", query = "SELECT m FROM Mark m WHERE m.sid Like :sid"),
    @NamedQuery(name = "Mark.findByMarkId", query = "SELECT m FROM Mark m WHERE m.markId = :markId")})
public class Mark implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUIZ")
    private Double quiz;
    @Column(name = "MID")
    private Double mid;
    @Column(name = "ASSESSMENT1")
    private Double assessment1;
    @Column(name = "ASSESSMENT2")
    private Double assessment2;
    @Column(name = "FINAL")
    private Double final1;
    @Column(name = "TOTAL")
    private Double total;
    
    @Size(max = 300)
    @Column(name = "SID")
    private String sid;
    
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MARK_SEQ")
    @SequenceGenerator(name = "MARK_SEQ", sequenceName = "MARK_SEQ", allocationSize = 1)
    @Column(name = "MARK_ID")
    private Integer markId;
    @JoinColumn(name = "STUD_ID", referencedColumnName = "ID")
    @ManyToOne
    private Student studId;
    @JoinColumn(name = "SUBJ_ID", referencedColumnName = "SUBJ_ID")
    @ManyToOne
    private Subject subjId;

    public Mark() {
    }

    public Mark(Integer markId) {
        this.markId = markId;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

   

    public Integer getMarkId() {
        return markId;
    }

    public void setMarkId(Integer markId) {
        this.markId = markId;
    }


    public Student getStudId() {
        return studId;
    }

    public void setStudId(Student studId) {
        this.studId = studId;
    }

    public Subject getSubjId() {
        return subjId;
    }

    public void setSubjId(Subject subjId) {
        this.subjId = subjId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (markId != null ? markId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mark)) {
            return false;
        }
        Mark other = (Mark) object;
        if ((this.markId == null && other.markId != null) || (this.markId != null && !this.markId.equals(other.markId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "et.gov.hrms.entity.Mark[ markId=" + markId + " ]";
    }

    public Double getQuiz() {
        return quiz;
    }

    public void setQuiz(Double quiz) {
        this.quiz = quiz;
    }

    public Double getMid() {
        return mid;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }

    public Double getAssessment1() {
        return assessment1;
    }

    public void setAssessment1(Double assessment1) {
        this.assessment1 = assessment1;
    }

    public Double getAssessment2() {
        return assessment2;
    }

    public void setAssessment2(Double assessment2) {
        this.assessment2 = assessment2;
    }

    public Double getFinal1() {
        return final1;
    }

    public void setFinal1(Double final1) {
        this.final1 = final1;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
}
