package edu.calpoly.csc366.teamdatabase.supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SuppliedProductRepository extends JpaRepository<SuppliedProduct, Long> {

    SuppliedProduct findByName(String name);

    // JPQL query  (validity check on application init)
    @Query("from SuppliedProduct s where s.name = :name")
    SuppliedProduct findByNameJpql(@Param("name") String name);
}
