/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dao.PrendasDao;
import dao.ConexionDB;
import java.sql.Connection;
import data.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author win
 */
public class LogicaPrendas {
    
    private PrendasDao dao;

    public LogicaPrendas() {
       dao= new PrendasDao();
    }    
        
    public List<Producto> cargarProductos(){
     List<Producto> productos = new ArrayList<>();
        productos.addAll(dao.cargarProductos());
        return productos;
    }
    
   public void insertarPrendas(Producto producto) {
        if (dao.insertarPrenda(producto)) {
            System.out.println("registro completo");
        } else {
            System.out.println("no registro");
        }
    }

    public void resetListaPrendas() {
        if (dao.resetLista()) {
            System.out.println("reset exitoso");
        } else {
            System.out.println("no se pudo limpiar la lista");
        }
    }

    public void eliminarPrendas(List<Producto> prendas) {
        if (dao.elminiarPrendas(prendas)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successful", "se elimino"));
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successful", "no se pudo eliminar"));
        }
    }
    
     public void editarPrendas(Producto prenda) {
        if (dao.editarPrendas(prenda)) {
            System.out.println("registro completo");
        } else {
            System.out.println("no registro");
        }
    }
    
}
