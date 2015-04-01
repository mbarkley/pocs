package org.jboss.errai.demo.server;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.errai.demo.client.shared.Employee;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class EmployeeService {

  @PersistenceContext(unitName = "forge-default")
  private EntityManager em;

  public Employee getById(Long id) {
    return em.find(Employee.class, id);
  }

  @SuppressWarnings("unchecked")
  public List<Employee> listAll() {
    return em.createNamedQuery("allEmployees").getResultList();
  }
  
  public void create(Employee entity) {
    em.persist(entity);
  }

  public void update(Long id, Employee entity) {
    entity.setId(id);
    entity = em.merge(entity);
  }

  public void delete(Long id) {
    Employee uc = em.find(Employee.class, id);
    em.remove(uc);
  }
  
}