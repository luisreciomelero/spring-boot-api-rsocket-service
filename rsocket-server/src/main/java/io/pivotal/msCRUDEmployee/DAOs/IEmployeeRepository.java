package io.pivotal.msCRUDEmployee.DAOs;

import org.springframework.data.jpa.repository.JpaRepository;

import io.pivotal.msCRUDEmployee.models.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {


}
