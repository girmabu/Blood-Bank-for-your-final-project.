/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package et.gov.hrms.mapper.Role;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jk
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
         clearCach();
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
         clearCach();
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
        public T saveOrUpdate(@NotNull T entity) {
        for (Field field : entity.getClass().getDeclaredFields()) {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if (annotation instanceof Id) {
                    try {
                        Id id = Id.class.cast(annotation);
                        field.setAccessible(true); // so we can access the private fields for bean type
                        if (isContainingValue(field.get(entity))) {
                            edit(entity);
                            getEntityManager().getEntityManagerFactory().getCache().evictAll();
                            return entity;
                        } else {
                            //TODO  if  any
                            // so we can access the private fields for bean type
                            create(entity);
                            getEntityManager().getEntityManagerFactory().getCache().evictAll();
                            return entity;
                        }
                    } catch (IllegalArgumentException | IllegalAccessException ex) {
                        Logger.getLogger(entityClass.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        clearCach();
        return entity;
    }
        public void clearCach() {
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
    }
         private boolean isContainingValue(Object value) {
        boolean containsValue = false;
        if (value != null) {
            if (value instanceof String) {
                containsValue = !String.class.cast(value).trim().isEmpty();
            } else if ((value instanceof Integer)) {
                containsValue = !Integer.class.cast(value).equals(0);
            } else {
                containsValue = true;
            }
        }
        return containsValue;
    }
    
}
