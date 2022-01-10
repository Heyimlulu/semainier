package com.semainier.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="tbltravaux")
public class Work {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, columnDefinition = "varchar(45)")
	private String branche;

	@Column(nullable = false)
	private Integer duree;

	@Column(nullable = false)
	private Date date;

	@Column(nullable = false)
	private String remarque;

	@ManyToMany
	@JoinTable(name = "tbletudier", joinColumns = @JoinColumn(name = "tbltravaux_traid"), inverseJoinColumns = @JoinColumn(name = "tbleleve_eleid"))
	private Set<Student> students = new HashSet<Student>();

	public Work() {}
	public Work(Integer id) {
		super();
		this.id = id;
	}

	public Work(String branche, Integer duree, Date date, String remarque) {
		super();
		this.branche = branche;
		this.duree = duree;
		this.date = date;
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

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
				", date=" + date +
				", remarque=" + remarque + "]";
	}
}
