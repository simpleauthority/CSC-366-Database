package edu.calpoly.csc366.teamdatabase;


import edu.calpoly.csc366.teamdatabase.manager.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import edu.calpoly.csc366.teamdatabase.supplier.SuppliedProduct;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ManagerTests {
    private final static Logger log = LoggerFactory.getLogger(ManagerTests.class);

    @Autowired
    private ManagerRepository managerRepository;

    Date currentDate = new Date();
    Date newDate = new GregorianCalendar(2025, Calendar.FEBRUARY, 11).getTime();

    private final SuppliedProduct suppliedProduct = new SuppliedProduct("Coffee Beans", "Coffee")
    private final Manager manager = new Manager("test", "test", "test@calpoly.edu", "888-888-8888", "123 Street");
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
        managerRepository.saveAndFlush(manager);
        manager.addStore(store);
        managerRepository.saveAndFlush(manager);
    }

}
