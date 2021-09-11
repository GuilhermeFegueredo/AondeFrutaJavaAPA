package AondeFruta;

import java.sql.*;

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
      + "nextval('aondefruta.users_sequence'), ?, ?, ?, ?, ?, ?, ?)";
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

  public static void getUser(Connection conn, int _id) {

    try {
      Statement stmt = conn.createStatement();
      ResultSet rs;
      rs = stmt.executeQuery("SELECT id, name, last_name FROM aondefruta.users WHERE id = " + _id);
      while ( rs.next() ) {
        String id = rs.getString("id");
        String name = rs.getString("name");
        String last_name = rs.getString("last_name");
        System.out.println(id + "|" + name + "|" + last_name);
      }
      conn.close();
    } catch (Exception e) {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }

  public static void listUsers(Connection conn) {

    try {
      Statement stmt = conn.createStatement();
      ResultSet rs;
      rs = stmt.executeQuery("SELECT id, name, last_name, discoveres, user_name FROM aondefruta.users");
      while ( rs.next() ) {
        String id = rs.getString("id");
        String name = rs.getString("name");
        String last_name = rs.getString("last_name");
        String discoveres = rs.getString("discoveres");
        String user_name = rs.getString("user_name");
        System.out.println(id + "|" + name + "|" + last_name + "| Trees: " + discoveres + " | userName: " + user_name);
      }
      conn.close();
    } catch (Exception e) {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }

  public static void deleteUser(Connection conn, int _id) {
    try {
      Statement stmt = conn.createStatement();
      ResultSet select;
      ResultSet rs;
      select = stmt.executeQuery("SELECT id, name, last_name FROM aondefruta.users WHERE id = " + _id);
      while ( select.next() ) {
        String id = select.getString("id");
        String name = select.getString("name");
        String last_name = select.getString("last_name");
        System.out.println(id + "|" + name + "|" + last_name + " was deleted");
      }
      rs = stmt.executeQuery("DELETE FROM aondefruta.users WHERE id = " + _id);

      conn.close();
    } catch (Exception e) {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }

  public static void updateNameUser(Connection conn, int _id, String _name) {
    try {
      Statement stmt = conn.createStatement();
      ResultSet select;
      ResultSet rs;
      select = stmt.executeQuery("SELECT id, name, last_name FROM aondefruta.users WHERE id = " + _id);
      while ( select.next() ) {
        String id = select.getString("id");
        String name = select.getString("name");
        String last_name = select.getString("last_name");
        System.out.println(id + "|" + name + "|" + last_name + " was updated!!!");
      }
      rs = stmt.executeQuery("UPDATE aondefruta.users SET name = '" + _name + "' WHERE id = " + _id);
      conn.close();
    } catch (Exception e) {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    System.out.println("Aonde Fruta DB");
		MySQL post = new MySQL();

        //addUser(post.connect(), "Giselle", "Gomes", "fruta@afruta.com.br", "1999-05-03", 2, "pfsousa", "654789");
        listUsers(post.connect());
        //getUser(post.connect(), 3);
       //deleteUser(post.connect(), 7);
       //updateNameUser(post.connect(), 7, "Joe");
  }
}

