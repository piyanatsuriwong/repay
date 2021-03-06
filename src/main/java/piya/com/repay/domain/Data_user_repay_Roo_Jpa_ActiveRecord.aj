// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package piya.com.repay.domain;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import piya.com.repay.domain.Data_user_repay;

privileged aspect Data_user_repay_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Data_user_repay.entityManager;
    
    public static final EntityManager Data_user_repay.entityManager() {
        EntityManager em = new Data_user_repay().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Data_user_repay.countData_user_repays() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Data_user_repay o", Long.class).getSingleResult();
    }
    
    public static List<Data_user_repay> Data_user_repay.findAllData_user_repays() {
        return entityManager().createQuery("SELECT o FROM Data_user_repay o", Data_user_repay.class).getResultList();
    }
    
    public static Data_user_repay Data_user_repay.findData_user_repay(Long id) {
        if (id == null) return null;
        return entityManager().find(Data_user_repay.class, id);
    }
    
    public static List<Data_user_repay> Data_user_repay.findData_user_repayEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Data_user_repay o", Data_user_repay.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Data_user_repay.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Data_user_repay.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Data_user_repay attached = Data_user_repay.findData_user_repay(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Data_user_repay.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Data_user_repay.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Data_user_repay Data_user_repay.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Data_user_repay merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
