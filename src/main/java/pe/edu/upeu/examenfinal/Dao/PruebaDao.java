/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.examenfinal.Dao;

import java.util.List;
import pe.edu.upeu.examenfinal.model.Prueba;
/**
 *
 * @author Alvaro Alva
 */
public interface PruebaDao {
    public int create(Prueba s);
	public int update(Prueba s);
	public Prueba read(int id);
	public List<Prueba> readAll();
	public int delete(int id);
}
