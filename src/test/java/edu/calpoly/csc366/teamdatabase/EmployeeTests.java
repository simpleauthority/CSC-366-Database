package edu.calpoly.csc366.teamdatabase;

import edu.calpoly.csc366.teamdatabase.employee.Employee;
import edu.calpoly.csc366.teamdatabase.employee.EmployeeRepository;
import edu.calpoly.csc366.teamdatabase.employee.Role;
import edu.calpoly.csc366.teamdatabase.employee.RoleRepository;
import edu.calpoly.csc366.teamdatabase.manager.CustomerFeedback;
import edu.calpoly.csc366.teamdatabase.manager.EmployeeStatus;
import edu.calpoly.csc366.teamdatabase.manager.Inventory;
import edu.calpoly.csc366.teamdatabase.manager.Maintenance;
import edu.calpoly.csc366.teamdatabase.manager.Manager;
import edu.calpoly.csc366.teamdatabase.manager.Regulations;
import edu.calpoly.csc366.teamdatabase.manager.Rent;
import edu.calpoly.csc366.teamdatabase.manager.Store;
import edu.calpoly.csc366.teamdatabase.manager.StoreRegulation;
import edu.calpoly.csc366.teamdatabase.supplier.SuppliedProduct;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// Demo0: Add, list, and remove Person & Address instances

@ExtendWith(SpringExtension.class)
@DataJpaTest
//@TestPropertySource(properties = {
//        "spring.main.banner-mode=off",
//        "logging.level.root=ERROR",
//        "logging.level.csc366=DEBUG",
//
//        "logging.level.org.hibernate.SQL=DEBUG",
//        "logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE", // display prepared statement parameters
//        "spring.jpa.properties.hibernate.format_sql=true",
//        "spring.jpa.show-sql=false",   // prevent duplicate logging
//        "spring.jpa.properties.hibernate.show_sql=false",
//
//        "logging.pattern.console= %d{yyyy-MM-dd HH:mm:ss} - %msg%n"
//})
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeTests {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;

    @BeforeEach
    public void setup() {
        roleRepository.saveAllAndFlush(List.of(new Role("barista"), new Role("cashier"), new Role("store manager"), new Role("executive")));
        employeeRepository.saveAllAndFlush(List.of(
                new Employee("Eva Johnson", "5552468135", "eva.johnson@example.org", Date.from(Instant.parse("1980-03-03T00:00:00.00Z")), roleRepository.findByName("store manager")),
                new Employee("Alice Wonderland", "5551234567", "alice.wonderland@example.com", Date.from(Instant.parse("1990-07-12T00:00:00.00Z")), roleRepository.findByName("executive")),
                new Employee("Mark Lawrence", "5558393894", "mark.lawrence@example.org", Date.from(Instant.parse("1999-05-29T00:00:00.00Z")), roleRepository.findByName("barista")),
                new Employee("Bob Smith", "5559876543", "bob.smith@example.net", Date.from(Instant.parse("1985-11-05T00:00:00.00Z")), roleRepository.findByName("cashier"))
        ));
    }

    @Test
    @Order(1)
    public void testEmployeeAndAttributes() {
        Employee emp = employeeRepository.findByName("Eva Johnson");
        assertNotNull(emp);
        assertEquals(emp.getPhone(), "5552468135");
        assertEquals(emp.getEmail(), "eva.johnson@example.org");
        assertEquals(emp.getDateOfBirth(), Date.from(Instant.parse("1980-03-03T00:00:00.00Z")));
        assertEquals(emp.getRole().getName(), "store manager");
    }
}