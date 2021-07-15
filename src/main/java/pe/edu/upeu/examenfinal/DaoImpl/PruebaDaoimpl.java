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
import pe.edu.upeu.examenfinal.Dao.PruebaDao;
import pe.edu.upeu.examenfinal.model.Prueba;

/**
 *
 * @author Alvaro Alva
 */
public class PruebaDaoimpl implements PruebaDao {
private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection cx = null;
    @Override
    public int create(Prueba s) {
        int x = 0;
		String SQL = "INSERT INTO producto (idproducto,nombre, precio, stock, categoria_idcategoria) VALUES(?,?,?,?,?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
                        ps.setInt(1, s.getIdproducto());
			ps.setString(2, s.getNombre());
		        ps.setDouble(3, s.getPreio());
                        ps.setInt(4, s.getStock());
                        ps.setInt(5, s.getIdcategoria());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
    }

    @Override
    public int update(Prueba s) {
        int x = 0;
		String SQL = "update producto set nombre=?, precio=?, stock=?, categoria_idcategoria=? where idproducto = ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, s.getNombre());
                        ps.setDouble(2, s.getPreio());
                        ps.setInt(3, s.getStock());
                        ps.setInt(4, s.getIdcategoria());
                        ps.setInt(5, s.getIdproducto());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
    }

    @Override
    public Prueba read(int id) {
        Prueba a = new Prueba();
		String SQL = "select *from producto where idproducto=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {				
				a.setIdproducto(rs.getInt("idproducto"));
                                a.setNombre(rs.getString("nombre"));
                                a.setPreio(rs.getDouble("precio"));
                                a.setStock(rs.getInt("stock"));
                                a.setIdcategoria(rs.getInt("categoria_idcategoria"));
                                
                               
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return a;
    }

    @Override
    public List<Prueba> readAll() {
         List<Prueba> lista = new ArrayList<>();
		String SQL = "select p.idproducto, p.nombre, p.precio, p.stock, c.nombre nombrec from producto p join categoria c on p.categoria_idcategoria=c.idcategoria order by p.idproducto ";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				Prueba a = new Prueba();
				a.setIdproducto(rs.getInt("idproducto"));
                                a.setNombre(rs.getString("nombre"));
                                a.setPreio(rs.getDouble("precio"));
                                a.setStock(rs.getInt("stock"));
                                a.setNoca(rs.getString("nombrec"));
                             
				lista.add(a);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return lista;
    }

    @Override
    public int delete(int id) {
       int x = 0;
		String SQL = "delete from producto where idproducto=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
    }
    
}
