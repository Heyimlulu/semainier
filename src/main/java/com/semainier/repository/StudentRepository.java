package com.semainier.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.semainier.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query("SELECT student FROM Student student WHERE CONCAT(student.id, ' ', student.nom, ' ', student.prenom, ' ', student.dob) LIKE %?1%")
	public Page<Student> findAll(String keyword, Pageable pageable);

}
