package com.valitski.dto;
/**
 * Class AbiturientDTO
 */
public class AbiturientDTO extends Entity {
	private int id_abiturienta;
	private String last_name;
	private String first_name;
	private String second_name;
	private String phone;
	private String pasport;
	private int user_role;

	public AbiturientDTO() {
	}

	public AbiturientDTO(String last_name, String first_name, String second_name, String phone,
			String pasport) {
		this.last_name = last_name;
		this.first_name = first_name;
		this.second_name = second_name;
		this.phone = phone;
		this.pasport = pasport;
	}

	public int getId_abiturienta() {
		return id_abiturienta;
	}

	public void setId_abiturienta(int id_abiturienta) {
		this.id_abiturienta = id_abiturienta;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getSecond_name() {
		return second_name;
	}

	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPasport() {
		return pasport;
	}

	public void setPasport(String pasport) {
		this.pasport = pasport;
	}

	public int getUser_role() {
		return user_role;
	}

	public void setUser_role(int user_role) {
		this.user_role = user_role;
	}

	@Override
	public String toString() {
		return "Abiturient [id_abiturienta=" + id_abiturienta + ", last_name=" + last_name + ", first_name="
				+ first_name + ", second_name=" + second_name + ", phone=" + phone + ", pasport=" + pasport
				+ ", user_role=" + user_role + "]";
	}

}

