package org.baeldung.persistence.repo;

import org.baeldung.persistence.model.Sales;
import org.springframework.data.repository.CrudRepository;

public interface SalesRepository extends CrudRepository<Sales, Long> {


    
}