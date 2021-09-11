package AondeFruta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Date;

public class MySQL {

  public MySQL() {
  }

  public Connection connection() {
    Connection conn = null;
    try {
      String serverName = "127.0.0.1:3306";
      String myDataBase = "aonde_fruta";
      String url = "jdbc:mysql://" + serverName + "/" + myDataBase;

      String username = "root";
      String password = "Aonde_fruta";

      conn = DriverManager.getConnection(url, username, password);

      System.out.println("Conexão realizada com sucesso ! ! !");
    } catch (SQLException e) {
      System.out.println("Não foi possível conectar ao Banco de Dados" + "-----> " + e.getMessage());
      return null;
    }
    return conn;
  }

  public static void addUser(Connection conn, String name_user, String last_name_user, String email_user, Date birth_date, int discoveres,  String user_name, String password){
    String query = "INSERT INTO users ("
      + "id, "
      + "name_user, "
      + "last_name_user, "
      + "email_user, "
      + "birth_date, "
      + "discoveres, "
      + "user_name, "
      + "password, "
      + ") VALUES ("
      + "?, ?, ?, ?, ?, ?, ?, ?)";
    try{
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(2, name_user);
      st.setString(3, last_name_user);
      st.setString(4, email_user);
      st.setDate(5, birth_date);
      st.setInt(6, discoveres);
      st.setString(7, user_name);
      st.setString(8, password);

      st.executeUpdate();
      st.close();
    } catch (SQLException ex){
      System.out.println("-----> " + ex.getMessage() + ex.getErrorCode());
    }
  }


}

