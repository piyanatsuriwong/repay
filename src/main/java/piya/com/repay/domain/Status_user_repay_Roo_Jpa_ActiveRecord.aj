// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package piya.com.repay.domain;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import piya.com.repay.domain.Status_user_repay;

privileged aspect Status_user_repay_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Status_user_repay.entityManager;
    
    public static final EntityManager Status_user_repay.entityManager() {
        EntityManager em = new Status_user_repay().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Status_user_repay.countStatus_user_repays() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Status_user_repay o", Long.class).getSingleResult();
    }
    
    public static List<Status_user_repay> Status_user_repay.findAllStatus_user_repays() {
        return entityManager().createQuery("SELECT o FROM Status_user_repay o", Status_user_repay.class).getResultList();
    }
    
    public static Status_user_repay Status_user_repay.findStatus_user_repay(Long id) {
        if (id == null) return null;
        return entityManager().find(Status_user_repay.class, id);
    }
    
    public static List<Status_user_repay> Status_user_repay.findStatus_user_repayEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Status_user_repay o", Status_user_repay.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Status_user_repay.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Status_user_repay.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Status_user_repay attached = Status_user_repay.findStatus_user_repay(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Status_user_repay.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Status_user_repay.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Status_user_repay Status_user_repay.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Status_user_repay merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
