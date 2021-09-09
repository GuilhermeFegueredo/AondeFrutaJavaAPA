package AondeFruta;

public class Users {
  private int idUser;
  private String nameUser;
  private String firstName;
  private String lastName;
  private String emailUser;
  private String password;
  private String birthDate;

  private Users(int id, String nameUser, String firstName, String lastName, String emailUser, String password, String birthDate) {
    this.idUser = id;
    this.nameUser = nameUser;
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailUser = emailUser;
    this.password = password;
    this.birthDate = birthDate;
  }

  public int getId(){
    return idUser;
  }

  public String getNameUser(){
    return nameUser;
  }

  public String getFirstName(){
    return firstName;
  }

  public String getLastName(){
    return lastName;
  }

  public String getEmailUser(){
    return emailUser;
  }

  public String getPassword(){
    return password;
  }

  public String getBirthDate(){
    return birthDate;
  }
}
