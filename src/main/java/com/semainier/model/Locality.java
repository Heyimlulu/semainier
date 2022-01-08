package com.semainier.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tbllocalite")
public class Locality {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, columnDefinition = "varchar(45)")
	private String canton;

	@Column(nullable = false, columnDefinition = "varchar(45)")
	private String ville;

	@Column(nullable = false, columnDefinition = "int")
	private Integer NPA;

	@OneToMany(mappedBy = "locality", cascade = CascadeType.ALL)
	private List<Student> lStudent = new ArrayList<Student>();

	public List<Student> getlStudent() {
		return lStudent;
	}

	public void setlStudent(List<Student> lStudent) {
		this.lStudent = lStudent;
	}

	public Locality() {}
	public Locality(Integer id) {
		this.id = id;
	}

	public Locality(String canton, String ville, Integer NPA) {
		super();
		this.canton = canton;
		this.ville = ville;
		this.NPA = NPA;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCanton() {
		return canton;
	}
	public void setCanton(String canton) {
		this.canton = canton;
	}

	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getNPA() {
		return NPA;
	}
	public void setNPA(Integer NPA) {
		this.NPA = NPA;
	}

	@Override
	public String toString() {
		return "Localite " +
				"[id=" + id +
				", canton=" + canton +
				", ville=" + ville +
				", NPA=" + NPA + "]";
	}


}
