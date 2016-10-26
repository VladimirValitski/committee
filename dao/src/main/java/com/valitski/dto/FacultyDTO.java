package com.valitski.dto;
/**
 * Class FacultyDTO
 */
public class FacultyDTO extends Entity{
	private int id_faculty;
	private String name_faculty;
	private int enrollment;

	public FacultyDTO() {
	}
	
	public FacultyDTO(String name_faculty, int enrollment) {
		this.name_faculty = name_faculty;
		this.enrollment = enrollment;	
	}
	
	public FacultyDTO(int id_faculty) {
		this.id_faculty = id_faculty;	
	}

	public FacultyDTO(int id_faculty, String name_faculty, int enrollment) {
		this.id_faculty = id_faculty;
		this.name_faculty = name_faculty;
		this.enrollment = enrollment;
	}

	public int getId_faculty() {
		return id_faculty;
	}

	public void setId_faculty(int id_faculty) {
		this.id_faculty = id_faculty;
	}

	public String getName_faculty() {
		return name_faculty;
	}

	public void setName_faculty(String name_faculty) {
		this.name_faculty = name_faculty;
	}

	public int getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(int enrollment) {
		this.enrollment = enrollment;
	}

	@Override
	public String toString() {
		return "Faculty [id_faculty=" + id_faculty + ", name_faculty=" + name_faculty + ", enrollment=" + enrollment
				+ "]";
	}

}
