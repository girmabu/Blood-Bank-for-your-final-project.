/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.mapper.Question;

import et.gov.hrms.entity.Question;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jk
 */
@Stateless
public class QuestionFacade extends AbstractFacade<Question> {

    @PersistenceContext(unitName = "ERP_DEMO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuestionFacade() {
        super(Question.class);
    }

    public Question checkUser(String q1, String q2, String q3, String q4, String q5) {
        Query query = em.createNamedQuery("Question.findAllQuestion");
        query.setParameter("q1", q1);
        query.setParameter("q2", q2);
        query.setParameter("q3", q3);
        query.setParameter("q4", q4);
        query.setParameter("q5", q5);
        try {
            Question s = (Question) query.getResultList().get(0);
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
