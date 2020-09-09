package com.thoughtworks.capacity.gtb.mvc.entity;

public class UserDTO extends User {

    private Integer id;

    public UserDTO(Integer id, String username, String password, String email) {
        super(username, password, email);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
