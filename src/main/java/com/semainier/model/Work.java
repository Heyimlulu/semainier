package com.semainier.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="tblTache")
public class Work {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, columnDefinition = "varchar(45)")
	private String branche;

	@Column(nullable = false)
	private Integer duree;

	@Column(nullable = false)
	private String semaine;

	@Column(nullable = false)
	private String remarque;

	@ManyToMany
	@JoinTable(name = "tblEtudier", joinColumns = @JoinColumn(name = "tblTache_tacId"), inverseJoinColumns = @JoinColumn(name = "tblEleve_EleId"))
	private Set<Student> students = new HashSet<Student>();

	public Work() {}
	public Work(Integer id) {
		super();
		this.id = id;
	}

	public Work(String branche, Integer duree, String semaine, String remarque) {
		super();
		this.branche = branche;
		this.duree = duree;
		this.semaine = semaine;
		this.remarque = remarque;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getBranche() {
		return branche;
	}
	public void setBranche(String branche) {
		this.branche = branche;
	}

	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String getSemaine() {
		return semaine;
	}
	public void setSemaine(String semaine) {
		this.semaine = semaine;
	}

	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public Set<Student> getStudent() {
		return students;
	}
	public void setStudent(Set<Student> students) {
		this.students = students;
	}
	public void addStudent(Student student) {
		students.add(student);
	}
	public void removeStudent(Student student) {
		students.remove(student);
	}

	@Override
	public String toString() {
		return "Work " +
				"[id=" + id +
				", branche=" + branche +
				", duree=" + duree +
				", semaine=" + semaine +
				", remarque=" + remarque + "]";
	}
}
