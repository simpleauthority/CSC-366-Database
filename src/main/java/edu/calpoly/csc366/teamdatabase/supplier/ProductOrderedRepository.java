package edu.calpoly.csc366.teamdatabase.supplier;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderedRepository extends JpaRepository<ProductOrdered, Long> {
}
