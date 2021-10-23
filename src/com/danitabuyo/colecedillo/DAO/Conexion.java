/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danitabuyo.colecedillo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;


/**
 * o
 *
 * @author Cedillo15
 */
public class Conexion {

    //String de conexión
    String conexionDB = "jdbc:sqlite:C:/Users/Cedillo15/Documents/DANI/DAM/PRUEBAS JAVA/ColeCedilloNuevo/pruebascolegio.s3db";
    Connection conn = null;

    public Conexion() {

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(conexionDB);
            if (conn != null) {

                System.out.println("Conexión a la BBDD realizada con éxito");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha realizado la conexión a la BBDD"+ e);

        }
    }
//Sirve para confirmar que Insertar, eliminar se han realizado bien
    public int ejecutarSQL(String strSecuenciaSQL) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(strSecuenciaSQL);
            pstmt.execute();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("El registro no se ha guardo");
            return 0;
        }

    }
//Método para recuperar datos en una consulta.Devuelve los datos obtenidos en la strSecuenciaSQL;
    public ResultSet consultarDatos(String strSecuenciaSQL){
        try {
            PreparedStatement pstmt = conn.prepareStatement(strSecuenciaSQL);
            ResultSet registros = pstmt.executeQuery();
            return registros;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return  null;
        }

    }

}
