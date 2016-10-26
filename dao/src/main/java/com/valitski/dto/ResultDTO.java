package com.valitski.dto;

/**
 * Class ResultDTO
 */
public class ResultDTO extends Entity {
    private String pasport;
    private int accept;

    public ResultDTO() {
    }

    public ResultDTO(String pasport, int accept) {
        this.pasport = pasport;
        this.accept = accept;
    }

    public String getPasport() {
        return pasport;
    }

    public void setPasport(String pasport) {
        this.pasport = pasport;
    }

    public int getAccept() {
        return accept;
    }

    public void setAccept(int accept) {
        this.accept = accept;
    }

    @Override
    public String toString() {
        return "Result [pasport=" + pasport + ", accept=" + accept + "]";
    }

}