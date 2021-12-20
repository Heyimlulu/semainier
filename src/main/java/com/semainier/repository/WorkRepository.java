package com.semainier.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.semainier.model.Work;

public interface WorkRepository extends JpaRepository<Work, Integer>{

	@Query("SELECT work FROM Work work WHERE CONCAT(work.id, ' ', work.branche) LIKE %?1%")
	public Page<Work> findAll(String keyword, Pageable pageable);
}
