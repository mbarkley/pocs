package org.jboss.errai.demo.server;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.jboss.errai.demo.client.shared.Employee;
import org.jboss.errai.demo.client.shared.EmployeeEndpoint;

@Stateless
public class EmployeeEndpointImpl implements EmployeeEndpoint {

  @Inject
  private Event<Employee> created;

  @Inject
  private EmployeeService employeeService;

  @Override
  public Employee get(Long id) {
    return employeeService.getById(id);
  }

  @Override
  public List<Employee> listAll() {
    return employeeService.listAll();
  }
  
  @Override
  public Response create(Employee entity) {
    employeeService.create(entity);
    created.fire(entity);
    return Response.created(
            UriBuilder.fromResource(EmployeeEndpoint.class).path(String.valueOf(entity.getId())).build()).build();
  }

  @Override
  public Response update(Long id, Employee entity) {
    employeeService.update(id, entity);
    return Response.noContent().build();
  }

  @Override
  public Response delete(Long id) {
    employeeService.delete(id);
    return Response.noContent().build();
  }
}