/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import data.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author win
 */
public class PrendasDao {

    private ConexionDB dB;
    private Connection connection;
    private PreparedStatement statement;

    public PrendasDao() {
        dB = new ConexionDB();
    }

    public List<Producto> cargarProductos() {
        List<Producto> productos = new ArrayList<>();
        ResultSet rs = null;
        try {
            connection = dB.getConnection();
            String query = "SELECT * FROM public.prendas;";
            statement = connection.prepareCall(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("prenda_id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setMarca(rs.getString("marca"));
                producto.setTalla(rs.getString("talla"));
                producto.setPrecio(rs.getFloat("precio"));

                productos.add(producto);
            }
            if (!connection.isClosed()) {
                connection.close();
            }
            statement.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }

        return productos;
    }

    public boolean insertarPrenda(Producto prenda) {
        boolean registro = false;
        try {
            connection = dB.getConnection();
            String query = "INSERT INTO public.prendas(\n"
                    + "	prenda_id, nombre, marca, talla, precio)\n"
                    + "	VALUES (?, ?, ?, ?, ?);";
            statement = connection.prepareCall(query);
            statement.setInt(1, prenda.getId());
            statement.setString(2, prenda.getNombre());
            statement.setString(3, prenda.getMarca());
            statement.setString(4, prenda.getTalla());
            statement.setDouble(5, prenda.getPrecio());

            statement.execute();

            registro = true;
            if (!connection.isClosed()) {
                connection.close();
            }
            statement.close();

        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }

        return registro;
    }

    public boolean resetLista() {
        boolean registro = false;
        try {
            connection = dB.getConnection();
            String query = "DELETE FROM public.prendas\n";
            statement = connection.prepareCall(query);

            statement.execute();

            registro = true;
            if (!connection.isClosed()) {
                connection.close();
            }
            statement.close();

        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }

        return registro;
    }

    public boolean elminiarPrendas(List<Producto> productos) {
        boolean registro = false;
        try {
            connection = dB.getConnection();
            for (int i = 0; i < productos.size(); i++) {
                String query = "DELETE FROM public.prendas WHERE prenda_id = ?";
                statement = connection.prepareCall(query);
                statement.setInt(1, productos.get(i).getId());
                statement.execute();
                registro = true;
            }
            if (!connection.isClosed()) {
                connection.close();
            }
            statement.close();

        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }

        return registro;
    }

    public boolean editarPrendas(Producto prendas) {
        boolean registro = false;
        try {
            connection = dB.getConnection();
            
                String query = "UPDATE public.prendas \n"
                        + "	SET nombre=?, marca=?, talla=?, precio=? \n"
                        + "	WHERE prenda_id = ?;";
                
                statement.setString(1, prendas.getNombre());
                statement.setString(2, prendas.getMarca());
                statement.setString(3, prendas.getTalla());
                statement.setDouble(4, prendas.getPrecio());
                statement.setInt(5, prendas.getId());
                statement.execute();
                //  connection.commit();
                registro = true;
            
            if (!connection.isClosed()) {
                connection.close();
            }
            statement.close();

        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }

        return registro;
    }

}
