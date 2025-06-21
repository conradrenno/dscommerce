package com.devrenno.dscommerce.dto;

import com.devrenno.dscommerce.entities.User;

public class ClientMinDTO {

    private Long id;
    private String name;

    public ClientMinDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClientMinDTO() {}

    public ClientMinDTO(User user) {
        id = user.getId();
        name = user.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
