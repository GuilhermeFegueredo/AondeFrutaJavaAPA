package AondeFruta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class MySQL {

  public MySQL() {
  }

  public Connection connection() {
    Connection con;
    try {
      Class.forName("com.mysql.jdbc.Driver");

      String serverName = "127.0.0.1:3306";
      String myDataBase = "aonde_fruta";
      String url = "jdbc:mysql://" + serverName + "/" + myDataBase;

      String username = "root";
      String password = "Aonde_fruta";

      con = DriverManager.getConnection(url, username, password);

      System.out.println("Conexão bem realizada com sucesso ! ! !");
    } catch (ClassNotFoundException e) {
      System.out.println("O driver expecificado não foi encontrado");
      return null;
    } catch (SQLException e) {
      System.out.println("Não foi possível conectar ao Banco de Dados");
      return null;
    }
    return con;
  }

}
