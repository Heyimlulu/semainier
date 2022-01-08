package com.semainier.model;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name="tbleleve")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, columnDefinition = "varchar(45)")
	private String nom;

	@Column(nullable = false, columnDefinition = "varchar(45)")
	private String prenom;

	@Column(nullable = false)
	private Date dob;

	@ManyToOne
	@JoinColumn(name = "tbllocalite_locid")
	private Locality locality;

	public Locality getLocality() {
		return locality;
	}

	public void setLocality(Locality locality) {
		this.locality = locality;
	}

	public Student() {}
	public Student(Integer id) {
		this.id = id;
	}

	public Student(String nom, String prenom, Date dob, Locality locality) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dob = dob;
		this.locality = locality;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student " +
				"[id=" + id +
				", nom=" + nom +
				", prenom=" + prenom +
				", dob=" + dob + "]";
	}


}
