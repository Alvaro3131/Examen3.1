/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.examenfinal.model;

/**
 *
 * @author Alvaro Alva
 */
public class Prueba {
private int idproducto;
private String nombre;
private double preio;
private int stock;
private int idcategoria;
private String noca;

    public Prueba(int idproducto, String nombre, double preio, int stock, int idcategoria) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.preio = preio;
        this.stock = stock;
        this.idcategoria = idcategoria;
        
    }
    public Prueba() {
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPreio() {
        return preio;
    }

    public void setPreio(double preio) {
        this.preio = preio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNoca() {
        return noca;
    }

    public void setNoca(String noca) {
        this.noca = noca;
    }
    
}
