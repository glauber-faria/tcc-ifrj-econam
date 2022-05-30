package org.econam.api.repository;

import org.econam.api.model.ReadInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadInputRepository extends JpaRepository<ReadInput, Long> {
	
}
