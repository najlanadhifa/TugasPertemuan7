/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;
import java.util.List;
import model.*;
/**
 *
 * @author DELL
 */
public interface movieimplement {
    public void insert(movie p);
    public void update(movie p);
    public void delete(String judul);
    public void clear(String judul);
    public List<movie> getAll();
}
