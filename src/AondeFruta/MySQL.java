package AondeFruta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQL {

  public MySQL() {
  }

  private final String url = "jdbc:postgresql://ec2-44-198-100-81.compute-1.amazonaws.com/d8lvqtjqpb5hoa";
  private final String username = "idabpsyoghqkyl";
  private final String password = "b55b1ddae49b03316bc5dcb21b9338b3897d63606b3519fd01c5af5624844784";

  public Connection connect() {
    Connection conn = null;
    try {

      conn = DriverManager.getConnection(url, username, password);
      System.out.println("Conexão realizada com sucesso ! ! !");

    } catch (SQLException e) {
      System.out.println("Não foi possível conectar ao Banco de Dados -----> " + e.getMessage());
      return null;
    }
    return conn;
  }

  public static void addUser(Connection conn, String name, String last_name, String email, String birth_date, int discoveres, String user_name, String password){
    String query = "INSERT INTO aondefruta.users ("
      + " id,"
      + " name,"
      + " last_name,"
      + " email,"
      + " birth_date,"
      + " discoveres,"
      + " user_name,"
      + " password"
      + ") VALUES ("
      + "nextval('users_sequence'), ?, ?, ?, ?, ?, ?, ?)";
    try{
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, name);
      st.setString(2, last_name);
      st.setString(3, email);
      st.setString(4, birth_date);
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

  public static void main(String[] args) {
    System.out.println("Aonde Fruta DB");
		MySQL post = new MySQL();

		addUser(post.connect(), "Giselle", "Gomes", "giselle@afruta.com.br", "1976-05-03", 5, "giFinder006", "147855");
    //listUsers(post.connect());
		//getUsers(post.connect(), 200);
    //deleteUsers(post.connect(), 200);
    //updateUsers(post.connect(), 200);
  }
}

