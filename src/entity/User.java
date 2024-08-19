package entity;

public class User {
    private int id;

    private String password;
    private String email;

    private String full_name;

    private int role_id;

    public User() {
    }

    public User(int id, String password, String email, String full_name, int role_id) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.full_name = full_name;
        this.role_id = role_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
