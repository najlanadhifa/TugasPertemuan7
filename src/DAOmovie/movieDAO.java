/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOmovie;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAOImplement.movieimplement;
/**
 *
 * @author DELL
 */
public class movieDAO implements movieimplement{
    Connection connection;
    
    final String select = "SELECT * FROM movie";
    final String insert = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES (?, ?, ?, ?, ?);";
    final String update = "update movie set judul=?, alur=?, penokohan=?, akting=?, nilai=?";
    final String delete = "delete movie where judul=?";
    public movieDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(movie p) {
        p.setNilai(p.calculateRating()); // calculate the rating
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setInt(2, p.getAlur());
            statement.setInt(3, p.getPenokohan());
            statement.setInt(4, p.getAkting());
            statement.setInt(5, p.getNilai());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                p.setJudul(rs.getString(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void update(movie p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getJudul());
            statement.setInt(2, p.getAlur());
            statement.setInt(3, p.getPenokohan());
            statement.setInt(4, p.getAkting());
            statement.setInt(5, p.getNilai());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setString(1, judul);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }   
    }
    
    @Override
    public void clear(String judul) {
        
        }

    @Override
    public List<movie> getAll() {
        List<movie> dm = null;
        try{
            dm = new ArrayList<movie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                movie mo = new movie();
                mo.setJudul(rs.getString("judul"));
                mo.setAlur(rs.getInt("alur"));
                mo.setPenokohan(rs.getInt("penokohan"));
                mo.setAkting(rs.getInt("akting"));
                mo.setNilai(rs.getInt("nilai"));
                dm.add(mo);
            }
        }catch(SQLException ex){
            Logger.getLogger(movieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dm;
        
    }
}
