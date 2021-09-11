package AondeFruta;

import java.util.Date;

public class Users {
  private String nameUser;
  private String lastNameUser;
  private String emailUser;
  private Date birthDate;
  private int discoveres;
  private String userName;
  private String password;

  private Users(String nameUser, String lastNameUser, String emailUser, Date birthDate, int discoveres, String userName, String password) {
    this.nameUser = nameUser;
    this.lastNameUser = lastNameUser;
    this.emailUser = emailUser;
    this.birthDate = birthDate;
    this.discoveres = discoveres;
    this.userName = userName;
    this.password = password;
  }

  public String getNameUser(){ return nameUser; }

  public String getLastNameUser(){ return lastNameUser; }

  public String getEmailUser(){ return emailUser; }

  public Date getBirthDate(){ return birthDate; }

  public int getDiscoveres(){ return discoveres; }

  public String getUserName(){ return userName; }

  public String getPassword(){ return password; }
}
