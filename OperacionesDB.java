package fabricaSillas;

import java.lang.Boolean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class operacionesDB {

  //Guardar pedidos
  public static PreparedStatement guardarPedidos (Connection connection) {

    PreparedStatement myStatement = null;

    try {

      myStatement = connection.prepareStatement("UPDATE ID, TIPO, ESTADO FROM PRODUCTOS"
          + " WHERE ID = ? AND ESTADO = ?");

    } catch (SQLException e) {

      System.out.println("No database connection!");
      e.printStackTrace();
    }

    return myStatement;
  }

  //1. Establish a connection
  public static Connection conectar (){

    Connection myConnection = null;

    try {

      myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fabricadesillas", "root", "pLate.24");

    }catch(Exception e) {

      System.out.println("No database connection!");
      e.printStackTrace();

    }

    return myConnection;

  }




}