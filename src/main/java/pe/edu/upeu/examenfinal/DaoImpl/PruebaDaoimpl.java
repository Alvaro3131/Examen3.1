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
		String SQL = "INSERT INTO venta (idventa,fecha, tipodoc, idsucursal, idcliente) VALUES(null,?,?,?,?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
                        
			ps.setString(1, s.getFecha());
		        ps.setString(2, s.getDoc());
                        ps.setInt(3, s.getIdsucursal());
                        ps.setInt(4, s.getIdcliente());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
    }

   

    @Override
    public List<Prueba> readAll() {
         List<Prueba> lista = new ArrayList<>();
		String SQL = "SELECT V.IDVENTA, S.NOMSUCURSAL, C.NOMBRES, C.APELLIDOS, V.FECHA, V.TIPODOC FROM VENTA V, CLIENTE C, SUCURSAL S WHERE V.IDCLIENTE = C.IDCLIENTE AND V.IDSUCURSAL = S.IDSUCURSAL ";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				Prueba a = new Prueba();
                                a.setIdventa(rs.getInt("V.IDVENTA"));
				a.setSucursal(rs.getString("S.NOMSUCURSAL"));
                                a.setNombrec(rs.getString("C.NOMBRES"));
                                a.setApellido(rs.getString("C.APELLIDOS"));
                                a.setFecha(rs.getString("V.FECHA"));
                                a.setDoc(rs.getString("V.TIPODOC"));
                             
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
		String SQL = "delete from venta where idventa=?";
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
