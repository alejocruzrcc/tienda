/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author win
 */
public class ConexionDB {

    public Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/tienda";
        String usuario = "postgres";
        String password = "root";
        Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            System.out.println("ERROR DE CONEXION" + e.getMessage());
        }
        return conexion;
    }
}
