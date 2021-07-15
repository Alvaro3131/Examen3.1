/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.examenfinal.Controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upeu.examenfinal.Dao.PruebaDao;
import pe.edu.upeu.examenfinal.DaoImpl.PruebaDaoimpl;
import pe.edu.upeu.examenfinal.model.Prueba;

/**
 *
 * @author Alvaro Alva
 */
@WebServlet(name = "PruebaController", urlPatterns = {"/pc"})
public class PruebaController extends HttpServlet {
private Gson gson = new Gson();
	private PruebaDao udao = new PruebaDaoimpl();
	private static final long serialVersionUID = 1L;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("opc"));
         switch (op) {
                case 1://todos los productos
                          System.out.println("Prueba1");
		          out.println(gson.toJson(udao.readAll()));
			break;
		case 2://guardar
                   System.out.println("Caso2");
                        int q=Integer.parseInt(request.getParameter("i"));
			String e=request.getParameter("nombre");
                       double p=Double.parseDouble(request.getParameter("precio"));
			int t=Integer.parseInt(request.getParameter("stock"));
                        int y=Integer.parseInt(request.getParameter("ca"));
                        System.out.println(q+e+p+t+y);
                        System.out.println("Hola");
			out.println(gson.toJson(udao.create(new Prueba(q,e,p,t,y))));
			break;
                case 3://read
			out.println(gson.toJson(udao.read(Integer.parseInt(request.getParameter("id")))));
			break;
                case 4://modificar
			Prueba r = new Prueba();
			r.setIdproducto(Integer.parseInt(request.getParameter("id")));
			r.setNombre(request.getParameter("nombre"));
			r.setPreio(Double.parseDouble(request.getParameter("precio")));
			r.setStock(Integer.parseInt(request.getParameter("stock")));
                        r.setIdcategoria(Integer.parseInt(request.getParameter("ca")));
			out.println(gson.toJson(udao.update(r)));
			break;
                case 5://eliminar
			int id=Integer.parseInt(request.getParameter("id"));
			out.println(gson.toJson(udao.delete(id)));
			break;
		default:
			break;
		}
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
