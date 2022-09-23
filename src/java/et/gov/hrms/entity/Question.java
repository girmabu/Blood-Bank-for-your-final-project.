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
import javax.persistence.Id;
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
@Table(name = "QUESTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findById", query = "SELECT q FROM Question q WHERE q.id = :id"),
    @NamedQuery(name = "Question.findByQ1", query = "SELECT q FROM Question q WHERE q.q1 = :q1"),
    @NamedQuery(name = "Question.findByQ2", query = "SELECT q FROM Question q WHERE q.q2 = :q2"),
    @NamedQuery(name = "Question.findByQ3", query = "SELECT q FROM Question q WHERE q.q3 = :q3"),
    @NamedQuery(name = "Question.findAllQuestion", query = "SELECT q FROM Question q WHERE q.q1 = :q1 AND q.q2 =:q2 AND q.q3 =:q3 AND q.q4=:q4 AND q.q5=:q5"),
    @NamedQuery(name = "Question.findByQ4", query = "SELECT q FROM Question q WHERE q.q4 = :q4"),
    @NamedQuery(name = "Question.findByQ5", query = "SELECT q FROM Question q WHERE q.q5 = :q5")})
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 20)
    @Column(name = "Q1")
    private String q1;
    @Size(max = 20)
    @Column(name = "Q2")
    private String q2;
    @Size(max = 20)
    @Column(name = "Q3")
    private String q3;
    @Size(max = 20)
    @Column(name = "Q4")
    private String q4;
    @Size(max = 20)
    @Column(name = "Q5")
    private String q5;

    public Question() {
    }

    public Question(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String getQ4() {
        return q4;
    }

    public void setQ4(String q4) {
        this.q4 = q4;
    }

    public String getQ5() {
        return q5;
    }

    public void setQ5(String q5) {
        this.q5 = q5;
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
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "et.gov.hrms.entity.Question[ id=" + id + " ]";
    }
    
}
