/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAOmovie.movieDAO;
import DAOImplement.movieimplement;
import model.*;
import view.MainView;
/**
 *
 * @author DELL
 */
public class moviecontroller {
    MainView frame;
    movieimplement implmovie;
    List<movie> dm;
    
    public moviecontroller(MainView frame){
        this.frame = frame;
        implmovie = new movieDAO();
        dm = implmovie.getAll();
    }
    public void isitabel(){
        dm = implmovie.getAll();
        modeltabelmovie mv = new modeltabelmovie(dm);
        frame.getTabelmovie().setModel(mv);
    }
    
    public void insert(){
        movie dm = new movie();
        dm.setJudul(frame.getJTxtjudul().getText());
        dm.setAlur(Integer.parseInt(frame.getJTxtalur().getText()));
        dm.setPenokohan(Integer.parseInt(frame.getJTxtpenokohan().getText()));
        dm.setAkting(Integer.parseInt(frame.getJTxtakting().getText()));
        dm.setNilai(dm.calculateRating()); // calculate the rating
        implmovie.insert(dm);
    }
    
    public void update(){
        movie dm = new movie();
        dm.setJudul(frame.getJTxtjudul().getText());
        dm.setAlur(Integer.parseInt(frame.getJTxtalur().getText()));
        dm.setPenokohan(Integer.parseInt(frame.getJTxtpenokohan().getText()));
        dm.setAkting(Integer.parseInt(frame.getJTxtakting().getText()));
        implmovie.update(dm);
    }
    
    public void delete(){
        String judul = frame.getJTxtjudul().getText();
        implmovie.delete(judul);
    }
}
