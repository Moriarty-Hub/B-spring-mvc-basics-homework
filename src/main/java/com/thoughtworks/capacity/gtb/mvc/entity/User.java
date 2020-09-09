package com.thoughtworks.capacity.gtb.mvc.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class User {

    @NotNull(message = "The username cannot be null")
    @Size(min = 3, message = "The length of username is too short")
    @Size(max = 10, message = "The length of username is too long")
    @Pattern(regexp = "^[0-9a-zA-Z_]+$", message = "The username cannot contain any other character than number, alphabet and underline")
    private String username;

    @NotNull(message = "The password cannot be null")
    @Size(min = 5, message = "The length of password is too short")
    @Size(max = 12, message = "The length of password is too long")
    private String password;

    @Email(message = "Invalid email address")
    private String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) &&
                password.equals(user.password) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, email);
    }
}
