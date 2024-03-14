package edu.calpoly.csc366.teamdatabase.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByName(String name);

    Employee findByEmail(String name);
}
