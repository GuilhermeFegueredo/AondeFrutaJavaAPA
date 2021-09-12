package AondeFruta;

import java.sql.*;

public class MySQL {

  public MySQL() {
  }

  private final String url = "jdbc:postgresql://ec2-44-198-100-81.compute-1.amazonaws.com/d8lvqtjqpb5hoa"; // url do banco
  private final String username = "idabpsyoghqkyl";                                                        // name do usuário do banco
  private final String password = "b55b1ddae49b03316bc5dcb21b9338b3897d63606b3519fd01c5af5624844784";      // password do banco


  // Faz conexão com o DB
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

  // add um user no DB
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
      System.out.println(" -----> " + ex.getMessage() + ex.getErrorCode());
    }
  }

  // busca um user no DB
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

  // retorna a lista de user do DB
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

  // deleta um user do DB
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

  // altera/atualiza um user no DB
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


  // add uma tree no DB
  public static void addTree(Connection conn, String name, String species, String discoverer, Double latitude, Double longitude, String description, int user_id){
    String query = "INSERT INTO aondefruta.trees ("
      + " id,"
      + " name,"
      + " species,"
      + " discoverer,"
      + " latitude,"
      + " longitude,"
      + " description,"
      + " user_id"
      + ") VALUES ("
      + "nextval('trees_sequence'), ?, ?, ?, ?, ?, ?, ?)";
    try{
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, name);
      st.setString(2, species);
      st.setString(3, discoverer);
      st.setDouble(4, latitude);
      st.setDouble(5, longitude);
      st.setString(6, description);
      st.setInt(7, user_id);

      st.executeUpdate();
      st.close();
    }
    catch (SQLException ex){
      System.out.println(" -----> " + ex.getMessage() + ex.getErrorCode());
    }
  }


  // busca um user no DB
  public static void getTree(Connection conn, int _id) {

    try {
      Statement stmt = conn.createStatement();
      ResultSet rs;
      rs = stmt.executeQuery("SELECT id, name, species, user_id FROM aondefruta.trees WHERE id = " + _id);
      while ( rs.next() ) {
        String id = rs.getString("id");
        String name = rs.getString("name");
        String species = rs.getString("species");
        String user_id = rs.getString("user_id");
        System.out.println(id + "|" + name + "|" + species + "|" + user_id);
      }
      conn.close();
    } catch (Exception e) {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }

  // retorna a lista de user do DB
  public static void listTrees(Connection conn) {

    try {
      Statement stmt = conn.createStatement();
      ResultSet rs;
      rs = stmt.executeQuery("SELECT id, name, species, user_id FROM aondefruta.trees");
      while ( rs.next() ) {
        String id = rs.getString("id");
        String name = rs.getString("name");
        String species = rs.getString("species");
        String user_id = rs.getString("user_id");
        System.out.println(id + "|" + name + "|" + species + "| user_id: " + user_id);
      }
      conn.close();
    } catch (Exception e) {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }

  // deleta um user do DB
  public static void deleteTree(Connection conn, int _id) {
    try {
      Statement stmt = conn.createStatement();
      ResultSet select;
      ResultSet rs;
      select = stmt.executeQuery("SELECT id, name, species, user_id FROM aondefruta.trees WHERE id = " + _id);
      while ( select.next() ) {
        String id = select.getString("id");
        String name = select.getString("name");
        String species = select.getString("species");
        String user_id = select.getString("user_id");
        System.out.println(id + "|" + name + "|" + species + "|" + user_id + " was deleted");
      }
      rs = stmt.executeQuery("DELETE FROM aondefruta.trees WHERE id = " + _id);

      conn.close();
    } catch (Exception e) {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }

  // altera/atualiza um user no DB
  public static void updateNameTree(Connection conn, int _id, String _name, String _species) {
    try {
      Statement stmt = conn.createStatement();
      ResultSet select;
      ResultSet rs;
      select = stmt.executeQuery("SELECT id, name, species, user_id FROM aondefruta.trees WHERE id = " + _id);
      while ( select.next() ) {
        String id = select.getString("id");
        String name = select.getString("name");
        String species = select.getString("species");
        String user_id = select.getString("user_id");
        System.out.println(id + "|" + name + "|" + species + "|" + user_id + " was updated!!!");
      }
      rs = stmt.executeQuery("UPDATE aondefruta.trees SET name = '" + _name + "', species = '" + _species + "' WHERE id = " + _id);
      conn.close();
    } catch (Exception e) {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    System.out.println("Aonde Fruta DB");
		MySQL post = new MySQL();

    // addUser(post.connect(), "Barbara", "Alves", "barbara@afruta.com.br", "1999-02-25", 7, "barbaraAlves", "987654321");
    // listUsers(post.connect());
    // getUser(post.connect(), 5);
    // deleteUser(post.connect(), 7);
    // updateNameUser(post.connect(), 7, "Joe");

    // addTree(post.connect(), "Laranjeira", "arvore", "Guilherme", -21.00, -21.00, "Goiabeira", 1);
    // listTrees(post.connect());
    // getTree(post.connect(), 3);
    // deleteTree(post.connect(), 4);
    // updateNameTree(post.connect(), 3, "Laranjeira","arvore");
  }
}

