package ru.vsuet.bank;

public class User {

    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    public User(String firstname, String lastname, String username, String password){
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public User() {

    }

    public User(Long id, String firstname, String lastname, String username, String password) {
        this(firstname, lastname, username, password);
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = this.lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
