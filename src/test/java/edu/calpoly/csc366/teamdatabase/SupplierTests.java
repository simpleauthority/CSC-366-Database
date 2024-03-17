package edu.calpoly.csc366.teamdatabase;

import edu.calpoly.csc366.teamdatabase.manager.Manager;
import edu.calpoly.csc366.teamdatabase.manager.ManagerRepository;
import edu.calpoly.csc366.teamdatabase.manager.Store;
import edu.calpoly.csc366.teamdatabase.manager.StoreRepository;
import edu.calpoly.csc366.teamdatabase.supplier.SupplierRepository;
import edu.calpoly.csc366.teamdatabase.supplier.*;
import org.checkerframework.checker.units.qual.A;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("junit")
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SupplierTests {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private ShipmentRepository shipmentRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private ProductOrderedRepository productOrderedRepository;
    @Autowired
    private SuppliedProductRepository suppliedProductRepository;

    private Date testDate = Date.from(Instant.now());

    @BeforeEach
    public void setup() {
        Supplier s1 = new Supplier("First1", "Last1", "first1last1@gmail.com", "123 Main St");
        Supplier s2 = new Supplier("First2", "Last2", "first2last2@gmail.com", "124 Main St");
        supplierRepository.saveAllAndFlush(List.of(s1, s2));

        SuppliedProduct sp1 = new SuppliedProduct("A", "B");
        SuppliedProduct sp2 = new SuppliedProduct("B", "C");

        suppliedProductRepository.saveAllAndFlush(List.of(sp1, sp2));

        Shipment sh1 = new Shipment(testDate, testDate, testDate, s1,
                "Delivery Company 1", "A1", 10.0, 10.0, 10.0);

        List<ProductOrdered> productOrderedList = List.of(
                new ProductOrdered(sh1, sp1,1.0, null),
                new ProductOrdered(sh1, sp2,1.0, null)
        );

        sh1.setProductOrderedList(productOrderedList);
        shipmentRepository.saveAndFlush(sh1);
    }
    @Test
    public void testFindPerson() {
        Supplier s = supplierRepository.findByFirstName("First1");
        assertEquals(s.getFirstName(), "First1");
        assertEquals(s.getLastName(), "Last1");
        assertEquals(s.getEmail(), "first1last1@gmail.com");
        assertEquals(s.getAddress(), "123 Main St");
    }

    @Test
    public void testFindNonexistentPerson() {
        Supplier s = supplierRepository.findByFirstName("First0");
        assertNull(s);
    }

    @Test
    public void testFindShipment() {
        Shipment s = shipmentRepository.findByTrackingNumber("A1");
        assertEquals(s.getExpectedDeliveryDate(), testDate);
        assertEquals(s.getOrderCost(), 10);
        assertEquals(s.getSupplier().getEmail(), "first1last1@gmail.com");
    }

    @Test
    public void testAddDuplicateEmail() {
        Supplier s3 = new Supplier("First3", "Last3", "first2last2@gmail.com", "125 Main St");
        assertThrows(DataIntegrityViolationException.class, () -> supplierRepository.saveAndFlush(s3));
    }

    @Test
    public void testFindSuppliedProduct() {
        SuppliedProduct sp = suppliedProductRepository.findByName("A");
        assertEquals(sp.getName(), "A");
        assertEquals(sp.getDescription(), "B");
    }




}
