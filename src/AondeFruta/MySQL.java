package AondeFruta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;


import java.text.ParseException;

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

  public static void addUser(Connection conn, String name, String last_name, String email, Date birth_date, int discoveres, String user_name, String password){
    String query = "INSERT INTO aonde_fruta.users ("
      + "name, "
      + "last_name, "
      + "email, "
      + "birth_date, "
      + "discoveres, "
      + "user_name, "
      + "password, "
      + ") VALUES ("
      + "?, ?, ?, ?, ?, ?)";
    try{
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, name);
      st.setString(2, last_name);
      st.setString(3, email);
      st.setDate(4, birth_date);
      st.setInt(5, discoveres);
      st.setString(6, user_name);
      st.setString(7, password);

      st.executeUpdate();
      st.close();
    }
    catch (SQLException ex){
      System.out.println("-----> " + ex.getMessage() + ex.getErrorCode());
    }
  }

  private void setBirthDate(Date birth_date){


  }

  public static void main(String[] args) throws ParseException {
    System.out.println("Aonde Fruta DB");
		MySQL post = new MySQL();
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    Date formatedDate = (Date) format.parse("1976/05/03");

		addUser(post.connection(), "Giselle", "Gomes", "giselle@afruta.com.br", formatedDate, 5, "giFinder006", "147855");
    //listUsers(post.connect());
		//getUsers(post.connect(), 200);
    //deleteUsers(post.connect(), 200);
    //updateUsers(post.connect(), 200);
  }
}

