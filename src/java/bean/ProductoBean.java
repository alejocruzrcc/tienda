/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import data.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import logica.LogicaPrendas;

@ManagedBean
@ViewScoped
public class ProductoBean {
    
    private Producto producto; 
    private List<Producto> listProductos;
    private List<Producto> listProductoSelect;
    private Producto selectedProducto;
    private LogicaPrendas logicaPrendas;

    public Producto getSelectedProducto() {
        return selectedProducto;
    }

    public void setSelectedProducto(Producto selectedProducto) {
        this.selectedProducto = selectedProducto;
    }
        
    public ProductoBean() {
        producto = new Producto();
        listProductos = new ArrayList<>();
        logicaPrendas= new LogicaPrendas();
        cargarPrendas();
    }

    public List<Producto> getListProductoSelect() {
        return listProductoSelect;
    }

    public void setListProductoSelect(List<Producto> listProductoSelect) {
        this.listProductoSelect = listProductoSelect;
    }

    public LogicaPrendas getLogicaPrendas() {
        return logicaPrendas;
    }

    public void setLogicaPrendas(LogicaPrendas logicaPrendas) {
        this.logicaPrendas = logicaPrendas;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }
    
    public void cargarPrendas(){
    listProductos.addAll(logicaPrendas.cargarProductos());
    }
    
     public void registrarPrenda() {
               
        logicaPrendas.insertarPrendas(producto);
        listProductos.clear();
        cargarPrendas();
    }
     
    public void editarPrendas() {
               
        logicaPrendas.editarPrendas(producto);
        listProductos.clear();
        cargarPrendas();
    }
    
    public void resetLista(){
       logicaPrendas.resetListaPrendas();
       listProductos.clear();
       cargarPrendas();
    }
    
    public void eliminarEstudiantes(){
        logicaPrendas.eliminarPrendas(listProductoSelect);
        listProductos.clear();
        cargarPrendas();
    }
     
    
    
}
