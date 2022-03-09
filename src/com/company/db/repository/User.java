package com.company.db.repository;

import java.sql.ResultSet;
import java.util.Objects;

public class User implements Items {

    protected Integer user_id;
    protected String username, login, pass;

    public User(int user_id, String login, String username, String pass) {
        this.user_id = user_id;
        this.login = login;
        this.username = username;
        this.pass = pass;
    }

    //    @Override
    public boolean equels(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(user_id, user.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(user_id);
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id = '" + user_id + ", login = " + login +
                ", username = " + username + ", password = " + pass + '}';
    }

    public String getUsername() {
        return username;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return pass;
    }

    @Override
    public Integer getID() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
