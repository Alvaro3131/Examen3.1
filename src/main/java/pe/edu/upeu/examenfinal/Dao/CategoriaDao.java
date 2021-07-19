/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.examenfinal.Dao;

import java.util.List;
import pe.edu.upeu.examenfinal.model.Categoria;

/**
 *
 * @author Alvaro Alva
 */
public interface CategoriaDao {
    public List<Categoria> readAll();
}
