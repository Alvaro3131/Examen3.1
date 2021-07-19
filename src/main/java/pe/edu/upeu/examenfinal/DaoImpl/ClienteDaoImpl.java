/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.examenfinal.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.examenfinal.Config.Conexion;
import pe.edu.upeu.examenfinal.Dao.ClienteDao;
import pe.edu.upeu.examenfinal.model.Cliente;

/**
 *
 * @author Alvaro Alva
 */
public class ClienteDaoImpl implements ClienteDao {
private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection cx = null;
    @Override
    public List<Cliente> readAll() {
         List<Cliente> lista = new ArrayList<>();
		String SQL = "select * from cliente";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cliente a = new Cliente();
				a.setIdcliente(rs.getInt("idcliente"));
                                a.setNombre(rs.getString("nombres"));
                                a.setApellido(rs.getString("apellidos"));
                             
                             
				lista.add(a);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return lista;
    }
    
}
