// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package piya.com.repay.domain;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import piya.com.repay.domain.Backlog_repay;

privileged aspect Backlog_repay_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Backlog_repay.entityManager;
    
    public static final EntityManager Backlog_repay.entityManager() {
        EntityManager em = new Backlog_repay().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Backlog_repay.countBacklog_repays() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Backlog_repay o", Long.class).getSingleResult();
    }
    
    public static List<Backlog_repay> Backlog_repay.findAllBacklog_repays() {
        return entityManager().createQuery("SELECT o FROM Backlog_repay o", Backlog_repay.class).getResultList();
    }
    
    public static Backlog_repay Backlog_repay.findBacklog_repay(Long id) {
        if (id == null) return null;
        return entityManager().find(Backlog_repay.class, id);
    }
    
    public static List<Backlog_repay> Backlog_repay.findBacklog_repayEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Backlog_repay o", Backlog_repay.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Backlog_repay.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Backlog_repay.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Backlog_repay attached = Backlog_repay.findBacklog_repay(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Backlog_repay.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Backlog_repay.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Backlog_repay Backlog_repay.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Backlog_repay merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
