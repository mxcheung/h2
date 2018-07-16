package org.baeldung.persistence.repo;

import org.baeldung.persistence.model.Settlement;
import org.springframework.data.repository.CrudRepository;

public interface SettlementRepository extends CrudRepository<Settlement, Long> {


    
}