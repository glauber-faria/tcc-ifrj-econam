package org.econam.api.repository;

import org.econam.api.model.ReadOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadOutputRepository extends JpaRepository<ReadOutput, Long> {
	
}
