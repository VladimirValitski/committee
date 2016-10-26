package com.valitski.dto;
/**
 * Class Entity
 */
public abstract class Entity {
	private int id;
	private String name_faculty;
	private int enrollment;
	private String pasport;
	private int total_score;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(int enrollment) {
		this.enrollment = enrollment;
	}

	public String getName_faculty() {
		return name_faculty;
	}

	public void setName_faculty(String name_faculty) {
		this.name_faculty = name_faculty;
	}

	public String getPasport() {
		return pasport;
	}

	public void setPasport(String pasport) {
		this.pasport = pasport;
	}

	public int getTotal_score() {
		return total_score;
	}

	public void setTotal_score(int total_score) {
		this.total_score = total_score;
	}
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name_faculty=" + name_faculty + ", enrollment=" + enrollment + ", pasport="
				+ pasport + ", total_score=" + total_score + "]";
	}
}
