package edu.calpoly.csc366.teamdatabase.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// This class will be automatically implemented by Spring and made available as a "Bean" named personRepository
@Repository
public interface CustomerFeedbackRepository extends JpaRepository<CustomerFeedback, Long> {
    // query inferred from method name, code generated by Spring Framework
    CustomerFeedback findByFeedBackId(Integer id);
}
