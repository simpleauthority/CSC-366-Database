package edu.calpoly.csc366.teamdatabase;


import edu.calpoly.csc366.teamdatabase.employee.Employee;
import edu.calpoly.csc366.teamdatabase.employee.Role;
import edu.calpoly.csc366.teamdatabase.manager.*;
import edu.calpoly.csc366.teamdatabase.supplier.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("junit")
public class ManagerTests {

    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private CustomerFeedbackRepository customerFeedbackRepository;
    @Autowired
    private EmployeeStatusRepository employeeStatusRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private MainteanceRepository mainteanceRepository;
    @Autowired
    private RegulationsRepository regulationsRepository;
    @Autowired
    private RentRepository rentRepository;
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private StoreRegulationRepository storeRegulationRepository;

    private Date testDate = Date.from(Instant.now());
    Date newDate = new GregorianCalendar(2025, Calendar.FEBRUARY, 11).getTime();

    private final SuppliedProduct suppliedProduct = new SuppliedProduct("A", "B");
    private final Manager manager = new Manager("test", "test", "test@calpoly.edu", "888-888-8888", "123 Street");
    private final Store store1 = new Store("1234 Street", 10, 123456, "Southern California");
    private final Store store2 = new Store("12345 Street", 10, 123456, "Southern California");

    private final Rent rent = new Rent("Land Fee", "Land tax needed", 1000.00F, testDate, newDate, "N/A");
    private final CustomerFeedback customerFeeback = new CustomerFeedback(CustomerFeedback.polarity.POSITIVE, "Great Service!", testDate);
    private final EmployeeStatus employeeStatus = new EmployeeStatus(testDate, newDate);
    private final Inventory inventory = new Inventory(suppliedProduct, 1000, 10);
    private final Maintenance maintenance = new Maintenance(testDate, "something", "something", 1000.00F, testDate, newDate, "N/A");
    private final Employee employee = new Employee("Eva Johnson", "5552468135", "eva.johnson@example.org", Date.from(Instant.parse("1980-03-03T00:00:00.00Z")), new Role("cashier"));
    @BeforeEach
    private void setup() {
        // add 2 store to manager and flush
        managerRepository.saveAndFlush(manager);
        manager.addStore(store1);
        manager.addStore(store2);
        managerRepository.saveAndFlush(manager);

        rentRepository.saveAndFlush(rent);

        // add employee to store and flush
        storeRepository.saveAndFlush(store1);

        // customer feedbacks
        customerFeedbackRepository.saveAndFlush(customerFeeback);
        mainteanceRepository.saveAndFlush(maintenance);
        employeeStatusRepository.saveAndFlush(employeeStatus);
        inventoryRepository.saveAndFlush(inventory);
    }

    @Test
    @Order(1)
    public void testManagerAndAttribute() {
        Manager m = managerRepository.findByFirstName("test");
        assertEquals(m.getFirstName(), manager.getFirstName());
        assertEquals(m.getLastName(), manager.getLastName());
        assertEquals(m.getEmail(), manager.getEmail());
        assertEquals(m.getAddress(), manager.getAddress());
    }

    @Test
    @Order(2)
    public void testStoreExist() {
        Manager m = managerRepository.findByFirstName("test");
        assertEquals(m.getStore().get(0), store1);
        assertEquals(m.getStore().get(1), store2);
    }

    @Test
    @Order(3)
    public void testMaintenance() {
        Manager m = managerRepository.findByFirstName("test");
        assertEquals(m.getStore().get(0), store1);
        assertEquals(m.getStore().get(1), store2);
    }
}
