package com.devrenno.dscommerce.dto;

public interface UserDetailsProjection {

    String getUsername();

    String getPassword();

    Long getAuthorityId();

    String getAuthority();
}
