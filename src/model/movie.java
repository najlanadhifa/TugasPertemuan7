/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class movie {
    private String judul;
    private Integer alur;
    private Integer penokohan;
    private Integer akting;
    private Integer nilai;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public Integer getAlur() {
        return alur;
    }

    public void setAlur(Integer alur) {
        this.alur = alur;
    }

    public Integer getPenokohan() {
        return penokohan;
    }

    public void setPenokohan(Integer penokohan) {
        this.penokohan = penokohan;
    }

    public Integer getAkting() {
        return akting;
    }

    public void setAkting(Integer akting) {
        this.akting = akting;
    }

    public Integer getNilai() {
        return nilai;
    }

    public void setNilai(Integer nilai) {
        this.nilai = nilai;
    }
    
    public int calculateRating() {
        return (getAlur() + getPenokohan() + getAkting()) / 3;
    
    }
}
