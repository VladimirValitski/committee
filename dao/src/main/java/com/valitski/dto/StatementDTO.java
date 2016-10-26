package com.valitski.dto;

/**
 * Class StatementDTO
 */
public class StatementDTO extends Entity {
    private String pasport;
    private int subject_one;
    private int subject_two;
    private int school_certificate;
    private int total_score;
    private int id_faculty;

    public StatementDTO(String pasport, int total_score) {
        this.pasport = pasport;
        this.total_score = total_score;
    }

    public StatementDTO() {
    }

    public StatementDTO(String pasport, int subject_one, int subject_two, int school_certificate,
                        int id_faculty) {
        this.pasport = pasport;
        this.subject_one = subject_one;
        this.subject_two = subject_two;
        this.school_certificate = school_certificate;
        this.id_faculty = id_faculty;
    }

    public String getPasport() {
        return pasport;
    }

    public void setPasport(String pasport) {
        this.pasport = pasport;
    }

    public int getSubject_one() {
        return subject_one;
    }

    public void setSubject_one(int subject_one) {
        this.subject_one = subject_one;
    }

    public int getSubject_two() {
        return subject_two;
    }

    public void setSubject_two(int subject_two) {
        this.subject_two = subject_two;
    }

    public int getSchool_certificate() {
        return school_certificate;
    }

    public void setSchool_certificate(int school_certificate) {
        this.school_certificate = school_certificate;
    }

    public int getTotal_score() {
        return total_score;
    }

    public void setTotal_score(int total_score) {
        this.total_score = total_score;
    }

    public int getId_faculty() {
        return id_faculty;
    }

    public void setId_faculty(int id_faculty) {
        this.id_faculty = id_faculty;
    }

    @Override
    public String toString() {
        return "Statement [pasport=" + pasport + ", subject_one=" + subject_one + ", subject_two=" + subject_two
                + ", school_certificate=" + school_certificate + ", total_score=" + total_score + ", id_faculty="
                + id_faculty + "]";
    }

}
