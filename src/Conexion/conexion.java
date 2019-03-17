package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion
{
  Connection connection = null;
  static conexion instance = null;
  
  public conexion()
    throws Exception
  {
    Class.forName("com.mysql.jdbc.Driver");
    this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/ledatel", "root", "123");
  }
  
  public static conexion getInstance()
    throws Exception
  {
    if (instance == null) {
      instance = new conexion();
    }
    return instance;
  }
  
  public void finalize()
    throws Exception
  {
    if (this.connection.isClosed())
    {
      this.connection = null;
      this.connection.isClosed();
    }
  }
  
  public Connection getConnection()
  {
    return this.connection;
  }
}

/* AUTOR:           EDSON J SUAREZ LOLI
 */