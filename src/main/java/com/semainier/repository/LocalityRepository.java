package com.semainier.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.semainier.model.Locality;

public interface LocalityRepository extends JpaRepository<Locality, Integer> {
	@Query("SELECT locality FROM Locality locality WHERE CONCAT(locality.id, ' ', locality.canton, ' ', locality.ville, ' ', locality.NPA) LIKE %?1%")
	public Page<Locality> findAll(String keyword, Pageable pageable);

}
