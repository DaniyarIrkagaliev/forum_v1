package com.company.db.repository.items;

import java.sql.ResultSet;
import java.util.Objects;

public class User implements Items {

    protected Integer user_id;
    protected String username, login, password;

    public User(int user_id, String login, String username, String password) {
        this.user_id = user_id;
        this.login = login;
        this.username = username;
        this.password = password;
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
                ", user_id='" + user_id + ", login=" + login +
                ", username=" + username + ", password =" + password + '}';
    }

    public static User getByResultSet(ResultSet rs){
        User user1 = null;
        try {
            user1 = new User(
                    rs.getInt("user_id"), rs.getString("login"),
                    rs.getString("username"), rs.getString("pass"));
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return user1;
    }

    public String getUsername() {
        return username;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public Integer getID() {
        return user_id;
    }
}
