package edu.calpoly.csc366.teamdatabase;
import edu.calpoly.csc366.teamdatabase.customer.CustomerAccount;
import edu.calpoly.csc366.teamdatabase.manager.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import edu.calpoly.csc366.teamdatabase.supplier.SuppliedProduct;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.TestPropertySource;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Demo0: Add, list, and remove Person & Address instances

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(properties = {
        "spring.main.banner-mode=off",
        "logging.level.root=ERROR",
        "logging.level.csc366=DEBUG",

        "spring.jpa.hibernate.ddl-auto=update",
        "spring.datasource.url=jdbc:mysql://mysql.labthreesixsix.com/csc366",
        "spring.datasource.username=jpa",
        "spring.datasource.password=demo",

        "logging.level.org.hibernate.SQL=DEBUG",
        "logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE", // display prepared statement parameters
        "spring.jpa.properties.hibernate.format_sql=true",
        "spring.jpa.show-sql=false",   // prevent duplicate logging
        "spring.jpa.properties.hibernate.show_sql=false",

        "logging.pattern.console= %d{yyyy-MM-dd HH:mm:ss} - %msg%n"
})
@TestMethodOrder(OrderAnnotation.class)
public class ManagerTests {

    private final static Logger log = LoggerFactory.getLogger(ManagerTests.class);

    @Autowired
    private PersonRepository personRepository;

    Date currentDate = new Date();
    Date newDate = new GregorianCalendar(2025, Calendar.FEBRUARY, 11).getTime();

    private final SuppliedProduct suppliedProduct = new SuppliedProduct("Coffee Beans", "Coffee")
    private final Manager person = new Manager("test", "test", "test@calpoly.edu", "888-888-8888", "123 Street");
    private final Store store = new Store("1234 Street", 10, 123456, "Southern California");
    private final Rent rent = new Rent("Land Fee", "Land tax needed", 1000.00F, currentDate, newDate, "N/A");
    private final CustomerFeedback customerFeeback = new CustomerFeedback(CustomerFeedback.polarity.POSITIVE, "Great Service!", currentDate);
    private final EmployeeStatus employeeStatus = new EmployeeStatus(currentDate, newDate);
    private final Inventory inventory = new Inventory(suppliedProduct, 1000, 10);
    private final Maintenance maintenance = new Maintenance(currentDate, "something", "something", 1000.00F, currentDate, newDate, "N/A");
    private final Regulations regulations = new Regulations("some regulation", Regulations.Regs.EMPLOYMENT, (java.sql.Date) currentDate, (java.sql.Date) currentDate);
    private final StoreRegulation storeRegulation = new StoreRegulation((java.sql.Date) currentDate, true);


    @BeforeEach
    private void setup() {
        personRepository.saveAndFlush(person);
        person.addAddress(addrCP);
        personRepository.saveAndFlush(person);
    }

    @Test
    @Order(1)
    public void testPersonAndAddress() {
        Person person2 = personRepository.findByFirstName("test");

        log.info(person2.toString());

        assertNotNull(person);
        assertEquals(person2.getAddresses().size(), 1);
    }

    @Test
    @Order(2)
    public void testPersonAddressQuery() {
        Person person2 = personRepository.findByFirstName("test");
        assertNotNull(person);
        assertEquals(person2.getFirstName(), person.getFirstName());
        assertEquals(person2.getLastName(), person.getLastName());
    }


    @Test
    @Order(3)
    public void testRemoveAddress() {
        Person p = personRepository.findByFirstName("test");
        Address a = new ArrayList<Address>(p.getAddresses()).get(0);  // get an address
        p.removeAddress(a);
        personRepository.save(p);
        log.info(p.toString());
    }

    @Test
    @Order(4)
    public void testRemoveAddressAndFlush() {
        Person p = personRepository.findByFirstName("test");
        Address a = new ArrayList<Address>(p.getAddresses()).get(0);  // get an address
        p.removeAddress(a);
        personRepository.saveAndFlush(p);
        log.info(p.toString());
    }

    @Test
    @Order(5)
    public void testJpqlJoin() {
        Person p = personRepository.findByNameWithAddressJpql("test");
        log.info(p.toString());

        p.addAddress(new Address("2 Grand Ave", "SLO", "CA", "93407-0002"));
        personRepository.saveAndFlush(p);

        p = personRepository.findByNameWithAddressJpql("test");
        log.info(p.toString());
    }

}